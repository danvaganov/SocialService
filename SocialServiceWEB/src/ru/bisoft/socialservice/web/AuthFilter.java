package ru.bisoft.socialservice.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(urlPatterns = { "/private/*" })
public class AuthFilter implements Filter {
	private static final String FACES_REDIRECT_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
		    + "<partial-response><redirect url=\"%s\"></redirect></partial-response>";
	/**
	 * Default constructor.
	 */
	public AuthFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();

		HttpSession session = req.getSession(false);

		if ((session == null || session.getAttribute("user")==null) && (!uri.endsWith("login.xhtml"))) {
		    if ("partial/ajax".equals(req.getHeader("Faces-Request"))) 
		    {
		        res.setContentType("text/xml");
		        res.setCharacterEncoding("UTF-8");
		        res.getWriter().printf(FACES_REDIRECT_XML, req.getContextPath() + "/login.xhtml");	
		    }
		    else
		    	res.sendRedirect(req.getContextPath() + "/login.xhtml");
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
