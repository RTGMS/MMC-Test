package pojo;

public class Pool {
    private int fundPoolId;
    private int preAllocation;
    private int allocation;
    private int afterAllocation;

    public Pool() {
    }

    //初始化,支出数量为0,支出后等于支出前
    public Pool(int fundPoolId, int preAllocation) {
        this.fundPoolId = fundPoolId;
        this.allocation = 0;
        this.preAllocation = preAllocation;
        this.afterAllocation = preAllocation;
    }

    public int getPreAllocation() {
        return preAllocation;
    }

    public int getFundPoolId() {
        return fundPoolId;
    }

    public int getAllocation() {
        return allocation;
    }

    public int getAfterAllocation() {
        return afterAllocation;
    }

    public void setFundPoolId(int fundPoolId) {
        if (fundPoolId < 0){
            throw new IllegalArgumentException("Pool ID can't be minus");
        }
        this.fundPoolId = fundPoolId;
    }

    public void setPreAllocation(int preAllocation) {
        this.preAllocation = preAllocation;
    }

    public void setAllocation(int allocation) {
        if (allocation < 0){
            throw new IllegalArgumentException("allocation can't be minus");
        }
        this.allocation = allocation;
    }

    public void setAfterAllocation(int afterAllocation) {
        this.afterAllocation = afterAllocation;
    }
}
