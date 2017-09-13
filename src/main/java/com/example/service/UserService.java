package com.example.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.bean.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Resource
	private UserRepository userRepository;
	
	@Transactional
	public void save(User user){
		userRepository.save(user);
	}
	
	@Transactional
	public void delete(int id){
		userRepository.delete(id);
	}
}
