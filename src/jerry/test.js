var Test = function() {
  var self = this;
  var val = "";
  var timeout = 0;

  this.sleep = function(timeout) {
    setTimeout(function() {
      
    }, timeout);

    return self;
  };

  this.print = function(string) {
    self.val = string;
    console.log(self.val);

    return self;
  };
};


(function() {

})();