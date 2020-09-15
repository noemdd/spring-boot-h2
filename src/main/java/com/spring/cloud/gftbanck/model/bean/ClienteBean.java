package com.spring.cloud.gftbanck.model.bean;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteBean {
	
	private long id;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String sexo;
	private List<CuentaBean> cuentas = new ArrayList<CuentaBean>();
		
}
