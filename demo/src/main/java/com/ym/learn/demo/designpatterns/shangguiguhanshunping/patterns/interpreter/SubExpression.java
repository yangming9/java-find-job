package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.interpreter;

import java.util.HashMap;

public class SubExpression extends SymbolExpression {

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    //super.left.interpreter(var) ：返回 left表达式对应的值
    //super.right.interpreter(var) ：返回 right表达式对应的值
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var)-super.right.interpreter(var);
    }

}
