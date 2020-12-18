package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public class BoardDAOMyBatis implements BoardDAO {
    // extends SqlSessionDaoSupport
//    @Autowired
//    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//        super.setSqlSessionFactory(sqlSessionFactory);
//    }

    @Autowired
    private SqlSessionTemplate mybatis;

    @Override
    public void insertBoard(BoardVO vo) {
        System.out.println("===> MyBatis 로 insertBoard() 기능 처리");
        mybatis.insert("BoardDAO.insertBoard", vo);
    }

    @Override
    public void updateBoard(BoardVO vo) {
        System.out.println("===> MyBatis 로 updateBoard() 기능 처리");
        mybatis.update("BoardDAO.updateBoard", vo);
    }

    @Override
    public void deleteBoard(BoardVO vo) {
        System.out.println("===> MyBatis 로 deleteBoard() 기능 처리");
        mybatis.delete("BoardDAO.deleteBoard", vo);
    }

    @Override
    public BoardVO getBoard(BoardVO vo) {
        System.out.println("===> MyBatis 로 getBoard() 기능 처리");
        return mybatis.selectOne("BoardDAO.getBoard", vo);
    }

    @Override
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> MyBatis 로 getBoardList() 기능 처리");
        return mybatis.selectList("BoardDAO.getBoardList", vo);
    }
}
