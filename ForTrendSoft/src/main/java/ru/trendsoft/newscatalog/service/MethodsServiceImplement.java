package ru.trendsoft.newscatalog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ru.trendsoft.newscatalog.interfaces.MethodsDAO;
import ru.trendsoft.newscatalog.objects.Category;
import ru.trendsoft.newscatalog.objects.News;

@Service
public class MethodsServiceImplement implements MethodsService
{
	private MethodsDAO methodsDAO;
	
	public void setMethodsDAO(MethodsDAO methodsDAO)
	{
		this.methodsDAO = methodsDAO;
	}
	@Override
	@Transactional
	public List<News> getNews()
	{
		return this.methodsDAO.getNews();
	}
	
	@Override
	@Transactional
	public List<Object[]> getNewsByCategory(String category)
	{
		return this.methodsDAO.getNewsByCategory(category);
	}
	
	@Override
	@Transactional
	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		return this.methodsDAO.getCategory();
	}
	@Override
	public void createNews(String title, String content, Category category) 
	{
		this.methodsDAO.createNews(title, content, category);
		// TODO Auto-generated method stub
		
	}
}
