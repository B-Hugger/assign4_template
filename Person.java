//Assign 4, Peron class.
//  Represent an applicant, or an employee

package assign4_template;

import java.util.ArrayList;
import java.util.List;

public class Person { //new applicants, current employees, past employees
    
    //Item 3. in Assign 4 Document.
    String name;
    String degree;
    List skills = new ArrayList<>();
    //define data fields: name, degree, skill list ("Java, C#, C++", etc.)
    //  skill list: must be array list or linked list
    

    //define the constructor with given name, degree, and skill list
    Person(String name,String degree,List skills) {
        this.name = name;
        this.degree = degree;
        this.skills = List.of(skills);
    }
    //define getters

    public List getSkills() {
        return skills;
    }
    public String getDegree() {
        return degree;
    }
    public String getName() {
        return name;
    }

    //define setters

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSkills(List skills) {
        this.skills = List.of(skills);
    }
    //define toString()
    public String toString() {
        return "Name: " + name + " Degree: " + degree + " skills: " + skills;
    }
}

