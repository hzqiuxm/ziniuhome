//初始化下拉框
$(function () {
    initSelect($(".age"),55,16,false,null);

    var ranks = new Array("青铜","白银","黄金","白金","钻石","王者");
    initSelect($(".rank"),5,0,true,ranks);

    var sexs = new Array("男","女");
    initSelect($(".sex"),1,0,true,sexs);
});
//初始化下拉框：selcalss：那个class需要添加下拉框  num ：添加到哪里  start 从哪里开始  flag，是否 使用特定数据展示下拉框，arrs 特定数据的数组
function initSelect(selClass,num,start,flag,arrs) {
    var str="";
    if(flag){
        for(var i=start;i<=num;i++){
            str+="<option>"+arrs[i]+"</option>";
        }
    }else{
        for(var i=start;i<=num;i++){
            str+="<option>"+i+"</option>";
        }
    }
    $(selClass).append(str);
}
//添加用户信息
function addUser() {
    var user=userMessage();
    if(user==0) return;
    $.ajax({
        type: 'POST',
        url:  '/register',
        cache : false,
        dataType: 'json',
        data:{"userInfo":user+""},
        async:false,
        timeout:3000,
        success:function(data){
            if(data.code.toString()==200){
                alert("用户注册成功！！")
                document.location = "/login/view"
            }else{
                alert("用户信息导入异常！")
            }

        },
        error:function(){
            alert("error!!!!");
        }
    });
}
//注册用户填写信息的简单删选
function userMessage() {
    var userJson="{";
    var str;
    var flag=0;

    str=$(".showName").val();
    userJson+="\"showName\":\"";
    userJson+=str;
    flag+=infoMatch(str,$(".showNameInfo"));

    str=$(".loginName").val();
    userJson+="\",\"loginName\":\"";
    userJson+=str;
    flag+=infoMatch(str,$(".loginNameInfo"));

    str=$(".cellNumber").val();
    userJson+="\",\"cellNumber\":\"";
    userJson+=str;
    flag+=infoMatch(str,$(".cellNumberInfo"));

    str=$(".password").val();
    userJson+="\",\"password\":\"";
    userJson+=str;
    flag+=infoMatch(str,$(".passwordInfo"));

    if(flag!=0){
        return 0;   //这里是一个分界点要是不满足上面的情况就返回0（其实这里的逻辑还是有点转折的，要有耐心才能看完，比较低等级的代码！）
    }
    str=$(".age").val();
    userJson+="\",\"age\":\"";
    userJson+=str;
    str=$(".sex").val();
    userJson+="\",\"sex\":\"";
    userJson+=str;
    str=$(".rank").val();
    userJson+="\",\"rank\":\"";
    userJson+=str;
    userJson+="\"}";

    return userJson;
}
function infoMatch(str,userClass) {
    if(str==null||str==""){
        $(userClass).text("*");
        $(userClass).css('color','red');
        return 1; //1表示注册信息错误
    }
    $(userClass).text("ok");
    $(userClass).css('color','green');
    return 0;
}
function clearPoint() {
    $(".showNameInfo").text("");
    $(".cellNumberInfo").text("");
    $(".loginNameInfo").text("");
    $(".passwordInfo").text("");
}
