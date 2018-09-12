/**
 * 应用表格的查询条件，并查询
 * @param tableName: 表格元素的ID
 * @param operator:
 eq：       等于
 dateEq：   等于指定日期，时间匹配范围为当天：00时00分00秒-23时59分59秒
 ne：       不等于
 gt：       大于
 lt：       小于
 ge：       大于等于
 le：       小于等于
 dateLe：   小于指定日期，时间匹配最大值为当天：23时59分59秒
 startLike：模糊查询，以指定内容开始
 endLike：  模糊查询，以指定内容结束
 like：     糊糊查询，全匹配方式
 in：       包含，字段值在指定列表内出现
 isNull：   指定字段值为空
 isNotNull：指定字段值不为空
 */
function reloadTableFilters(tableName) {
    $("#" + tableName).bootstrapTable("refresh");

}



/**
 * 清空当前表格的查询条件
 * @param gridName
 */
function clearTableFilters(tableName) {
    $(".table-filter").each(function () {
        if ($(this).attr("type") != "hidden") {
            $(this).val("");
        }
    });
    $("#" + tableName).bootstrapTable("refresh", {pageNumber: 1});

}

/**
 * 加载缺省的过滤条件
 * @param params
 * @returns {*}
 */
function appendDefaultFilters(params) {
    var filters = [];
    var orFilters = [];
    //应用过滤器
    $("input[type=hidden].table-filter").each(function (index) {
        var filterField = $(this).data("filter");
        var filterValue = $.trim($(this).val());
        if (filterValue != "0" && filterValue != "") {
            var logic = $(this).data("logic");
            var filter = {
                field: filterField,
                operator: $(this).data("operator"),
                value: filterValue
            };
            if (logic == "or") {
                orFilters.push(filter);
            } else {
                filters.push(filter);
            }
        }
    });
    params.filters = filters;
    params.orFilters = orFilters;
    return params;
}