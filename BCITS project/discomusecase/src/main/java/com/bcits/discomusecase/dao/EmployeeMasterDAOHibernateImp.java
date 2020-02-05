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
import com.bcits.discomusecase.beans.MonthlyConsumptionBean;
import com.bcits.discomusecase.beans.MonthlyConsumptionPK;

@Repository
public class EmployeeMasterDAOHibernateImp implements EmployeeMasterDAO{
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Autowired
	private BillCalculationDAOHibernateImpl generateBill;

	@Override
	public boolean registerEmployee(EmployeeMasterBean employeeMasterBean) {
		return false;
	}

	@Override
	public EmployeeMasterBean authentication(int employeeId, String password) {
		EntityManager manager = emf.createEntityManager();
		EmployeeMasterBean empMasterInfo = manager.find(EmployeeMasterBean.class, employeeId);
		if((empMasterInfo != null && empMasterInfo.getEmployeeId()== employeeId)&&
				(empMasterInfo.getPassword().equals(password))) {
			return empMasterInfo;
		}
		return null;
	}//end of authentication()
    
	@Override
	public List<ConsumersMasterBean> getAllConsumer(String region) {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from ConsumersMasterBean where region= :regionName";
		Query query = manager.createQuery(jpql);
		query.setParameter("regionName", region);
		List<ConsumersMasterBean> consumersMasterBean = (List<ConsumersMasterBean>)query.getResultList();
		if(consumersMasterBean != null) {
			return consumersMasterBean;
		}
		return null;
		 
	}//end of getAllConsumer()

	@Override
	public boolean addCurrentBillToMonthlyConsumption(CurrentBillBean currentBill) {
		int units = currentBill.getCurrentReading()-currentBill.getPreviousReading();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		MonthlyConsumptionBean monthlyConsumption = new MonthlyConsumptionBean();
		MonthlyConsumptionPK mothlyPk = new MonthlyConsumptionPK();
		CurrentBillBean bill = manager.find(CurrentBillBean.class, currentBill.getMeterNumber());
		String typeOfConsumer = currentBill.getConsumerType();
		double amount = generateBill.billCalculation(units, typeOfConsumer);
		 try {
			 transaction.begin();
			 if(bill != null) {
				 manager.remove(bill);
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
			 currentBill.setConsumption(units);
			 currentBill.setStatus("Not paid");
			 manager.persist(monthlyConsumption);
			 manager.persist(currentBill);
			 transaction.commit();
			 return true;
		 }catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}//end of addCurrentBillToMonthlyConsumption(

	 

}//end of class
