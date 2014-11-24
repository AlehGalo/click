/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.alfa.click.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.WindowScoped;

import com.alfa.click.service.GreetingService;
import com.alfa.click.service.WidgetService;
import com.alfa.click.webservice.server.Widget;

/**
 * A typical simple backing bean, that is backed to
 * <code>helloWorld.xhtml</code>
 */
@Named("helloWorld")
@WindowScoped
public class HelloWorldController implements Serializable {

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	// properties
	private String name;

	@Inject
	private GreetingService greetingService;

	@Inject
	private WidgetService widgetService;

	/**
	 * default empty constructor
	 */
	public HelloWorldController() {
	}

	/**
	 * Method that is backed to a submit button of a form.
	 */
	public String send() {
		return "page2";
	}

	public String getGreeting() {
		return greetingService.createGreeting(name);
	}

	public List<Widget> getWidgetsList() {
		return widgetService.getWidgets();
	}

	// -------------------getter & setter

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void continueAction() {
		System.out.println("Called");
		// Map<String, String> params =
		// FacesContext.getCurrentInstance().getRequestParameterMap();
		// String action = params.get("continueAction");
	}

}