package pojo;

public class PoolUtil {

    //根据支出前进行排序
    public static Pool[] sort(Pool[] pools){
        sort(pools,0,pools.length-1);
        return pools;
    }
    private static void sort(Pool[] pools,int lo,int hi){
        if (lo >= hi){
            return;
        }
        int p = partition(pools,lo,hi);
        sort(pools,lo,p-1);
        sort(pools,p+1,hi);
    }
    private static int partition(Pool[] pools,int lo,int hi){
        int pivot = pools[lo].getPreAllocation();
        int i = lo, j = hi + 1;
        while (true){
            while (pools[++i].getPreAllocation() > pivot){
                if (i == hi) break;
            }
            while (pools[--j].getPreAllocation() < pivot){
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(pools,i,j);
        }
        swap(pools,j,lo);
        return j;
    }
    private static void swap(Pool[] pools, int i,int j){
        Pool temp = pools[i];
        pools[i] = pools[j];
        pools[j] = temp;
    }
}
