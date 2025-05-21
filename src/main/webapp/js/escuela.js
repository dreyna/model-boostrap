$(document).ready(function(){
	listar();
});

$("#save").click(function() {
	let nombre = $("#escNuevo").val();
	$.post("escuela", { "nombre": nombre, "opc": 3 }, function() {
		listar();
	});
	limpiar();
	cerrarNuevo();

});
$("#edit").click(function() {
	let cat = $("#escEdit").val();
	let id = $("#idEdit").val();
	$.post("escuela", { "id": id, "nombre": cat, "opc": 4 }, function() {
		listar();
	});
	cerrarEdit();

});
function editar(id) {
	$.get("escuela", { "id": id, "opc": 2 }, function(data) {
		var x = JSON.parse(data);
		$("#escEdit").val(x.nombre);
		$("#idEdit").val(x.idescuela);
	});
	mostrarEdit();
}
function listar() {
	$.get("escuela", { "opc": 1 }, function(data) {
		var x = JSON.parse(data);
		$("#tablita tbody tr").remove();
		x.forEach(function(item) {
			$("#tablita").append("<tr><td>" + item.nombre + "</td><td><a href='#' onclick='editar(" + item.idescuela + ")' class='btn btn-warning'><i class='far fa-edit'></i></a></td><td><a href='#' onclick='eliminar(" + item.idescuela + ")' class='btn btn-danger'><i class='fas fa-trash-alt'></i></a></td></tr>"
			);
		});
	});
}
function eliminar(id) {
	$.get("escuela", { "id": id, "opc": 5 }, function() {
		listar();
	});
}
function limpiar() {
	$("#catNuevo").val("");
}
function cerrarNuevo() {
	const modalInstance = bootstrap.Modal.getInstance(document.getElementById('cadModalNuevo'));
	if (modalInstance) {
		modalInstance.hide();
	}
}
function cerrarEdit() {
	const modalInstance = bootstrap.Modal.getInstance(document.getElementById('cadModalEdit'));
	if (modalInstance) {
		modalInstance.hide();
	}
}
function mostrarEdit() {
	const modal = new bootstrap.Modal(document.getElementById('cadModalEdit'));
	modal.show();

}