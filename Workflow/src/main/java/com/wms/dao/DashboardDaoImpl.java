package com.wms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wms.model.WorkflowInstance;

@Repository
@Transactional
public class DashboardDaoImpl implements DashboardDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WorkflowInstance> getAllWorkflowInstance(){
		String workflowInstanceQuery = "From WorkflowInstance as workflowInstance";
		return (List<WorkflowInstance>) entityManager.createQuery(workflowInstanceQuery).getResultList();
	}
}
