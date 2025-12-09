# Modelos de TypeScript

En este proyecto, utilizamos TypeScript para definir los tipos de datos en el archivo `src/models.ts`. A continuación, relacionamos estos tipos con conceptos clave de la documentación de TypeScript.

## Tipos Primitivos

Los tipos primitivos son los bloques básicos de TypeScript. En nuestro modelo `Tarea`, utilizamos:

- `number`: Para el identificador único de la tarea (`id`).
- `string`: Para el título de la tarea (`titulo`) y su descripción opcional (`descripcion`).
- `boolean`: Para indicar si la tarea está completada (`completada`).

Estos tipos primitivos aseguran que los datos sean de tipos específicos y eviten errores en tiempo de ejecución.

## Propiedades Opcionales

Las propiedades opcionales permiten que ciertos campos no sean obligatorios. En la interfaz `Tarea`, la propiedad `descripcion` se marca con `?`, lo que significa que puede estar presente o no en un objeto de tipo `Tarea`. Esto es útil para campos que no siempre son necesarios.

## Tipos Unión

Los tipos unión permiten representar un conjunto de valores posibles. El tipo `FiltroTarea` es un ejemplo de tipo unión: `"todas" | "pendientes" | "completadas"`. Esto restringe los valores posibles para los filtros de tareas, mejorando la seguridad de tipos y la autocompletación en el editor.

Estos conceptos hacen que nuestro código sea más robusto, legible y mantenible.
