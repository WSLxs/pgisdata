//获取地址栏参数
//url为空时为调用当前url地址
//调用方法为 var params = getPatams();
function getParams(url) {
    var theRequest = new Object();
    if (!url)
        url = location.href;
    if (url.indexOf("?") !== -1)
    {
        var str = url.substr(url.indexOf("?") + 1) + "&";
        var strs = str.split("&");
        for (var i = 0; i < strs.length - 1; i++)
        {
            var key = strs[i].substring(0, strs[i].indexOf("="));
            var val = strs[i].substring(strs[i].indexOf("=") + 1);
            theRequest[key] = val;
        }
    }
    return theRequest;

    /**
     *
     * @param text
     * @param type  primary,success,warning,danger
     */
    function commonNotify(text, type) {
        new PNotify({title: "提示", text: text,type: type, styling: 'fontawesome'});
    }
}