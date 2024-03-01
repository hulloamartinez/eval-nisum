#   MÉTODO USER (CREACIÓN)
## Table of Contents
<p>
<details>
<summary>Click to unfold.</summary>

[[_TOC_]]

</details>
</p>

## Functional Description
### Context
Test de evaluacion de conocimientos JAVA para NISUM

## Technical Description
Método que permite crear y persistir un usuario en base de datos H2

## Diagrama
```

```

## Detalles del servicio
- Servicio recibe JSON con información de usuario.
- Servicio Valida correo electrónico. Si existe en base de datos, se devuelve error 400 con mensaje
- Si correo no existe, se almacena en base de datos
- Servicio devuevle resumen de la transacción realizada.

## Parámetros de entrada

![imagen](https://github.com/hulloamartinez/eval-nisum/assets/5367860/cfcc61c0-aff6-4400-8507-83bcc7ca698a)

![imagen](https://github.com/hulloamartinez/eval-nisum/assets/5367860/fbe56e47-f2a1-41e4-aa07-5443979fbc06)

## Parámetros de salida

![imagen](https://github.com/hulloamartinez/eval-nisum/assets/5367860/aef87de3-6e93-4398-a3e3-ac485694cbcb)

## JSON ENTRADA

```yaml
{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.com",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}
```

## JSON SALIDA

```yaml
{
    "id": "52163568-c897-4697-b9eb-2c894e03c0a0",
    "created": "2024-03-01T16:18:11.987",
    "modified": "2024-03-01T16:18:11.987",
    "lastLogin": "2024-03-01T16:18:11.987",
    "token": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQHVzZXJzLmNvbSIsImV4cCI6MTcxMTg5MTY1NCwibm9tYnJlIjoidXN1YXJpbyBkb3MifQ.1yNcAo-OUBMxoUYFY8sN_YpgcRycyj8KpIotb8uB9x4",
    "active": true
}
```


## JSON ERROR 409

```yaml
{
    "code": "Email Registration Error",
    "message": "El correo ya está registrado"
}
```


## JSON ERROR 400

```yaml
{
    "code": "Email format Error",
    "message": "Formato inválido, por favor revise."
}
```

