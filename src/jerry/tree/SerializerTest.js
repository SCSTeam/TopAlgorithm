var BfsSerializer = require('./BfsSerializer.js');
var _ = require('underscore');
var TreeNode = require('../common/TreeNode.js');

(() => {
  var s = "4 2 6 1 3 5 7";
  var root = BfsSerializer.deserialize(s);
  console.log(BfsSerializer.serialize(root));
})();