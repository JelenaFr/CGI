$(document).ready(function (){
    date = $("#date");
    inputTime = $("#inputTime");

    date.click(function (){
        loadAvailableTimes();
    });
});

function loadAvaialbleTimes() {
    url = "/";
    $.get(url, function (responseJson){
        alert(responseJson);
    }).done(function (){
        alert('Done');
    }).fail(function (){
        alert('Failed')
    });
}