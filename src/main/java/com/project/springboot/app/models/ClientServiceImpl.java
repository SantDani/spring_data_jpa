package com.project.springboot.app.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clientService;

	@Override
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		return clientService.findAll();
	}

	@Override
	@Transactional // to indicate that it is a writing transaction
	public void save(Client client) {
		this.clientService.save(client);

	}

	@Override
	@Transactional(readOnly = true)
	public Client findOne(Long id) {
		return this.clientService.findOne(id);
	}

	@Override
	@Transactional // to indicate that it is a writing transaction
	public void delete(Long id) {
		this.clientService.delete(id);

	}

}
