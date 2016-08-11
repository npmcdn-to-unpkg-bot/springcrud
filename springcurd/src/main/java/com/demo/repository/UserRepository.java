/**
 * 
 */
package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.domain.UserDetails;

/**
 * @author kalaiselvan.a
 *
 */
public interface UserRepository extends JpaRepository<UserDetails, Long> {

}
