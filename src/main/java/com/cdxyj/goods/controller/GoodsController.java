package com.cdxyj.goods.controller;

import com.cdxyj.goods.po.GoodsPo;
import com.cdxyj.reputation.dao.IXyjDao;
import com.cdxyj.reputation.util.AjaxResultPo;
import com.cdxyj.reputation.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    IXyjDao xyjDao;
    @RequestMapping("/list")
    @ResponseBody
    public AjaxResultPo list(int page, int rows, GoodsPo goodsPo){
        AjaxResultPo resultPo = new AjaxResultPo();
        PageInfo pageInfo = null;
        if (page > 0) {
            pageInfo = new PageInfo((page - 1) * rows, rows);
        }
        List<GoodsPo> goodsPos = xyjDao.queryGoodsByPage(pageInfo,goodsPo);

        resultPo.setSuccess(true);
        resultPo.setMsg("查询成功");
        resultPo.setTotal(pageInfo.getResults());
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
