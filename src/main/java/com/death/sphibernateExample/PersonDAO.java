package com.death.sphibernateExample;

import java.util.List;

public interface PersonDAO {
	public void save(Person person);
	
	public List<Person> list();
	
	public void delete(int id);
}
