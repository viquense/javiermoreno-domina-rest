

function inicializarControlador() {
    var $accionAceptar = $('form input[type=submit]');
    var $resultado = $('#informacion p');
    
    $accionAceptar.click(function() {
        console.info('Botón pulsado.');
        
        var codigo = $('input[name=codigo]').val();
        var $promesa = recuperarProductoAsync(codigo);
        $promesa.done(function(producto) {
            $resultado.text('El saldo es de ' + producto.saldo + '.');
        });
        $promesa.fail(function($promesa) {
            $resultado.text('Error: ' + $promesa.status + '.');
        });
        return false;
    });
}


function recuperarProductoAsync(codigo) {
    var url = "api/producto/{codigo}";
    url = url.replace('{codigo}', codigo);
    var $xhr = $.getJSON(url);
    console.debug('Enviada petición.');
    return $xhr;
}