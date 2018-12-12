import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
	public static void main(String[]args) {
		Resource r=new ClassPathResource("applicationContext.xml");
		BeanFactory bf=new XmlBeanFactory(r);
		
		CustomerDAO cd=(CustomerDAO)bf.getBean("cd");
		/*
		Customer c1=new Customer();
		c1.setId(1);
		c1.setName("Joe");
		c1.setAddress("Some address 1");
		c1.setAge(2);
		cd.save(c1);
		
		c1=new Customer();
		c1.setId(2);
		c1.setName("Earl");
		c1.setAddress("Some address 2");
		c1.setAge(43);
		cd.save(c1);
		
		c1=new Customer();
		c1.setId(3);
		c1.setName("Clari");
		c1.setAddress("Some address 3");
		c1.setAge(73);
		cd.save(c1);
		
		System.out.println("Deleting customer with id 2");
		c1=new Customer();
		c1.setId(2);
		cd.delete(c1);
		*/
		System.out.println("Finding customer with id 3");
		Customer c2=new Customer();
		c2.setId(1);
		Customer c3=cd.getId(1);
		System.out.println(c3.getId()+" "+c3.getName()+" "+c3.getAddress()+" "+c3.getAge());
		
		List<Customer>list=cd.getDetails();
		System.out.println("All Customers:");
		for(Customer c:list) {
			System.out.println(c.getId()+" "+c.getName()+" "+c.getAddress()+" "+c.getAge());
		}
		
		System.out.println("Updating based on address");
		c2=new Customer();
		c2.setId(3);
		c2.setName("Clari");
		c2.setAddress("Some address 23");
		c2.setAge(73);
		cd.update(c2);
		
		list=cd.getDetails();
		System.out.println("Post-update All Customers:");
		for(Customer c:list) {
			System.out.println(c.getId()+" "+c.getName()+" "+c.getAddress()+" "+c.getAge());
		}
	}
}
