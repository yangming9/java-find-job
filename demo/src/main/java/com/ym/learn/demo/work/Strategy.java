package com.ym.learn.demo.work;
import java.util.*;

public class Strategy {
    public static List<Integer> splitIntoPagesWithOneVideo(List<Integer> list, int pageSize, Integer specialElement) {
        List<Integer> pages = new ArrayList<>();
        Deque<Integer> tempObjects = new LinkedList<>();
        int i = 0;
        while (i < list.size()){
            if(!tempObjects.isEmpty() && list.get(i).intValue() == specialElement.intValue()){
                i = i + 1;
            }
            List<Integer> currentPage = new ArrayList<>();
            boolean hasSpecialElement = false;
            if(tempObjects.isEmpty()){
                for(int j = 0; j < pageSize && i < list.size(); j++, i++) {
                    Integer currentElement = list.get(i);
                    if(currentElement.intValue() == specialElement.intValue()) {
                        hasSpecialElement = true;
                    }
                    currentPage.add(currentElement);
                }
            }else {
                for(int j=0;j<pageSize && !tempObjects.isEmpty();j++){
                    Integer currentElement = tempObjects.poll();
                    if(currentElement.intValue() == specialElement.intValue()) {
                        hasSpecialElement = true;
                    }
                    currentPage.add(currentElement);
                }
                if(currentPage.size() < pageSize){
                    for(int j = 0; currentPage.size() < pageSize && i < list.size(); j++, i++) {
                        Integer currentElement = list.get(i);
                        if(currentElement.intValue() == specialElement.intValue()) {
                            hasSpecialElement = true;
                        }
                        currentPage.add(currentElement);
                    }
                }
            }
            if(!hasSpecialElement){
                for(int tempI = i;tempI<list.size() && i < list.size();tempI++,i++){
                    Integer currentElement = list.get(tempI);
                    if( currentElement.intValue() == specialElement.intValue()){
                        int randomNumber = getRandomIndex(currentPage.size());
                        currentPage.add(randomNumber,specialElement);
                        boolean flag = false;
                        int index = currentPage.size();
                        while (!flag){
                            index = index -1;
                            int lastElement = currentPage.get(index);
                            if(lastElement != specialElement){
                                flag = true;
                                currentPage.remove(index);
                                tempObjects.offerFirst(lastElement);
                            }
                        }
                        break;
                    }
                    tempObjects.add(currentElement);
                }
            }
            for (Integer item : currentPage) {
                pages.add(item);
            }
        }
        if(!tempObjects.isEmpty()){
            for (Integer tempObject : tempObjects) {
                pages.add(tempObject);
            }
        }
        return pages;
    }

    /**
     * reRank 策略参考
     * @param list  等待重排的结果列表
     * @param pageSize  每页的数量
     * @param specialElement  需要重排的标记值
     * @param specialNumber  每页重排至少出现的数量 不能大于pageSize
     * @return
     */
    public static List<Integer> splitIntoPagesWithManyVideo(List<Integer> list, int pageSize, Integer specialElement, Integer specialNumber) {
        List<Integer> pages = new ArrayList<>();
        if(specialNumber >= pageSize){
            throw new RuntimeException("每页重排数量过多！！！");
        }
        Deque<Integer> tempObjects = new LinkedList<>();
        int i = 0;
        int specialTempCount = 0;
        while (i < list.size()){
            if(!tempObjects.isEmpty() && list.get(i).intValue() == specialElement.intValue()){
                i = i + 1;
            }
            List<Integer> currentPage = new ArrayList<>();
            boolean hasSpecialElement = false;
            specialTempCount = 0;
            if(tempObjects.isEmpty()){
                for(int j = 0; j < pageSize && i < list.size(); j++, i++) {
                    Integer currentElement = list.get(i);
                    if(currentElement.intValue() == specialElement.intValue()) {
                        specialTempCount = specialTempCount + 1;
                        if(specialTempCount == specialNumber){
                            hasSpecialElement = true;
                        }
                    }
                    currentPage.add(currentElement);
                }
            }else {
                for(int j=0;j<pageSize && !tempObjects.isEmpty();j++){
                    Integer currentElement = tempObjects.poll();
                    if(currentElement.intValue() == specialElement.intValue()) {
                        specialTempCount = specialTempCount + 1;
                        if(specialTempCount == specialNumber){
                            hasSpecialElement = true;
                        }
                    }
                    currentPage.add(currentElement);
                }
                if(currentPage.size() < pageSize){
                    for(int j = 0; currentPage.size() < pageSize && i < list.size(); j++, i++) {
                        Integer currentElement = list.get(i);
                        if(currentElement.intValue() == specialElement.intValue()) {
                            specialTempCount = specialTempCount + 1;
                            if(specialTempCount == specialNumber){
                                hasSpecialElement = true;
                            }
                        }
                        currentPage.add(currentElement);
                    }
                }
            }
            if(!hasSpecialElement){
                for(int tempI = i;tempI<list.size() && i < list.size();tempI++,i++){
                    Integer currentElement = list.get(tempI);
                    if( currentElement.intValue() == specialElement.intValue()){
                        int randomNumber = getRandomIndex(currentPage.size());
                        currentPage.add(randomNumber,specialElement);
                        boolean flag = false;
                        int index = currentPage.size();
                        while (!flag){
                            index = index -1;
                            int lastElement = currentPage.get(index);
                            if(lastElement != specialElement){
                                flag = true;
                                currentPage.remove(index);
                                tempObjects.offerFirst(lastElement);
                            }
                        }
                        specialTempCount = specialTempCount + 1;
                        if(specialTempCount == specialNumber){
                            hasSpecialElement = true;
                            break;
                        }
                    } else {
                        tempObjects.add(currentElement);
                    }
                }
            }
            pages.addAll(currentPage);
        }
        if(!tempObjects.isEmpty()){
            pages.addAll(tempObjects);
        }
        return pages;
    }


    public static int getRandomIndex(int size){
        Random rand = new Random();
        return rand.nextInt(size);
    }

    public static boolean getTest(){
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=100;i++){
            list.add(i);
        }
        Random rand = new Random();
        for(int i=0;i<50;i++){
            int randomNum = rand.nextInt(100);
            list.add(randomNum,0);
        }
//        list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 0, 46, 0, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100));
        List<Integer> newPages = splitIntoPagesWithManyVideo(list,10,0,1);
        int count = 0;
        List<Integer> printPage = new ArrayList<>();
        if(list.size() == newPages.size()) {
            System.out.println(list);
            System.out.println(list.size());
            System.out.println(newPages.size());
            for (Integer newPage : newPages) {
                printPage.add(newPage);
                count = count + 1;
                if(count%10==0 || count==newPages.size()){
                    int row = count/10;
                    if(count==newPages.size() && count%10 != 0){
                        row = row + 1;
                    }
                    System.out.println("page" + row +": " + printPage);
                    printPage.clear();
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        getTest();
//        try {
//            for(int i=0;i<10000000;i++){
//                System.out.println(getTest());
//                if(!getTest()){
//                    Thread.sleep(30000);
//                }else {
//                    System.out.println(i);
//                }
//            }
//        } catch (InterruptedException e) {
//            // Exception handling code here
//        }
    }
}
