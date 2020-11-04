package com.smfy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smfy.biz.impl.AdminBizImpl;
import com.smfy.entity.Admin;

/**
 * Servlet implementation class Admin_Login_Servlet
 */
public class Admin_Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Login_Servlet() {
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
		String userName=request.getParameter("userName");
		String userPwd=request.getParameter("userPwd");
		String code=request.getParameter("code");
		String numrand=(String) request.getSession().getAttribute("code");//ȡ��ϵͳ���ɵ���֤��
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		//�ȼ����֤��
		if(code.equalsIgnoreCase(numrand)){
			//��������
			Admin temp=new Admin();
			temp.setName(userName);
			temp.setPassword(userPwd);
			Admin admin=new AdminBizImpl().adminLogin(temp);
				if(admin!=null){
					int status=admin.getStatus();
					if(status==1){
						 out.write("stop");//�˺ű�ͣ��
					}else{
					//�������µ�¼ʱ��
					Timestamp loginDate=new Timestamp(System.currentTimeMillis());//��ȡ��ǰϵͳʱ��
					admin.setLoginDate(loginDate);
					new AdminBizImpl().updateAdminStatus(admin);
				   //����Session
					HttpSession session=request.getSession();
					session.setAttribute("admin", admin);
					out.write("ok");
					}
				}else {
					out.write("error");
			}
		}else{
			out.write("vcError");
		}
		out.flush();
		out.close();		
		
	}
}
