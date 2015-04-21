public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<String> wordQueue = new LinkedList<>();
		int level = 1;
		int cur_index = 1, next_index = 0;
		wordQueue.add(beginWord);
		while (!wordQueue.isEmpty()) {
			String curWord = wordQueue.poll();
			cur_index--;
			for (int i = 0; i < curWord.length(); i++) {
				char[] wordUnits = curWord.toCharArray();
				for(char j='a'; j<='z'; j++){
					wordUnits[i]=j;
					String tempWord = new String(wordUnits);
					if(tempWord.equals(endWord))
						return level+1;
					if(wordDict.contains(tempWord)){
						wordQueue.add(tempWord);
						next_index++;
						wordDict.remove(tempWord);
					}
				}
			}
			
			if(cur_index == 0){
				cur_index=next_index;
				next_index=0;
				level++;
			}
		}
		return 0;
    }
}