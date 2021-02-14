**If we have a list inside the bean class then how to handle..**

**Employee**

```
public class Employee{
	private int empid;
	private String ename;
	private int salary;
	private List<String> skills;


	//getters and stters and equals
}
```

**XML**

```
<bean id="emp" class="com.thinkitive.Employee">
	<property  name="empid" value="12"></property>
	<property  name="ename" value="ankush"></property>
	<property  name="salary" value="1222"></property>

	<property name="skills">
		<list>
			<value>Java</value>
			<value>C++</value>
		</list>>
	</property>

</bean>

```

---

2. **Instanciating with static Factory method (static method which creates object and returns it)**

```
<bean id="emp" class="com.thinkitive.Employee" factory-method="function name">


</bean>>

```

---

3. **Instanciating using an instance Factory method**

Create Another class **EmployeeFactory.java**

```
public class EmployeeFactory{
	public Employee getEmployee(){
		return new Employee();
	}
}
```

**Anynam.xml**
keep the class of bean empty

```
<bean id="emp"  factory-bean="bean_id_of_the_EmployeeFactory_class"

factory-method="getEmployee">


</bean>>

<bean id="this_should_be_same_As_written_in_above_factory_bean_Attribute" class="com.thinkitive.EmployeeFactory" factory-method="function name">

</bean>>


```

---

- **IF Employee have object of Address inside the class declaration then how to instialise it?**

```
public Employee{
	private Address address;
}
```

**XML**

```
<bean id="emp" class="com.thinkitive.Employee">


</bean>>

<bean id="addr" class="cpm.thinkitive.Address">

</bean>

```

If we do this It won't work.. It will putt address as **null** , so we need ti wire the address with employee so that spring will automatically initilaise the the address and use to initialise Employee.

To Autowire them we do it by using property tag and using **ref** attribute to refer to the address bean

```

<bean id="emp" class="com.thinkitive.Employee">

	<property name="address" ref="addr"></property>

</bean>>

<bean id="addr" class="com.thinkitive.Address">

</bean>

```

**OR**
instead of manually doing the the wiring using ref attribute we can use autowiring

```


<bean id="emp" class="com.thinkitive.Employee" autoWire="byType">


</bean>>

<bean id="addr" class="com.thinkitive.Address">   </bean>


```
