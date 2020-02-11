package com.bcits.discomusecase.dao;

 
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.BillHistoryBean;
import com.bcits.discomusecase.beans.BillHistoryPK;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBillBean;
import com.bcits.discomusecase.beans.MonthlyConsumptionBean;
 

@Repository
public class ConsumerMasterDAOHibernateImp implements ConsumersMasterDAO{
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean registerConsumer(ConsumersMasterBean consumersMasterBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(consumersMasterBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return false;
	}//end of registerConsumer()
	
	
	@Override
	public ConsumersMasterBean authentication(String meterNumber, String password) {
		EntityManager manager = emf.createEntityManager();
		ConsumersMasterBean consumersMasterBean = manager.find(ConsumersMasterBean.class, meterNumber );
		if (consumersMasterBean != null && consumersMasterBean.getPassword().equals(password)) {
			return consumersMasterBean;
		} else {
			return null;
		}
	}//end of authentication()


	@Override
	public List<MonthlyConsumptionBean> getMonthlyConsumption(String meterNumber) {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from MonthlyConsumptionBean where consumptionPk.meterNumber= :meterNum";
		Query query = manager.createQuery(jpql);
		query.setParameter("meterNum", meterNumber);
		List<MonthlyConsumptionBean> monthlyConsumptionBean = (List<MonthlyConsumptionBean>)query.getResultList();
		if(monthlyConsumptionBean != null) {
			return monthlyConsumptionBean;
		}
		return null;
	}//end of getMonthlyConsumption() 


	@Override
	public CurrentBillBean getCurrentBill(String meterNumber) {
		EntityManager manager = emf.createEntityManager();
		CurrentBillBean currentBill = manager.find(CurrentBillBean.class, meterNumber);
		if (currentBill != null) {
			return currentBill;
		}
		manager.close();
		return null;
	}//end of getCurrentBill()


	@Override
	public List<BillHistoryBean> getBillHistory(String meterNumber) {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery("from BillHistoryBean where biHistoryPK.meterNumber= :rrNum ");
		query.setParameter("rrNum", meterNumber);
		List<BillHistoryBean> billList = query.getResultList();
		if (billList != null) {
			return billList;
		}
		manager.close();
		return null;
	}//end of getBillHistory()


	@Override
	public CurrentBillBean getBillAmount(String meterNumber) {
		EntityManager manager = emf.createEntityManager();
		CurrentBillBean currentBill = manager.find(CurrentBillBean.class, meterNumber);
		if (currentBill != null) {
			return currentBill;
		}
		manager.close();
		return null;
	}//end of getBillAmount()


	@Override
	public boolean successfullBillPayment(String meterNumber, Date date, Double amount) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		BillHistoryBean billHistoryBean = new BillHistoryBean();
		BillHistoryPK billHistoryPK = new BillHistoryPK();
		billHistoryBean.setAmount(amount);
		billHistoryBean.setStatus("paid");
		
		billHistoryPK.setMeterNumber(meterNumber);
		billHistoryPK.setPaymentDate(date);
		
		billHistoryBean.setBiHistoryPK(billHistoryPK);
		boolean isAdd= true;
		if(isAdd) {
			transaction.begin();
			manager.persist(billHistoryBean);
			transaction.commit();
			return isAdd;
		}else {
			return false;
		}
		
		
	}//end of successfullBillPayment()


	@Override
	public ConsumersMasterBean getConsumer(String meterNumber) {
		EntityManager manager = emf.createEntityManager();
		ConsumersMasterBean conInfoBean = manager.find(ConsumersMasterBean.class, meterNumber);
		if(conInfoBean != null) {
			return conInfoBean;
		}
		manager.close();
		return null;
	}//end of getConsumer()


	@Override
	public int getPreviousReading(String meterNumber) {
		EntityManager manager = emf.createEntityManager();
		String jpql =" select currentReading from CurrentBillBean where meterNumber=:rrNum ";
		Query query = manager.createQuery(jpql);
		query.setParameter("rrNum", meterNumber);
		int previous = (int) query.getSingleResult();
		if(previous != 0) {
			return previous;
		}
		return 0;
	}//end of getPreviousReading()
	

}//end of class
