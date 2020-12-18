package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

//@Repository
public class BoardDAOSpring extends JdbcDaoSupport implements BoardDAO {
    private final String BOARD_INSERT = "insert into board(title, writer, content) values(?, ?, ?)";
    private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete board where seq=?";
    private final String BOARD_GET = "select * from board where seq=?";
    private final String BOARD_LIST = "select * from board order by seq desc";
    private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
    private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // CRUD 기능 메소드 구현
    @Override
    public void insertBoard(BoardVO boardVO) {
        System.out.println("===> Spring JDBC 로 insertBoard() 기능 처리");
        jdbcTemplate.update(BOARD_INSERT, boardVO.getTitle(), boardVO.getWriter(), boardVO.getContent());
    }

    @Override
    public void updateBoard(BoardVO boardVO) {
        System.out.println("===> Spring JDBC 로 updateBoard() 기능 처리");
        jdbcTemplate.update(BOARD_UPDATE, boardVO.getTitle(), boardVO.getContent(), boardVO.getSeq());
    }

    @Override
    public void deleteBoard(BoardVO boardVO) {
        System.out.println("===> Spring JDBC 로 deleteBoard() 기능 처리");
        jdbcTemplate.update(BOARD_DELETE, boardVO.getSeq());
    }

    @Override
    public BoardVO getBoard(BoardVO boardVO) {
        System.out.println("===> Spring JDBC 로 getBoard() 기능 처리");
        return jdbcTemplate.queryForObject(BOARD_GET, new BoardRowMapper(), boardVO.getSeq());
    }

    @Override
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> Spring JDBC 로 getBoardList() 기능 처리");
        Object[] args = {vo.getSearchKeyword()};
        if (vo.getSearchCondition().equals("TITLE")) {
            return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
        } else if (vo.getSearchCondition().equals("CONTENT")) {
            return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
        }
        return null;
    }
}
