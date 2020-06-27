// Call the dataTables jQuery plugin
// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').dataTable({
    "oLanguage": {
        "sLengthMenu": "Mostrar _MENU_ registros",
        "sZeroRecords": "No se encontraron registros ",
        "oPaginate": {
            "sNext": "Siguiente",
            "sPrevious": "Anterior"
        },

    },
    "iDisplayLength": 5,
    "aLengthMenu": [
        [5, 10, 25, -1],
        [5, 10, 25, "All"]
    ],


});
});
