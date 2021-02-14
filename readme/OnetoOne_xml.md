**Address.java**
```public class Address {
	
	private int pincode;
	private String city;
	//getters and setters
```

**Employee.java**
```
public class Employee {
	private int empid;
	private String ename;
	private int salary;
	
	private Address address;
    //getters and setters
```

**employee.hbm.xml**
```
hibernate-mapping>
	
	<class name="com.thinkitive.Employee" table="employee2">
		<id name="empid" column="empid" type="int">
			<generator class="assigned"></generator>
		</id>

		<property name="ename" column="ename" type="string"></property>
		<property name="salary" column="salary" type="int"></property>


		<one-to-one name="address" class="com.thinkitive.embedding.Address" cascade="all" ></one-to-one>


	</class>

	<class name="com.thinkitive.Address" table="demoaddress">
		<id name="pincode" column="pincode" type="int">
			<generator class="assigned"></generator>
		</id>

		<property name="city" column="city" type="string"></property>

	</class>
	
	
</hibernate-mapping> 
```