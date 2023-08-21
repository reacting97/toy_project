package com.example.demo.complaints_board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintsBoardDao extends JpaRepository<ComplaintsBoard, Integer> {
	
}
