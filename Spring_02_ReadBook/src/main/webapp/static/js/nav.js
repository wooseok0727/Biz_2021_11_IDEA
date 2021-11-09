$(function () {
    $("li.home").on("click",function () {
        location.href = `${rootPath}/`;
    })
    $("li.write").on("click",function () {
        location.href = `${rootPath}/write`;
    })

    $("li.login").on("click",function () {
        location.href = `${rootPath}/member/login`;
    })
})