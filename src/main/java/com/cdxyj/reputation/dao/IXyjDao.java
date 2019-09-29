package com.cdxyj.reputation.dao;

import com.cdxyj.goods.po.GoodsPo;
import com.cdxyj.info.po.InfoPo;
import com.cdxyj.item.po.ItemPo;
import com.cdxyj.reputation.vo.PageInfo;

import java.util.List;

public interface IXyjDao {

    List<GoodsPo> queryGoodsByPage(PageInfo pageInfo,GoodsPo goodsPo);

    int addGoods(GoodsPo goodsPo);

    int updateGoods(GoodsPo goodsPo);

    List<InfoPo> queryInfoByPage();

    int addInfo(InfoPo infoPo);

    int updateInfo(InfoPo infoPo);

    List<ItemPo> queryItemByPage(PageInfo pageInfo, ItemPo itemPo);

    int addItem(ItemPo itemPo);

    int updateItem(ItemPo itemPo);

    int delete(int id,String tableName);


}
