package com.xyl.web.view;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

public class JsonViewResolver  implements ViewResolver {
	
	
	public View resolveViewName(String viewName, Locale locale)
			throws Exception {
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		view.setPrettyPrint(true);      // Lay the JSON out to be nicely readable 
		return view;
	}

}
