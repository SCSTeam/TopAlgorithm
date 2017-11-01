var _ = require('underscore');
var PriorityQueue = require('js-priority-queue');

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var smallestDistancePair = function(nums, k) {
  var result = 0;
  if (!nums || k <= 0) {
    return result;
  }
  
  nums.sort();
  var count = 0;
  var n = nums.length;
  var pq = new PriorityQueue({
    comparator: (a, b) => {
      if (a.val === b.val) {
        return 0;
      }
      return a.val < b.val ? 1 : -1;
    }
  });
  pq.queue(new Cell(nums[n - 1] - nums[0], n - 1, 0));

  var visited = new Array(n);
  for (let i = 0; i < n; i++) {
    visited[i] = new Array(n);
  }
  visited[n - 1][0] = true;

  while (pq.length > 0) {
    let cell = pq.dequeue();
    let x = cell.x;
    let y = cell.y;
    
    if (x > 1 && x - 1 > y && !visited[x - 1][y]) {
      pq.queue(new Cell(nums[x - 1] - nums[y], x - 1, y));
    }

    if (y < n - 1 && y + 1 < x && !visited[x][y + 1]) {
      pq.queue(new Cell(nums[x] - nums[y + 1], x, y + 1));
    }

    count++;
    if (count == n - k + 1) {
      result = cell.val;
      break;
    }
  }

  return result;
};

var Cell = function(val, x, y) {
  this.val = val;
  this.x = x;
  this.y = y;
};

(function() {
  var nums = [1, 3, 1];
  var k = 1;
  console.log(smallestDistancePair(nums, k));
})();