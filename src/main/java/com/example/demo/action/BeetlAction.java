package com.example.demo.action;

import xyz.erupt.annotation.sub_erupt.Tpl;
import xyz.erupt.tpl.annotation.EruptTpl;
import xyz.erupt.tpl.annotation.TplAction;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@EruptTpl(engine = Tpl.Engine.Beetl)
public class BeetlAction {

    @TplAction("beetl-page.html")
    public Map<String, Object> beetlPage() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> mp = new LinkedHashMap<>();
//        mp.put("annotation", 'E');
        map.put("map", mp);
        return map;
    }

}