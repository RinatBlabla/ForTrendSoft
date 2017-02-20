package ru.trendsoft.newscatalog.objects;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
//import ru.postgres.test.objects.Users;


@Entity(name="Category")
@Table(name="Category")
public class Category 
{
			@Id 
			@GeneratedValue(strategy=GenerationType.AUTO)
			@Column(name="categ_id")
			private int id;

			@Column(name="name")
			private String name;
			
			@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
			private Set<News> news;
			
			public Category()
			{
			}
			    
			/**
			 * @return the id
			 */
			public int getId() {
				return id;
			}

			/**
			 * @param id the id to set
			 */
			public void setId(int id) {
				this.id = id;
			}

			/**
			 * @return the name
			 */
			public String getName() {
				return name;
			}

			/**
			 * @param name the name to set
			 */
			public void setName(String name) {
				this.name = name;
			}

			
			
			/**
			 * @return the news
			 */
			public Set<News> getNews() {
				return news;
			}

			/**
			 * @param news the news to set
			 */
			public void setNews(Set<News> news) {
				this.news = news;
			}

			public Category(int id,String name)
			{
			    this.id = id;
			    this.name = name;
			}
}
