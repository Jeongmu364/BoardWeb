package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDAO boardDAO;

    @Override
    public void insertBoard(BoardVO boardVO) {
        boardDAO.insertBoard(boardVO);
    }

    @Override
    public void updateBoard(BoardVO boardVO) {
        boardDAO.updateBoard(boardVO);
    }

    @Override
    public void deleteBoard(BoardVO boardVO) {
        boardDAO.deleteBoard(boardVO);
    }

    @Override
    public BoardVO getBoard(BoardVO boardVO) {
        return boardDAO.getBoard(boardVO);
    }

    @Override
    public List<BoardVO> getBoardList(BoardVO boardVO) {
        return boardDAO.getBoardList(boardVO);
    }
}
