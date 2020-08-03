package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.interpreter;

import java.util.HashMap;

/**
 * 变量的解释器
 */
public class VarExpression extends Expression {
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
