# MAny Employee have same address

### there is no mapping from ONe to Many so we have to use list mapping for one to many

### Note: In one to one there was no extra field added in employee table hoever in case of Many to One pincode column is added in Employee table
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
	
	private List<Address> addresses;
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


		<list name="addresses" cascade="all">
			<key column="empid"></key>
			<list-index column="myindex"></list-index>
			<one-to-many class="com.thinkitive.embedding.Address"></one-to-many>
		</list>



	</class>

	<class name="com.thinkitive.embedding.Address" table="demoaddress">
		<id name="pincode" column="pincode" type="int">
			<generator class="assigned"></generator>
		</id>

		<property name="city" column="city" type="string"></property>

	</class>
	
	
</hibernate-mapping> 
```

**Driver**
```

public class Demo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Address a1 = new Address(999, "Mumbai");
		Address a2 = new Address(555, "Nasik");
		Address a3 = new Address(222, "New York");
	
		List<Address> l = new ArrayList<Address>();

		l.add(a2);
		l.add(a1);
	
		l.add(a3);
		Employee e1 = new Employee(12, "Rajesh", 69000, l);

		session.save(e1);

		t.commit();
		session.close();
		factory.close();
	}

}
```
