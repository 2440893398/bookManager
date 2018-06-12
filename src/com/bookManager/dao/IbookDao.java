package com.bookManager.dao;

import com.bookManager.domin.book;

import java.util.List;

public interface IbookDao {
   //查询所有数据
    List<book> getall();
   //通过id查询单个数据
    book getbookbyid(String id);
    void savebook(book a);
}
