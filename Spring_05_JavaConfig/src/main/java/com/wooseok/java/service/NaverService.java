package com.wooseok.java.service;

import com.wooseok.java.models.BookVO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;

public abstract class NaverService<T> {

    // 필수적으로 생성할 method
    public String queryString(String search) throws UnsupportedEncodingException {

        String searchUTF8 = URLEncoder.encode(search,"UTF-8");
        StringBuilder queryURL = new StringBuilder();
        String NAVER_BOOK_URL = "https://openapi.naver.com/v1/search/book.json";
        queryURL.append(NAVER_BOOK_URL);

        queryURL.append(String.format("?query=%s",searchUTF8));

        return queryURL.toString();
    };

    // 선택적으로 사용할 method
    public abstract String getJsonString(String queryString) throws IOException;
    public abstract List<T> naverList(String queryString) throws URISyntaxException;
}
