
 this will create two tables

 1. Laptop
 2. Student
 
 In Student we will have one extra column names lid which is a foreign key and is sc created and stored automatically due to onetoone mapping

 ```
 @Entity
public class Laptop{

    @Id
    private int lid;
    private String Lname;


}


@Entity
public class Student{
    @Id
    private int rollno;
    private String name;
    private int marks;
    
    @OneToOne
    private Laptop laptop;
}

 ```
