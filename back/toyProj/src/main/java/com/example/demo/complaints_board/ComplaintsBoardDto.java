package com.example.demo.complaints_board;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComplaintsBoardDto {
	private int num;
	//게시판제목
	private String title;
	
	//게시판내용
	private String contents;
	
	//대상학교
	private String school;
	
	//민원종류
	private String category;
	
	//열람여부
	private int ischecked;
	
	//조회수
	private int cnt;
	
	private String img1;
	private String img2;
	private MultipartFile[] f = new MultipartFile[2];
}
