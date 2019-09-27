package com.cdxyj.reputation.dao.impl;

import com.cdxyj.goods.po.GoodsPo;
import com.cdxyj.info.po.InfoPo;
import com.cdxyj.reputation.dao.IXyjDao;
import com.cdxyj.reputation.dao.jdbc.BaseJdbcDao;
import com.cdxyj.reputation.dao.jdbc.BaseJdbcMysqlDao;
import com.cdxyj.reputation.vo.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

/**
 * @Author jiangwei
 * @Description
 * @Date 2019/9/27
 **/
@Repository
public class XyjDaoImpl extends BaseJdbcMysqlDao implements IXyjDao {
    @Override
    public List<GoodsPo> queryGoodsByPage(PageInfo pageInfo, GoodsPo goodsPo) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from goods where 1=1");
        if(null!=goodsPo) {
            if (StringUtils.isNotBlank(goodsPo.getGoodsName())){
                sql.append(" and goodsname like '%").append(goodsPo.getGoodsName()).append("%'");
            }
        }
        return queryByPage(sql.toString(),pageInfo,GoodsPo.class);
    }

    @Override
    public int addGoods(GoodsPo goodsPo) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into (goodsname,pictureurl,goodsprice,goodsunit,frist,second) value (?,?,?,?,?,?)");
        Object[] params = new Object[]{
            goodsPo.getGoodsName(),goodsPo.getPictureUrl(),goodsPo.getGoodsPrice(),goodsPo.getGoodsUnit(),goodsPo.getFrist(),goodsPo.getSecond()
        };
        int[] types = new int[]{
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
        };
        return this.update(sql.toString(), params, types);
    }

    @Override
    public int updateInfo(InfoPo infoPo) {
        StringBuilder sql = new StringBuilder();
        sql.append("update info set ").append("contactName=?,contactPhone=?,contactAddr=?,contactDec=? where id=?");
        Object[] params = new Object[]{
                infoPo.getContactName(),infoPo.getContactPhone(),infoPo.getContactAddr(),infoPo.getContactDec(),infoPo.getId()
        };
        int[] types = new int[]{
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER,
        };
        return this.update(sql.toString(), params, types);
    }
}
