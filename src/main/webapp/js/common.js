var TEACHER_ID = "teacherId";
var STUDENT_ID = "studentId";
var TYPE = "ADD_OR_EDIT";
var TYPE_ADD = "TYPE_ADD";
var TYPE_EDIT = "TYPE_EDIT";
var DATA = "DATA";
var URL_ROOT = "http://localhost/";

function getParamValue(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] === variable) {
            return pair[1];
        }
    }
    return (false);
}

function request(url, requestData) {
    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: url,
        data: {
            json: JSON.stringify(requestData)
        },
        success: function (data) {
            if (data.successful === true) {
                layer.msg(data.msg);
            } else {
                layer.msg(data.msg);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            layer.msg("请求失败");
        }
    });
}

function deleteObject(url) {
    $.ajax({
        type: 'GET',
        url: url,
        success: function (data) {
            layer.msg(data.msg);
            reloadTable();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            layer.msg("请求失败");
        }
    });
}

function deleteObjects(url, arr) {
    $.ajax({
        type: 'POST',
        dataType:'json',
        url: url,
        data: {
            json: JSON.stringify(arr)
        },
        success: function (data) {
            layer.msg(data.msg);
            reloadTable();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            layer.msg("请求失败");
        }
    });
}