package com.wooseok.student.dispatcher;

import com.wooseok.student.controller.StController3;
import com.wooseok.student.service.StService;
import com.wooseok.student.service.impl.StService2;

public class Dispatcher_03 {

    public static void main(String[] args) {

        StService stService = new StService2();
        StController3 stCon = new StController3(stService);
        stCon.list();
    }
}
