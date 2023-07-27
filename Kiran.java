package com.adobe.aem.guides.emmy.core.models;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;



@Model(adaptables= {Page.class,Resource.class,SlingHttpServletRequest.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Kiran {
	
//	
//	@Inject
//	Resource resource;
//	
	@Inject
	Page page;
	Resource resource;
	
	@ValueMapValue
	public String name;
	
	
//	public String getResourceAPIValues()
//	{
//		String name = resource.getPath();
//		return name;
//		
//	}
	
//	public String getResourceAPIValues() {
//		String name=resource.getName();
//		return name;
//	}
//
//	public String getPageAPIValues() {
//		String name = page.getTitle();
//		return name;
//	}
    public String getpagePath() {
	String path = page.getPath();
	return path;
}
    public Page getPageParent() {
	String parent = page.getParent().getTitle();
	return page;
    }
//    ValueMap properties = resource.getValueMap();
//    String value = properties.get("jcr:title", "Default title");
//    String relativeResourceValue = properties.get("relative/propertyName", "Default value");

    }



