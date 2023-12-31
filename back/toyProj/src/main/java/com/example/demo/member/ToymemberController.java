package com.example.demo.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // rest api controller
@CrossOrigin(origins = "*") // 모든 ip로부터 요청 받기 허용
@RequestMapping("/cmember") // 기본 url: restshop
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

	// 멤버 전체조회
	@GetMapping("")
	public Map getByall() {
		ArrayList<ToymemberDto> list = service.getAll();
		Map map = new HashMap<>();
		map.put("list", list);
		return map;
	}

	// 맴버 Id로 검색
	@GetMapping("/{id}")
	public Map getById(@PathVariable("id") String id) {
		ToymemberDto dto = service.getById(id);
		Map map = new HashMap<>();
		map.put("dto", dto);
		return map;
	}
	
	//맴버 로그인 인증
	@GetMapping("/{id}/{pwd}")
	public Map login(@PathVariable("id") String id, @PathVariable("pwd") String pwd) {
		ToymemberDto dto = service.getByIdAndPwd(id, pwd);
		Map map = new HashMap<>();
		map.put("dto", dto);
		return map;
	}
}
