# RESPONSE David Fidalgo Jiménez

## 1. Búsqueda de patrones de diseño:

En la clase [CreateCustomerCommand](src/main/java/com/breadhardit/travelagencykata/application/command/command/CreateCustomerCommand.java)
encontramos un patrón de creacional: Patrón Builder.

En la clase [CustomersController](src/main/java/com/breadhardit/travelagencykata/infrastructure/rest/CustomersController.java)
encontramos en repetidas ocasiones el patrón builder


## 2. Violaciones de principios SOLID:

En la clase [CreateCustomerCommand](src/main/java/com/breadhardit/travelagencykata/application/command/command/CreateCustomerCommand.java)
y [GetCustomerQuery](src/main/java/com/breadhardit/travelagencykata/application/command/query/GetCustomerQuery.java)
tenemos una mezcla rara entre datos y lógica, una de las primeras cosas que no podemos aplicar. Debemos separar la parte de la lógica, de la parte de los datos. Tal y como está ahora violaría el principio "Abierto cerrado"
y también violaría el principio de responsabilidad única.

Hemos modificado el código creando un Handler para el manejo de las lógicas y luego manteniendo el Query y el Command para
la parte de los datos. De esa forma hemos delegado las diferentes responsabilidades

