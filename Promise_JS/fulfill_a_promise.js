require ('es6-promise');

var promise = new Promise(function (fulfill, reject) {
  setTimeout(function () {
    fulfill('FULFILLED!');
  }, 300);
}).then(function (onFulfilled) {
  console.log(onFulfilled);
});
