class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxCount = 0;

        for(String x : sentences){
            int count = 1;

            for(int i=0; i<x.length(); i++){
                if(x.charAt(i) == ' '){
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}