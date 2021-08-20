package main;

import pojo.Pool;
import pojo.PoolUtil;


public class AllocationSupplyResult {
    public static Pool[] Result(int fund,Pool[] pools){
        if (fund == 0){
            return pools;
        }

        pools = PoolUtil.sort(pools);
        int length = pools.length;
        int index = 1;
        int width = 1;
        int height = pools[0].getPreAllocation();

        while (fund > 0){
            if (index < length){
                while (index<length &&
                        pools[index].getPreAllocation() == pools[index-1].getPreAllocation()){
                    index++;
                }
                int temp = height - pools[index].getPreAllocation();
                fund = fund - (index*temp);
                height = pools[index].getPreAllocation();
            }else {
                height--;
                fund = fund-length;
            }
            index++;
        }
        index = (index < length)? index:length;
        for (int i=0;i<index;i++){
            int preAllocation = pools[i] .getPreAllocation();
            pools[i].setAfterAllocation(height);
            pools[i].setAllocation(preAllocation - height);
        }
        return pools;
    }
}
