var _ = require('underscore');
var TreeNode = require('../common/TreeNode.js');
var BfsSerializer = require('./BfsSerializer.js');

var test = () => {
  let root = BfsSerializer.deserialize("1 2 3 4 _ _ _ 5 _ 6");
  debugger;
};
test();