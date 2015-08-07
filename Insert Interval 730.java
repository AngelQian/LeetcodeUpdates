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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.isEmpty()){
			intervals.add(newInterval);
			return intervals;
		}
		
		int left = newInterval.start;
		int right = newInterval.end;
		ListIterator<Interval> iterator = intervals.listIterator();
		while(iterator.hasNext()){
			Interval cur = iterator.next();
			if(left<=cur.end){
				if(right<cur.start){
				    iterator.remove();
					iterator.add(new Interval(left, right));
					iterator.add(cur);
					return intervals;
				}
				left = Math.min(cur.start, left);
				right = Math.max(cur.end, right);
				iterator.remove();
			}
		}
	    intervals.add(new Interval(left, right));
		
		return intervals;
    }
}