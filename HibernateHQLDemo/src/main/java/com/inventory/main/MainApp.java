package com.inventory.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class MainApp {

public static void main(String[] args) {

Session session = HibernateUtil.getSessionFactory().openSession();

System.out.println("----Sort Price Ascending----");

Query<Product> q1 = session.createQuery(
"FROM Product ORDER BY price ASC", Product.class);

List<Product> list1 = q1.list();

for(Product p : list1){
System.out.println(p.getName()+" "+p.getPrice());
}

System.out.println("----Sort Price Descending----");

Query<Product> q2 = session.createQuery(
"FROM Product ORDER BY price DESC", Product.class);

for(Product p : q2.list()){
System.out.println(p.getName()+" "+p.getPrice());
}

System.out.println("----Sort Quantity Highest First----");

Query<Product> q3 = session.createQuery(
"FROM Product ORDER BY quantity DESC", Product.class);

for(Product p : q3.list()){
System.out.println(p.getName()+" "+p.getQuantity());
}

System.out.println("----Pagination First 3 Products----");

Query<Product> q4 = session.createQuery("FROM Product",Product.class);
q4.setFirstResult(0);
q4.setMaxResults(3);

for(Product p : q4.list()){
System.out.println(p.getName());
}

System.out.println("----Next 3 Products----");

Query<Product> q5 = session.createQuery("FROM Product",Product.class);
q5.setFirstResult(3);
q5.setMaxResults(3);

for(Product p : q5.list()){
System.out.println(p.getName());
}

System.out.println("----Total Product Count----");

Query q6 = session.createQuery("SELECT COUNT(*) FROM Product");
System.out.println(q6.uniqueResult());

System.out.println("----Min and Max Price----");

Query q7 = session.createQuery(
"SELECT MIN(price), MAX(price) FROM Product");

Object[] result = (Object[]) q7.uniqueResult();

System.out.println("Min price = "+result[0]);
System.out.println("Max price = "+result[1]);

System.out.println("----Price Range Filter----");

Query<Product> q8 = session.createQuery(
"FROM Product WHERE price BETWEEN 1000 AND 20000",Product.class);

for(Product p : q8.list()){
System.out.println(p.getName()+" "+p.getPrice());
}

System.out.println("----LIKE Query----");

Query<Product> q9 = session.createQuery(
"FROM Product WHERE name LIKE 'L%'",Product.class);

for(Product p : q9.list()){
System.out.println(p.getName());
}

session.close();

}

}