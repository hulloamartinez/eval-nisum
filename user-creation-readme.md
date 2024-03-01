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
´

´

## Detalles del servicio
- Servicio recibe JSON con información de usuario.
- Servicio Valida correo electrónico. Si existe en base de datos, se devuelve error 400 con mensaje
- Si correo no existe, se almacena en base de datos
- Servicio devuevle resumen de la transacción realizada.

## Parámetros de entrada
NOMBRE	TIPO	RESTRICCIONES
name	String	Not null, not empty
email	String	Not null, not empty, UNIQUE
password	String	Not Null, Not empty
![imagen](https://github.com/hulloamartinez/eval-nisum/assets/5367860/7030e1ff-bb34-4ff4-9136-d5491af1f861)

