var courseList = {};
$(function () {
    getCourseReviewList();
});
function getCourseReviewList(){
    $.ajax({
        type: "GET",
        url: "/course/reviewList",
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
            showReviewBox($(this).attr("id"));
        });
    }
}
function showReviewBox(cid) {
    ReviewBox.style.display = "block";
    $("#ReviewBox").children().first().attr("data", cid);
    if (courseList[cid].cover){
        $(".ub-right-span").first().css("background", 'url('+courseList[cid].cover.url+'?v='+new Date().getTime()+')no-repeat center');
        $(".ub-right-span").first().addClass("card-img-have");
    }else{
        $(".ub-right-span").first().css("background", 'url(/favicon.ico)no-repeat center');
        $(".ub-right-span").first().removeClass("card-img-have");
    }
    $("#upTitle").val(courseList[cid].title);
    $("#upDescrip").text(courseList[cid].descrip);
    $("#upAudience").text(courseList[cid].audience);
    ziniu.commons.setDateTimeBox(lectureDate, lectureTime, courseList[cid].gmtLecture)
    $("#addr").val(courseList[cid].addr);
}
function closeBox(node) {
    ReviewBox.style.display = "none";
}
function review(stage) {
    var upId = $("#ReviewBox").children().first().attr("data");
    $.ajax({
        type: "POST",
        url: "/course/review",
        data: {"id":upId,"stage":stage,
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
    ReviewBox.style.display = "none";
}