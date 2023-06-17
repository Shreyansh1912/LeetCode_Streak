// TOP-DOWN APPROACH
class Solution { 
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        
        int answer = dfs(0, -1, arr1, arr2);
        
        return answer < 2_001 ? answer : -1;
    }
    
    Map<Pair<Integer, Integer>, Integer> dp = new HashMap<>();
    private int dfs(int i, int prev, int[] arr1, int[] arr2) {
        if (i == arr1.length) {
            return 0;
        }
        if (dp.containsKey(new Pair<>(i, prev))) {
            return dp.get(new Pair<>(i, prev));
        }

        int cost = 2_001;

        // If arr1[i] is already greater than prev, we can leave it be.
        if (arr1[i] > prev) {
            cost = dfs(i + 1, arr1[i], arr1, arr2);
        }

        // Find a replacement with the smallest value in arr2.
        int idx = bisectRight(arr2, prev);

        // Replace arr1[i], with a cost of 1 operation.
        if (idx < arr2.length) {
            cost = Math.min(cost, 1 + dfs(i + 1, arr2[idx], arr1, arr2));
        }

        dp.put(new Pair<>(i, prev), cost);
        return cost;
    }
    
    private static int bisectRight(int[] arr, int value) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    } 
}
 // BOTTOM-UP APPROACH
class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Map<Integer, Integer> dp = new HashMap<>();
        Arrays.sort(arr2);
        int n = arr2.length;
        dp.put(-1, 0);

        for (int i = 0; i < arr1.length; i++) {
            Map<Integer, Integer> newDp = new HashMap<>();
            for (int prev : dp.keySet()) {
                if (arr1[i] > prev) {
                    newDp.put(arr1[i], Math.min(newDp.getOrDefault(arr1[i], Integer.MAX_VALUE), dp.get(prev)));
                }
                int idx = bisectRight(arr2, prev);
                if (idx < n) {
                    newDp.put(arr2[idx], Math.min(newDp.getOrDefault(arr2[idx], Integer.MAX_VALUE), 1 + dp.get(prev)));
                }
            }
            dp = newDp;
        }
        
        int answer = Integer.MAX_VALUE;
        for (int value : dp.values()) {
            answer = Math.min(answer, value);
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    private static int bisectRight(int[] arr, int value) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
