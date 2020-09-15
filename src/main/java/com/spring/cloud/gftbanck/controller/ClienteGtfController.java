package com.spring.cloud.gftbanck.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.gftbanck.feign.ClienteServiceProxy;
import com.spring.cloud.gftbanck.model.bean.ClienteBean;

@RestController
public class ClienteGtfController {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ClienteServiceProxy proxy;
	
	@GetMapping("/")
	public List<ClienteBean> listaClientes() {
		LOGGER.info("mostramos los clientes en el proxy");
		return proxy.listaClientes();
	}
	
	@GetMapping("/{id}")
	public ClienteBean getClienteById(@PathVariable(value = "id") Long clienteId) {
		return proxy.getClienteById(clienteId);
	}

	@PostMapping("/")
	public ClienteBean createCliente(@Valid @RequestBody ClienteBean cliente) {
		return proxy.createCliente(cliente);
	}

	@PutMapping("/{id}")
	public ClienteBean updateCliente(@PathVariable(value = "id") Long clienteId,
			@Valid @RequestBody ClienteBean clienteDetails)  {
		return proxy.updateCliente(clienteId, clienteDetails);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteCliente(@PathVariable(value = "id") Long clienteId)
			 {
		return proxy.deleteCliente(clienteId);
	}
}
