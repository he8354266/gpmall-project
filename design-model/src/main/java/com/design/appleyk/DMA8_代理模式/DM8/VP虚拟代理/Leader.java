package com.design.appleyk.DMA8_代理模式.DM8.VP虚拟代理;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description //TODO
 * @Date 2023/11/3 9:26
 * @Author hy
 **/
public class Leader implements Signable {
    {
        System.out.println("come back");
    }

    private List<String> deals;

    public List<String> getDeals() {
        return deals;
    }

    public Leader() {
        this.deals = new ArrayList<>();
    }

    public void setDeals(List<String> deals) {
        this.deals = deals;
    }

    public void addDel(String deal) {
        this.deals.add(deal);
    }

    public void addDeals(List<String> deals) {
        this.deals.addAll(deals);
    }

    @Override
    public void sign() {
        Collections.sort(deals);
        for (String deal : deals) {
            System.out.println(deal);
        }
    }
}
