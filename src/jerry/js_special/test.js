num = 9;

var printer = {
  num: 81,
  print: function() {
    console.log(this.num);
  }
};

console.log("print 81");
printer.print();

console.log("print 9");
var print2 = printer.print.bind(printer);
print2();