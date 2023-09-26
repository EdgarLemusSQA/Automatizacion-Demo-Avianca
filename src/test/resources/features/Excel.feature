#Author: edgar.lemus@sqasa.co
#language: es

Característica: Manejo de Archivo Excel
  Yo como usuario de windows
  Quiero crear un archivo excel con encabezado y datos
  Para ver los datos
  
  Escenario: Crear archivo de excel con encabezado y datos
    Dado crea un archivo excel con el siguiente encabezado
    |Nombre|Apellido|Telefono|Edad|
    Cuando cuando ingrese los siguiente datos
    |Andres|Perez|3125479320|25|
    |Maria|Jose|3154782649|22|
    |Andrea|Escobar|3259469161|35|
    |Juan|Ramirez|3135479651|27|
    Entonces podra verificar la cantidad de datos en el archivo