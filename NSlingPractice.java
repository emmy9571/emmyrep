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
import com.adobe.aem.guides.emmy.core.beans.Nbeans;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NSlingPractice {
	@ValueMapValue
	public String name;

	@ValueMapValue
	public Integer number;
	
	@ValueMapValue
	public String fullname;
	
	@ValueMapValue
	public String id;

	

	@Inject
	Resource resource;

	

	public String getFullname() {
		return fullname;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getNumber() {
		return number;
	}

	@ChildResource
	Resource studentdetails;
	

	public ArrayList<Nbeans> getMultiChildNode() {
		ArrayList<Nbeans> emmy = new ArrayList<Nbeans>();
		Nbeans nb = new Nbeans();
		
		Resource childResource=resource.getChild("studentdetails");
		Iterator<Resource> itemResource = childResource.listChildren();

		while (itemResource.hasNext()) {

			Resource itemResource1 = itemResource.next();

			// to get the data //
			String fullname = itemResource1.getValueMap().get("fullname", String.class);
			Integer studentnumber = itemResource1.getValueMap().get("studentnumber", Integer.class);
			Integer pincode = itemResource1.getValueMap().get("pincode", Integer.class);
			String address = itemResource1.getValueMap().get("address", String.class);

			// to set the data//
			nb.setFullname(fullname);
			nb.setStudentnumber(studentnumber);
			nb.setPincode(pincode);
			nb.setAddress(address);

			// sub child

			Resource subChildResource = itemResource1.getChild("employeedetailswithnestedmultifield");

			Iterator<Resource> item = subChildResource.listChildren();
			while (item.hasNext()) {
				Resource itemResource2 = item.next();
				String empname = itemResource2.getValueMap().get("empname", String.class);
				Integer empid = itemResource2.getValueMap().get("empid", Integer.class);
				String dob = itemResource2.getValueMap().get("dob", String.class);
				nb.setEmpname(empname);
				nb.setEmpid(empid);
				nb.setDob(dob);

			

			// sub child1

			Resource subChildResource1 = itemResource2.getChild("bookdetails");
			Iterator<Resource> item1 = subChildResource1.listChildren();
			while (item1.hasNext()) {
				Resource itemresource3 = item1.next();

				String authorname = itemresource3.getValueMap().get("authorname", String.class);
				String publishyear = itemresource3.getValueMap().get("publishyear", String.class);
				String bookname = itemresource3.getValueMap().get("bookname", String.class);
				

				nb.setAuthorname(authorname);
				nb.setPublishyear(publishyear);
				nb.setBookname(bookname);
				
				emmy.add(nb);
			}
		}
	}
		return emmy;

	}

	Resource surgedetails;
	

	public ArrayList<Nbeans> getMultiChildNodes() {
		ArrayList<Nbeans> object = new ArrayList<Nbeans>();
		Nbeans vem = new Nbeans();
		
		Resource childResource1=resource.getChild("surgedetails");
		Iterator<Resource> itemResources = childResource1.listChildren();

		while (itemResources.hasNext()) {

			Resource itemResource4 = itemResources.next();

			// to get the data //
			String foundername = itemResource4.getValueMap().get("foundername", String.class);
			String establishyear = itemResource4.getValueMap().get("establishyear", String.class);
			String surgeaddress = itemResource4.getValueMap().get("surgeaddress", String.class);
			String gender = itemResource4.getValueMap().get("gender",String.class);
			String richtext = itemResource4.getValueMap().get("richtext",String.class);
			String select = itemResource4.getValueMap().get("select",String.class);
			String video = itemResource4.getValueMap().get("video",String.class);
			String pathbrowser = itemResource4.getValueMap().get("pathbrowser",String.class);
			String pathfield = itemResource4.getValueMap().get("pathfield",String.class);
			String pic = itemResource4.getValueMap().get("pic",String.class);
			String colourpicker = itemResource4.getValueMap().get("colourpicker",String.class);

			// to set the data//
			vem.setFoundername(foundername);
			vem.setEstablishyear(establishyear);
			vem.setSurgeaddress(surgeaddress);
			vem.setGender(gender);
			vem.setRichtext(richtext);
			vem.setSelect(select);
			vem.setVideo(video);
			vem.setPathbrowser(pathbrowser);
			vem.setPathfield(pathfield);
			vem.setPic(pic);
			vem.setColourpicker(colourpicker);
			object.add(vem);
		}
		return object;		
}
}
