package com.pdsu.mypojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形结构
 * @author zhangchi
 * @create 2019-04-13
 */
public class ThreeResult {

    private String id;
    private String name;
    private boolean spread = true;
    private List<ThreeResult> children = new ArrayList<ThreeResult>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public List<ThreeResult> getChildren() {
        return children;
    }

    public void setChildren(List<ThreeResult> children) {
        this.children = children;
    }
}
