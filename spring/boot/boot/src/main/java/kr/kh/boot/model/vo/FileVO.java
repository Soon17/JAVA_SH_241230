package kr.kh.boot.model.vo;

import lombok.Data;

@Data
public class FileVO {
	public FileVO(int po_num, String fi_ori_name, String fi_name) {
		this.fi_po_num = po_num;
		this.fi_ori_name = fi_ori_name;
		this.fi_name = fi_name; 
	}
	int fi_num;
	String fi_name;
	String fi_ori_name;
	int fi_po_num;
}