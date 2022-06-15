package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static ru.netology.Main.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainTest {

    private final Employee JOHN = new Employee(1, "John", "Smith", "USA", 25);
    private final Employee IVAN = new Employee(2, "Ivan", "Petrov", "RU", 23);
    private final List<Employee> EMPLOYEES = new ArrayList<>();

    @BeforeAll
    public void beforeAll() {
        EMPLOYEES.add(JOHN);
        EMPLOYEES.add(IVAN);
    }

    @Test
    public void parseCSVTest() {
//      arrange:
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
//      act:
        List<Employee> employees = parseCSV(columnMapping, fileName);
//      assert:
        Assertions.assertEquals(EMPLOYEES, employees);
    }

    @Test
    public void listToJsonTest() {
//      arrange:
        String json = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25}," +
                "{\"id\":2,\"firstName\":\"Ivan\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";

//      act:
        String employees = listToJson(EMPLOYEES);
//      assert:
        Assertions.assertEquals(json, employees);
    }

    @Test
    public void parseXMLTest() {
//      arrange:
        String fileName = "data.xml";
//      act:
        List<Employee> employees = parseXML(fileName);
//      assert:
        Assertions.assertEquals(EMPLOYEES, employees);
    }
}
