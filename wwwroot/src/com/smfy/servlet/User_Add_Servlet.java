package com.smfy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smfy.biz.impl.UserBizImpl;
import com.smfy.entity.User;

/**
 * Servlet implementation class User_Del_Servlet
 */
public class User_Add_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_Add_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");	
		String name=request.getParameter("name");		
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String qq=request.getParameter("qq");
		String email=request.getParameter("email");
		String code=request.getParameter("code");
		String numrand=(String) request.getSession().getAttribute("code");//ȡ��ϵͳ���ɵ���֤��
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		//�ȼ����֤��
		if(code.equalsIgnoreCase(numrand)){
			//��������
			User user=new User();
			user.setName(name);
			user.setPassword(password);
			user.setPhone(phone);
			user.setQq(qq);
			user.setEmail(email);			
			
			int falg=new UserBizImpl().addUser(user);
			if(falg>0){
				out.write("ok");
			}else {
				out.write("error");
			}
			System.out.println(falg);
		}else{
			out.write("vcError");
		}
		out.flush();
		out.close();
	
	}

}
