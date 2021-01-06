package com.jha.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;

public class ValidationError extends StandardError {

	

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> list = new ArrayList<>();
	
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		// TODO Auto-generated constructor stub
	}
    
	public List<FieldMessage> getErrors(){
		return list;
	}
	
	public void addError(String fieldName, String messsage) {
		list.add(new FieldMessage(fieldName,messsage));
	}
}
