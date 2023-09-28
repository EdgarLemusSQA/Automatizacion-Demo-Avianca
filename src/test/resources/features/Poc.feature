#Author: edgar.lemus@sqasa.co
#language: es

Característica: Manejo de Archivo Excel
  Yo como usuario de windows
  Quiero automatizar un archivo de excel
  Para ver los datos
  
  Escenario: Crear archivo de excel con encabezado y datos
    Dado que el abre un archivo excel
    Cuando cuando ingrese los datos
    |POC|Resultado|
    Y cambie de lugar el archivo
    Entonces podra verificar el archivo
