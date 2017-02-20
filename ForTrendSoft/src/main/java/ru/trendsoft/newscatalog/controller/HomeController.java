package ru.trendsoft.newscatalog.controller;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestParam;






import ru.trendsoft.newscatalog.objects.Category;
import ru.trendsoft.newscatalog.service.MethodsService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("news")
public class HomeController
{
	private MethodsService methodsService;
	
	@Autowired(required=true)
	@Qualifier(value="MethodsService")
	public void setMethodsService(MethodsService ms)
	{
		this.methodsService = ms;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model)
	{
		logger.info("Welcome home! The client locale is {}.", locale);
		
		JSONArray jsArray1 = new JSONArray(methodsService.getNews());
		JSONArray jsArray2 = new JSONArray(methodsService.getCategory());
		
		System.out.println(jsArray1.toString());
		System.out.println(jsArray2.toString());
		model.addAttribute("getNewsList",jsArray1);
		model.addAttribute("getCategoryList",jsArray2);
		//model.addAttribute("getNewsList",methodsService.getNews());
		
		return "home";
	}
	@RequestMapping(value="/create-news", method = { RequestMethod.POST, RequestMethod.GET })
    public String createNewsForm(HttpServletRequest request,HttpServletResponse response, Model model)
	{
		JSONArray jsArray1 = new JSONArray(methodsService.getCategory());
		
		System.out.println("createNews = " + jsArray1.toString());
		model.addAttribute("getCategoryList",jsArray1);
		
       return "admin"; 
    }
	
	@RequestMapping(value="/test", method = { RequestMethod.POST, RequestMethod.GET } )
	public String afterNewsCreation(@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "content", required = false) String content,
			@RequestParam(value = "category", required = false) String[] category)
	{
		System.out.println("title = " + title + "; content = " + content + "; Integer.parseInt(category[0]) = " 
				+ Integer.parseInt(category[0]) + "; category[1] = " + category[1] );

		Category c =new Category(Integer.parseInt(category[0]),category[1]);
		methodsService.createNews(title, content, c);
		return "home"; 
	}
	
}
