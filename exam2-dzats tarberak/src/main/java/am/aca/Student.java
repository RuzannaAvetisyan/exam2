package am.aca;

import java.util.*;

public class Student {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Valid(minValue = 0.0f, maxValue = 4.0f)
    private float gpa;

    @NotEmpty
    private List<Course> courses = new ArrayList<Course>();

    //TODO constructor

    public Student(String firstName,String lastName, float gpa){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;

    }
    //TODO getters

    public String getLastName(){
        return this.lastName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public float getGpa(){
        return this.gpa;
    }
    public List<Course>  getCourses(){
        return this.courses;
    }
    
    void enroll(Course course) {
        courses.add(course);
    }

}