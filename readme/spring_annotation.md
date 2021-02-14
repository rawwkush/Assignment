# anyname.xml file in src folder

Model classes are beans

**Employee**

```
@Component
public class Employee{
	private int empid;
	private String ename;
	private int salary;
	//getters and stters and equals
}
```

---

**Demo.java**

```
public class Demo {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotaionConfigApplicationConext("com.thikitive.Employee");


		Employee e = context.getBean(Employee.class);

		System.out.println(e);

	}

}

```

**Note Employee is no longer POJO, so we need alternative**

# alternative

create another class appcongig and use @configuration annotation for it and create a function that will return the object of Employee and annotate it as @Bean

`if you remmeber this a instance factory method` (check spring_demo.md)
**AppConfig**

```
@Configuration
publci class AppConfig{

	@Bean
	@scope(scopeName="prototype") // use if you eant to change from singleton as its default
	public Employee getEmployee(){
		return new Employee();
	}
}
```

# If Employee have object of Address class then

In Employee You must have setter and getters for adrress.

**AppConfig**

```
@Configuration
publci class AppConfig{

    @Bean
    @scope(scopeName="prototype") // use if you eant to change from singleton as its default
    public Employee getEmployee(){
    	return new Employee();
    }

	@Bean
	public Adress getAddress( ){
		return new Address();
	}

}

```

**Employee**

```
public Employee{
	private int empid;
	private String name;
	@AutoWired
	private Address address;
}

```

# if List of Address

todo
