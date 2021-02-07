
# JDBC

### 7 steps for connecting in jdbc

1. import package  
2. Load and Register the Drivers
3. Establish the connection
4. Create the statement
5. Execute the Query
6. Process result
7. close the connection


# Servlet
When a user makes a request to a page server sends the html page to the client as its a path.
However if a page doesn't exist and page needs to be build dynamically then request is forwarded to helper application by the server.

Helper application is a webcontainer(like TomCat), it contains servlet.


```
Servlet: takes the request and processes the request and sends the responds
```


let's say client request for a page abc.html to add two numbers, and this page needs to be dynamically created, so request is passed to webcontainer and webcontainer  will pass it to the required servlet, and servlet will process the request and send the response.

##### However servlet name is Addservlet.java not abc.html so how will tis servlet be called???

#### So to do this we have a special file in our webcontainer called as Deployment descriptor. And file name is "web.xml"

in which we mention for which request which servlet should be called. 
So every request is mapped with one servlet.

this is how web.cml looks like
```
<web-app>

    <servlet>
        <servlet-name>AddServlet</servlet-name>
        <servlet-class>AddServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>AddServlet</servlet-name>
        <url-pattern>/abc.html</url-pattern>
    </servlet-mapping>>

</web-app>
```

In "web.xml" we have two tags <servlet> and <servlet-mapping>, In <Servlet> tag we add class name of the servlet and in <servlet-mapping> we specify url pattern(for this url this servlet will be called).

###### Note: mapping can also be done using annotations


### Calling servlet from another Servlet

 There are two ways of doing it.
 1. Send Redirect <br>
 2. Request Dispatcher

#### Request Dispatcher: 
servlet s1 can call servlet s2 by using RequesDispatcher object, this also forwards response and request object of servlet s1 to s2, so that if we want to send data from s1 to s2 we can add the data to request object so that we can access data in servlet s2.<br>

Now s2 will send servlet s2 will send response to the client  and as same response object is being used by the servlet s2 as of servlet s1 sp client doesn't know that the servlet s2 was sending the
data(in Url the address is same).<br>
```
RequestDispatcher rd = request.getRequestDispatcher("newservlet");
rd.forward(request,response); 
```



#### Send Redirect:
 servlet s1 will inform user that request is being redirected, we can't send data like we did on request dipatcher instead we use either URL Rewriting or session for that.
<br>
<br>
Also as it's not forwarding the request but instead redirecting it so it means response object of servlet s1 is used and so the url of client will change.

```
    response.sendRedirect("newservlet");
    //for url rewriting
    response.sendRedirect("newservler?key=" + data );
```
#####  NOTE: ```  Redirect is used in payment gateways, that's why we move from flipkart website to some another while paying online    ```


# Sessions

```
    HttpSession session= request.getSession();
    session.setAttribute("key","value);
    
    /*
    * ho to access thw session
    */

    HttpSession session= request.getSession();
    int data = (int) session.getAttribute("key");

```

# Cookies

```
    Cookies cookie= new Cookie("key", "values");
    response.addCookie(cookie);
```

# ServletComfig and ServletContext
TODO:

# Configure servlet using Annotations

Instead of configuring  using xml and doing servlet mapping etc we can use annotations. Ex.
```
    @WebServlet("/add")
    class myservlet extends HttpsServlet{
        .....
    }

```

## Why Do we need JSP?
Since we send response using servlet it sends a normal string as a response.

And if now we need to to do more of HTML based stuff like changing colour, style etc, we have to write the whole tags of html inside a string and then write it using response Writer.
example:
```
PrintWriter out = response.getWriter();
out.println("<html> <body bgcolor="red">");
out.print("My output");
out.print("</body> </html>");
```
Now if the page contains more data and more styling it will be chaotic to write html stuff here.

 
#### So JSP came to Rescue
###### JSP= java server page
JSP allows us to write JAva code inside the HTML.
<br>
JSP gives to request and response object so you can work with them. 

```
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>MY FIRST JSP</title>
</head>
<body>

	<%

	try{
		out.println(request.getAttribute("message"));	
	}
	catch(Exception e){
		out.println("Error");
	}

	%>


</body>
</html>
```

**Why use servlet when we have JSP?**

We can't run JSP, as we have seen the TomCat Server is "Servlet Container" so we can only run servlet in tomcat, so how did JSP run in our code?

- **So JSP code is actually converted into servlet.**

so if you want to simply process something servlet is a good choice and if you want a html page then JSP.

<br>

### Tags in JSP

- Directive
 if you want to import a java pacakage so that u can use it in your JSP(which actually does import when jsp is converted into servlet).

 you can also include other jsp page, and other tags using this tag

 ```
<%@page import =" java.utils.Date "  %>
 ```

 - Declarative
 If you want to declare a global variable i.e a variable outside the service methods(like doGet() or doPost() ), we use this tag to declare the variable.
 ```
<%!
    int i=0;
%>
 ``` 

- Scriptlet
 All the code written inside the scriplet is transfered to the "service methods".
 ```
<%
    int value= req.getAttribute("key");
%>
 ```

- Expression
IF you wanna print something instead of writing **out.print(value);** we can do this by using a tag

```
<%= value  %>
```

** lets see how the Above code will look like in servlet

```
import java.utli.Date; // due to Directive tag
public class myClass_jsp extends HttpsServlet{

    int i=0; // due to declarative tag

    public void _jspService(request, response){    
        
        /*
            html stuff i.e normal tags are also pushed here

        */
        
        out.write("<html>  
            
            <head>
                <title>My title</title>
            </head>
            <body>
        
         ")
        
        // java stuff pushed due to jsp tags
        int value= req.getAttribute("key"); // due to scriptlet
        out.print(value); // due to expression tag

        //html tags again at the end
        out.write("</body>
            </html>
        ")
  
    }
    

}

```



# MVC: Model View Controller
**Keep Model as POJO**
**Use DAO(Databse Aceess Object) for databse realted work(not compulsory but good practice)**

## Custom JSP Tags

## Filters
**why filters??**


# Hibernate 
It is a ORM tool.(so we can save our object directly into database)

**model**
```
class Employee{
    int id;
    String name;
    int salary;

    //getter and setters to string etc

}
```

**DriverCode**
```
class Test{

    public static void main(Strin[] args){
        Employee emp= new Eemlpoye("ankuhs",12,10000);

        /*
         * to save emp object
        */
        Configuration con= new Configuration().Configure();
        SessionFactory sf= con.builSessionFactory();
        Session session=sf.openSession();


        /*
        * As the Data is being stored in DATABASE so we also need to follow ACID property of databse
        * and to do that have to do Transaction
        */

        Transaction tx= session.beginTransaction();

        session.save(emp);
        
        tx.commit();

    }

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
<?xml version = "1.0" encoding = "utf-8"?>
<!DOCTYPE hibernate-configuration SYSTEM 
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

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

**employee.hbm.xml**
This is replaced by using Annotations. You need to tell hibernate that the Employee class is an entity by using @Entity Annotation.

- IT is also important to Tell the Hibernate about **primary key** as in RDBMS primary key is must.

```
@Entity
@Table(name="my_table_name_to_store_Data")
class Employee{
    @Id
    int empid;

    @Column(name="Employee_Salary")
    int salary;
    ...
    ...
}
```
OR we can just use the XML, Here is how XML will look like.
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

### How to save data if Employee have object of Another class called Address.java
```
class Employee{

    String name;
    int id;
    int Salary;
    Address address;

}

```