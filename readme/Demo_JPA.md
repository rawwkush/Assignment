**persistence.xml**
instead of hibernate perisitence is written in name attribute of property tags
```
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1"
    xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
    <persistence-unit name="myemp" transaction-type="RESOURCE_LOCAL">
        <class>com.vwits.demo.Employee</class>      
        <properties>
            <!-- Configuring The Database Connection Details -->
            <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/mydbs" />
            <property name="javax.persistence.jdbc.user" value="rawkush" />
            <property name="javax.persistence.jdbc.password" value="Ankush@123" /> 
                 
        </properties>
    </persistence-unit>
</persistence>
```

**model.java**
```
@Entity
@Table(name="my_table_name_to_store_Data")
class Employee{
    @Id
    int empid;

    @Column(name="Employee_Salary")
    int salary;
	
	String ename;
	// getter and setter
}
```

**Driver**
```
public class Demo {
	public static void main(String[] args) {

		//Instead of Seesion  Entity is used
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myemp");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Employee e = new Employee(701, "James Bond", 77777);

		//instead of save persist is used
		manager.persist(e);

		tx.commit();
		manager.close();
		factory.close();
	}

}
```