package kr.kh.spring2.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PostCriteria extends Criteria{
	
	private int po_bo_num;
	private String orderBy;
}
