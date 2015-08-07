public class Solution {
    public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> result = new ArrayList<>();
		if (dict.size() < 1)
			return result;

		Queue<String> queue = new ArrayDeque<>();
		queue.add(start);

		HashMap<String, List<String>> hm = new HashMap<>();
		Map<String, Integer> ladder = new HashMap<String, Integer>();
		for (String s : dict)
			ladder.put(s, Integer.MAX_VALUE);
		ladder.put(start, 0);

		dict.add(end);

		int min = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			String word = queue.poll();
			int step = ladder.get(word) + 1;
			if (step > min)
				break;

			for (int i = 0; i < word.length(); i++) {
				StringBuilder sb = new StringBuilder(word);
				for (char c = 'a'; c <= 'z'; c++) {
					sb.setCharAt(i, c);
					String new_word = sb.toString();
					if (ladder.containsKey(new_word)) {
						if (step > ladder.get(new_word))
							continue;
						else if (step < ladder.get(new_word)) {
							queue.add(new_word);
							ladder.put(new_word, step);
						}
						// It is a KEY line. If one word already appeared in one ladder,
						// Do not insert the same word inside the queue twice.

						if (hm.containsKey(new_word)) {
							hm.get(new_word).add(word);
						} else {
							List<String> l = new ArrayList<>();
							l.add(word);
							hm.put(new_word, l);
						}

						if (new_word.equals(end))
							min = step;
					}
				}
			}
		}

		List<String> path = new ArrayList<>();
		backTrace(end, start, hm, path, result);
		return result;
	}

	private void backTrace(String end, String start, HashMap<String, List<String>> hm, List<String> path, List<List<String>> result) {
		if(end.equals(start)){
			path.add(0, start);
			result.add(new ArrayList<>(path));
			path.remove(0);
			return;
		}
		
		path.add(0,end);
		if(hm.get(end)!=null){
			for(String s: hm.get(end))
				backTrace(s, start, hm, path, result);
		}
		path.remove(0);
	}
}