/**
 * 
 */
package com.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.domain.UserDetails;
import com.demo.repository.UserRepository;
import com.demo.service.UserServices;

/**
 * @author kalaiselvan.a
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserServices {

	@Autowired
	UserRepository userrepository;

	public void addUser(UserDetails u) {
		// TODO Auto-generated method stub
		userrepository.save(u);

	}

	public List<UserDetails> findAll() {
		// TODO Auto-generated method stub
		return (List<UserDetails>) userrepository.findAll();
	}

	public void UpdateByID(UserDetails u) {
		// TODO Auto-generated method stub
		// userrepository.Update(u);
	}

	public UserDetails findById(long id) {
		// TODO Auto-generated method stub
		return userrepository.findOne(id);
	}

	public void deleteuser(long id) {
		// TODO Auto-generated method stub
		userrepository.delete(id);
	}

}
