#Author: edgar.lemus@sqasa.co
#language: es

Característica: Operaciones Matematicas
  Yo como usuario de windows
  Quiero realizar las operaciones matematicas basicas en la calculadora de windows
  Para ver cada uno de sus resultados

  Esquema del escenario: <Escenario>
    Dado que el usuario se encuentra en la calculadora de windows
    Cuando cuando realice la operacion <Operacion>
    Entonces podra verificar como resultado el valor <Resultado> en pantalla

    Ejemplos: 
      | Escenario                                               | Operacion       | Resultado |
      | Realizar la suma en la calculadora de windows           | 5 + 8 =         |        13 |
      | Realizar la resta en la calculadora de windows          | 24 - 8 =        |        16 |
      | Realizar la division en la calculadora de windows       | 5 / 5 =         |         1 |
      | Realizar la multiplicacion en la calculadora de windows | 100 * 100 =     |     10.000 |
      | Realizar una operacion en la calculadora de windows     | 7 * 9 + 1 / 8 = |         8 |
