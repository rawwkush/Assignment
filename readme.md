# JDBC

**7 steps for connecting in jdbc**

> 1. import package
> 2. Load and Register the Drivers
> 3. Establish the connection
> 4. Create the statement
> 5. Execute the Query
> 6. Process result
> 7. close the connection

[click here for view Code](https://github.com/rawwkush/Assignment/blob/master/readme/jdbc_demo.md)

---

# Servlet

When a user makes a request to a page server sends the html page to the client as its a path.
However if a page doesn't exist and page needs to be build dynamically then request is forwarded to helper application by the server.

Helper application is a webcontainer(like TomCat), it contains servlet.

`Servlet: takes the request and processes the request and sends the responds`

let's say client request for a page abc.html to add two numbers, and this page needs to be dynamically created, so request is passed to webcontainer and webcontainer will pass it to the required servlet, and servlet will process the request and send the response.

**However servlet name is Addservlet.java not abc.html so how will tis servlet be called???**

**So to do this we have a special file in our webcontainer called as Deployment descriptor. And file name is "web.xml"** <br>
<br>
In which we mention for which request which servlet should be called.
So every request is mapped with one servlet.

this is how web.xml looks like

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

> **Note: mapping can also be done using annotations**

### Calling servlet from another Servlet (Servlet Collaboration)

There are two ways of doing it.

1.  Response Redirect (Send Redirect) <br>
2.  Request Redirect (Request Dispatcher)

#### Request Dispatcher:

servlet s1 can call servlet s2 by using RequesDispatcher object, this also forwards response and request object of servlet s1 to s2, so that if we want to send data from s1 to s2 we can add the data to request object so that we can access data in servlet s2.<br>

Now servlet s2 will send response to the client, as same response object is being used by the servlet s2 as of servlet s1 so client doesn't know that the servlet s2 was sending the data(in Url the address is same).<br>

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

> **Note: Redirect is used in payment gateways, that's why we move from flipkart website to some another while paying online**

---

# Sessions Handling

Four ways of doing it.<br>

1. Hidden HTML form fields
2. Cookies
3. URL Rewriting
4. HttpSession Object (it is combination of 2 and 3)

[click here for Code](https://github.com/rawwkush/Assignment/blob/master/readme/session.md)

# Cookies

Cookie aren't meant for session handling, but we can use it for sessions too.
<br>
Cookies are text files with small pieces of data stored on the user's computer by the web browser while browsing. Cookies were designed to be a reliable mechanism for websites to remember stateful information (such as items added in the shopping cart in an online store) or to record the user's browsing activity (including clicking particular buttons, logging in, or recording which pages were visited in the past). They can also be used to remember pieces of information that the user previously entered into form fields, such as names, addresses, passwords, and payment card numbers.

Created by webserver stored in client machine.(Data is tored in key value pair)

```
    Cookies cookie= new Cookie("key", "values");
    response.addCookie(cookie);
```

---

# ServletConfig and ServletContext

TODO:

---

# Configure servlet using Annotations

Instead of configuring using xml and doing servlet mapping etc we can use annotations. Ex.

```
    @WebServlet("/add")
    class myservlet extends HttpsServlet{
        .....
    }

```

---

## Why Do we need JSP?

Since we send response using servlet it sends a normal string as a response.
<br>
And if now we need to to do more of HTML based stuff like changing colour, style etc, we have to write the whole tags of html inside a string and then write it using response Writer.
example:

```
PrintWriter out = response.getWriter();
out.println("<html> <body bgcolor="red">");
out.print("My output");
out.print("</body> </html>");
```

Now if the page contains more data and more styling it will be chaotic to write html stuff here.

> So JSP came to Rescue

> JSP = java server page

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

> **So JSP code is actually converted into servlet.**

so if you want to simply process something servlet is a good choice and if you want a html page then JSP.

<br>

### Tags in JSP

- Directive:
  if you want to import a java pacakage so that u can use it in your JSP(which actually does import when jsp is converted into servlet).

  you can also include other jsp page, and other tags using this tag

```
<%@page import =" java.utils.Date "  %>
```

- Declarative:
  If you want to declare a global variable i.e a variable outside the service methods(like doGet() or doPost() ), we use this tag to declare the variable.

```
<%!
   int i=0;
%>
```

- Scriptlet:
  All the code written inside the scriplet is transfered to the "service methods".

```
<%
   int value= req.getAttribute("key");
%>
```

- Expression:
  IF you wanna print something instead of writing **out.print(value);** we can do this by using a tag

```
<%= value  %>
```

lets see how the Above code will look like in servlet after JSP is complied into servlet

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

# Scope of JSP object

The avaialability of the application from a particular place of the application is defined as the scope of that JSP object.
Every object in a JSP page will have a scope. Object scope in JSP is segregated into four parts and they are page, request, session and application.

1. Page
2. request
3. session
4. application

- page
  Page scope means, the JSP object can be accessed only from whithin the same page where it was created. the default scope for jsp object created using \*\*<jsp: useBean> tag is page. JSP implicit object out,exception, response, pageContext, config and page have "page" scope.

- request
  A JSp object created using the request scope can be accessed from any pages that serves request. More than a single request object. Implicit object request have the 'request' scope.

- session
  'session' scope means, the JSP object is accessible from page that belong ti the same session from where it was created. The JSP object that is created with session scope is bound to the session object. Implicit sessoin object have session scope

- application
  A JSP object created using the application scope can be accessed from any page across the appplication. The Jsp object is bound to the applicatiob object. Implicti object application has the application scope

# MVC: Model View Controller

> **Keep Model as POJO** <br>

> **Use DAO(Databse Aceess Object) for databse realted work(not compulsory but good practice)**

## Custom JSP Tags

Steps:

1. You need to create a java class which extends TagSupport Class, and override doStartTag() or doEndTag().
2. Tag Library descriptor (anyname.tld file) (store in webcontent/WEB_INF)
3. JSP page to use the tags with Taglib

   [click here for Code](https://github.com/rawwkush/Assignment/blob/master/readme/custom_jsp_tags.md.md)

## Filters

A filter is an object that is invoked at the preprocessing and postprocessing of a request.

It is mainly used to perform filtering tasks such as conversion, logging, compression, encryption and decryption, input validation etc.

The servlet filter is pluggable, i.e. its entry is defined in the web.xml file, if we remove the entry of filter from the web.xml file, filter will be removed automatically and we don't need to change the servlet.

So maintenance cost will be less.
**Best and important thing of filter is that it is plugable, so code reuse**
<br>
For creating any filter, you must implement the Filter interface. Filter interface provides the life cycle methods for a filter.

1. public void init(FilterConfig config)
2. public void doFilter(HttpServletRequest request,HttpServletResponse response, FilterChain chain)
3. public void destroy()

[click here for Code](https://github.com/rawwkush/Assignment/blob/master/readme/filter.md)

---

# Hibernate

It is a ORM tool.(so we can save our object directly into database)

[click here for Annotation code](https://github.com/rawwkush/Assignment/blob/master/readme/basic_hibernate_annotations.md)
<br>

[Click here for Xml code](https://github.com/rawwkush/Assignment/blob/master/readme/basic_hibernate_xml.md)

---

# Embedding

[click here for Code](https://github.com/rawwkush/Assignment/blob/master/readme/hibernate_embedding.md)

## How to save data if Employee have object of Another class called Address.java

### Hibernate Relations

1. **One to One**

   - [using xml](https://github.com/rawwkush/Assignment/blob/master/readme/OnetoOne_xml.md)
   - [using annotations](https://github.com/rawwkush/Assignment/blob/master/readme/OnetoOne_annotation.md)

2. **OneToMany**

   - [Using XML](https://github.com/rawwkush/Assignment/blob/master/readme/OneToMany_xml.md)
   - using annotation

3. Many to one
   - [using xml](https://github.com/rawwkush/Assignment/blob/master/readme/ManyToOne_xml.md)
   - click here

# Limitaions of hibernate

Shifting from hibernate will require to rewrite all configurations.

**so java provided som API called JPA, and defined some specifications for DB practices.**
All databse related tools to implement these API's and use DB practices.
<br>
So by using JPA Classes we can shift easily from hibernate to other framework.
And instead of XML we use Annotation for mapping.

Instead of using hibernate classes we will use JPA generic classes,
SessionManager ---> EntityManager,
SessionFactory ----> EntityManagerEntity.

And instead of hibernate.cfg.xml we will use persistence.xml(Inside META-INF folder)

[click here to see example](https://github.com/rawwkush/Assignment/blob/master/readme/Demo_JPA.md)

# Spring

IOC; Inversion of Control: control of creatng the object is transferred to Framework.

AOP : Aspect oriented Programming
Aspect-Oriented Programming (AOP) complements Object-Oriented Programming (OOP) by providing another way of thinking about program structure. The key unit of modularity in OOP is the class, whereas in AOP the unit of modularity is the aspect. Aspects enable the modularization of concerns such as transaction management that cut across multiple types and objects.
(Boilerplater reduction using aspect and templates)

> DI; Dependency Injection (Provides looose coupling)<br>

> DI means instead of initialzing attributes of our class by itself we transfers this responsibilty to other class

Example:
**Before DI**

```
public class Employee{

    Address a;
    public Employee(){
        a= newEmployee
    }

}

```

**After applying DI concept**

```

public class Employee{

    Address a;
    public Employee(Address a){
        this.a=a;
    }

}

```

Address a is injected into class employee at run time, by someone else, DI can be done by two ways

1. Constructor Injection
2. Property Injection (Setter)

[click here for Hello World code](https://github.com/rawwkush/Assignment/blob/master/readme/spring_hello_world.md)

# What is a POJO

POJO is plain Old Java Object, this is class which follows below properties

1. Does not inherit any Framework specific class
2. Does not implelment interfaces
3. Does not Contain Annotations

> **NOTE: they can implement serializable interface if required**

# What is a JavaBean

JAvaBean is a special type of POJO with some restrictions like:

1. Fields should be private.
2. Fields should be accessed only thorough getters and setters.
3. **A default constructor is a must( i.e no argument constructor)**
4. They Should implement Serializable interface

[click here for demo](https://github.com/rawwkush/Assignment/blob/master/readme/spring_demo.md)

# Bean

Bean is a class which is managed by IOC container

# Domain Object

objects which are managed by the user

# Working with Annotaion in spring

[click here Code](https://github.com/rawwkush/Assignment/blob/master/readme/spring_annotation.md)

# Service

service is a bean which is not pojo but is used to provide some bussiness logic.
They are also managed by the IOC container but spring knows that they are not Enitity but helpers.
They are singleton as they are service(although we can change it)

```
@Service
class Calculator{
    public int add(int a, int b){
        return a+b;
    }
}

```

you can use @controller annotation too and it won't really change output but using service annotation increases redability for us as we can know that this is not a Componenet clas but only service.

# Spring Boot = spring - configuration

todo

# JS

Todo

# TypeScript

TypeScript extends JavaScript by adding types in javascript.
<br>
Types provide a way to describe the shape of an object, providing better documentation, and allowing TypeScript to validate that your code is working correctly.
<br>
Writing types can be optional in TypeScript, because type inference allows you to get a lot of power without writing additional code.

# Angular
