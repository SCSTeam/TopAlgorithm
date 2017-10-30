/**
 * @param {number[]} bits
 * @return {boolean}
 */

/**
 * Time complexity O(n)
 */
var isOneBitCharacter = function(bits) {
    if (!bits) {
        return false;
    }
    
    var last = bits.length - 1;
    if (bits[last] === 1) {
        return false;
    }
    
    var i = 0;
    while (i < bits.length - 1) {
        if (bits[i] === 0) {
            i += 1;
        } else {
            i += 2;
        }
    }
    
    return i === bits.length - 1;
};

(function() {
    const bits1 = [1, 1, 0];
    const bits2 = [1, 1, 1, 0];
})();