class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length < 60) return majorityElement1(nums);
        Set<Integer> setIds = new HashSet<>();
        while (setIds.size() < 30) {
            setIds.add((int) (Math.random() * nums.length));
        }
        int[] arr = new int[setIds.size()];
        int count = 0;
        for (int i : setIds) arr[count++] = nums[i];
        return majorityElement1(arr);
    }

    private List<Integer> majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) map.put(n, map.get(n) + 1);
            else map.put(n, 1);
        }
        int indicator = nums.length / 3;
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet())
            if (map.get(key) > indicator) list.add(key);
        return list;
    }
}