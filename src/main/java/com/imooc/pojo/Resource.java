package com.imooc.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration											  //相当于把该类作为spring的xml配置文件中的<beans>，作用为：配置spring容器(应用上下文)
@ConfigurationProperties(prefix="com.imooc.opensource")   //扫描这个路径下的属性
@PropertySource(value="classpath:resource.properties")	  //配置属性文件路径
public class Resource {
	private String name;
	private String website;
	private String language;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
