class Q134GasStation {
    public static void main(String[] args) {
        int gas[] = new int[]{5,1,2,3,4};
        int cost[] = new int[]{4,4,1,5,1};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    //笨方法
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i=0;i<n;i++){
            if(gas[i]>=cost[i]){
                int gasLeft = gas[i];
                for(int j=0;gasLeft>=cost[(i+j)%n];j++){
                    gasLeft -= cost[(i+j)%n];
                    if(j==n-1){
                        return i;
                    }
                    gasLeft+=gas[(i+j+1)%n];
                }

            }
        }
        return -1;
    }

    //好方法
    public static int canCompleteCircuitExample(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, start = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            // 如果这一段的油量不够，无法到达下一个加油站，重置起点和油箱
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        // 如果总油量小于总成本，说明无法走完全程
        if (totalGas < totalCost) {
            return -1;
        }
        // 否则，start就是合适的起始加油站
        return start;
    }

}