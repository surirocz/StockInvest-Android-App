package com.surirocz.stockinvest.modules;

import android.content.Context;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;

import com.surirocz.stockinvest.R;

public class Company {

    String name;
    String ticker;
    String shares;
    String last;
    double change;

    String companyPriceChange;

    float price;
    String name_or_shares;
    @DrawableRes
    int arrow;
    @ColorInt
    int changeColor;

    public Company(){
        this.name = "AAA";
        this.shares = "BBB";
        this.last = "CCC";
        this.change = 0;
        this.name_or_shares = "DDD";
        this.arrow = 0;
    }

    public Company(String name, String ticker, String shares, String last, double change, String companyPriceChange, float price, String name_or_shares, int arrow, int changeColor) {
        this.name = name;
        this.ticker = ticker;
        this.shares = shares;
        this.last = last;
        this.change = change;
        this.companyPriceChange = companyPriceChange;
        this.price = price;
        this.name_or_shares = name_or_shares;
        this.arrow = arrow;
        this.changeColor = changeColor;
    }

    public Company(String name, String ticker, String shares, String last, String prevClose,
                   String name_or_shares, Context ctx) {
        this.name = name;
        this.ticker = ticker;
        this.shares = shares;
        this.last = last;
        this.change =  Math.round((Double.parseDouble(last) - Double.parseDouble(prevClose)) * 100.0)/100.0;

        this.name_or_shares = name_or_shares;

        if (change > 0) {
            this.arrow = R.drawable.ic_twotone_trending_up_24;
            this.changeColor = ResourcesCompat.getColor(ctx.getResources(), R.color.positive, null);
        }else  if (change < 0){
            this.arrow = R.drawable.ic_baseline_trending_down_24;
            this.changeColor = ResourcesCompat.getColor(ctx.getResources(), R.color.negative, null);
        }else{
            this.arrow = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public String getName_or_shares() {
        return name_or_shares;
    }

    public void setName_or_shares(String name_or_shares) {
        this.name_or_shares = name_or_shares;
    }

    public int getArrow() {
        return arrow;
    }

    public void setArrow(int arrow) {
        this.arrow = arrow;
    }

    public String getCompanyPriceChange() {
        return companyPriceChange;
    }

    public void setCompanyPriceChange(String companyPriceChange) {
        this.companyPriceChange = companyPriceChange;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getChangeColor() {
        return changeColor;
    }

    public void setChangeColor(int changeColor) {
        this.changeColor = changeColor;
    }
}
