package ru.trendsoft.newscatalog.service;

import java.util.List;

import ru.trendsoft.newscatalog.objects.Category;
import ru.trendsoft.newscatalog.objects.News;

public interface MethodsService 
{
	public List<News> getNews();
	public List<Object[]> getNewsByCategory(String category);
	public List<Category> getCategory();
	public void createNews(String title,String content, Category category);
}
