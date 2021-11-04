package com.wooseok.student.dispatcher;

import com.wooseok.student.controller.StController;

public class Dispatcher_01 {

    public static void main(String[] args) {

        StController stCon = new StController();
        stCon.list();
    }
}
