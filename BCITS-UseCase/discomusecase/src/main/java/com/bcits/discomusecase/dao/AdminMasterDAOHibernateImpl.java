package com.bcits.discomusecase.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.AdminMasterBean;
import com.bcits.discomusecase.beans.BillHistoryBean;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBillBean;
import com.bcits.discomusecase.beans.EmployeeMasterBean;
import com.bcits.discomusecase.beans.MonthlyConsumptionBean;
import com.bcits.discomusecase.beans.TarrifMasterBean;
  

 
@Repository
public class AdminMasterDAOHibernateImpl implements AdminMasterDAO{
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public AdminMasterBean authentication(String userId, String password) {
		EntityManager manager = emf.createEntityManager();
		AdminMasterBean adminMasterBean = manager.find(AdminMasterBean.class, userId );
		if (adminMasterBean != null && adminMasterBean.getPassword().equals(password)) {
			return adminMasterBean;
		} else {
			return null;
		}
		
	}//end of authentication()

	@Override
	public boolean registerEmployee(EmployeeMasterBean employeeMasterBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(employeeMasterBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			manager.close();
		}
	}//end of registeremployee()
	
	@Override
	public List<TarrifMasterBean> getTarrife(){
		EntityManager manager = emf.createEntityManager();
		String jpql = "from TarrifMasterBean ";
		Query query = manager.createQuery(jpql);
		try {
			List<TarrifMasterBean> tarrifMasterBean = (List<TarrifMasterBean>)query.getResultList();
			if(tarrifMasterBean != null) {
				return tarrifMasterBean;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}//end of getMonthlyConsumption()

	@Override
	public int getMulitplayerAmount(String typeOfConsumer, int unitsRange) {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery("Select mulitplayerAmount from TarrifMasterBean where "
				+ "tarrifMasterPK.typeOfConsumer =:typeOfCon and tarrifMasterPK.unitsRange =:unitsRang");
		
		try {
			query.setParameter("typeOfCon", typeOfConsumer);
			query.setParameter("unitsRang", unitsRange);
			int mulitplayerAmount = (int)query.getSingleResult();
			return mulitplayerAmount;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			manager.close();
		}	
	}//end of getMulitplayerAmount()

	@Override
	public boolean tarrifChanged(String typeOfConsumer,int unitsRange,int mulitplayerAmount) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Query query = manager.createQuery(" from TarrifMasterBean where "
				+ "tarrifMasterPK.typeOfConsumer =:typeOfCon and tarrifMasterPK.unitsRange =:unitsRang");
		query.setParameter("typeOfCon",typeOfConsumer );
		query.setParameter("unitsRang",unitsRange);
		try {
			TarrifMasterBean monthlyConsumptionBean = (TarrifMasterBean)query.getSingleResult();
			boolean isAddUpdate= true;
			if(isAddUpdate) {
				transaction.begin();
				monthlyConsumptionBean.setMulitplayerAmount(mulitplayerAmount);
				transaction.commit();
				return isAddUpdate;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}//end of tarrifChanged()
	
	@Override
	public List<EmployeeMasterBean> getAllEmployee() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from EmployeeMasterBean ";
		Query query = manager.createQuery(jpql);
		try {
			List<EmployeeMasterBean> employeeMasterBeanList = (List<EmployeeMasterBean>)query.getResultList();
			if(employeeMasterBeanList != null) {
				return employeeMasterBeanList;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}//end of getAllEmployee()

}//end of class
