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
import com.bcits.discomusecase.beans.HelpConsumerBean;
import com.bcits.discomusecase.beans.HelpConsumerBeanPK;
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
			return false;
		}finally {
			manager.close();
		}
		
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
		String jpql = "from MonthlyConsumptionBean where consumptionPk.meterNumber=:meterNum";
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
		try {
			CurrentBillBean currentBill = manager.find(CurrentBillBean.class, meterNumber);
			return currentBill;
		} catch (Exception e) {
			return null;
		}finally {
			manager.close();
		}	
		
	}//end of getCurrentBill()


	@Override
	public List<BillHistoryBean> getBillHistory(String meterNumber) {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery("from BillHistoryBean where biHistoryPK.meterNumber= :rrNum ");
		
		try {
			query.setParameter("rrNum", meterNumber);
			List<BillHistoryBean> billList = query.getResultList();
			return billList;
		} catch (Exception e) {
			return null;
		}finally {
			manager.close();
		}	
		
		
		 
	}//end of getBillHistory()


	@Override
	public  Double getBillAmount(String meterNumber) {
		EntityManager manager = emf.createEntityManager();
		CurrentBillBean currentBill = manager.find(CurrentBillBean.class, meterNumber);
		if (currentBill != null) {
			Double billAmount = currentBill.getBillAmount();
			return billAmount;
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
		
		String jpql = "from MonthlyConsumptionBean where consumptionPk.meterNumber=:meterNum";
		Query query = manager.createQuery(jpql);
		query.setParameter("meterNum", meterNumber);
		try {
			MonthlyConsumptionBean monthlyConsumptionBean = (MonthlyConsumptionBean)query.getSingleResult();
			
			CurrentBillBean currentBillBean = manager.find(CurrentBillBean.class, meterNumber);
			 
			boolean isAddUpdate= true;
			
			if(isAddUpdate) {
				transaction.begin();
				manager.persist(billHistoryBean);
				currentBillBean.setStatus("paid");
				monthlyConsumptionBean.setStatus("paid");
				transaction.commit();
				return isAddUpdate;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		try {
			Query query = manager.createQuery(jpql);
			query.setParameter("rrNum", meterNumber);
			int previous = (int) query.getSingleResult();
			if(previous != 0) {
			}	return previous;
		}catch(Exception e){
			return 0;
		}
		
	}//end of getPreviousReading()


	@Override
	public boolean setQuerie(ConsumersMasterBean consumersMasterBean, String querie) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		HelpConsumerBean helpConsumerBean = new HelpConsumerBean();
		helpConsumerBean.setQuerie(querie);
		helpConsumerBean.setRegion(consumersMasterBean.getRegion());
	    helpConsumerBean.setResponce("Not Responce");
	    
	    HelpConsumerBeanPK helpConsumerBeanPK = new HelpConsumerBeanPK();
		helpConsumerBeanPK.setMeterNumber(consumersMasterBean.getMeterNumber());
		helpConsumerBeanPK.setQueryDate(new Date());
		
		helpConsumerBean.setHelpConsumerBeanPK(helpConsumerBeanPK);
		
		try {
			transaction.begin();
			manager.persist(helpConsumerBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}//end of setQuerie()


	@Override
	
	public boolean authenticationForSetPassword(ConsumersMasterBean consumersMasterBean) {
		String meterNumber = consumersMasterBean.getMeterNumber();
		String email = consumersMasterBean.getEmail();
		EntityManager manager = emf.createEntityManager();
		ConsumersMasterBean consumersMaster = manager.find(ConsumersMasterBean.class, meterNumber );
		if (consumersMaster != null && consumersMaster.getEmail().equals(email)) {
			return true;
		} else {
			return false; 
		}
		
	}//end of authenticationForSetPassword()


	@Override
	public boolean reSetPassword(ConsumersMasterBean consumersMasterBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String meterNumber = consumersMasterBean.getMeterNumber();
		String jpql = "from ConsumersMasterBean where meterNumber=:meterNum";
		Query query = manager.createQuery(jpql);
		query.setParameter("meterNum", meterNumber);
	    ConsumersMasterBean  consumerMaster = (ConsumersMasterBean)query.getSingleResult();
		String password = consumersMasterBean.getPassword();
		try {
			transaction.begin();
			consumerMaster.setPassword(password);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			manager.close();
		}
	}


	@Override
	public List<HelpConsumerBean> getAllResponse(String meterNumber) {
		EntityManager manager = emf.createEntityManager();
		String jpql =" from HelpConsumerBean where helpConsumerBeanPK.meterNumber=:rrNum ";
		try {
			Query query = manager.createQuery(jpql);
			query.setParameter("rrNum", meterNumber);
			List<HelpConsumerBean> helpEmployeeResponce = query.getResultList();
			if(helpEmployeeResponce != null) {
			}	return helpEmployeeResponce;
		}catch(Exception e){
			return null;
		}
	}


	@Override
	public boolean removeConsumer(String meterNumber) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			ConsumersMasterBean consumersMaster = manager.find(ConsumersMasterBean.class, meterNumber );
			transaction.begin();
			manager.remove(consumersMaster);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}//end of removeConsumer()
	

}//end of class
