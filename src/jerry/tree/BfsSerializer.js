var _ = require('underscore');
var TreeNode = require('../common/TreeNode');

/**
 * 
 * @param {TreeNode} root
 * @return {Array} 
 */
var serialize = (root) => {
  var result = [];
  if (_.isNull(root)) {
    return result;
  }

  var height = getHeight(root);
  var level = 1;
  var q = [];
  q.push(root);
  
  while (!_.isEmpty(q)) {
    let size = q.length;
    for (let i = 0; i < size; i++) {
      let cur = q.shift();
      result.push(_.isNull(cur) ? '_' : cur.val);

      if (level !== height && !_.isNull(cur)) {
        q.push(cur.left);
        q.push(cur.right);
      }
    }
    level++;
  }

  return result.join(' ');
};

/**
 * 
 * @param {String} input 
 */
var deserialize = (input) => {
  if (_.isEmpty(input) || input[0] === '_') {
    return null;
  }

  input = input.split(' ');
  var q = [];
  const root = new TreeNode(+input[0]);
  q.push(root);
  for (let i = 1; i < input.length;) {
    let size = q.length;
    for (let j = 0; j < size; j++) {
      let cur = q.shift();
      if (cur === '_') continue;

      let left = new TreeNode(+input[i++]);
      let right = i < input.length ? new TreeNode(+input[i++]) : null;
      cur.left = left;
      cur.right = right;
      q.push(left);
      q.push(right);
    }
  }

  return root;
};

var getHeight = (root) => {
  if (_.isNull(root)) {
    return 0;
  }

  return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
};

module.exports.serialize = serialize;
module.exports.deserialize = deserialize;