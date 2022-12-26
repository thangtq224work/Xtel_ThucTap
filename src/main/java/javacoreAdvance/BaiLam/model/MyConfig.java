package javacoreAdvance.BaiLam.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyConfig {
	private String ip;
	private Integer port;
	private Integer connectionTimeOut;
	private Integer sendTimeOut;
	private Integer receiveTimeOut;

	public MyConfig() {
		getDataFromConfigFile();
	}

	private void getDataFromConfigFile() {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(new File("socketConfig.properties"));

			Properties properties = new Properties();
			properties.load(fileInputStream);
			this.setIp(properties.getProperty("ip"));
			this.setPort(Integer.parseInt(properties.getProperty("port")));
			this.setConnectionTimeOut(Integer.parseInt(properties.getProperty("connection-time-out")));
			this.setReceiveTimeOut(Integer.parseInt(properties.getProperty("send-time-out")));
			this.setSendTimeOut(Integer.parseInt(properties.getProperty("receive-time-out")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setIp(String ip) {
		this.ip = ip;
	}

	private void setPort(Integer port) {
		this.port = port;
	}

	private void setConnectionTimeOut(Integer connectionTimeOut) {
		this.connectionTimeOut = connectionTimeOut;
	}

	private void setSendTimeOut(Integer sendTimeOut) {
		this.sendTimeOut = sendTimeOut;
	}

	private void setReceiveTimeOut(Integer receiveTimeOut) {
		this.receiveTimeOut = receiveTimeOut;
	}

	public String getIp() {
		return ip;
	}

	public Integer getPort() {
		return port;
	}

	public Integer getConnectionTimeOut() {
		return connectionTimeOut;
	}

	public Integer getSendTimeOut() {
		return sendTimeOut;
	}

	public Integer getReceiveTimeOut() {
		return receiveTimeOut;
	}

}
