package com.smfy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.smfy.biz.impl.UserBizImpl;
import com.smfy.entity.User;

/**
 * Servlet implementation class User_Login_Setvlet
 */
public class User_Login_Setvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_Login_Setvlet() {
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
		User temp=new User();
		temp.setName(userName);
		temp.setPassword(userPwd);
		//���õ�¼
		User user=new UserBizImpl().userLogin(temp);
		//������д��web��ҳ
		response.setCharacterEncoding("utf-8");             
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out= response.getWriter();
		if(user!=null){
			int status=user.getStatus();
			if(status==1){
				 out.write("stop");//�˺ű�ͣ��
			}else{
				//��������״̬
				user.setIslogin(1);
				//�������µ�¼ʱ��
				Timestamp dateNow=new Timestamp(System.currentTimeMillis());//��ȡ��ǰϵͳʱ��
				user.setLoginDate(dateNow);
				new UserBizImpl().updateUserStatus(user);
				//ʹ��JSON�����û�����
				String json=JSON.toJSONString(user);
				//��session
				HttpSession session=request.getSession();
				session.setAttribute("user", user);				
			    out.write(json);
			}		
		}else{
			out.write("error");
		}
		
		out.flush(); 
		out.close(); 	
	}

}
