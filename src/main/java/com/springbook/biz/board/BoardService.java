package com.springbook.biz.board;

import java.util.List;

public interface BoardService {

    // CRUD 구현
    void insertBoard(BoardVO boardVO);

    void updateBoard(BoardVO boardVO);

    void deleteBoard(BoardVO boardVO);

    BoardVO getBoard(BoardVO boardVO);

    List<BoardVO> getBoardList(BoardVO boardVO);
}
