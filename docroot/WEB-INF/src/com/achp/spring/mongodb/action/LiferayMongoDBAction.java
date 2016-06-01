package com.achp.spring.mongodb.action;

import com.achp.spring.mongodb.mode.Person;
import com.achp.spring.mongodb.service.PersonServiceUtil;
import com.achp.spring.mongodb.util.MongoTemplateUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.springframework.data.mongodb.core.MongoTemplate;

public class LiferayMongoDBAction extends MVCPortlet {

	public void savePerson(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {
		MongoTemplate mongoTemplate=MongoTemplateUtil.getMongoTemplate();
		Person person=new Person();
		person.setName(ParamUtil.getString(actionRequest,"name"));
		PersonServiceUtil.addPerson(person, mongoTemplate);
	}
	public void deletePerson(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {
		MongoTemplate mongoTemplate=MongoTemplateUtil.getMongoTemplate();
		Person person=new Person();
		person.setId(ParamUtil.getString(actionRequest,"id"));
		PersonServiceUtil.deletePerson(person, mongoTemplate);
	}

}
