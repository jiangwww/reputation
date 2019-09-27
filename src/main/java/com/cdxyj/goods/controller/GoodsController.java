package com.cdxyj.goods.controller;

import com.cdxyj.goods.po.GoodsPo;
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
@RequestMapping("/goods")
public class GoodsController {
    @RequestMapping("/list")
    @ResponseBody
    public AjaxResultPo list(){
        AjaxResultPo resultPo = new AjaxResultPo();
        List<GoodsPo> goodsPos = new ArrayList<>();
        GoodsPo goodsPo = new GoodsPo();
        goodsPo.setGoodsName("123");
        goodsPos.add(goodsPo);
        resultPo.setSuccess(true);
        resultPo.setMsg("查询成功");
        resultPo.setTotal(1);
        resultPo.setRows(goodsPos);
        return resultPo;
    }

    @RequestMapping("/add")
    @ResponseBody
    public AjaxResultPo add(GoodsPo goods){
        AjaxResultPo resultPo = new AjaxResultPo();
        resultPo.setMsg("添加成功");
        resultPo.setSuccess(true);
        return resultPo;
    }
    @RequestMapping("/update")
    @ResponseBody
    public AjaxResultPo update(GoodsPo goods){
        AjaxResultPo resultPo = new AjaxResultPo();
        resultPo.setMsg("修改成功");
        resultPo.setSuccess(true);
        return resultPo;
    }
}
