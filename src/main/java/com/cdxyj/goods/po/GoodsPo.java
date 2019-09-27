package com.cdxyj.goods.po;

/**
 * @Author jiangwei
 * @Description
 * @Date 2019/9/27
 **/
public class GoodsPo {
    private int id;
    private String GoodsName;
    private String pictureUrl;
    private String GoodsPrice;
    private String GoodsUnit;
    private String frist;
    private String second;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getGoodsPrice() {
        return GoodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        GoodsPrice = goodsPrice;
    }

    public String getGoodsUnit() {
        return GoodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        GoodsUnit = goodsUnit;
    }

    public String getFrist() {
        return frist;
    }

    public void setFrist(String frist) {
        this.frist = frist;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }
}
