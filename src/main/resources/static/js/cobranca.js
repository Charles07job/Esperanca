$('#confirmacaoExclusaoModalCliente').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codigoCliente = button.data('id');
	var nomeCliente = button.data('nome');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + codigoCliente);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o cliente <strong>' + nomeCliente + '</strong>?');
});

$('#confirmacaoExclusaoModalQuestionario').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codigoQuestionario = button.data('id');
		
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + id);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o questionário <strong>' + id + '</strong>?');
});

$(function() {
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true});
	
});