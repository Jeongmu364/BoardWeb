package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardVO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BoardDAOJPA implements BoardDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertBoard(BoardVO vo) {
        System.out.println("===> JPA 로 insertBoard() 기능 처리");
        entityManager.persist(vo);
    }

    @Override
    public void updateBoard(BoardVO vo) {
        System.out.println("===> JPA 로 updateBoard() 기능 처리");
        entityManager.merge(vo);
    }

    @Override
    public void deleteBoard(BoardVO vo) {
        System.out.println("===> JPA 로 deleteBoard() 기능 처리");
        entityManager.remove(entityManager.find(BoardVO.class, vo.getSeq()));
    }

    @Override
    public BoardVO getBoard(BoardVO vo) {
        System.out.println("===> JPA 로 getBoard() 기능 처리");
        return (BoardVO) entityManager.find(BoardVO.class, vo.getSeq());
    }

    @Override
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> JPA 로 getBoardList() 기능 처리");
        return entityManager.createQuery("select b from BoardVO b order by b.seq desc").getResultList();
    }
}
