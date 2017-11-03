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
})();