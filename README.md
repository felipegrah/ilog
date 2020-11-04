# ilog

O aplicativo tem como o objetivo cadastrar usuário e curso para um melhor gerenciamento.

## API

### Usuario

JSON

    {
        "nome": "João",
        "telefone": "99999999",
        "dataAdmissao": "2002-01-03",
        "login": "admin",
        "senha": "root"
    }

    Cadastrar Type: POST, '/api/user'

    Editar Type: PUT, '/api/user'

    Excluir Type: DELETE, '/api/user/{id}'

    Detalhes Type: GET, '/api/user/{id}'

### Curso

JSON


    {
        "titulo": "Programador Java",
        "descricao": "Mais um curso",
        "cargaHoraria": "3",
        "valor": 550,
            "usuarios": [
                {
                    "nome": "João",
                    "telefone": "99999999",
                    "dataAdmissao": "2002-01-03",
                    "login": "admin",
                    "senha": "root"
                }
            ]
    }

    Cadastrar Type: POST, '/api/course'

    Editar Type: PUT, '/api/course'

    Excluir Type: DELETE, '/api/course/{id}'

    Detalhes Type: GET, '/api/course/{id}'
