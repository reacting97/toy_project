package com.example.demo.complaints_board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController // rest api controller
@CrossOrigin(origins = "*") // 모든 ip로부터 요청 받기 허용
@RequestMapping("/complaintsboard") // 기본 url: restshop
public class ComplaintsBoardController {
	@Autowired
	private ComplaintsBoardService service;

	@Value("${spring.servlet.multipart.location}")
	private String path; // C:/shop/

	// 전체목록검색
	@GetMapping("")
	public Map getAll() {
		ArrayList<ComplaintsBoardDto> list = service.getAll();
		Map map = new HashMap();
		map.put("list", list);
		return map;
	}

	// 글번호로 상세조회
	@GetMapping("/{num}")
	public Map getByNum(@PathVariable("num") int num) {
		ComplaintsBoardDto dto = service.getByNum(num);
		Map map = new HashMap<>();
		map.put("dto", dto);
		return map;
	}

	// 글 생성
	@PostMapping("")
	public Map add(ComplaintsBoardDto dto) {
		boolean flag = true;
		try {
			int num = service.save(dto);
			File dir = new File(path + num);
			MultipartFile[] f = dto.getF();
			String[] imgs = new String[2];
			for (int i = 0; i < f.length; i++) {
				MultipartFile x = f[i];
				String fname = x.getOriginalFilename();
				if (fname != null && !fname.equals("")) {
					String newpath = path + num + "/" + fname;
					File newfile = new File(newpath);// 복사할 새 파일 생성. c:/shop/번호/원본파일명
					System.out.println(newpath);
					try {
						x.transferTo(newfile); // 파일 업로드
						imgs[i] = newpath;
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			dto.setImg1(imgs[0]);
			dto.setImg2(imgs[1]);
			dto.setNum(num);
			int saveNum = service.save(dto);// 수정
		} catch (Exception e) {
			flag = false;
		}
		Map map = new HashMap();
		map.put("flag", flag);
		map.put("dto", dto);
		return map;
	}
}
