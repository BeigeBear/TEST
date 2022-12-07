package com.addrbook.service;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addrbook.model.AddrDao;
import com.addrbook.model.AddrDto;

public class DeleteServiceImpl implements DeleteService {
	private AddrDao addrDao;

	public DeleteServiceImpl() {
		addrDao = AddrDao.getInstance();
	}

	@Override
	public ArrayList<AddrDto> execute(HttpServletRequest request, HttpServletResponse response) {
		return addrDao.getList();
	}

}