$(function () {
    $("li.home").on("click",function () {
        location.href = `${rootPath}`;
    })
    $("li.write").on("click",function () {
        location.href = `${rootPath}insert`;
    })

    $("li.login").on("click",function () {
        location.href = `${rootPath}member/login`;
    })
    $("li.join").on("click",function () {
        location.href = `${rootPath}member/join`;
    })
})