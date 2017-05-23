package com.death.sphibernateExample;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.envers.event.AuditEventListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
        
        
        PersonDAO personDAO = context.getBean(PersonDAO.class);
        Person person = new Person();
        person.setName("Aditya");
        person.setCountry("INDIA");
        person.setCreated_at(new Timestamp(System.currentTimeMillis()));
        personDAO.save(person);
        
        System.out.println("Person :"+person);
        
        List<Person> list = personDAO.list();
        
        for(Person p : list)
        {
        	System.out.println("Person List: "+p);
        }
        
        System.out.println("Enter ID to delete:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.close();
        personDAO.delete(id);
        System.out.println("Record Deleted!");
        context.close();
    }
}
