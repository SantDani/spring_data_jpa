package com.project.springboot.app.models;

import java.util.List;
import java.util.Optional;


public interface IClientService  {

	public List<Client> findAll();
	
	public void save(Client client);

	public Client findOne(Long id);
	
	public  void delete(Long id);
}
