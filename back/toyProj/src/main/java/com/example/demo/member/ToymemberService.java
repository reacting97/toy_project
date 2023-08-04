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
		ArrayList<Toymember> list = dao.();
	}
}
