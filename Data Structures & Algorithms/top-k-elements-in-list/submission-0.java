class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            int currentCount = map.getOrDefault(num, 0);
            map.put(num, currentCount + 1);
        }

        List<List<Integer>> bucket = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            bucket.add(new ArrayList<>());
        }

        for(var entry: map.entrySet()) {
            int val = entry.getValue() - 1;
            int key = entry.getKey();
            if(bucket.get(val) == null) {
                bucket.add(val, new ArrayList<>());
            } 
            bucket.get(val).add(key);
        }

        int[] ans = new int[k];
        int ansIndex = 0;
        for(int i = len - 1; i >= 0; i--) {
            if(ansIndex == k) break;
            if(bucket.get(i) != null) {
                for(Integer val: bucket.get(i)) {
                    if(ansIndex == k) break;
                    ans[ansIndex] = val;
                    ansIndex++;
                }
            }
        }
        return ans;
    }
}
