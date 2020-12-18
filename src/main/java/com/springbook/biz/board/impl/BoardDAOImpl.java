package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class BoardDAOImpl implements BoardDAO {
    // JDBC 관련 변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // SQL 명령어들
    private final String BOARD_INSERT = "insert into board(title, writer, content) " +
            "values(?, ?, ?)";
    private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete from board where seq=?";
    private final String BOARD_GET = "select * from board where seq=?";
    private final String BOARD_LIST = "select * from board order by seq desc";
    private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
    private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";


    public void insertBoard(BoardVO boardVO) {
        System.out.println("===> JDBC로 insertBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_INSERT);
            stmt.setString(1, boardVO.getTitle());
            stmt.setString(2, boardVO.getWriter());
            stmt.setString(3, boardVO.getContent());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public void updateBoard(BoardVO boardVO) {
        System.out.println("===> JDBC로 updateBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_UPDATE);
            stmt.setString(1, boardVO.getTitle());
            stmt.setString(2, boardVO.getContent());
            stmt.setInt(3, boardVO.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public void deleteBoard(BoardVO boardVO) {
        System.out.println("===> JDBC로 deleteBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_DELETE);
            stmt.setInt(1, boardVO.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public BoardVO getBoard(BoardVO boardVO) {
        System.out.println("===> JDBC로 getBoard() 기능 처리");
        BoardVO board = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_GET);
            stmt.setInt(1, boardVO.getSeq());
            rs = stmt.executeQuery();
            if (rs.next()) {
                board = getResultObject(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return board;
    }

    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> JDBC로 getBoardList() 기능 처리");
        List<BoardVO> boardList = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            if (vo.getSearchCondition().equals("TITLE")) {
                stmt = conn.prepareStatement(BOARD_LIST_T);
            } else if (vo.getSearchCondition().equals("CONTENT")) {
                stmt = conn.prepareStatement(BOARD_LIST_C);
            }
            stmt.setString(1, vo.getSearchKeyword());
            rs = stmt.executeQuery();
            while (rs.next()) {
                boardList.add(getResultObject(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return boardList;
    }

    private BoardVO getResultObject(ResultSet rs) throws SQLException {
        BoardVO boardVO = new BoardVO();
        boardVO.setSeq(rs.getInt("SEQ"));
        boardVO.setTitle(rs.getString("TITLE"));
        boardVO.setWriter(rs.getString("WRITER"));
        boardVO.setContent(rs.getString("CONTENT"));
        boardVO.setRegDate(rs.getDate("REGDATE"));
        boardVO.setCnt(rs.getInt("CNT"));

        return boardVO;
    }
}
