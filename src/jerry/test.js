var PQ = require('js-priority-queue');

(() => {
  var q = new PQ({
    comparator: (a, b) => {
        return b.val - a.val;
    }
  });

  q.queue(new Cell(2));
  q.queue(new Cell(1));
  q.queue(new Cell(3));

  console.log(q.peek().val);
})();

function Cell(v) {
  this.val = v;
}