/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        //[[1,4],[0,0]]
        List<Interval> result = new ArrayList<>();
        intervals.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start>o2.start)
					return 1;
				else if(o1.start<o2.start)
					return -1;
				else
					return 0;
			}});
			
        for(int i=0; i<intervals.size(); ){
            Interval base=intervals.get(i);
            int j=i+1;
            for(;j<intervals.size(); j++){
                Interval cur = intervals.get(j);
                if(cur.start<=base.end)
                    base.end = Math.max(base.end, cur.end);
                else
                    break;
            }
            result.add(base);
            i=j;
        }
        return result;
    }
    
    private static void insertionSort(int[] arr){
    for(int i=0; i<arr.length; i++){
      int tmp=arr[i], j=i;
      while(j>0 && tmp<arr[j-1]){
        arr[j]=arr[j-1];
        j--;
      }
      arr[j]=tmp;
    }
    
  }
}