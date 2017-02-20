package ru.trendsoft.newscatalog.implementation;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.trendsoft.newscatalog.interfaces.*;
import ru.trendsoft.newscatalog.objects.Category;
import ru.trendsoft.newscatalog.objects.News;



@Repository
@Transactional
public class PostgresDAO implements MethodsDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public List<News> getNews()
	{
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT n.title, n.content, n.publication_date,c.name from News n  JOIN  n.category c";
		return session.createQuery(sql).list();
	}
	
	public List<Category> getCategory()
	{
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT c.id, c.name from Category c";
		return session.createQuery(sql).list();
	}
	public List<Object[]> getNewsByCategory(String category)
	{
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT n.title, n.content, n.publication_date,c.name from News n  JOIN  n.category c"
						+ "where c.name = :categName";
		
		List<Object[]> newsByCategoryList = session.createQuery(sql).setParameter("categName", category).list();
		System.out.println("newsByCategoryList = " + newsByCategoryList);
		
		return newsByCategoryList;
	}
	public void createNews(String title,String content, Category category)
	{
		System.out.println("createNews");
		
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println(session.isConnected());
		
		News news = new News();
	      Date date = new Date();

	      System.out.println("date.toString() = " + date.toString());
	

		news.setTitle(title);
		news.setContent(content);
		news.setPublication_date(date);
		news.setCategory(category);
        session.save(news);
 
        session.getTransaction().commit();
	}
}
