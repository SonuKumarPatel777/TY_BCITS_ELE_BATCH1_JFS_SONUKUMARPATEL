package com.bcits.discomusecase.dao;

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
		if (consumersMasterBean != null) {
			return consumersMasterBean;
		}
		return null;

	}// end of getAllConsumer()

	@Override
	public boolean currentBillGeneration(CurrentBillBean currentBill) {
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

	}// end of addCurrentBillToMonthlyConsumption()

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
	public String getSingleComplaint(String meterNumber, Date queryDate){
		EntityManager manager = emf.createEntityManager();
		String jpql= "from HelpConsumerBean where helpConsumerBeanPK.meterNumber=:meterNum and helpConsumerBeanPK.queryDate=:queDate ";
		Query query = manager.createQuery(jpql);
		query.setParameter("meterNum", meterNumber);
		query.setParameter("queDate", queryDate);
		try {
			String  getSingleComplaint = (String)query.getSingleResult();
			return getSingleComplaint;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

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
	public boolean sendRespond(String meterNumber,String response ,Date date) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
			try {
				transaction.begin();
				String jpql=" from HelpConsumerBean where meterNumber= :mNum and DATE(date)=:date ";
				Query query =manager.createQuery(jpql);
				query.setParameter("mNum", meterNumber);
				query.setParameter("date", date);
				HelpConsumerBean supportBean = (HelpConsumerBean) query.getSingleResult();
				supportBean.setResponce(response);
				transaction.commit();
				return true;
			}catch (Exception e) {
				e.printStackTrace();
				
				return false;
			}
	}//end of sendRespond()

	@Override
	public boolean sendMail(String meterNumber) {
	EntityManager manager = emf.createEntityManager();
	try {
		CurrentBillBean billBean = manager.find(CurrentBillBean.class, meterNumber);
		 mail.sendMail(billBean);
		 return true;
		 
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
		 
	}//end of sendMail()

}// end of class
