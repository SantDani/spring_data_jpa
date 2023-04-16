package com.project.springboot.app.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl implements IClientDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAll() {
		// "from Client" points to the Client class, so it is important that "C" is capitalised.
		return entityManager.createQuery("from Client").getResultList();
		
	}
	
	@Override
	public void save(Client client) {

		System.out.println("Client ID: " + client.getId());
		
		if(client.getId() != null && client.getId() > 0) {
			// update the current data
			this.entityManager.merge(client); 
		}else {
			// crate a new client
			this.entityManager.persist(client);
		}
	}
	
	@Override
	public void delete(Long id) {
		this.entityManager.remove(this.findOne(id));
	}
	

	@Override
	public Client findOne(Long id) {
		Client result = entityManager.find(Client.class, id);
		System.out.println("ClientDaoImpl.findOne()" + result.toString());
		return  result;
	}
	
	
	
	
}
