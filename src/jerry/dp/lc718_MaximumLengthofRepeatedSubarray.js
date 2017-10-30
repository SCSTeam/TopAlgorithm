/**
 * @param {number[]} A
 * @param {number[]} B
 * @return {number}
 */
var findLength = function(A, B) {
  if (!A || !B || A.length === 0 || B.length === 0) {
      return 0;
  }
  
  var m = A.length, n = B.length;
  var M = new Array(m);
  var max = 0;
  for (let i = 0; i < n; i++) {
      M[i] = new Array(n);
  }
  
  for (let i = 0; i < m; i++) {
      M[i][0] = (A[i] === B[0]) ? 1 : 0;
      max = Math.max(max, M[i][0]);
  }
  
  for (let j = 0; j < n; j++) {
      M[0][j] = (A[0] === B[j]) ? 1 : 0;
      max = Math.max(max, M[0][j]);
  }
  
  for (let i = 1; i < m; i++) {
      for (let j = 1; j < n; j++) {
          if (A[i] === B[j]) {
              M[i][j] = M[i - 1][j - 1] + 1;
          } else {
              M[i][j] = 0;
          }
          
          max = Math.max(max, M[i][j]);
      }
  }
  
  return max;
};