# anyname.xml file in src folder

Model classes are beans

**Employee**

```
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
		ApplicationContext context = new ClassPathXmlApplicationContext("anyname.xml");


		Employee e = context.getBean("emp",Employee.class);

		System.out.println(e);

	}

}

```

---

**Anyname.xml**

```
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="emp" class="com.thinkitive.Employee">
	</bean>

</beans>
```

If you want to intialise the bean object you can do it by

```
<bean id="emp" class="com.thinkitive.Employee">
	<constructor-arg name="empid" value="1"> </constructor-arg>
	<constructor-arg name="ename" value="ankush"> </constructor-arg>
	<constructor-arg name="salary" value="1000"> </constructor-arg>
</bean>

```

**Note: Data type casting is done handled by spring**

---

If you wana inject using property(setters)

```
<bean id="emp" class="com.thinkitive.Employee">
	<property  name="empid" value="12"></property>
	<property  name="ename" value="ankush"></property>
	<property  name="salary" value="1222"></property>
</bean>
```
