package com.ict.edu;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 : 자바를 가지고 웹 페이지를 표현하는 기법
//        자바에서 HTML,CSS,Javascript 등을 표현해서 웹 페이지로 만들어 표시한다.
//        main 메소드 없이 실행한다.


// URL mapping : 해당 페이지를 웹에서 접근할 수 있는 주소
//					localhost:8090/프로젝트이름/URL mapping주소("Ex01")
@WebServlet("/Ex01")
public class Ex01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Ex01() {
        super();
        // 콘솔창에 출력된다.(웹페이지에는 출력되지 않는다.)
        System.out.println("생성자");
    }

	
	public void init(ServletConfig config) throws ServletException {
		// 생성자와 멤버필드의 초기화, 객체 생성할 때 한번 호출된다.
		System.out.println("init");
		  // 자동으로 service를 호출한다.
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스의 역할은 클라이언트가 정보를 요청할때 요청 방식에 따라 알맞는 메소드를 호출하는 역할을 한다.
		// 요청 방식 : - get 방식
		//			 - post 방식
		// ** get방식(생략가능) : 정보를 http 패킷의 head에 담아서 보낸다.
		//						주소창에 해당 정보가 보인다. 속도가 빠르다. 적은 양에 적합, 보안에 취약
		// ** post방식 : 정보를 http 패킷의 body에 담아서 보낸다.
		// 						주소창에 해당 정보가 안보인다. 속도가 상대적으로 느리다. 많은 양에 적합, 보안에 비교적 적합
	
		// ** request : 클라이언트에게 들어온 요청정보를 가지고 있는 객체
		// ** response : 클라이언트에게 결과를 보여줄 수 있는 응답정보를 가지고 있는 객체
		System.out.println("service");
		
		if(request.getMethod().equalsIgnoreCase("get")) {
			doGet(request,response);
		}else if(request.getMethod().equalsIgnoreCase("post")) {
			doPost(request,response);
		}
	}
	
	// 서블릿이 자바코드와 html,css,javascript를 섞어서 사용해서 웹페이지를 만드는 메소드 (doGet(),doPost())
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGET()");
		doPost(request,response);
	}
	
	
	// 서블릿이 자바코드와 html,css,javascript를 섞어서 사용해서 웹페이지를 만드는 메소드 (doGet(),doPost())
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
	}
	
	public void destroy() {
		// 해당 프로젝트 톰켓에서 삭제되기 직전에 실행하는 메소드
		System.out.println("destroy");
	}

	

	

}
