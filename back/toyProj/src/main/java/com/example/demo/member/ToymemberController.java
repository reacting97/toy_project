package com.example.demo.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // rest api controller
@CrossOrigin(origins = "*") // 모든 ip로부터 요청 받기 허용
@RequestMapping("/member") // 기본 url: restshop
public class ToymemberController {
	@Autowired
	private ToymemberService service;

	// 가입
	@PostMapping("")
	public Map join(ToymemberDto dto) {
		ToymemberDto d = service.join(dto);
		Map map = new HashMap();
		map.put("dto", d);
		return map;
	}
	
	//멤버 전체조회
	@GetMapping("")
	public Map getByall() {
		ArrayList<ToymemberDto> list = service.getAll();
		Map map = new HashMap<>();
		map.put("list", list);
		return map;
	}

}
