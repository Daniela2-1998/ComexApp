<h1 align="center"> ComexApp </h1>

  ![logo de la app](https://user-images.githubusercontent.com/108192404/218524739-98ffa4b5-b387-4f29-9a8e-7f5373520f83.png)

<p align="left">
   <img src="https://img.shields.io/badge/STATUS-EN%20DESAROLLO-green">
   <img src="https://img.shields.io/badge/ÚLTIMA VERSIÓN-%20 1.0-red">
   <img src="https://img.shields.io/badge/LENGUAJE-%20 JAVA-blue">
   <img src="https://img.shields.io/badge/BBD-%20 POSTGRESQL-violet">
   <img src="https://img.shields.io/badge/IDE-%20 NETBEANS-orange">
 </p>

   

 
 
 ## Índice de ComexApp

* [Descripción del proyecto](#descripción-del-proyecto)

* [Estado del proyecto](#Estado-del-proyecto)

* [Características de la aplicación y demostración](#Características-de-la-aplicación-y-demostración)

* [Versiones del sistema](#Versiones-del-sistema)

* [Características agregadas en cada versión](#Características-agregadas-en-cada-sistema)

* [Acceso al proyecto](#acceso-proyecto)

* [Tecnologías utilizadas](#tecnologías-utilizadas)

* [Conclusión](#conclusión)


<h4 align="center">
:construction: Proyecto en construcción. Versión 1.0 lanzada :construction:
</h4>

## Descripcion del proyecto:
ComexApp es un software desarrollado con el fin de facilitar y reunir operaciones que realiza un especialista en comercio internacional. Puede ser utilizado por empresas que se dediquen al comercio internacional (ya sean importadores, exportadores, despachantes o empresas relacionadas con la logística internacional), o bien empresas que sólo se dediquen al comercio a nivel nacional. 

Su función es ser un software cómodo, de fácil entendimiento y práctico para que todos los usuarios del sistema sepan como utilizarlo, puedan adaptarse rápidamente a ComexApp y aprovechen sus funcionalidades.

## Estado del proyecto:
Recientemente se ha lanzado la versión 1.0 de ComexApp. Más allá de eso, siempre surgen nuevas ideas de mejoras, cambios y nuevas funcionalidades a ser desarrolladas para brindar más servicios de cálidad a los usuarios de la aplicación, por lo que, la nueva versión de la aplicación se encuentra en desarrollo. 

## Características del proyecto:
El proyecto cuenta con un sistema de inicio de sesión con diferencia según el tipo de rol declarado en el momento de crear un usuario, estos roles pueden ser: Administrador, Exportador, Importador, Agente, Logística y Marketing. Como podrán ver, el rol está relacionado con el puesto de trabajo al que se dedica el usuario. De momento, todos tienen acceso a las mismas funciones, con excepción del administrador, que tendrá funciones extra para poder controlar a los usuarios pudiendo modificar sus datos (excepto las contraseñas) o eliminarlos del sistema en caso de renuncia o hechos similares.

Estamos trabajando en crear funciones específicas para poder brindas un mejor provecho a la diferenciación por roles.

Debajo te presentamos las funciones que podrás realizar como usuario de ComexApp:

#### :hammer: Funciones:
- `Administración de usuarios`: el administrador puede ver y modificar la información relativa a los usuarios inscriptos en el sistema, con excepción de las contraseñas para dar mayor seguridad a los mismos usuarios.
- `Almacenar información de contactos`: contactos como importadores, exportadores, despachantes de aduana o agentes de logística internacional (marítima o aerolínea) pueden ser registrados, modificados o eliminados del sistema. El objetivo principal de esta función es poder almacenar, en único lugar, toda la información relevante a un contacto y tener acceso a ellas de forma rápida y fácil. 
- `Agenda personal`: también permite el almacenamiento de información esencial de los contactos de la empresa, pero esta función permite registrar esta información de forma privada para que sólo tenga acceso a ella el usuario que realizó el registro del contacto. Es sumamente útil para aquellas empresas en las que varios empleados se contactan con diferentes empleados de otra empresa; o bien, para gerentes que se comunican con otros gerentes y desean mantener esta información en privado.
- `Gestión de operaciones internacionales`: gestiona de forma rápida y completa la información más importante de las operaciones internacionales que se registran en ComexApp. Reune en un mismo lugar toda su información y permite buscar por filtros los registros solicitados. Las operaciones están organizadas de forma creciente, es decir, desde el más actual al más lejano. A su vez, se pueden ocultar las operaciones que ya fueron completadas o se pueden mostrar todas en caso de que sea necesario. En el día en el que acontece una operación, se envía una notificación al abrir la sección correspondiente informando que hay operaciones en el día, a su vez, automáticamente cambia su status a "Completada". En esta sección, también podrás asociar la información registrada de los contenedores, a un producto del stock o bien asociarlas con los participantes de la operación. La tabla correspondiente está organizada desde los más cercanos a los más lejanos.
- `Gestión de operaciones nacionales`: funciona exactamente igual que como funciona la sección anterior, sólo que con información adaptada únicamente a las operaciones nacionales. 
- `Gestión de stock`: se ingresan los productos al sistema indicando producto, código, número que tendrá en ComexApp, cantidades, fechas de registro e ingreso a stock, status del ingreso, detalle del producto y cuidados especiales o indicaciones necesarias para su cuidado y almacenamiento. Adicionalmente, se diferencian sus vendedores y países de orígen. Como ocurre con las secciones anteriores, también tiene notificaciones, cambio de status, busqueda por filtros y organizado por fechas.
- `Gestión de suministros o reabastecimiento`: es identica al stock, sólo que está dedicada a las materias primas y materiales o productos que se utilizan para motivos diferentes a la venta de productos. Se puede declarar si ya fue reservado para algun uso y su destino futuro.
- `Creación de informes`: el sistema puede crear automáticamente unos informes a partir de las tablas creadas en el sistema. Se pueden generar para toda un área (contactos, operaciones, stock, contenedores) o para una sección en particular (exportadores, operaciones internacionales, suministros) o se pueden crear manualmente con la información que el usuario quiera escribir e incluir con un límite de 5 subtítulos y 5 espacios de párrafo (estos espacios tienen un límite de 1000 palabras por lo que es posible crear más de un párrafo en un lugar.  
- `Creación de reportes y estadísticas`: de momento informan la cantidad de operaciones nacionales, internacionales, totales, los productos más comprados y vendidos, y los principales compradores y vendedores.
- `Establecimiento de objetivos y mensajes`: es posible crear objetivos colocando fecha del objetivo, nivel de importancia, sector o persona a la que está destinado, título y detalles del objetivo. Además, pueden escribirse mensajes relacionados a estos objetivos para ir notificando su avance, dudas, consultas, inconvenientes o imposibilidades de cumplimiento. Ambas partes se pueden visualizar y ver en los espacios correspondientes. Es posible filtrar para ver según solicitud. Al entrar a la sección de objetivos, se notificará en caso de tener un nuevo mensaje u objetivo disponible.
- `Sticky notes`: el usuario podrá elegir un espacio para crear una nota con su N°, título, contenido y elegir el color y fuente que más les guste pudiendo mantener estos datos una vez cerrada la sesión. Todas las notas seguirán disponibles en la base de datos y se podrán recuperar o eliminar según desee el usuario. Cabe destacar, que se trata de una sección privada, por lo que sólo el propio usuario podrá ver sus notas.


#### :hammer: Comodidades para el usuario y su seguridad:
- `Preguntas de seguridad`: establecimiento y visualización de 3 preguntas de seguridad privadas por usuario.
- `Recupero de usuario o contraseña`: recuperando y completando correctamente la información solicitada y contestando correctamente las preguntas de seguridad recuperadas.
- `Cambio de contraseña`: mediante la contraseña anterior y confirmación de la nueva.
- `Modificar información de usuario`: cada usuario podrá modificar toda su información de usuario.
- `Elección de colores y fondo para página principal`: cada usuario podrá elegir los colores y/o fondo de página principal pudiendo recuperarlos una vez cerrada la sesión.

