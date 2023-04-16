package com.project.springboot.app.models;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.app.models.dao.IClientDao;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clientService;

	@Override
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		return (List<Client>) clientService.findAll();
	}

	@Override
	@Transactional // to indicate that it is a writing transaction
	public void save(Client client) {
		this.clientService.save(client);

	}

	@Override
	@Transactional(readOnly = true)
	public Client findOne(Long id) {
		return this.clientService.findById(id).orElse(null);
	}

	@Override
	@Transactional // to indicate that it is a writing transaction
	public void delete(Long id) {
		this.clientService.deleteById(id);

	}

}
