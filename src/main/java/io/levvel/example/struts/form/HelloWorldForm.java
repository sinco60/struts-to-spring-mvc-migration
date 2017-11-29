package io.levvel.example.struts.form;

import org.apache.struts.action.ActionForm;

import lombok.Data;


public class HelloWorldForm extends ActionForm{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}