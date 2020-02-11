package com.bcits.discomusecase.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.MonthlyConsumptionBean;
import com.bcits.discomusecase.beans.TarrifMasterBean;

@Repository
public class BillCalculationDAOHibernateImpl {
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	
	public double billCalculation(int units ,String typeOfConsumer) {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from TarrifMasterBean where tarrifMasterPK.typeOfConsumer= :consumerType";
		Query query = manager.createQuery(jpql);
		query.setParameter("consumerType", typeOfConsumer);
		List<TarrifMasterBean> tarrifMasterBean = (List<TarrifMasterBean>)query.getResultList();
		
		System.out.println(typeOfConsumer);
		int firstRange = tarrifMasterBean.get(0).getTarrifMasterPK().getUnitsRange();
		int secondRange = tarrifMasterBean.get(1).getTarrifMasterPK().getUnitsRange();
		int thirdRange = tarrifMasterBean.get(2).getTarrifMasterPK().getUnitsRange();
		
		int firstMulitplayerAmount = tarrifMasterBean.get(0).getMulitplayerAmount();
		int secondMulitplayerAmount = tarrifMasterBean.get(1).getMulitplayerAmount();
		int thirdMulitplayerAmount = tarrifMasterBean.get(2).getMulitplayerAmount();
		
		double billAmount=0.0;
		if (units < firstRange) {
			billAmount = units * firstMulitplayerAmount;
		} else if (units < secondRange) {
			billAmount = (firstRange * firstMulitplayerAmount) + ((units - firstRange)
					* secondMulitplayerAmount);
		} else if (units > thirdRange) {
			billAmount = (firstRange * firstMulitplayerAmount) + (firstRange * secondMulitplayerAmount)
					+ ((units - secondRange) * thirdMulitplayerAmount);
		}
		return billAmount;
		
	}//end of registerConsumer()

}//end of class
