package com.klef.fsad.exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ClientDemo {

public static void main(String[] args)
{

SessionFactory factory =
new Configuration().configure().buildSessionFactory();

Session session = factory.openSession();

Transaction tx = session.beginTransaction();

Booking b = new Booking("Hotel","Hyderabad",4500);

session.save(b);

tx.commit();

Query q = session.createQuery("from Booking");

List<Booking> list = q.list();

for(Booking bk:list)
{
System.out.println(bk.getId()+" "+bk.getName()+" "+bk.getLocation()+" "+bk.getPrice());
}

session.close();
factory.close();

}

}