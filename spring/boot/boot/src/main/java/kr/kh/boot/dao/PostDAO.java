package kr.kh.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.boot.model.vo.BoardVO;
import kr.kh.boot.model.vo.CommentVO;
import kr.kh.boot.model.vo.FileVO;
import kr.kh.boot.model.vo.PostVO;

public interface PostDAO {

	List<PostVO> selectPostList(int bo_num);

	List<BoardVO> selectBoardList();

	PostVO selectPost(@Param("po_num")int po_num);

	List<FileVO> selectFileList(int po_num);

	boolean insertPost(PostVO post);

	void insertComment(CommentVO comment);
	
}
