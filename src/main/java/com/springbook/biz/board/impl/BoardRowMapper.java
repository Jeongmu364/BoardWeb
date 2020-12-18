package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardRowMapper implements RowMapper<BoardVO> {
    @Override
    public BoardVO mapRow(ResultSet resultSet, int i) throws SQLException {
        BoardVO board = new BoardVO();
        board.setSeq(resultSet.getInt("seq"));
        board.setTitle(resultSet.getString("title"));
        board.setWriter(resultSet.getString("writer"));
        board.setContent(resultSet.getString("content"));
        board.setRegDate(resultSet.getDate("regdate"));
        board.setCnt(resultSet.getInt("cnt"));
        return board;
    }
}
