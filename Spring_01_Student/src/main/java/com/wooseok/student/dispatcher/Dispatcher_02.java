package com.wooseok.student.dispatcher;

import com.wooseok.student.controller.StController2;
import com.wooseok.student.service.StService;
import com.wooseok.student.service.impl.StService2;

public class Dispatcher_02 {

    public static void main(String[] args) {

        StController2 stCon = new StController2();
        StService stService = new StService2();
        stCon.setStService(stService);

        stCon.list();
    }
}
