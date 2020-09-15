package com.spring.cloud.gftbanck.feign;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.cloud.gftbanck.model.bean.ClienteBean;

@FeignClient(name="spring-cloud-dtb-h2")
public interface ClienteServiceProxy {

	@GetMapping("/")
	public List<ClienteBean> listaClientes();

	@GetMapping("/{id}")
	public ClienteBean getClienteById(@PathVariable(value = "id") Long clienteId);

	@PostMapping("/")
	public ClienteBean createCliente(@Valid @RequestBody ClienteBean cliente);

	@PutMapping("/{id}")
	public ClienteBean updateCliente(@PathVariable(value = "id") Long clienteId,
	@Valid @RequestBody ClienteBean clienteDetails);

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteCliente(@PathVariable(value = "id") Long clienteId);
}
