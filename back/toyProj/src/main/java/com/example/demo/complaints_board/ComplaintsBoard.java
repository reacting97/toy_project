package com.example.demo.complaints_board;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintsBoard {
	@Id
	@SequenceGenerator(name="seq_complaints", sequenceName="seq_complaints", allocationSize=1)//시퀀스 생성. sequenceName:시퀀스 이름
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_complaints")//값 자동생성설정
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
}
