package org. zerock. Test;

 import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.board.BoardDAO;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.BoardDA0;

RunWith(SpringJUnit4ClassRunner.class)
ContextConfigurationlocations = ("file: src/main/webapp/WEB - INF/spring/root-context.xml);
public class BoardDAO {



@Inject
private BoardDAO dao;

private static Logger logger = LoggerFactory.getLogger(BoardDAOTests.class);


@Test
public void testCreate() throws Exception {
	BoardVO board = new BoardVO();
	board.setTitle("새로운 글을 넣습니다");
	board.setContent("새로운 내용을 넣습니다");
	board.setWriter("홍길동");
	dao.create(board);
}


	@Test
	public void testRead() throws Exception {
		Logger.info(dao.read(1).toString());
		
	}
	@Test
	public void testUpdate () throws Exception {
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("수정글 입니다.");
		board.setContent("수정 텍스트 입니다");
		dao.update(board);
		
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}
	
	@Test
	public void testListAll() throws Exception {
		
		
		
	}
	
	
}

