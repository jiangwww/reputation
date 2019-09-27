package com.cdxyj.info.controller;

import com.cdxyj.info.po.InfoPo;
import com.cdxyj.item.po.ItemPo;
import com.cdxyj.reputation.util.AjaxResultPo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiangwei
 * @Description
 * @Date 2019/9/27
 **/
@Controller
@RequestMapping("/info")
public class InfoController {
    @RequestMapping("/update")
    @ResponseBody
    public AjaxResultPo update(InfoPo infoPo){
        AjaxResultPo resultPo = new AjaxResultPo();
        resultPo.setMsg("修改成功");
        resultPo.setSuccess(true);
        return resultPo;
    }
}
