package com.netcracker.TestClasses;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collection {
    List list;
    Set set;
    Map map;

    public Collection() {
        System.out.println("Collection.Collection");
    }

    public Collection(List list, Set set, Map map) {
        this.list = list;
        this.set = set;
        this.map = map;
        System.out.println("list = " + list);
        System.out.println("list = " + set);
        System.out.println("map = " + map);
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
        System.out.println("Collection.setList");
        System.out.println("list = " + list);
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
        System.out.println("Collection.setSet");
        System.out.println("set = " + set);
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
        System.out.println("Collection.setMap");
        System.out.println("map = " + map);
    }
}
