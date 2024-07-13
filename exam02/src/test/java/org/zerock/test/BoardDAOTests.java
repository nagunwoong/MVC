package org.zerock.test;

import javax.inject.Inject;

import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.persistense.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class BoardDAOTests {

    @Inject
    private BoardDAO dao;

    private static Logger logger = LoggerFactory.getLogger(BoardDAOTests.class);

    @Test
    public void testCreate() throws Exception {
        BoardVO board = new BoardVO();
        board.setTitle("내용");
        board.setContent("제목");
        board.setWriter("내용을 입력하세요");
        dao.create(board);
    }

    @Test
    public void testRead() throws Exception {
        logger.info(dao.read(1).toString());
    }

    @Test
    public void testUpdate() throws Exception {
        BoardVO board = new BoardVO();
        board.setBno(3);
        board.setTitle("수정");
        board.setContent("내용을 수정합니다");
        dao.update(board);
    }

    @Test
    public void testDelete() throws Exception {
        dao.delete(1);
    }

    @Test
    public void testListAll() throws Exception {
        logger.info(dao.listAll().toString());
    }
}
