package puntoventa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import puntoventa.modelo.Usuario;

public class Filtro implements Filter {
	FilterConfig config = null;
	ServletContext servletContext = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,	FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		HttpServletResponse response=(HttpServletResponse)servletResponse;
		HttpSession sesion=request.getSession();
		Usuario u=null;
		u=(Usuario)sesion.getAttribute("usuario");
		if(u!=null){
			filterChain.doFilter(request, response);
		}else{
			response.sendRedirect("/index.jsp");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
		servletContext = config.getServletContext();

	}

}
