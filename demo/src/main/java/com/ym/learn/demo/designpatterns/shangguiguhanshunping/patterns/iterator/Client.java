package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<College> collegeArrayList = new ArrayList<>();
        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();
        collegeArrayList.add(computerCollege);
        collegeArrayList.add(infoCollege);

        OutPutImpl outPut = new OutPutImpl(collegeArrayList);
        outPut.printCollege();
    }
}
