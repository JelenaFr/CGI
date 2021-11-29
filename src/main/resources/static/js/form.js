'use strict'

let time = document.getElementById("time");
let inputDentist = document.getElementById('dentistName');
let inputDate = document.getElementById('date');

function refresh() {
  if( inputDate.value!== undefined || inputDate.value !== null) {
    time.hidden = true;
    let $j = jQuery.noConflict();
    $j('#date').val('').datepicker('remove').datepicker();
  }
}

function getdate() {
  let id = inputDentist.options[inputDentist.selectedIndex].value;
  let date = inputDate.value;
  if (!date || !id) {
    return;
  }
  $('#inputTime').empty();
  $.ajax({
    url: "/dentists/" + id + "/" + date,
    success: function (result) {
      $.each(result, function (i, item) {
        time.hidden = false;
        $('#inputTime').append($('<option>', {value: item.id, text: item.period}, '</option>'));
      });
    }
  });
}

$.when($.ready).then(function () {
  $(function () {
    $('#date').datepicker({
      minDate: "+1d",
      beforeShowDay: $.datepicker.noWeekends,
      dateFormat: 'dd-mm-yy',
      firstDay: 1
    });
  });
});



