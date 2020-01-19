param = {};
$(function () {
    $('#selectData').click(function () {
        // yyyy-MM-dd 需要与格式一样 |@DateTimeFormat(pattern = "yyyy-MM-dd")
        //                          |private Date beginDate;

        var beginDate = $('#beginDate').data('datetimepicker').getDate();
        beginDate = beginDate.getFullYear() + '-' + p((beginDate.getMonth() + 1)) + '-' + p(beginDate.getDate());
            // + ' ' + p(beginDate.getHours()) + ':' + p(beginDate.getMinutes()) + ':' + p(beginDate.getSeconds());

        var endDate = $('#endDate').data('datetimepicker').getDate();
        endDate = endDate.getFullYear() + '-' + p((endDate.getMonth() + 1)) + '-' + p(endDate.getDate());
        // + ' ' + endDate.getHours() + ':' + endDate.getMinutes() + ':' + endDate.getSeconds();

        param.beginDate = beginDate;
        param.endDate = endDate;

        $.ajax({
            url: "/selectDate",
            type: "post",
            data: JSON.stringify(param),
            contentType: "application/json",
            success: function (data) {
                showAzkabanJobs(data);
            }, error: function () {
                alert("请求失败，稍后重试！");
            }
        });
    });
});

// 转化0 ~ 9的数
function p(s) {
    return s < 10 ? '0' + s : s ;

}

function showAzkabanJobs(azkabanExecutionJobs) {
    var html = [];
    html.push("<thead><tr><th>#</th><th>execId</th><th>projectId</th><th>version</th><th>flowId</th><th>jobId</th>" +
        "<th>attempt</th><th>status</th><th>开始时间</th><th>结束时间</th><th>运行状态</th></tr></thead>");
    html.push("<tbody>");
    for(var i = 0;i < azkabanExecutionJobs.length;i++){
        html.push("<tr>");
        html.push("<td>" + (i + 1) + "</td>");
        html.push("<td>" + azkabanExecutionJobs[i].execId + "</td>");
        html.push("<td>" + azkabanExecutionJobs[i].projectId + "</td>");
        html.push("<td>" + azkabanExecutionJobs[i].version + "</td>");
        html.push("<td>" + azkabanExecutionJobs[i].flowId + "</td>");
        html.push("<td>" + azkabanExecutionJobs[i].jobId + "</td>");
        html.push("<td>" + azkabanExecutionJobs[i].attempt + "</td>");
        html.push("<td>" + azkabanExecutionJobs[i].status + "</td>");
        html.push("<td>" + formatTime(azkabanExecutionJobs[i].startTime, 'y-M-d H:m:s') + "</td>");
        html.push("<td>" + formatTime(azkabanExecutionJobs[i].endTime, 'y-M-d H:m:s') + "</td>");
        html.push("<td>失败</td>");
        html.push("</tr>");
    };
    html.push("</tbody>");

    azkabanExecutionJob = document.getElementById("data");
    azkabanExecutionJob.innerHTML = html.join("");

}

/**
 * 时间戳转化为年 月 日 时 分 秒
 * number: 传入时间戳
 * format：返回格式，支持自定义，但参数必须与formateArr里保持一致
 */
function formatTime(number,format) {

    var formateArr  = ['y','M','d','H','m','s'];
    var returnArr   = [];

    var date = new Date(number);
    returnArr.push(date.getFullYear());
    returnArr.push(formatNumber(date.getMonth() + 1));
    returnArr.push(formatNumber(date.getDate()));

    returnArr.push(formatNumber(date.getHours()));
    returnArr.push(formatNumber(date.getMinutes()));
    returnArr.push(formatNumber(date.getSeconds()));

    for (var i in returnArr)
    {
        format = format.replace(formateArr[i], returnArr[i]);
    }
    return format;
}

//数据转化
function formatNumber(n) {
    n = n.toString()
    return n[1] ? n : '0' + n
}