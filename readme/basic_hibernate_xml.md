# Basic Hibernate Application


**model**
```
class Employee{
    int id;
    String name;
    int salary;

    //getter and setters to string etc

}
```



**hibernate.cf.xml**

```Goto New->others->hibernate->hibernate.cfg.xml```

- In dialect select the DBMS for us right now its MYSQL.
 - In driver select the driver for MYSQL we are using JDBC. 
 - In Connection URL enter the URL (which we used in JDBC)

 -Uername and password

 Here is how the file looks like
```

<hibernate-configuration>
   <session-factory>
        
      <!-- Dialect is the Database System for us MYSQL -->
      
      <property name = "hibernate.dialect"> org.hibernate.dialect.MySQLDialect   </property>
      
      <property name = "hibernate.connection.driver_class">   com.mysql.jdbc.Driver     </property>
      
      <!-- Assume mydbs is the database name -->

      <property name = "hibernate.connection.url">     jdbc:mysql://localhost:3306/mydbs      </property>
      
      <property name = "hibernate.connection.username">         rawkush      </property>
      
      <property name = "hibernate.connection.password">         Ankush@123      </property>
            


       <!-- asking hibernate to create the table if doesn't exist, if exist then update the table -->     

      <property name="hibernate.hbm2ddl.auto">  update    </property>
    
      <!-- List of XML mapping files, can be removed if we use Annotaions -->
      <mapping resource = "employee.hbm.xml"/>
      

   </session-factory>
</hibernate-configuration>

```


Now lets do the mapping of model class with database columns
**employee.hbm.xml**

```
<?xml version='1.0' encoding='UTF-8'?>  
<!DOCTYPE hibernate-mapping PUBLIC   "-//Hibernate/Hibernate Mapping DTD 5.3//EN"   "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">

<hibernate-mapping>


	<class name="com.thinkitive.Employee" table="demoemployee">

		<id name="empid" column="employee id" type="int">
            <!-- this means we will manually assign value to empid which is a primary key-->
			<generator class="assigned"></generator>
		
        </id>

		<property name="ename" column="Employee name" type="string"></property>
		<property name="salary" column="salary" type="int"></property>

	</class>

	


</hibernate-mapping> 

```
----------

**Driver Code**
public class MyDBConnection {

```
	public void insertEmployee() {
		
		Employee e= new Employee(322,"abc",10000);
		Configuration cfg= new Configuration();
		SessionFactory factory= cfg.configure().buildSessionFactory();
		
		Session sesson= factory.openSession();
		Transaction tx= sesson.beginTransaction();
		
		
		sesson.save(e);
		
		tx.commit();
		sesson.close();
		factory.close();
	}


	public void delete() {
		
		Employee e= new Employee(12,"abc",10000);
		Configuration cfg= new Configuration();
		SessionFactory factory= cfg.configure().buildSessionFactory();
		
		Session sesson= factory.openSession();
		Transaction tx= sesson.beginTransaction();
		
		//to delete
		sesson.delete(e);
	
		tx.commit();
		sesson.close();
		factory.close();
	}

	public void update() {
		
		Employee e= new Employee(12,"abc",10000);
		Configuration cfg= new Configuration();
		SessionFactory factory= cfg.configure().buildSessionFactory();
		
		Session sesson= factory.openSession();
		Transaction tx= sesson.beginTransaction();
		
		//to update
		sesson.update(e);
	
		tx.commit();
		sesson.close();
		factory.close();
	}

	/*
	 * Using Criteria Api
	 * Same as Query but allows us to add restristion in Query like 
	 * greater than or equals or less thans etc
	 */
	public List<Employee> getAllEmployee(){
		
		List l=null;
		Employee e= new Employee(12,"abc",10000);
		Configuration cfg= new Configuration();
		SessionFactory factory= cfg.configure().buildSessionFactory();
		
		Session sesson= factory.openSession();
		Transaction tx= sesson.beginTransaction();
		
		Criteria c= sesson.createCriteria(Employee.class);
		c.add(Restrictions.lt("salary",12000000  )); //lt means less than
		l=c.list();
		
		tx.commit();
		sesson.close();
		factory.close();
		return l;
	}	

	public List<Employee> getAll() {
		
		Employee e= new Employee(12,"abc",10000);
		Configuration cfg= new Configuration();
		SessionFactory factory= cfg.configure().buildSessionFactory();
		
		Session sesson= factory.openSession();
		Transaction tx= sesson.beginTransaction();

		/*
		 * Employee is class name here, not a table name 
		 */

		Query q= sesson.createQuery("From Employee");
		List l= q.list();
		tx.commit();
		sesson.close();
		factory.close();
		return l;
	}

}
```