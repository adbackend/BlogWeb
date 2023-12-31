package com.ql.blog.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {
	
	private int status; // HTTP 응답 상태코드
	private T data; // 실제 응답할 데이터
}
