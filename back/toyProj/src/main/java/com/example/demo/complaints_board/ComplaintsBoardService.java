package com.example.demo.complaints_board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintsBoardService {
	@Autowired
	private ComplaintsBoardDao dao;
	
	//추가, 수정
	public int save(ComplaintsBoardDto dto) {
		ComplaintsBoard entity = dao.save(new ComplaintsBoard(dto.getNum(), dto.getTitle(), dto.getContents(), dto.getSchool(),  dto.getCategory(), dto.getIschecked(), dto.getCnt(), dto.getImg1(), dto.getImg2()));
		return entity.getNum();
	}
	
	//전체조회
	public ArrayList<ComplaintsBoardDto> getAll(){
		ArrayList<ComplaintsBoard> list = (ArrayList<ComplaintsBoard>) dao.findAll();
		ArrayList<ComplaintsBoardDto> dlist = new ArrayList<>();
		for(ComplaintsBoard dto : list) {
			dlist.add(new ComplaintsBoardDto(dto.getNum(), dto.getTitle(), dto.getContents(), dto.getSchool(),  dto.getCategory(), dto.getIschecked(), dto.getCnt(), dto.getImg1(), dto.getImg2(), null));
		}
		return dlist;
	}
	
	//번호로 조회
	public ComplaintsBoardDto getByNum(int num) {
		ComplaintsBoard vo = dao.findById(num).orElse(null);
		if(vo == null) {
			return null;
		}
		return new ComplaintsBoardDto(vo.getNum(), vo.getTitle(), vo.getContents(), vo.getSchool(),  vo.getCategory(), vo.getIschecked(), vo.getCnt(), vo.getImg1(), vo.getImg2(), null);
	}
}
