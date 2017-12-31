var _ = require('underscore');

/**
 * O(n^2) time
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea1 = function(heights) {
  if (_.isNull(heights) || heights.length === 0) {
      return 0;
  }
  
  var max = Number.MIN_SAFE_INTEGER;
  for (let i = 0; i < heights.length; i++) {
      let left = i, right = i;
      while (left > 0) {
          if (heights[left - 1] < heights[i]) {
              break;
          }
          left--;
      }
      while (right < heights.length - 1) {
          if (heights[right + 1] < heights[i]) {
              break;
          }
          right++;
      }
      let area = (right - left + 1) * heights[i];
      max = Math.max(max, area);
  }
  
  return max;
};

// tester
(function() {
  var arr = [2,1,5,6,2,3];
  console.log(largestRectangleArea1(arr));
})();