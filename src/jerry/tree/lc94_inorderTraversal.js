var _ = require('underscore');
var TreeNode = require('../common/TreeNode.js');

var inorder = function(root) {
  if (_.isNull(root)) {
      return [];
  }

  var stack = [];
  var result = [];
  while (_.isNull(root) || stack.length > 0) {
      if (!_.isNull(root)) {
          stack.push(root);
          root = root.left;
      } else {
          root = stack.pop();
          result.push(root.val);
          root = root.right;
      }
      count++;
  }

  return result;
};