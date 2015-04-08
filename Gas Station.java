public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
		int station_left = 0;
		int total_left = 0;
		
		for (int i = 0; i < gas.length; i++) {
			station_left += gas[i] - cost[i];
			if (station_left < 0) {
				start = i + 1;
				total_left += station_left;
				station_left = 0;
			}
		}

		return total_left + station_left < 0 ? -1 : start;
    }
}