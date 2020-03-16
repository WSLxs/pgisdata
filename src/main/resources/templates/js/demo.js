//初始化时间输入框
$('.datetimepicker').datetimepicker({
    language: 'zh-CN',
    format: 'yyyy-mm-dd HH:ii',//显示格式
    todayHighlight: 1,//今天高亮
    minView: "hour",//设置只显示到小时
    startView: 1,
    forceParse: 0,
    showMeridian: 0,
    autoclose: 1,//选择后自动关闭
    initialDate: new Date(),
});

//初始化树变量
var tree = [
    {
        text: "深圳公安局(477/2000)",
        selectable:false,
        nodes: [
            {
                text: "宝安分局(104/504)",
                selectable:false,
                checked:true,
                nodes: [
                    {
                        text: "西乡派出所(10/80)",
                        selectable:false,
                        nodes: [
                            {text: "粤B222222(在线)",},
                            {text: "粤B222222(在线)"},
                            {text: "粤B222222",color:'gray'}
                        ]
                    },
                    {
                        text: "桃源派出所"
                    }
                ]
            },
            {
                text: "南山分局",
                selectable:false,
                nodes: [
                    {
                        text: "南山分局1",
                        selectable:false,
                    },
                    {
                        text: "南山分局 2",
                        selectable:false,
                    }
                ]
            }
        ]
    },
    {
        text: "广州公安局",
        nodes: [
            {
                text: "宝安分局",
                nodes: [
                    {
                        text: "宝安分局一",

                    },
                    {
                        text: "宝安分局 2"
                    }
                ]
            },
            {
                text: "南山分局",
                nodes: [
                    {
                        text: "南山分局1"
                    },
                    {
                        text: "南山分局 2"
                    }
                ]
            }
        ]
    },
    {
        text: "东莞公安局",
        nodes: [
            {
                text: "宝安分局",
                nodes: [
                    {
                        text: "宝安分局一"
                    },
                    {
                        text: "宝安分局 2"
                    }
                ]
            },
            {
                text: "南山分局",
                nodes: [
                    {
                        text: "南山分局1"
                    },
                    {
                        text: "南山分局 2"
                    }
                ]
            }
        ]
    }
];

//初始化树
$('.treeList').treeview({data: tree});
function colorTree() {
    
}


//监控列表内容
var list = [{id: 1, label: '粤B12345'}, {id: 1, label: '粤B12356'}, {id: 1, label: '粤B12665'},
    {id: 1, label: '粤B12345'},{id: 1, label: '粤B12345'},{id: 1, label: '粤B12345'}
    ,{id: 1, label: '粤B12345'},{id: 1, label: '粤B12345'}]

//监控列表构造函数
function createTable() {
    var str = ''
    for (var i = 0; i < list.length; i++) {
        str += '<tr><td>' + list[i].label + '</td><td onclick="deleteList(' + i + ')"><a style="cursor: pointer;">取消监控</a></td></tr>'
    }
    $('.table tbody').html(str)
}

//初始化监控列表
createTable()

//取消监控
function deleteList(index) {
    list.splice(index, 1)
    createTable()
}

//登出账户
$('.layout').click(function () {
    // $('.history').show()
})

//关闭历史轨迹查询框
$('.closeHistory').click(function () {
    $('.history').hide()
})

//初始化搜索下拉框
function createSearchList() {
    $('.searchList ul').html('')
    var str = ''
    for (var i = 0; i < 6; i++) {
        str += '<li onclick="selectSearchList(' + i + ')"><span><i class="glyphicon glyphicon-map-marker"></i>粤B3588警</span>' +
            '<span><p>西乡派出所</p><p>989898</p></span></li>'
    }
    $('.searchList ul').show()
    $('.searchList ul').html(str)
}

//点击搜索下拉框中选项
function selectSearchList(i) {
    $('.searchList ul').hide()
    $('.history').show()
}

//点击搜索框搜索按钮
$('.searchIcon').click(function () {
    if (!$('.form-control').val()) {
        return
    }
    createSearchList()
})

//搜索框监控回车键
$('.form-control').bind('keypress', function (event) {
    if (!$('.form-control').val()) {
        return
    }

    $(".treeList").treeview('updateNode',[$(".treeList").node,tree,{silent:true}]);
    if (event.keyCode == "13") {
        createSearchList()
    }
})

//监控搜索框焦点，显示重置按钮
$('.form-control').focus(function () {
    $('.clearInput').show()
})

//搜索框失去焦点，判断输入框是否有内容，无内容则清除重置按钮
$('.form-control').blur(function () {
    if ($('.form-control').val()) {
        return
    }
    $('.clearInput').hide()
    $('.searchList').hide()
})

//点击重置按钮，清除搜索框和下拉框
$('.clearInput').click(function () {
    $('.form-control').val('')
    $('.clearInput').hide()
    $('.searchList ul').hide()
})


//初始化地图
var map = new MapLite.Map("mapDiv", {
    /* 中心点  */
    center: [114.06, 22.60],
    /* 初始级别  */
    level: 12,
    /* 底图  */
    basemap: "online/baidu/map"
});


