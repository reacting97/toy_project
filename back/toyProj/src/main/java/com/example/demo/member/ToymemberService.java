package com.example.demo.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToymemberService {
	@Autowired
	private ToymemberDao dao;
	
	public ToymemberDto join(ToymemberDto dto) {
		Toymember vo = dao.save(new Toymember(dto.getId(), dto.getPwd(), dto.getName(), dto.getEmail()));
		return new ToymemberDto(vo.getId(), vo.getPwd(), vo.getName(), vo.getEmail());
	}
	
	public ArrayList<ToymemberDto> getAll(){
		ArrayList<Toymember> list = (ArrayList<Toymember>) dao.findAll();
		ArrayList<ToymemberDto> dlist = new ArrayList<>();
		for(Toymember vo:list) {
			dlist.add(new ToymemberDto(vo.getId(), vo.getPwd(), vo.getName(), vo.getEmail()));
		}
		return dlist;
	}
	
	public ToymemberDto getById(String id) {
		Toymember vo = dao.findById(id).orElse(null);
		if(vo == null) {
			return null;
		}
		return new ToymemberDto(vo.getId(), vo.getPwd(), vo.getName(), vo.getEmail());
	}
	
	public ToymemberDto getByIdAndPwd(String id, String pwd) {
		Toymember vo = dao.findByIdAndPwd(id, pwd);
		if(vo == null) {
			return null;
		}
		return new ToymemberDto(vo.getId(), vo.getPwd(), vo.getName(), vo.getEmail());
	}
}
