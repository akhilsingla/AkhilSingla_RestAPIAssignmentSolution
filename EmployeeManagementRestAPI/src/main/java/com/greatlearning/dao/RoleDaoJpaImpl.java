package com.greatlearning.dao;

import com.greatlearning.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class RoleDaoJpaImpl implements RoleDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public void addRole(Role role) {
        entityManager.merge(role);
    }

//    @Override
//    public Role findRoleByName(String theRoleName) {
//
//        Session currentSession = sessionFactory.getCurrentSession();
//        Query<Role> theQuery = currentSession.createQuery("from Role where name=:roleName", Role.class);
//        theQuery.setParameter("roleName", theRoleName);
//
//        Role theRole = null;
//
//        try {
//            theRole = theQuery.getSingleResult();
//        } catch (Exception e) {
//            theRole = null;
//        }
//
//        return theRole;
//    }
}
