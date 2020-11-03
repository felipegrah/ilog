app.config(function($stateProvider) {
    var states = [
        {
        name: 'curso',
        url: '/curso',
        templateUrl: './templates/curso/index.html'
        }
    ]

    $stateProvider
    .state('usuario', {
        url: '/usuario',
        templateUrl: './templates/usuario/index.html',
        controller: 'UsuarioController'
    })
    .state('usuario.novo', {
        url: '/novo',
        templateUrl: './templates/usuario/novo.html',
        controller: 'UsuarioController'
    })
    .state('usuario.editar', {
        url: '/editar/{id}',
        templateUrl: './templates/usuario/novo.html',
        controller: 'UsuarioController'
    })
    states.forEach(function(state) {
        $stateProvider.state(state);
    });
  });