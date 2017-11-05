<<<<<<< HEAD
var DfsSerializer = require('./DfsSerializer.js');
var TreeNode = require('../common/TreeNode');

(() => {
  console.log("Test DFS Serialize Deserialize");
  var string = "4,2,1,_,_,_,3,_,_";
  var root = DfsSerializer.deserialize(string);

  var newSerial = DfsSerializer.serialize(root);
  if (string === newSerial) {
    console.log("DFS Serializer works ok");
  } else {
    console.error("error");
  }
=======
var BfsSerializer = require('./BfsSerializer.js');
var _ = require('underscore');
var TreeNode = require('../common/TreeNode.js');

(() => {
  var s = "4 2 6 1 3 5 7";
  var root = BfsSerializer.deserialize(s);
  console.log(BfsSerializer.serialize(root));
>>>>>>> c40760b02abcb70c1dbdc7554e5bc4bad4e89909
})();