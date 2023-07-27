package com.adobe.aem.guides.emmy.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables= {SlingHttpServletRequest.class,Resource.class},defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class DemoPractice {
	@ValueMapValue
	public String demoname;
	@ValueMapValue
	public String demoaddress;
	
	public String demoname()
	{
		return demoname;
	}
	public String demoaddress()
	{
		return demoaddress;
	}
	
	

	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Inject
//	Resource resource;
//	

	//public String getResourceAPIvalues()
	//{
	//String path=resource.getPath();
	//return path;
//}
//	public String getResourceAPIvalues()
//	{
//		String jcrconstants=resource.getjcrconstants();
//		return jcrconstants;
//	}
	
//	public String getResourceAPIvalues()
//	{
//		 String ValueMap=resource.getValueMap();
//		return valueMap;
//	}
//	


