package com.wooseok.java.repository;

import com.wooseok.java.models.BookVO;
import com.wooseok.java.repository.sql.BookSQL;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BookDao {

    @Select("SELECT * FROM tbl_members")
    public List<BookVO> selectAll();

    // @Insert(BookSQL.book_insert_sql)
    @InsertProvider(type = BookSQL.class, method = "book_insert")
    public int insert(BookVO bookVO);

    // @Update() : 문자열로 만든 SQL 을 실행할 때

    // SQL 클래스로 만든 SQL 을 실행할때
    @UpdateProvider(type = BookSQL.class,method = "book_update_sql")
    public int update(BookVO bookVO);

    @Delete("DELETE FROM tbl_members WHERE username = #{isbn}")
    public  int delete(String isbn);
}
