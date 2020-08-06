package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.chain;

/**
 * 责任链模式
 */
public class Client {
    public static void main(String[] args) {
        //1.创建请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 31000, 1);
        //2.创建相关的审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        CollegeApprover collegeApprover = new CollegeApprover("李院长");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("王副校长");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("佟校长");
        //需要将各个审批级别的下一个设置好（处理人构成环状）
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        departmentApprover.processRequest(purchaseRequest);
    }
}
