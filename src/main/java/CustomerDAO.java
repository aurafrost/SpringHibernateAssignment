import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class CustomerDAO {
	HibernateTemplate ht;
	
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void save(Customer c) {
		ht.save(c);
	}
	
	public void delete(Customer c) {
		ht.delete(c);
	}
	
	public void update(Customer c) {
		ht.update(c);
	}
	
	public Customer getId(int i) {
		Customer d=ht.get(Customer.class, i);
		return d;
	}
	
	public List<Customer> getDetails(){
		List<Customer>list=new ArrayList<Customer>();
		list=ht.loadAll(Customer.class);
		return list;
	}
}
