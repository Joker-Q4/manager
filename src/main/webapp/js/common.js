var TEACHER_ID = "teacherId";
var STUDENT_ID = "studentId";
var TYPE = "ADD_OR_EDIT";
var TYPE_ADD = "TYPE_ADD";
var TYPE_EDIT = "TYPE_EDIT";
var TYPE_LOOK = "TYPE_LOOK";
var DATA = "DATA";
var TYPE_ST = "STUDENT_OR_TEACHER";
var TYPE_S = "TYPE_STUDENT";
var TYPE_T = "TYPE_TEACHER";
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

UrlParm = function() { // url参数
    var data, index;
    (function init() {
        data = [];
        index = {};
        var u = window.location.search.substr(1);
        if(u !== '') {
            var parms = decodeURIComponent(u).split('&');
            for(var i = 0, len = parms.length; i < len; i++) {
                if(parms[i] !== '') {
                    var p = parms[i].split("=");
                    if(p.length === 1 || (p.length === 2 && p[1] === '')) { // p | p=
                        data.push(['']);
                        index[p[0]] = data.length - 1;
                    } else if(typeof(p[0]) == 'undefined' || p[0] === '') { // =c | =
                        data[0] = [p[1]];
                    } else if(typeof(index[p[0]]) == 'undefined') { // c=aaa
                        data.push([p[1]]);
                        index[p[0]] = data.length - 1;
                    } else { // c=aaa
                        data[index[p[0]]].push(p[1]);
                    }
                }
            }
        }
    })();
    return {
        // 获得参数,类似request.getParameter()
        parm: function(o) { // o: 参数名或者参数次序
            try {
                return(typeof(o) == 'number' ? data[o][0] : data[index[o]][0]);
            } catch(e) {}
        },
        //获得参数组, 类似request.getParameterValues()
        parmValues: function(o) { //  o: 参数名或者参数次序
            try {
                return(typeof(o) == 'number' ? data[o] : data[index[o]]);
            } catch(e) {}
        },
        //是否含有parmName参数
        hasParm: function(parmName) {
            return typeof(parmName) == 'string' ? typeof(index[parmName]) != 'undefined' : false;
        },
        // 获得参数Map ,类似request.getParameterMap()
        parmMap: function() {
            var map = {};
            try {
                for(var p in index) {
                    if(index.hasOwnProperty(p))
                        map[p] = data[index[p]];
                }
            } catch(e) {}
            return map;
        }
    }
}();