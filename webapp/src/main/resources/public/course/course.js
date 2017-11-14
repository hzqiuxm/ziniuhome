var courseList = {};
$(function () {
    getCourseList();
});
function showPubBox() {
    pubBox.style.display = "block";
}
function publish() {
    $.ajax({
        type: "POST",
        url: "/course/publish",
        data: {"title":title.value,"descrip":descrip.value,"audience":audience.value},
        success: function (result) {
            if (!result.success){
                alert(result.msg);
            }
            window.location.reload();
        },
        dataType: "json"
    });
    pubBox.style.display = "none";
}
function getCourseList(){
    $.ajax({
        type: "GET",
        url: "/course/getList",
        success: function (result) {
            if (!result.success){
                alert(result.msg);
            }else{
                showCards(result.data);
            }
        },
        dataType: "json"
    });
}
function showCards(courses) {
    for(var id in courses){
        courseList[id] = courses[id];
        var cardNode = $("#card").clone();
        $(cardNode).attr("id", id);
        $(cardNode).addClass("card");
        $(cardNode).children().first().html(setStage(id));
        $(cardNode).find("div").first().attr("data", id);
        $(cardNode).find("p[name=lecturerName]").first().html(courses[id].lecturerName);
        $(cardNode).find("p[name=title]").first().html(courses[id].title);
        if (courses[id].cover){
            $(cardNode).css("background", 'url('+courses[id].cover.url+'?v='+new Date().getTime()+')no-repeat center');
            $(cardNode).addClass("card-img-have");
        }else{
            $(cardNode).css("background", 'url(/favicon.ico)no-repeat center');
        }
        $(cardNode).css("display", "block");
        var liNode = document.createElement("li");
        $("#list").append(liNode);
        $(liNode).append(cardNode);
        $(cardNode).click(function () {
            showUpdateBox($(this).attr("id"));
        });
    }
}
function showUpdateBox(cid) {
    updateBox.style.display = "block";
    $("#updateBox").children().first().attr("data", cid);
    if (courseList[cid].cover){
        $(".ub-right-span").first().css("background", 'url('+courseList[cid].cover.url+'?v='+new Date().getTime()+')no-repeat center');
        $(".ub-right-span").first().addClass("card-img-have");
    }else{
        $(".ub-right-span").first().css("background", 'url(/favicon.ico)no-repeat center');
        $(".ub-right-span").first().removeClass("card-img-have");
    }
    $("#upTitle").val(courseList[cid].title);
    $("#upDescrip").val(courseList[cid].descrip);
    $("#upAudience").val(courseList[cid].audience);
    ziniu.commons.setDateTimeBox(lectureDate, lectureTime, courseList[cid].gmtLecture)
    $("#addr").val(courseList[cid].addr);
}
function closeBox(node) {
    pubBox.style.display = "none";
    updateBox.style.display = "none";
}
function updateCourse() {
    var upId = $("#updateBox").children().first().attr("data");
    uploadImg(upId, $("#upTitle").val());
    //如果信息没有修改就不用更新了
    if($("#upTitle").val() == courseList[upId].title
        && $("#upDescrip").val() == courseList[upId].descrip
        && $("#upAudience").val() == courseList[upId].audience
        && ziniu.commons.dateTimeHandle(lectureDate.value, lectureTime.value) == courseList[upId].gmtLecture){
        console.log("没有修改任何信息");
        window.location.reload();
        return;
    }
    $.ajax({
        type: "POST",
        url: "/course/update",
        data: {"id":upId,"title":$("#upTitle").val(),
            "descrip":$("#upDescrip").val(),"audience":$("#upAudience").val(),
            "gmtLecture":ziniu.commons.dateTimeHandle(lectureDate.value, lectureTime.value),"addr":addr.value},
        async: false,
        success: function (result) {
            if (!result.success){
                alert(result.msg);
            }
            window.location.reload();
        },
        dataType: "json"
    });
    updateBox.style.display = "none";
}
function setStage(id) {
    switch (courseList[id].stage){
        case 0: return "发布中";
        case 1: return "审核中";
        case 2: return "已滞留";
        case 3:
            var html = ziniu.commons.dateFmt("yyyy-MM-dd hh:mm", new Date(courseList[id].gmtLecture));
            //if (courseList[id].lecturere)//等拿到用户登录名才行
            return ziniu.commons.dateFmt("yyyy-MM-dd hh:mm", new Date(courseList[id].gmtLecture))
                + "<input type=\"button\" onclick=\"signup('"+id+"')\" value=\"报名\">";
        case 4: return "已闭课";
        case 5: return "进行中";
        case 6: return "已完成";
        default: return "已闭课";
    }
}
var upImage = "";
function onloadImg(file) {
    if(!file.files || !file.files[0]){
        return;
    }
    console.log("大小：" + file.files[0].size);
    if(file.files[0].size > 262144){
        alert("文件最大不能超过256KB。");
        return;
    }
    var reader = new FileReader();
    reader.readAsDataURL(file.files[0]);
    reader.onload = function(evt){
        $(".ub-right-span").first().css("background", 'url('+evt.target.result+')no-repeat center');
        //document.getElementById('coverImg').src = evt.target.result;
        upImage = evt.target.result;
    };
};
function uploadImg(id, title) {
    if(!upImage || "" == upImage){
        return;
    }
    $.ajax({
        type: "POST",
        url: "/course/uploadCover",
        data: {"id": id,"title": title,"image": upImage},
        async: false,
        success: function (result) {
            if(!result.success){
                alert(result.msg);
            }
        },
        dataType: "json"
    });
};
function signup(id) {
    console.log(id);
    $.ajax({
        type: "POST",
        url: "/course/signup",
        data: {"id": id},
        async: false,
        success: function (result) {
            if(!result.success){
                alert(result.msg);
            }
        },
        dataType: "json"
    });
};