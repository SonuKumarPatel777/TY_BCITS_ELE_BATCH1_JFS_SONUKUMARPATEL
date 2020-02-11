package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.UserAddressBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserOtherInfoBean;

public class UserJSONMarshalling {
	
	public static void main(String[] args) {
		
		UserInfoBean userInfoBean = new UserInfoBean();
		userInfoBean.setEmpId(101101);
		userInfoBean.setName("sonu kumar");
		userInfoBean.setMobileNum(7845124578L);
		userInfoBean.setOfficalMailId("sonuku@gmail.com");
		userInfoBean.setDateOfBirth(new Date());
		userInfoBean.setDateOfJoining(new Date());
		userInfoBean.setDesignation("SSD");
		userInfoBean.setBloodGroup("O+");
		userInfoBean.setEmployeeSalary((double) 55000);
		userInfoBean.setDepartmentId(45);
		userInfoBean.setManagerId(1002);
		userInfoBean.setPassword("qweertyu");
		
		UserOtherInfoBean userOtherInfoBean = new UserOtherInfoBean();
		userOtherInfoBean.setGender("male");
		userOtherInfoBean.setAddharNumber(1245784512457845L);
		
		userInfoBean.setUserOtherInfoBean(userOtherInfoBean);
		UserAddressBean tempUserAddress = new UserAddressBean();
		tempUserAddress.setHousnumber(55);
		tempUserAddress.setCity("BBL");
		tempUserAddress.setStreet("WEQ street");
		tempUserAddress.setAddressType('t');
		
		UserAddressBean permanentUserAddress = new UserAddressBean();
		permanentUserAddress.setHousnumber(58);
		permanentUserAddress.setCity("HYD");
		permanentUserAddress.setStreet("WEr street");
		permanentUserAddress.setAddressType('p');
				
		
		List<UserAddressBean> userAddressBeansList =  new ArrayList<UserAddressBean>();
		userAddressBeansList.add(tempUserAddress);
		userAddressBeansList.add(permanentUserAddress);
		
		userInfoBean.setUserAddresslist(userAddressBeansList);
		
		
		try {
			ObjectMapper mapper =new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter();//formated
			mapper.writeValue(new File("userjson1.json"), userInfoBean);
			mapper.writeValue(System.out, userInfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
	}//End of main()

}//End of class
