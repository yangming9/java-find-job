package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.chain;

public class SchoolMasterApprover extends Approver {

    public SchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (30000 < purchaseRequest.getPrice()){
            System.out.println("请求编号 id="+purchaseRequest.getId()+"被"+this.name+"处理了");
        }else {
            approver.processRequest(purchaseRequest);
        }
    }
}
