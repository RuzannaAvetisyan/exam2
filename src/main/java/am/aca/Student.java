package am.aca;

import java.util.List;

public class Student {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Valid(minValue = 0.0f, maxValue = 4.0f)
    private float gpa;

    @NotEmpty
    private List<Course> courses;

    //TODO constructor

    public Student(String firstName,String lastName, float gpa){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;

    }
    //TODO getters
    


    void enroll(Course course) {
        courses.add(course);
    }

}