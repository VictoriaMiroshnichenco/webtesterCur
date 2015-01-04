package com.miroshnichenco.webtester.l3.services.configapp.impl;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.miroshnichenco.webtester.l3.services.configpp.ConfigApplicationService;


@Service
public class ConfigApplicationServiceImpl implements ConfigApplicationService {

	@Value("${nedis.jee.study.supportEmailAddress}")
	private String supportEmailAddress;
	
	@Value("${nedis.jee.study.cssJsVersion}")
	private String cssJsVersion;
	
	@Override
	public String getSupportEmailAddress() {
		return supportEmailAddress;
	}

	@Override
	public String getCssJsVersion() {
		return cssJsVersion;
	}

}
