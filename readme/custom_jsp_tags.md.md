# Java file

```
public class MyClass extends TagSupport{

    @Override
    public int doStartTag() throws JspException{
        JspWriter out = pageContext.getOut();
        out.println("hello world");

        return super.doStartTag();
    }

}

```

# TLD file

this is Tag Libray Descriptor

```
<taglib>

    <tag>
        <name> custom_tag_name </name>
        <tag-class> com.thinkitive.MyClass </tag-class>
    </tag>

</taglib>
```

# Jsp page

```
<%@ taglib uri="/WEB-INF/myfile.tld" prefix="my" %>


<html>
    <body>
        <my:custom_tag_name></my:custom_tag_name>
    </body>
</html>


```

---

# For attributes

1. Declare variables in Java class (Use Wrapper variables instead of primitive datatypes, e.g instead os int use Integer)
2. make getters and setters for variables
3. mention attributes in tld file, name of attribute must be same are variable in class
   Example:

**java**

```
public class MyClass extends TagSupport{

    private String message;

    public void setMessage(String message){
        this.message=message;
    }

    public String message(){
        return message;
    }

    @Override
    public int doStartTag() throws JspException{
        JspWriter out = pageContext.getOut();
        out.println("my message is "+ message);
        return super.doStartTag();
    }
}

```

**tld**

```
<taglib>
    <tag>

        <name> custom_tag_name </name>
        <tag-class> com.thinkitive.MyClass </tag-class>
        <attribute>
            <name> message </name>
        </attribute>>

    </tag>
</taglib>
```

To use the attribute

```
<my: custom_tag_name message="custom jsp created"></my:>
```
