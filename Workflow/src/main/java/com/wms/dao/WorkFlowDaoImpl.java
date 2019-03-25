package com.wms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wms.model.Workflow;

@Repository
public class WorkFlowDaoImpl implements WorkFlowDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public boolean doCreate(Workflow workflow) {
		entityManager.persist(workflow);
		return true;
	}
}
