package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CCustomerCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response);
	public boolean execute2(HttpServletRequest request, HttpServletResponse response);
	
}
