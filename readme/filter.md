# Steps

1. goto File
2. goto New
3. select Filter

# MyFilter.java

**URl pattern of servlet is entered in the filter too fo plugging it into the servlet**

```
@WebFilter("/urlpatter_For_servlet")
class MyFilter implements Filter{

	@Override
	public void init(FilterConfig config){

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException{

		//your code

		//pass the request along the filter chain
		chain.doFilter(request, response);

		/*
			code below this will be called when chain.doFilter has 	done its worked like executing another filter or 	servlet
		*/
	}

	@Override
	public void init(FilterConfig config){

	}
}

```
