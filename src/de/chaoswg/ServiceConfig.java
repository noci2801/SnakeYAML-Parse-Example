/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.chaoswg;

/**
 *
 * @author Schmull
 */
public class ServiceConfig {

	private Boolean enableLog;
	private Boolean authRequired;
	private String appEnv;
	private Integer timeoutInMs;
	private String serviceUrl;
	private String serviceName;
	private String serviceVersion;
	private String serviceNamespace;

	public Boolean getEnableLog() {
		return enableLog;
	}

	public void setEnableLog(Boolean enableLog) {
		this.enableLog = enableLog;
	}

	public Boolean getAuthRequired() {
		return authRequired;
	}

	public void setAuthRequired(Boolean authRequired) {
		this.authRequired = authRequired;
	}

	public String getAppEnv() {
		return appEnv;
	}

	public void setAppEnv(String appEnv) {
		this.appEnv = appEnv;
	}

	public Integer getTimeoutInMs() {
		return timeoutInMs;
	}

	public void setTimeoutInMs(Integer timeoutInMs) {
		this.timeoutInMs = timeoutInMs;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public String getServiceNamespace() {
		return serviceNamespace;
	}

	public void setServiceNamespace(String serviceNamespace) {
		this.serviceNamespace = serviceNamespace;
	}
}