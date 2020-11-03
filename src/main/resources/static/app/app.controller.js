app.controller('UsuarioController', function($scope, IlogService){
    $scope.usuarios = [];
    $scope.usuario = {};
    $scope.getUsuarios = function () {
        IlogService.listarUsuarios().then(function(response) {
            console.log(response)
            $scope.usuarios = response;
        },
        function(data) {
            usuarios = [];
        });
    };

    $scope.enviarFormulario = function() {
        var usuario = $scope.usuario;
        IlogService.enviarFormularioUsuario(usuario);
    }

    $scope.deletarUsuario = function(idUsuario) {
        IlogService.deletarUsuarios(idUsuario).then(function(response) {
            $scope.usuarios = $scope.usuarios.filter(function(value) {
                return value.id !== idUsuario;
            });
        }, function(e) {
            console.log(e)
        })
    }

    
    $scope.getUsuarios()
    console.log($scope.usuarios);


    
})