package com.util.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.example.cmmn.EgovSampleExcepHndlr;
import egovframework.rte.fdl.cmmn.exception.handler.ExceptionHandler;

public class ExcepHndlr implements ExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExcepHndlr.class);

	@Override
	public void occur(Exception ex, String packageName) {
		LOGGER.debug(packageName + " 에서 error generate : " + ex.getMessage());
	}
}
