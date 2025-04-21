package kr.kh.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.boot.dao.PostDAO;
import kr.kh.boot.model.vo.PostVO;

@Service
public class PostService {
	
	@Autowired
	PostDAO postDao;

	public List<PostVO> getPostList(int bo_num) {
		return postDao.selectList(bo_num);
	}

	public PostVO getPost(int po_num) {
		return postDao.selectPost(po_num);
	}
}
