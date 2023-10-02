#Author: edgar.lemus@sqasa.co
#language: es

Característica: Manejo de Archivo Excel
  Yo como usuario de windows
  Quiero automatizar un archivo de excel
  Para ver los datos
  
  Escenario: Crear archivo de excel con encabezado y datos
    Dado que el abre un archivo excel
    Cuando cuando ingrese los datos
    |Nombre|Apellido|Telefono|Edad|
    |Andres|Perez|3125479320|25|
    |Maria|Jose|3154782649|22|
    |Andrea|Escobar|3259469161|35|
    |Juan|Ramirez|3135479651|27|
    Y cambie de lugar el archivo
    |C:\Users\Edgar\Desktop|ArchivoPrueba|
    Entonces podra verificar el archivo
