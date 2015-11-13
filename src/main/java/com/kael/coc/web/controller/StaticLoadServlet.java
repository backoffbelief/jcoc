package com.kael.coc.web.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.kael.coc.data.BuilingData;
import com.kael.coc.data.UserDB;

public class StaticLoadServlet extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		BuilingData.compareAndSet();
		UserDB.loadGame();
	}
}
