package org.zerock.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.BoardDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BoardDAOTests {
	
	@Inject
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTests.class);
	
	@Test
	public void testCreate() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("제목");
		board.setContent("�내용");
		board.setWriter("글쓴이");
		dao.create(board);		
	}
	
	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(2).toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO board = new BoardVO();
		board.setBno(2);
		board.setTitle("수정");
		board.setContent("수정내용");
		dao.update(board);
	}
	
	@Test
	  public void testDelete() throws Exception {
		dao.delete(2);
	}

	@Test
	  public void testListAll() throws Exception {
		logger.info(dao.listAll().toString());
	}
	
	@Test
	public void testListPage() throws Exception {
		int page = 3;
		
		List<BoardVO> list = dao.listPage(page);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}
		 @Test
		    public void testDynamic1() {
		    	try {
		    	SearchCriteria cri = new SearchCriteria();
		    	cri.setPage(1);
		    	cri.setKeyword("수");
		    	cri.setSearchType("t");
		    	
		    	logger.info("=======================================");
		    	
		    	
		    	List<BoardVO> list = dao.listSearch(cri);
		    	
		    	for(BoardVO boardVO : list) {
		    		logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		    	}
		    	logger.info("=======================================");
		    	
		    	logger.info("count: " + dao.listSearchCount(cri));
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    }
		}
