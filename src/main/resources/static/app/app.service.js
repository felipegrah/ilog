app.service('IlogService', function($http, $q){
    var defaultUrl = 'api/'
    var usuarioUrl = defaultUrl + 'user';
    var cursoUrl = defaultUrl + 'curso';

    var def = $q.defer();

    var _listarUsuarios = function () {
        
        $http({
            method: 'GET',
            url: usuarioUrl
        }).then(function(e) {
            def.resolve(e.data)
        })
        .catch(function(e) {
            def.reject("Erro ao acessar API");
        });

        return def.promise;
    };


    var _deletarUsuarios = function (e) {
        
        $http({
            method: 'DELETE',
            url: usuarioUrl + '/' + e
        }).then(function(e) {
            def.resolve(e.data)
        })
        .catch(function(e) {
            def.reject("Erro ao acessar API");
        });

        return def.promise;
    };

    var _enviarFormularioUsuario = function(usuario) {
        $http({
            method: 'POST',
            url: usuarioUrl,
            headers: {
                'Content-Type': 'application/json'
            },
            data: usuario

        }).then(function(e) {
            def.resolve(e.data)
        })
        .catch(function(e) {
            def.reject("Erro ao acessar API");
        });
    }


    return {
        listarUsuarios: _listarUsuarios,
        deletarUsuarios: _deletarUsuarios,
        enviarFormularioUsuario: _enviarFormularioUsuario,
    }


});