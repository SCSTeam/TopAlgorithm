var _ = require('underscore');
var ListNode = require('../common/ListNode.js');

(() => {
  const head = new ListNode(0);
  let cur = head;
  
  for (let i = 1; i <= 5; i++) {
    cur.next = new ListNode(i);
    cur = cur.next;
  }

  cur = head;
  while (!_.isNull(cur)) {
    console.log(cur.val);
    console.log('|');
    cur = cur.next;
  }
})();