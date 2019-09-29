package com.cdxyj.item.controller;

import com.cdxyj.goods.po.GoodsPo;
import com.cdxyj.item.po.ItemPo;
import com.cdxyj.reputation.dao.IXyjDao;
import com.cdxyj.reputation.util.AjaxResultPo;
import com.cdxyj.reputation.vo.PageInfo;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    IXyjDao xyjDao;
    @RequestMapping("/list")
    @ResponseBody
    public AjaxResultPo list(int page, int rows,ItemPo itemPo) {
        try {
            AjaxResultPo resultPo = new AjaxResultPo();
            PageInfo pageInfo = null;
            if (page > 0) {
                pageInfo = new PageInfo((page - 1) * rows, rows);
            }
            List<ItemPo> itemPos = xyjDao.queryItemByPage(pageInfo,itemPo);
            resultPo.setSuccess(true);
            resultPo.setMsg("查询成功");
            resultPo.setTotal(pageInfo.getTotalRecords());
            resultPo.setRows(itemPos);
            return resultPo;
        } catch (Exception e) {
            log.error(e.getMessage());
            return AjaxResultPo.failed(e);
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public AjaxResultPo add(ItemPo item) {
        try {
            AjaxResultPo resultPo = new AjaxResultPo();
            xyjDao.addItem(item);
            resultPo.setMsg("添加成功");
            resultPo.setSuccess(true);
            return resultPo;
        } catch (Exception e) {
            log.error(e.getMessage());
            return AjaxResultPo.failed(e);
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxResultPo update(ItemPo item) {
        try {
            AjaxResultPo resultPo = new AjaxResultPo();
            xyjDao.updateItem(item);
            resultPo.setMsg("修改成功");
            resultPo.setSuccess(true);
            return resultPo;
        } catch (Exception e) {
            log.error(e.getMessage());
            return AjaxResultPo.failed(e);
        }
    }
}
