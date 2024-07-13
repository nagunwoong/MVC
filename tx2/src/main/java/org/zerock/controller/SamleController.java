package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

public class SamleController {
	@RestController
	@RequestMapping("/sample")
	
	public class SampleController {
		@RequestMapping("/hello")
		public String sayHello() {
			return "Hello World";
		}
		
		@RequestMapping("/sendVO")
		public SampleVO sendVO() {
			SampleVO vo = new SampleVO();
			vo.setFirstName("�浿");
			vo.setLastName("ȫ");
	        vo.setMno(123); // ������ ��ȣ�� �����ϰų� �⺻ ���� �����ϼ���.
	        return vo;
	    }
		
		@RequestMapping("/sendList")
		public List<SampleVO> sendList(){
			List<SampleVO> list = new ArrayList<>();
			for (int i=0; i<10; i++) {
				SampleVO vo = new SampleVO();
				vo.setFirstName("�浿");
				vo.setLastName("ȫ");
		        vo.setMno(i);
		        list.add(vo);
			}
			return list;
		}
		
		@RequestMapping("sendMap")
		public Map<Integer, SampleVO> sendMap() {
			Map<Integer, SampleVO> map = new HashMap<>();
			
			for(int i = 0; i<10; i++) {
				SampleVO vo = new SampleVO();
				vo.setFirstName("�浿");
				vo.setLastName("ȫ");
		        vo.setMno(i);
			}
			return map;
		}
	}
	}
