package com.myproject.myproject.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
	
	private static int idcount=3;
	
	private static List<User> users=new ArrayList<>();
	
	static {
		
		users.add(new User(1,"saurabh", new Date()));
		users.add(new User(2,"Ankit", new Date()));
		users.add(new User(3,"Vijay", new Date()));
	}
	
	public List<User> findAll()
	{
		return users;
	}
	
	
	public User save(User user)
	{
		if(user.getId()==null)
		{
			user.setId(++idcount);
		}
		users.add(user);
		
		return user;
	}
	
	public User findone(int id)
	{
		for(User user: users)
		{
			if(user.getId()==id)
			{
				return user;
			}
		
		}
		return null;
	}

}
