/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
  if (nums === null || k <= 0) {
      return 0;
  }
  
  let start = 0, end = nums.length - 1;
  let remain = k;
  while (remain > 0) {
      let pivot = partition(nums, start, end);
      let length = end - pivot + 1;
      if (length === remain) {
          return nums[pivot];
      } else if (length > remain) {
          start = pivot + 1;
      } else {
          remain = remain - length;
          end = pivot - 1;
      }
  }
  
  return 0;
};

var partition = (arr, start, end) => {
  if (start > end) {
      return -1;
  }
  
  if (start === end) {
      return start;
  }
  
  let i = start, j = end - 1, pivot = end;
  while (i <= j) {
      if (arr[i] < arr[pivot]) {
          i++;
      } else {
          swap(arr, i, j);
          j--;
      }
  }
  swap(arr, i, pivot);
  return i;
};

var swap = (arr, i, j) => {
  let temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
};

(() => {
  let kth = findKthLargest([1,2], 1);
  debugger;
})();