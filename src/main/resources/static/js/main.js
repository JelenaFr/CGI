'use strict'

let time = document.getElementById("time");
let inputDentist = document.getElementById('dentistName');
let inputDate = document.getElementById('date');


function getdate() {
  let id = inputDentist.options[inputDentist.selectedIndex].value;
  let date = inputDate.value;
  if (!date) {
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
