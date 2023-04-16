package com.project.springboot.app.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.project.springboot.app.models.Client;

public interface IClientDao extends CrudRepository<Client, Long> {
	

}
