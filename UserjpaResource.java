package com.myproject.myproject.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserjpaResource {
	
	@Autowired
	private UserDaoService service;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private postRepository postRepository;
	
	
	@GetMapping(path="/jpa/users")
	public List<User> retrieveall()
	{
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public Optional<User> retrieveone(@PathVariable int id)
	{
		Optional<User> user=userRepository.findById(id);
		
		return user;
	}
	
	@PostMapping("/jpa/users")
	public void createUser(@RequestBody User user)
	{
		service.save(user);
	}
	
	@GetMapping(path="/jpa/users/{id}/posts")
	public List<Post> retrieveall(@PathVariable int id)
	{
		Optional<User> useroptional= userRepository.findById(id);
		return useroptional.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public void createpost(@PathVariable int id, @RequestBody Post post)
	{
		Optional<User> optionaluser= userRepository.findById(id);
		
		User user= optionaluser.get();
		
		post.setUser(user);
		
		postRepository.save(post);
		
		
	}

}
