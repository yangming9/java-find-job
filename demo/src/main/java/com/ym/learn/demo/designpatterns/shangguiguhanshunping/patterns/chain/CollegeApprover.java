package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.chain;

public class CollegeApprover extends Approver {

    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (5000 < purchaseRequest.getPrice() && purchaseRequest.getPrice() <= 10000){
            System.out.println("请求编号 id="+purchaseRequest.getId()+"被"+this.name+"处理了");
        }else {
            approver.processRequest(purchaseRequest);
        }
    }
}
