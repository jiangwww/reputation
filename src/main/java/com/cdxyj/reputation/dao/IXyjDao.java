package com.cdxyj.reputation.dao;

import com.cdxyj.goods.po.GoodsPo;
import com.cdxyj.info.po.InfoPo;
import com.cdxyj.reputation.vo.PageInfo;

import java.util.List;

public interface IXyjDao {

    List<GoodsPo> queryGoodsByPage(PageInfo pageInfo,GoodsPo goodsPo);

    int addGoods(GoodsPo goodsPo);

    int updateInfo(InfoPo infoPo);
}
