package ru.netology;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
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
        assertThat(employees, equalTo(EMPLOYEES));
    }

    @Test
    public void listToJsonTest() {
//      arrange:
        String json = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25}," +
                "{\"id\":2,\"firstName\":\"Ivan\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";
//      act:
        String employees = listToJson(EMPLOYEES);
//      assert:
        assertThat(employees, equalTo(json));
    }

    @Test
    public void parseXMLTest() {
//      arrange:
        String fileName = "data.xml";
//      act:
        List<Employee> employees = parseXML(fileName);
//      assert:
        assertThat(employees, equalTo(EMPLOYEES));
    }

    @Test
    public void readStringTest() {
//      arrange:
        String json = "[{\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"id\":1,\"age\":25}," +
                "{\"firstName\":\"Ivan\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"id\":2,\"age\":23}]";
        String jsonFile = "data2.json";
//      act:
        String stringValueOfJSON = readString(jsonFile);
//      assert:
        assertThat(stringValueOfJSON, Matchers.equalTo(json));
    }

    @Test
    public void jsonToListTest() {
//      arrange:
        String json3 = readString("data2.json");
//      act:
        List<Employee> employees = jsonToList(json3);
//      assert:
        assertThat(employees, Matchers.equalTo(EMPLOYEES));
    }
}
