package com.addrbook.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.addrbook.model.AddrDto;

public interface UpdateService {
	
	public void execute(HttpServletRequest request, HttpServletResponse response);

}