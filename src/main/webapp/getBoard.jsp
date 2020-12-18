<%@ page import="com.springbook.biz.board.BoardVO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-12-10 010
  Time: 오전 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>글 상세</title>
</head>
<body>
<div style="text-align: center">
    <h1>글 상세</h1>
    <a href="logout.do">Log-out</a>
    <hr>
    <form action="updateBoard.do" method="post">
        <input name="seq" type="hidden" value="${board.seq }"/>
        <table border="1" cellspacing="0" cellpadding="0">
            <tr>
                <td bgcolor="orange" width="70">제목</td>
                <td align="left"><input name="title" type="text" value="${board.title }"></td>
            </tr>
            <tr>
                <td bgcolor="orange">작성자</td>
                <td align="left">${board.writer }
                </td>
            </tr>
            <tr>
                <td bgcolor="orange">내용</td>
                <td align="left"><textarea name="content" cols="40" rows="10">
                    ${board.content }
                </textarea></td>
            </tr>
            <tr>
                <td bgcolor="orange">등록일</td>
                <td align="left"><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/>
                </td>
            </tr>
            <tr>
                <td bgcolor="orange">조회수</td>
                <td align="left">${board.cnt }
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="글 수정">
                </td>
            </tr>
        </table>
    </form>
    <hr>
    <a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
    <a href="deleteBoard.do?seq=${board.seq }">글삭제</a>&nbsp;&nbsp;&nbsp;
    <a href="getBoardList.do">글목록</a>
</div>
</body>
</html>
