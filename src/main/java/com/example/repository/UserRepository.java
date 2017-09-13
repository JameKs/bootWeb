package com.example.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.bean.User;

/**
 * PagingAndSortingRepository.
 * 第一个参数为实体类型.
 * 第二个参数为主键类型.
 * 
 * @author PVer
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

}
