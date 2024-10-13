# Documentación del Proyecto: Gestión de Pedidos

## Descripción

Este proyecto consiste en un sistema de gestión de pedidos que permite crear, visualizar y almacenar información sobre encargos en diferentes formatos: texto (Albarà), CSV y binario. El programa facilita la entrada de datos por parte del usuario y la gestión de archivos en el sistema de archivos.

## Estructura del Proyecto

El proyecto está compuesto por las siguientes clases:

1. **FileManager**: Encargada de gestionar la creación y visualización de archivos.
2. **Main**: Punto de entrada del programa donde se interactúa con el usuario.
3. **Pedido**: Representa un pedido que contiene información del cliente y una lista de artículos.
4. **Article**: Representa un artículo dentro de un pedido, incluyendo su nombre, cantidad y tipo de unidad.

## Proceso de Implementación

### 1. Clase `FileManager`

La clase `FileManager` contiene métodos para crear archivos de diferentes formatos y para mostrar su contenido. Aquí se describen los métodos implementados:

- **crearAlbaran(Pedido pedido)**: Crea un archivo de texto en formato albaràn.
- **crearCSV(Pedido pedido)**: Crea un archivo CSV con la información del pedido.
- **crearBinario(Pedido pedido)**: Crea un archivo binario.
- **mostrarCSV(String filePath)**: Lee y muestra el contenido de un archivo CSV (el resultado es en albaràn).
- **mostrarBinario(String filePath)**: Lee y muestra el contenido de un archivo binario(el resultado es en albaràn).

### 2. Clase `Main`

La clase `Main` contiene el método `main` que inicia la ejecución del programa. Aquí se presentan las opciones al usuario:

- **A**: Generar un nuevo encargo.
- **B**: Mostrar un encargo existente.
- **C**: Salir del programa.

El flujo del programa permite al usuario ingresar la información del cliente y los artículos que componen el pedido, eligiendo el formato del archivo a generar.

### 3. Clase `Pedido`

La clase `Pedido` almacena la información del cliente (nombre, número de teléfono, fecha) y mantiene una lista de artículos. Los métodos incluyen:

- **addArticle(String name, float quantity, String unit)**: Añade un nuevo artículo a la lista de artículos.

### 4. Clase `Article`

La clase `Article` define la estructura de un artículo. Sus atributos son:

- `nom`: Nombre del artículo.
- `quantitat`: Cantidad del artículo.
- `tipusUnitat`: Tipo de unidad (kg, g, u, etc.).

Además, se incluye el método `toCSV()` para facilitar la representación del artículo en formato CSV.

## Flujo de Ejecución

1. El usuario inicia el programa y elige una opción (A, B, C).
2. Si elige **A**, se le solicita la información del cliente y los artículos. Luego, se le pide que seleccione el formato del archivo a generar.
3. Si elige **B**, se le solicita la ruta del archivo que desea mostrar y el tipo de archivo (CSV o binario).
4. Si elige **C**, el programa finaliza.

## Ejemplo de Uso

- Generar un nuevo encargo:
    - Se pide el nombre del cliente.
    - Se pide el teléfono del cliente.
    - Se solicita la fecha del encargo.
    - Se permiten múltiples entradas de artículos.
    - Se selecciona el formato de archivo a generar.

- Mostrar un encargo existente:
    - Se proporciona la ruta del archivo.
    - Se selecciona el tipo de archivo a mostrar.

## Consideraciones Finales

- Se utilizan excepciones para manejar errores en la entrada/salida de datos.
- Se valida la entrada del usuario para evitar datos no válidos.
- Los archivos generados se almacenan en la ruta especificada con un nombre que incluye el nombre del cliente y la fecha/hora actual.

## Requerimientos

Para ejecutar este programa, se requiere:
- Java Development Kit (JDK) instalado.
- Acceso a un sistema de archivos donde se puedan crear y leer archivos.

## Conclusión

Este proyecto proporciona una solución efectiva para la gestión de pedidos, con una interfaz de usuario simple y opciones de almacenamiento flexibles.

