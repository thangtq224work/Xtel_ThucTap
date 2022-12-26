package javacore.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main2 {
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(Main2.class);
		logger.warn("hello log");
		logger.debug("hello log");
		logger.trace("hello log");
		logger.error("hello log");
		logger.info("hello log");
		logger.fatal("hello log");
		System.err.println("Finish");
		ExecutorService executorService;
		ThreadPoolExecutor executor;
	}

}
