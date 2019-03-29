package com.wms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wms.model.Workflow;

@Repository
@Transactional
public class WorkFlowDaoImpl implements WorkFlowDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean doCreate(Workflow workflow) {
		entityManager.persist(workflow);
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Workflow> getWorkflows() {
		String hql = "FROM Workflow as workflow";
		return (List<Workflow>) entityManager.createQuery(hql).getResultList();
	}
}
