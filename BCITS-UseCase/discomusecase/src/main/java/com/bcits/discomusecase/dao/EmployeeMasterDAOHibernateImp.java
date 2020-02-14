package com.bcits.discomusecase.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBillBean;
import com.bcits.discomusecase.beans.EmployeeMasterBean;
import com.bcits.discomusecase.beans.HelpConsumerBean;
import com.bcits.discomusecase.beans.MonthlyConsumptionBean;
import com.bcits.discomusecase.beans.MonthlyConsumptionPK;
import com.bcits.discomusecase.emailsender.MyMailGenerator;

@Repository
public class EmployeeMasterDAOHibernateImp implements EmployeeMasterDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Autowired
	private BillCalculationDAOHibernateImpl generateBill;
	
	private MyMailGenerator mail = new MyMailGenerator();

	@Override
	public boolean registerEmployee(EmployeeMasterBean employeeMasterBean) {
		return false;
	}

	@Override
	public EmployeeMasterBean authentication(int employeeId, String password) {
		EntityManager manager = emf.createEntityManager();
		EmployeeMasterBean empMasterInfo = manager.find(EmployeeMasterBean.class, employeeId);
		if ((empMasterInfo != null && empMasterInfo.getEmployeeId() == employeeId)
				&& (empMasterInfo.getPassword().equals(password))) {
			return empMasterInfo;
		}
		return null;
	}// end of authentication()

	@Override
	public List<ConsumersMasterBean> getAllConsumer(String region) {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from ConsumersMasterBean where region= :regionName";
		Query query = manager.createQuery(jpql);
		query.setParameter("regionName", region);
		List<ConsumersMasterBean> consumersMasterBean = (List<ConsumersMasterBean>) query.getResultList();
		if (consumersMasterBean != null && !consumersMasterBean.isEmpty()) {
			return consumersMasterBean;
		}
		return null;

	}// end of getAllConsumer()
	
	@Override
	public int countConsumer(String region) {
		EntityManager manager =emf.createEntityManager();
		try {
			String jpql ="select count(*) from ConsumersMasterBean where region= :region ";
			Query query =manager.createQuery(jpql);
			query.setParameter("region", region);
			long count = (long) query.getSingleResult();
		    int numberOfCount = (int)count;
		    return numberOfCount;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}//end of countConsumer()

	@Override
	public boolean currentBillGeneration(CurrentBillBean currentBill,String region) {
		int units = currentBill.getCurrentReading() - currentBill.getPreviousReading();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		MonthlyConsumptionBean monthlyConsumption = new MonthlyConsumptionBean();
		MonthlyConsumptionPK mothlyPk = new MonthlyConsumptionPK();
		CurrentBillBean currentBillBean = manager.find(CurrentBillBean.class, currentBill.getMeterNumber());
		double amount = generateBill.billCalculation(units, currentBill.getConsumerType());
		try {

			transaction.begin();
			if (currentBillBean != null) {
				manager.remove(currentBillBean);
			}
			monthlyConsumption.setBillAmount(amount);
			monthlyConsumption.setStatus("Not Paid");
			monthlyConsumption.setConsumption(units);
			monthlyConsumption.setRegion(region);
			monthlyConsumption.setPreviousReading(currentBill.getPreviousReading());
			monthlyConsumption.setCurrentReading(currentBill.getCurrentReading());
			mothlyPk.setDate(new Date());
			mothlyPk.setMeterNumber(currentBill.getMeterNumber());
			monthlyConsumption.setConsumptionPk(mothlyPk);
			currentBill.setBillAmount(amount);
			currentBill.setBillingDate(new Date());
			currentBill.setConsumption(units);
			currentBill.setStatus("Not paid");
			manager.persist(monthlyConsumption);
			manager.persist(currentBill);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}// end of currentBillGeneration()

	@Override
	public List<HelpConsumerBean> getAllComplaints(String region) {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from HelpConsumerBean where region= :regionName";
		Query query = manager.createQuery(jpql);
		query.setParameter("regionName", region);
		try {
			List<HelpConsumerBean> allComplaints = query.getResultList();
			return allComplaints;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}// end of getAllComplaints()

	@Override
	public boolean removeEmployee(int employeeId) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			EmployeeMasterBean  employeeMasterBean = manager.find(EmployeeMasterBean.class, employeeId );
			transaction.begin();
			manager.remove(employeeMasterBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}//end of removeEmployee()
	@Override
	public boolean sendRespond(String meterNumber,String response,String query) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String jpql=" from HelpConsumerBean where helpConsumerBeanPK.meterNumber= :mNum "
				+ "and helpConsumerBeanPK.querie= :que  ";
			try {
				transaction.begin();
				Query jpqlQuery =manager.createQuery(jpql);
				jpqlQuery.setParameter("mNum", meterNumber);
				jpqlQuery.setParameter("que", query);
				HelpConsumerBean supportBean = (HelpConsumerBean) jpqlQuery.getSingleResult();
				supportBean.setResponce(response);
				transaction.commit();
				return true;
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}//end of sendRespond()

	@Override
	public boolean sendMail(String meterNumber,String email) {
	EntityManager manager = emf.createEntityManager();
	try {
		CurrentBillBean billBean = manager.find(CurrentBillBean.class, meterNumber);
		 mail.sendMail(billBean,email);
		 return true;
		 
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
		 
	}//end of sendMail()

	@Override
	public List<Object[]> getAllPaidAmount(String region) {
		EntityManager manager = emf.createEntityManager();
		try {
			String jpql =" select sum(billAmount), DATE_FORMAT(consumptionPk.date,'%Y-%m') "
					+ "from MonthlyConsumptionBean"
					+ " where region=:region and status='paid' GROUP BY MONTH(consumptionPk.date) ";
			Query query = manager.createQuery(jpql);
			 
			query.setParameter("region", region);
			List<Object[]> paidBillList = query.getResultList(); 
			Object[]  notPaidBill= paidBillList.get(0);
			return paidBillList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}//end of getAllPaidAmount()

	@Override
	public List<Object[]> getAllNotPaidAmount(String region) {
		EntityManager manager = emf.createEntityManager();
		try {
			String jpql =" select sum(billAmount), DATE_FORMAT(consumptionPk.date,'%Y-%m') "
					+ "from MonthlyConsumptionBean"
					+ " where region=:region and status='Not Paid' GROUP BY MONTH(consumptionPk.date) ";
			Query query = manager.createQuery(jpql);
			 
			query.setParameter("region", region);
			List<Object[]> notPaidBillList = query.getResultList(); 
			return notPaidBillList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}//end of getAllNotPaidAmount()

	 
}// end of class
