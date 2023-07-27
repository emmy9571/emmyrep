package com.adobe.aem.guides.emmy.core.models;

import java.util.ArrayList;
import java.util.Iterator;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.aem.guides.emmy.core.beans.Mfieldbeans;

@Model(adaptables = { SlingHttpServletRequest.class,
		Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Mfield {

	@ValueMapValue
	public String name;

	@Inject
	Resource resource;

	public String getName() {

		return name;
	}

	@ChildResource

	Resource EmployeeDetails;

	public ArrayList<Mfieldbeans> getEmployeeDetailsList() {
		ArrayList<Mfieldbeans> emmy = new ArrayList<Mfieldbeans>();
		Iterator<Resource> itemResource = EmployeeDetails.listChildren();
		Mfieldbeans mfb = new Mfieldbeans();
		while (itemResource.hasNext()) {

			Resource itemResource2 = itemResource.next();
			
			// to get the data //
			String fullname = itemResource2.getValueMap().get("Fullname", String.class);
			String empnumber = itemResource2.getValueMap().get("Empnumber", String.class);
			String emppincode = itemResource2.getValueMap().get("Emppincode", String.class);
			String presentaddress = itemResource2.getValueMap().get("Presentaddress", String.class);
			
            // to set the data//
			mfb.setFullname(fullname);
			mfb.setEmpnumber(empnumber);
			mfb.setEmppincode(emppincode);
			mfb.setPresentaddress(presentaddress);

			emmy.add(mfb);

		}
		return emmy;
	}

}
