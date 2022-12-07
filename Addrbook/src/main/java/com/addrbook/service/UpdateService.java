package com.addrbook.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.addrbook.model.AddrDto;

public interface UpdateService {
	public void executeUpdate(HttpServletRequest request, HttpServletResponse response);
	
	public AddrDto executeRead(HttpServletRequest request, HttpServletResponse response);

}