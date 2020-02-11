package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserOtherInfoBean;

public class UserJSONUnmarshalling {
	
	public static void main(String[] args) {
		
		//Unmarshalling from JSON
		
				try {
					ObjectMapper mapper =new ObjectMapper();
					UserInfoBean UserInfoBean = mapper.readValue(new File("userjson.json"),UserInfoBean.class);
					
					System.out.println("Emp ID             :"+UserInfoBean.getEmpId());
					System.out.println("Emp name           :"+UserInfoBean.getName());
					System.out.println("Emp MN             :"+UserInfoBean.getMobileNum());
					System.out.println("Emp OfficalMailId  :"+UserInfoBean.getOfficalMailId());
					System.out.println("Emp DOB            :"+UserInfoBean.getDateOfBirth());
					System.out.println("Emp Password       :"+UserInfoBean.getPassword());
					System.out.println("Emp AddharNumber   :"+UserInfoBean.getUserOtherInfoBean().getAddharNumber());
					System.out.println("Emp Gender         :"+UserInfoBean.getUserOtherInfoBean().getGender());
				} catch (Exception e) {
					e.printStackTrace();
				}  
	}//End of main()

}//End of class
