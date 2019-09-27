package com.cdxyj.item.controller;

import com.cdxyj.goods.po.GoodsPo;
import com.cdxyj.item.po.ItemPo;
import com.cdxyj.reputation.util.AjaxResultPo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jiangwei
 * @Description
 * @Date 2019/9/27
 **/
@Controller
@RequestMapping("/item")
public class ItemController {

    @RequestMapping("/list")
    @ResponseBody
    public AjaxResultPo list(){
        AjaxResultPo resultPo = new AjaxResultPo();
        List<ItemPo> itemPos = new ArrayList<>();
        ItemPo itemPo = new ItemPo();
        itemPo.setItemName("123");
        itemPos.add(itemPo);
        resultPo.setSuccess(true);
        resultPo.setMsg("查询成功");
        resultPo.setTotal(1);
        resultPo.setRows(itemPos);
        return resultPo;
    }

    @RequestMapping("/add")
    @ResponseBody
    public AjaxResultPo add(ItemPo item){
        AjaxResultPo resultPo = new AjaxResultPo();
        resultPo.setMsg("添加成功");
        resultPo.setSuccess(true);
        return resultPo;
    }
    @RequestMapping("/update")
    @ResponseBody
    public AjaxResultPo update(ItemPo item){
        AjaxResultPo resultPo = new AjaxResultPo();
        resultPo.setMsg("修改成功");
        resultPo.setSuccess(true);
        return resultPo;
    }
}
