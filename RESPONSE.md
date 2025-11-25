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

He modificado el código creando un Handler para el manejo de las lógicas y luego manteniendo el Query y el Command para
la parte de los datos. De esa forma he delegado las diferentes responsabilidades

## 3. TAREA PENDIENTE DE CODIFICAR:

En este caso he cambiado las funciones que venían creando el [CustomersInDatabaseRepository](src/main/java/com/breadhardit/travelagencykata/infrastructure/persistence/repository/CustomersInDatabaseRepository.java)
donde junto con el Patrón de diseño Builder hemos hecho las tres funciones pedidas dependientes de JPA. También le dí vueltas para ver si se podría
añadir el patrón Adapter, pero creo que no llegaba a buen puerto :)


## 4. USOS EN EL CÓDIGO DE PRINCIPIOS SOLID:

Ahora vemos que en todas las clases de utiliza el principio de responsabilidad única, ya que se encarga de una sola función, o es una clase de lógica o es una clase de datos, pero no para ambas.

También vemos el uso del principio abierto - cerrado (abierto a extensión y cerrado a modifiación) ya que por ejemplo en CustomerRepository tenemos independencia de la base de datos utlizada y junto con los handler tenemos puerta abierta para recibir nuevos módulos o ampliaciones

También las interfaces son del tamaño adecuado, sin forzar, cumpliendo así el principio de segregación

Después hablando del Principio de inversión de dependencias, dice que las dependencias deben apuntar a abstracciones, no a implementaciones, y bajo mi punto de vista (creo) que el tema de usar el CustomersRepository customersRepository (cumpliría ese principio).

Muchas gracias por el curso!
Un saludo
David!
