var recorder = new Vue({
    el:"#recorder",
    data:{
        recordlist:[],
        page:"",
        examTypes:"",
        starttime:"",
        endtime:"",
        number:"",
        order:"",
        kslxxx:[],
        gradesinfo:[],
        proinfo:[],
        yzbm:"",
        checkxm:"",
        checkksm:"2",
        checksfzh:"",
        checkksnf:"",
        status:"",
        flag:""
    }
});



function submitRequire(obj){
    var pageNo = $(obj).attr("data-page");
    recorder.examTypes= $("#exam  option:selected").attr("data-key");
    recorder.starttime=document.getElementById("logmin").value;
    recorder.endtime=$("#logmax").val();
    recorder.number=document.getElementById("sfzh").value;
    recorder.flag="123";
    $.ajax({
        type: 'POST',
        url: "/recode/record",
        data:{
            kslx:recorder.examTypes,
            starttime:recorder.starttime,
            endtime:recorder.endtime,
            yhsjh:recorder.number,
            pageNo:pageNo,
        },
        success: function(data){
            var json=JSON.parse(data);
            console.log(data);
            recorder.recordlist=json.recordList;
            recorder.page = json.page;
        },
        error:function(data) {
            // console.log("怎么了");
            console.log(data.msg);
        },
    });
}

function article_edit(title,url,obj,id,w,h){
    var tr=obj.parentNode.parentNode;
    recorder.yzbm=$(obj).attr("data-yzbm");
    var thiskslx=$(obj).attr("data-kslx");
    recorder.checkxm=tr.getAttribute("data-xm");
    console.log(recorder.checkxm);
    recorder.checksfzh=tr.getAttribute("data-sfzh");
    recorder.checkksm=tr.getAttribute("data-ksm");
    recorder.ksnf=tr.getAttribute("data-ksnf");
    console.log(recorder.flag);
    $.ajax({
        type: 'POST',
        url: "/ks/watchgrade",
        data:{
            kslx:thiskslx,
            yzbm:recorder.yzbm,
        },
        success: function(data){
            var json=JSON.parse(data);
            if(json.success === "true"){
                recorder.gradesinfo=json.Scores;
                recorder.proinfo=json.Others;
                recorder.status=json.success;
                console.log(recorder.gradesinfo);
                console.log(recorder.proinfo);
                showinfo();
            }else {
                alert(json.result);
            }

        },
        error:function(data) {
            // console.log("怎么了");
            alert("没有数据！");
        },
    });
    // var index = layer.open({
    //     type: 2,
    //     title: title,
    //     content: url,
    // });
    // layer.full(index);
}

//展示查询结果
function showinfo(){
    document.getElementById('resultmodel').style.display='block';   //显示查询成绩结果框
    document.getElementById("cover").style.display = "block"; //遮罩层
}
function closeDialog_2(){
    document.getElementById('resultmodel').style.display='none';
    document.getElementById("cover").style.display = "none";
}