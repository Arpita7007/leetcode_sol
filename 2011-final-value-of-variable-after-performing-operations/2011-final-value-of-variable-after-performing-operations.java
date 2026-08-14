class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int count = 0;

        for(String ans : operations){
            if(ans.charAt(1) == '+'){
                count++;
            } else {
                count--;
            }
        }
        return count;

        // approach 2
        // int x = 0;

        // for (String op : operations) {
        //     if (op.equals("++X") || op.equals("X++")) {
        //         x += 1;
        //     } else if (op.equals("--X") || op.equals("X--")) {
        //         x -= 1;
        //     }
        // }

        // return x;
    }
}