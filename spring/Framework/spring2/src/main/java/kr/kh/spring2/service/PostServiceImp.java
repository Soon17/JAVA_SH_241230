package kr.kh.spring2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring2.dao.PostDAO;

@Service
public class PostServiceImp implements PostService{

	@Autowired
	PostDAO postDao;
}
