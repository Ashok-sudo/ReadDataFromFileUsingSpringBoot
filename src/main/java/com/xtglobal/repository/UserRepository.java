package com.xtglobal.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.xtglobal.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
