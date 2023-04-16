package com.project.springboot.app.models;

import java.util.List;

public interface IClientDao {
	
	public List<Client> findAll();
	
	public void save(Client client);

	public Client findOne(Long id);
	
	public  void delete(Long id);
}
