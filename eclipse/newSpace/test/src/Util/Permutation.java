package Util;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public List<List<Integer>> permute(int[] nums) {
		List<Integer> current = new ArrayList<Integer>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			current.add(null);
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(nums, 0, current, result);
		return result;
	}

	void helper(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
		if (index == nums.length) {
			result.add(new ArrayList<Integer>(current));
			return;
		}

		// set element at current index at each free position and recur
		for (int cur_i = 0; cur_i < nums.length; cur_i++) {
			if (current.get(cur_i) == null) {
				current.set(cur_i, nums[index]);
				helper(nums, index + 1, current, result);
				current.set(cur_i, null);
			}

		}
	}

	public static void main(String args[]) {

		Permutation s = new Permutation();
		List<List<Integer>> result = s.permute(new int[] { 1, 2, 3 });

		for (List<Integer> l : result) {
			for (Integer e : l)
				System.out.print(e + " ");
			System.out.println();
		}

	}

}
