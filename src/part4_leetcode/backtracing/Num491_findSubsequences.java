package part4_leetcode.backtracing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Num491_findSubsequences {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        backtrack( nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int start) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        Set<Integer> brother = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            // 剪枝
            // 如果上一个加入子集的数比当前准备加入的数大，则接着尝试下一个数看能否找到比上一个数更大的数加入子集
            if (!path.isEmpty() && path.get(path.size() - 1) > nums[i]) {
                continue;
            }
            // 去重：如果父节点下面有2个一样的可能性则跳过后面的重复的子节点选择
            if (brother.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            brother.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
