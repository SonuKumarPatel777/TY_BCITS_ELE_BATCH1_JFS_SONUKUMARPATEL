package com.bcits.springrestjaxb.apptest;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.beans.UserAddressBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;

 

public class UserUnmarshalling {

	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(UserInfoBean.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			UserInfoBean  userInfoBean =(UserInfoBean) unmarshaller.unmarshal(new File("userInfo2.xml"));
			System.out.println("Emp ID             :"+userInfoBean.getEmpId());
			System.out.println("Emp name           :"+userInfoBean.getName());
			System.out.println("Emp MN             :"+userInfoBean.getMobileNum());
			System.out.println("Emp OfficalMailId  :"+userInfoBean.getOfficalMailId());
			System.out.println("Emp DOB            :"+userInfoBean.getDateOfBirth());
			System.out.println("Emp Gender         :"+userInfoBean.getUserOtherInfoBean().getGender()); 
			System.out.println("Emp Addhar no.     :"+userInfoBean.getUserOtherInfoBean().getAddharNumber());
			
//			for (UserAddressBean userAddressBean : userInfoBean.getUserAddresslist()) {
//				System.out.println("Emp addressType:"+userAddressBean.getAddressType());
//				System.out.println("Emp city       :"+userAddressBean.getCity());
//				System.out.println("Emp Housnumber :"+userAddressBean.getHousnumber());
//				System.out.println("Emp Street     :"+userAddressBean.getStreet());
//				
//			}
			 
		} catch (JAXBException e) {
			e.printStackTrace();
		}
       
	}//End of main()

}//End of Class
