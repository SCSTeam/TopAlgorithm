var _ = require('underscore');
var TreeNode = require('../common/TreeNode');

/**
 * @param {TreeNode} root
 * @returns {Array} serialized tree in array format
 */
var serialize = (root) => {
  var serializedTree = [];
  if (_.isNull(root)) {
    return serializedTree;
  }

  serializeHelper(root, serializedTree);
  return serializedTree;
};

var serializeHelper = function(root, result) {
  if (_.isNull(root)) {
    result.push(root);
    return;
  }

  if (_.isNull(root.left) && _.isNull(root.right)) {
    result.push(root.val);
    return;
  }

  result.push(root.val);
  serializeHelper(root.left);
  serializeHelper(root.right);
};

/**
 * 
 * @param {Array} input 
 */
var deserialize = (input) => {
  if (_.isEmpty(input)) {
    return null;
  }

  var val = input.unshift();
  var root = new TreeNode(val);
  root.left = deserialize(input);
  root.right = deserialize(input);
  return root;
};

module.exports.serialize = serialize;
module.exports.deserialize = deserialize;