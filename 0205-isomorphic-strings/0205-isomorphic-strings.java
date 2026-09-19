class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] mapStoT = new int[256];
        int[] mapTtoS = new int[256];

        for(int i=0;i<256; i++){
            mapStoT[i] = -1;
            mapTtoS[i] = -1;
        }

        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(mapStoT[c1] != -1 && mapStoT[c1] != c2){
                return false;
            }
            if(mapTtoS[c2] != -1 && mapTtoS[c2] != c1){
                return false;
            }
            mapStoT[c1] = c2;
            mapTtoS[c2] = c1;
        }
        return true;
    }
}