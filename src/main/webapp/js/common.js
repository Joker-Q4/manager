var TEACHER_ID = "teacherId";
var STUDENT_ID = "studentId";
var TYPE = "ADD_OR_EDIT";
var TYPE_ADD = "TYPE_ADD";
var TYPE_EDIT = "TYPE_EDIT";
var DATA = "DATA";
var URL_ROOT = "http://localhost/";

function getParamValue(variable)
{
    var query = window.location.search.substring(1);
    console.log(query)
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}