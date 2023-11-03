package com.design.appleyk.DMA8_代理模式.DM8.VP虚拟代理;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description //TODO
 * @Date 2023/11/3 9:19
 * @Author hy
 **/
public class Secretary implements Signable {

    List<String> deals;
    private Leader leader;

    public Secretary() {
        this.deals = new ArrayList<>();
    }

    @Override
    public void sign() {
        if (leader == null) {
            System.out.println("lingdaobuzai");
        } else {
            this.leader.addDeals(deals);
            this.leader.sign();
        }
    }

    public void addDeal(String deal) {
        if (leader == null) {
            this.deals.add(deal);
            System.out.println("mishulanshou：" + deal);
        } else {
            this.leader.addDel(deal);
            System.out.println("lingdaolanshou：" + deal);
        }
    }

    static class LeaderFactory {
        public static Leader getLeader() {
            return new Leader();
        }
    }

    public void initLeader(int second) {
        int n = 0;
        do {
            System.out.println("等待领导出现："+(++n)+"秒");
        } while (--second > 0);
        this.leader = LeaderFactory.getLeader();

    }
}
