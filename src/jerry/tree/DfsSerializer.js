var _ = require('underscore');
var TreeNode = require('../common/TreeNode');

/**
 * @param {TreeNode} root
 * @returns {string} serialized tree in array format
 */
var serialize = (root) => {
  if (_.isNull(root)) {
    return ""
    ;
  }

  var serializedTree = [];
  serializeHelper(root, serializedTree);
  return serializedTree.join(',');
};

var serializeHelper = function(root, result) {
  if (_.isNull(root)) {
    result.push('_');
    return;
  }

  result.push(root.val);
  serializeHelper(root.left, result);
  serializeHelper(root.right, result);
};

/**
 * 
 * @param {Array} input 
 */
var deserialize = (input) => {
  if (_.isEmpty(input)) {
    return null;
  }

  input = input.split(',');
  return deserializeHelper(input, [0]);
};

/**
 * 
 * @param {Array} input 
 * @param {Array} index 
 */
var deserializeHelper = (input, index) => {
  if (index[0] === input.length) {
    return null;
  }

  var val = input[index[0]++];
  if (val === '_') {
    return null;
  }

  var root = new TreeNode(parseInt(val));
  root.left = deserializeHelper(input, index);
  root.right = deserializeHelper(input, index);
  return root;
};

module.exports.serialize = serialize;
module.exports.deserialize = deserialize;