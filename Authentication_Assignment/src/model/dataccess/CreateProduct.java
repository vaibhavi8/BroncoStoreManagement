package model.dataccess;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.entities.Product;

public class CreateProduct 
{
	public static boolean ProductCreate (int productID, String productName, Date product_date, 
		String productDesc, float productPrice) 
	{
	
		boolean flag = false;
		SessionFactory factory = new Configuration().
	            configure("hibernate.cfg.xml").
	            addAnnotatedClass(Product.class).
	            buildSessionFactory();
				Session session = factory.getCurrentSession();
		
	
		try {
			session.beginTransaction();
			
			
			Product newProduct = new Product(productID, productName, product_date, productDesc, productPrice );
			session.save(newProduct);
			session.getTransaction().commit();
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
		} finally {
			factory.close();
		
		}
		return flag;
		
		
	}

	
}
