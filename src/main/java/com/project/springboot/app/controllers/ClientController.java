package com.project.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.project.springboot.app.models.Client;
import com.project.springboot.app.models.IClientService;

@Controller
@SessionAttributes("client")
public class ClientController {
	
	@Autowired
	private IClientService clientDao;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("title", "List from clients");
		model.addAttribute("clients", clientDao.findAll());
		
		return "list";
	}
	
	@GetMapping({"", "/", "/home"})
	public String index(Model model) {
		model.addAttribute("title", "Home Page");
		
		return "index";

	}
	
	@RequestMapping(value="/form")
	public String create(Map<String, Object> model){
		
		model.put("title", "Form Client");
		
		Client client = new Client();
		model.put("client", client); // client object bidirectional with the form
		
		return "form";
	}
	
	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String save(@Valid Client client, BindingResult result, ModelMap model, SessionStatus status){
		
		System.out.println("ClientController.save() result.hasErrors()" + result.getFieldErrors().toString());
		if(result.hasErrors()) {
			model.put("title", "Form Client");
			/**
				As the "client" attribute of this function has the same name as in the create function, it is sent automatically. 
			 * as in the create function, it is automatically sent.
			 * 
			 * In any other case it would be necessary to specify it with :
			 * @ModelAttribute -> public String save(@Valid Client client, BindingResult result, ModelMap model){...}
			 */
			
			return "form";
		}
		clientDao.save(client);
		status.setComplete(); // removes client object from session
		
		return "redirect:/list";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Long id, ModelMap model){
		
		if(id > 0) {
			clientDao.delete(id);
		}
		
		return "redirect:/list";
	}
	
	
	@RequestMapping(value="/form/{id}")
	public String edit(@PathVariable(value="id") Long id, ModelMap model){
		
		Client client = null;
		
		if(id > 0) {
			client = clientDao.findOne(id);
		}else {
			return "redirect:/list";
		}
		
		model.put("title", "Edit Client");
		model.put("client", client);
		
		return "form";
	}
	
	
	
}
