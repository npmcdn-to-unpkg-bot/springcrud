/**
 * 
 */
package com.demo.service;

import java.util.List;

import com.demo.domain.UserDetails;

/**
 * @author kalaiselvan.a
 *
 */
public interface UserServices {

	public void addUser(UserDetails u);

	public List<UserDetails> findAll();

	public void UpdateByID(UserDetails u);

	public UserDetails findById(long id);

	public void deleteuser(long id);
}
