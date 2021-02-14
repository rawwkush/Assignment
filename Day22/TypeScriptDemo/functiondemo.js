"use strict";
exports.__esModule = true;
var demo;
(function (demo) {
    function hello() {
        return "hello";
    }
    demo.hello = hello;
    console.log(hello());
    var foo = function () {
        return "foo";
    };
    console.log(foo());
})(demo = exports.demo || (exports.demo = {}));
