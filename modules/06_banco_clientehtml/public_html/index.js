

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
            $resultado.text('Error: ' + $promesa.responseText + '.');
        });
        return false;
    });
}


function recuperarProductoAsync(codigo) {
    var url = "http://10.116.2.201:8084/05_banco_jersey/api/producto/{codigo}?callback=?";
    url = url.replace('{codigo}', codigo);
    var $xhr = $.getJSON(url);
    console.debug('Enviada petición.');
    return $xhr;
}

















