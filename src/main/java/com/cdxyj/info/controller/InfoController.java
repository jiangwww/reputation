package com.cdxyj.info.controller;

import com.cdxyj.info.po.InfoPo;
import com.cdxyj.item.po.ItemPo;
import com.cdxyj.reputation.dao.IXyjDao;
import com.cdxyj.reputation.util.AjaxResultPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author jiangwei
 * @Description
 * @Date 2019/9/27
 **/
@Slf4j
@Controller
@RequestMapping("/info")
public class InfoController {
    @Autowired
    IXyjDao xyjDao;
    @RequestMapping("/update")
    @ResponseBody
    public AjaxResultPo update(InfoPo infoPo){
        try {
            AjaxResultPo resultPo = new AjaxResultPo();
            xyjDao.updateInfo(infoPo);
            resultPo.setMsg("修改成功");
            resultPo.setSuccess(true);
            return resultPo;
        }catch (Exception e){
            log.error("更新失败"+e);
            return AjaxResultPo.failed(e);
        }

    }
    @RequestMapping("/query")
    @ResponseBody
    public AjaxResultPo query(){
        try {
            AjaxResultPo resultPo = new AjaxResultPo();
            List info= xyjDao.queryInfoByPage();
            resultPo.setMsg("查询成功");
            resultPo.setRows(info);
            resultPo.setTotal(1);
            resultPo.setSuccess(true);
            return resultPo;
        }catch (Exception e){
            log.error("查询失败"+e);
            return AjaxResultPo.failed(e);
        }

    }
}
