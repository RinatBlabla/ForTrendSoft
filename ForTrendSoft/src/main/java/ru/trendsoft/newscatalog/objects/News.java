package ru.trendsoft.newscatalog.objects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

//import ru.postgres.test.objects.Users;

//import ru.postgres.test.objects.User_roles;


@Entity(name="News")
@Table(name="News")
public class News 
{
		@Id //Primary key for table
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id")
		private int id;

		@Column(name="title")
		private String title;
		
		@Column(name="content")
		private String content;
		
		@Column(name="publication_date")
		private Date publication_date;
		
		@JsonIgnore
		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "category_id", referencedColumnName = "categ_id")
		//, insertable = false, updatable = false)
	    private Category category;
		
	    public News()
	    {
	    }
	    
	    public News(int id,String title, String content, Date publication_date, Category category)
	    {
	        this.id = id;
	        this.title = title;
	        this.content = content;
	        this.publication_date = publication_date;
	        this.category = category;
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
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

		/**
		 * @return the content
		 */
		public String getContent() {
			return content;
		}

		/**
		 * @param content the content to set
		 */
		public void setContent(String content) {
			this.content = content;
		}

		/**
		 * @return the publication_date
		 */
		public Date getPublication_date() {
			return publication_date;
		}

		/**
		 * @param publication_date the publication_date to set
		 */
		public void setPublication_date(Date publication_date) {
			this.publication_date = publication_date;
		}

		/**
		 * @return the category
		 */
		public Category getCategory() {
			return category;
		}

		/**
		 * @param category the category to set
		 */
		public void setCategory(Category category) {
			this.category = category;
		}

		
}
