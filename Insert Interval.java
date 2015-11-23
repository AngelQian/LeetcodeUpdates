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
        List<Interval> result = new ArrayList<>();
        int k=0;
        while(k<intervals.size()){
            Interval cur = intervals.get(k);
            if(cur.end<newInterval.start){
                result.add(cur);
                k++;
            }else
                break;
        }
        //merge start, cur.end>=new.start
        while(k<intervals.size()){
            Interval cur = intervals.get(k);
            if(cur.start>newInterval.end)
                break;
            newInterval.start = Math.min(cur.start, newInterval.start);
            newInterval.end = Math.max(cur.end, newInterval.end);
            k++;
        }
        result.add(newInterval);
        //append rest
        while(k<intervals.size()){
            result.add(intervals.get(k));
            k++;
        }
        return result;
    }
}