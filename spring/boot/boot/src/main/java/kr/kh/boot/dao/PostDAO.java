package kr.kh.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.boot.model.vo.PostVO;

public interface PostDAO {

	List<PostVO> selectList(int bo_num);

	PostVO selectPost(@Param("po_num")int po_num);
	
}
