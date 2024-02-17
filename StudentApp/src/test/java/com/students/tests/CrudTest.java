package com.students.tests;

import com.github.javafaker.Faker;
import com.students.requests.RequestFactory;
import com.students.specs.SpecificationFactory;
import com.students.tags.Regression;
import com.students.tags.Smoke;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.List;

@Story("This is a CRUD testing story")
public class CrudTest extends TestBase {

    RequestFactory requests = new RequestFactory();

    @Category(Smoke.class)
    @Story("This is a CRUD testing story")
    @DisplayName("This is a test to get all students from the database")
    @Feature("This is a test to get all students from the database")
    @Test
    public void getAllStudents(){
            requests.getAllStudents()
                    .then()
                    .spec(SpecificationFactory.getGenericResponseSpec())
                    .log().body()
                    .statusCode(200);
    }

    @Category({Regression.class, Smoke.class})
    @Story("This is a CRUD testing story")
    @DisplayName("Test to create & verify a new student")
    @Feature("Test to create & verify a new student")
    @Tag("Regression,Smoke")
    @Test
    public void createNewStudent(){

        Faker fakeData = new Faker();

        String firstName = fakeData.name().firstName();
        String lastName = fakeData.name().lastName();
        String email = fakeData.internet().emailAddress();
        String programme = "ComputerScience";
        List<String> courses = new ArrayList<String>();
        courses.add("C++");
        courses.add("Java");

        requests.createNewStudent("", firstName, lastName, email, programme, courses)
                .then()
                .spec(SpecificationFactory.getGenericResponseSpec())
                .log().all()
                .statusCode(201);
    }
}
