'use strict'
let context = document.getElementById('context')
function removeRegistration(url, element) {
  $.ajax({
    url: url,
    type: "PATCH",
    success: function (response) {
      $(element).closest('tr').hide();
    }
  });
}

function editRegistration(url) {
  $.ajax({
    url: url,
    type: "PATCH",
    success: function (response) {
      window.location.href = "/";
    }
  });
}

function getAllRegistrations() {
  $("#context").innerHTML = "";
  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/results/all',
    data: JSON
  }).done(function (response) {

    let x = 1;
    response.forEach(item => context.innerHTML += `
     <tr id="element">
            <td>${x++}</td>
            <td>${item["dentist"]["name"]}</td>
            <td>${item["dateAsString"]}</td>
            <td>${item["period"]}</td>
            <td>
            <button type="submit" class="btn btn-info btn-sm ml-3 mr-1"  onclick="editRegistration('http://localhost:8080/results/edit/' + ${item["id"]}, this ) "><i class="fa fa-edit"></i></button>
            <button  id="delButton" type="button" class="btn btn-danger btn-sm"  onclick="removeRegistration('http://localhost:8080/results/edit/' + ${item["id"]}, this )"><i class="fa fa-trash" ></i></button>
            </td>
    </tr>
    `)
  });
}

$.when($.ready).then(function () {
  getAllRegistrations();
})
