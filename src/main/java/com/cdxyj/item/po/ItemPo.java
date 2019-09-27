package com.cdxyj.item.po;

/**
 * @Author jiangwei
 * @Description
 * @Date 2019/9/27
 **/
public class ItemPo {
    private int id;
    private String itemName;
    private String itemCustomer;
    private String itemModel;
    private String itemNorms;
    private String itemDec;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCustomer() {
        return itemCustomer;
    }

    public void setItemCustomer(String itemCustomer) {
        this.itemCustomer = itemCustomer;
    }

    public String getItemModel() {
        return itemModel;
    }

    public void setItemModel(String itemModel) {
        this.itemModel = itemModel;
    }

    public String getItemNorms() {
        return itemNorms;
    }

    public void setItemNorms(String itemNorms) {
        this.itemNorms = itemNorms;
    }

    public String getItemDec() {
        return itemDec;
    }

    public void setItemDec(String itemDec) {
        this.itemDec = itemDec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
