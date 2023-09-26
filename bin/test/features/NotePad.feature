#Author: edgar.lemus@sqasa.co
#language: es
Característica: Escribir en Note Pad ++
  Yo como usuario de windows
  Quiero poder escribir en texto en la aplicación de Notepad++
  Para poder verlo en pantalla

  Esquema del escenario: <Escenario>
    Dado que el usuario se encuentra en Notepad++ de windows
    Cuando cuando escriba el texto <Texto> en la aplicacion
    Entonces podra verificar el texto <Texto> en pantalla

    Ejemplos: 
      | Escenario                                   | Texto                            |
      | Escribir un texto en NotePad ++  de Windows | Este es un texto para NotePad ++ |
