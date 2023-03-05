package com.xtglobal.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.xtglobal.entity.User;

public interface UserService {

	List<User> findAll();

	boolean saveDataFromUploadfile(MultipartFile file);

}
