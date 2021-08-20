package main;

import pojo.Pool;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random rd = new Random(100);
        Pool[] pools = new Pool[20];
        int length = pools.length;
        for (int i=0;i<length;i++) {
            Pool pool = new Pool(i, rd.nextInt(100));
            pools[i] = pool;
        }
        int fund = rd.nextInt(1000);
        System.out.println("fund = "+fund);
        pools = AllocationSupplyResult.Result(fund,pools);

        for (int i=0;i<length;i++){
            System.out.println("[fundPoolId = "+pools[i].getFundPoolId()+" Pre = "+pools[i].getPreAllocation()+
                    " all = "+pools[i].getAllocation()+" after = "+pools[i].getAfterAllocation() + "]");
        }
    }
}
