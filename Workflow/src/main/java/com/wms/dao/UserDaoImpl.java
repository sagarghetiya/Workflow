package com.wms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.wms.controller.PassEncryption;
import com.wms.model.User;
import com.wms.model.UserGroup;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager entityManager;
	private PassEncryption passEncryption = new PassEncryption("himsagabcdprijay");

	@Override
	public void doRegister(User user) {
		try {
			user.setPassword(passEncryption.encrypt(user.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.persist(user);
	}

	@Override
	public boolean registerExists(String username, String email) {
		String hql = "FROM User as user WHERE user.userName = ?1 or user.email = ?2";
		int count = entityManager.createQuery(hql).setParameter(1, username).setParameter(2, email).getResultList()
				.size();
		System.out.println("count:" + count);
		return count > 0 ? true : false;
	}
	
	@Override
	public User getUser(Long userid) {
		String hql = "from User as u where u.userId =?1";
		return (User) entityManager.createQuery(hql).setParameter(1, userid).getSingleResult();
	}

	@Override
	public List<User> getAllUsers() {
		String hql = "from User";
		@SuppressWarnings("unchecked")
		List<User> resultList = (List<User>) entityManager.createQuery(hql).getResultList();
		return resultList;
	}

	@Override
	public void addUserGroup(UserGroup grp) {
		UserGroup g = new UserGroup();
		g.setUserGroupName(grp.getUserGroupName());
		g.setDescription(grp.getDescription());
		for (User u : grp.getUserList()) {
			User ob = new User();
			ob = getUser(u.getUserId());
			g.addUser(ob);
		}
		entityManager.persist(g);
	}

	@Override
	public UserGroup getGroup(Long grpid) {
		String hql = "from UserGroup where userGroupId=?1";
		return (UserGroup) entityManager.createQuery(hql).setParameter(1, grpid).getSingleResult();
		/*
		 * TypedQuery<Object[]> query=
		 * entityManager.createQuery("FROM UserGroup g WHERE g.userGroupId = ?1",
		 * Object[].class); List<Object[]> results = query.setParameter(1,
		 * grpid).getResultList();
		 * 
		 * List<User> s=new ArrayList<>(); for (Object[] result : results) { s =
		 * (List<User>) result[0]; } return s;
		 */
	}

	@Override
	public List<UserGroup> getAllGroups() {
		String hql = "from UserGroup";
		@SuppressWarnings("unchecked")
		List<UserGroup> resultList = (List<UserGroup>) entityManager.createQuery(hql).getResultList();
		return resultList;
	}
}
