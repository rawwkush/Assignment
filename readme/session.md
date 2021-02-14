# Hidden HTML form fiels

**HTML FILE**

```
<form action="login" method="post">
	<input type="text" name="username" />
	<input type="password" name="pass" />

	<!--hidden field -->
	<input type="hidden" name="sessionid" value="1234" />
	<button type="submit"> sumbit </button>>

</form>>
```

**Login Servlet**

```
public void doPost(....){
	String user=request.getParameter("username");
	String pass=request.getParameter("pass");
	if(user.equals("admin") && pass.equals("pass") ){
		RequestDispatcher dispatcher= request.getRequestDispatcher("AccountServlet");
		dispatcher.forward(request, response);
	}else{
		out.println("imvalid credentials");
	}
}

```

**servlet that access should be allowed only whenn user is logged in**

```
public void doPost(.....){
	String session= request.getParameter("sessionid");
	if(sessionid!=null){
		out.print("Your balance is 100");
	}else{
		out.print("logg in first to acess this page");
	}
}

```

Con of this method is that the sessionid is static and it is visible in HTML page source code. So it is not used for session handling.

---

# URL Rewriting

**login Page servlet**

```
public void doPost(....){
	String user=request.getParameter("username");
	String pass=request.getParameter("pass");
	if(user.equals("admin") && pass.equals("pass") ){
		RequestDispatcher dispatcher= request.getRequestDispatcher("AccountServlet?"+"sessionid="+"1234");
		dispatcher.forward(request, response);
		// we can use sendRedirect() too
	}else{
		out.println("imvalid credentials");
	}
}

```

**Restricted servlet**

```
public void doPost(.....){
	String session= request.getParameter("sessionid");
	if(sessionid!=null){
		out.print("Your balance is 100");
	}else{
		out.print("logg in first to acess this page");
	}
}

```

---

# Cookie

Cookie aren't meant for session handling, but we can use it for sessions too.

**Login servlet**

```
public void doPost(...){
	String user=....
	String pass=....
	if(user.equals(..)&& pass.equals(..)){
		RequestDispatcher d= request.getRequestDispatcher("NextServlet");
		//Cookie for session management (done by on server without saving data in client side)

		Cooke ck= new Cookie("seesionid","1234");
		response.addCookie(ck);


		d.forward(request,response);
	}else{
		out.print("Wrong credentials")
	}
}

```

**Restricted servlet**

```
public void doPost(...){
	Cookie ck[] = request.getCookies();
	if(ck!=null){
		out.print("your balcane is 100");

	}else{
		out.print("login first to acess" );
	}
}
```

---

# HttpSession

It is a combination of Cookie and URL rewriting.

**Login servlet**

```
public void doPost(....){
	String user=request.getParameter("username");
	String pass=request.getParameter("pass");
	if(user.equals("admin") && pass.equals("pass") ){

		HttpSession  session= request.getSession();// open session if exist else create new

		response.sendRedirect("balanceServlet");

	}else{
		out.println("imvalid credentials");
	}
}

```

**Restricted Servlet**

```
public void doPost(.....){

	HttpSession session= request.getSession(false); // get session if exist, don;t create a new if it doesn't


	if(session!=null){
		out.print("balance is 1000");
	}else{
		out.print("login again");
	}


}

```

You can add additional data if you want in the session by

```
session.setAttribute("key", "value");
```
