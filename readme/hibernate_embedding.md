we can Embedd the data of address in employee or create a seperate table for address
- For Embedding

Using @Embeddable annotaion we solve this
**Employee.java**
```
class Employee{

    String name;
    int id;
    int Salary;
    Address address;
    //getters and setters
}

```

**Address.java**
```
@Embeddable
class Address{
    int pincode;
    String city;
    //getter and setters

}
```