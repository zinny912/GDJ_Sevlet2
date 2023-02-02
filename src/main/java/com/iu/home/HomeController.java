package com.iu.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HomeController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello JH");
		
		//객체생성 : 클래스에 정의된 대로 사용하기위해
		//클래스내에 생성자가 없지만 기본생성자 컴파일러가 생성함
		Soldier soldier = new Soldier();
		Gun gun = new Gun();
		Bullet bullet = new Bullet();
		gun.setBullet(bullet); //총에다가 총알집어넣어
		
		soldier.setGun(gun);
			
		soldier.useGun();
		
//		String method = request.getMethod();
//		StringBuffer sb =request.getRequestURL();
//		String uri = request.getRequestURI();
//		
//		Cookie [] cookies = request.getCookies();
//		
//		String context = request.getContextPath();
//		String name = request.getParameter("name");
//		
//		int age = Integer.parseInt(request.getParameter("age"));
//		
//		String [] moneys= request.getParameterValues("money");
		
		
		
		
//		System.out.println("Method : " +method);
//		System.out.println("URL :"+sb);
//		System.out.println("URI :"+uri);
//		
//		for(Cookie cookie: cookies) {
//			System.out.println("CookieName : " +cookie.getName());
//			System.out.println("CookieValue : "+cookie.getValue());
//		
//		}
//		
//		System.out.println("ContextPath : "+context); //GDJ60
//		System.out.println("Name : "+name);
//		System.out.println("Age : "+age*2);
//		
//		
//		for(String m : moneys) {
//			System.out.println(m);
//		}
		
		//PrintWriter out = respose.getWriter(); 
		//out.println("<h1>JH PAGE</h1>")
		//<h2></h2>
		//out.close();
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
