package com.ty_one_to_one_uni2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_one_to_one_uni2.dto.PanCard;
import com.ty_one_to_one_uni2.dto.Person;

public class PanCardDeo {
public EntityManager getEntityManager()
{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	return entityManagerFactory.createEntityManager();
}

public void SavePanCard(PanCard panCard)
{
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(panCard);
	entityTransaction.commit();
}
public void updatePanCard(String name,int pid) {
	EntityManager entityManager = getEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	PanCard panCard= entityManager.find(PanCard.class,pid);
	panCard.setName(name);
	entityTransaction.begin();
	entityManager.merge(panCard);
	entityTransaction.commit();
	System.out.println("update");
}

public void deletePanCard(int pid) {
	EntityManager entityManager = getEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	PanCard panCard = entityManager.find(PanCard.class, pid);
	if (panCard != null) {
		entityTransaction.begin();
		entityManager.remove(panCard);
		entityTransaction.commit();
	}
	System.out.println("deleted");
}

public PanCard getPanCardByPanCardId(int pid) {
	EntityManager entityManager = getEntityManager();
	PanCard panCard = entityManager.find(PanCard.class, pid);
	return panCard;
	
}

public List<PanCard> getAllPerson() {
	EntityManager entityManager = getEntityManager();
	Query query = entityManager.createQuery("Select p From PanCard p");
	return query.getResultList();
}
}
