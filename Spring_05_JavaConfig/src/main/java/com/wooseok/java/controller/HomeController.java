package com.wooseok.java.controller;

import com.wooseok.java.models.BookVO;
import com.wooseok.java.repository.BookDao;
import com.wooseok.java.service.impl.NaverServiceImplV1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Controller
public class HomeController {

    private final NaverServiceImplV1 naverService;
    private final BookDao bookDao;

    public HomeController(NaverServiceImplV1 naverService, BookDao bookDao) {
        this.naverService = naverService;
        this.bookDao = bookDao;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String home() {

        bookDao.selectAll();
        return "home";
    }

    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public List<BookVO> home(String search) throws IOException, URISyntaxException {

        String queryString = naverService.queryString(search);
        String jsonString = naverService.getJsonString(queryString);

        List<BookVO> bookList = naverService.naverList(queryString);

        return bookList;

    }
}
