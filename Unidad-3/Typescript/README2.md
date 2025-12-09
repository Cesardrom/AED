## Practica 2 Tareas rest

### Uso de promesas y async/await.

Se utiliza las funciones asincronas para la llamada a la api y sus endpoints, ya que son operaciones de larga duracion, para no bloquear el hilo principal. El uso de await es para pausar la ejecucion dentro de ella hasta que la promesa que en estos casos son un objeto response que es de donde se saca la informacion de la API.

### Tipos genéricos (Promise<Tarea[]>, Omit<Tarea, "id">).

Esto lo que permite es controlar lo que se recibe o envia desde el codigo de typescript hacia la API y viceversa. Siendo el Promise lo que representa de un resultado eventual siendo en este caso una lista de Tareas. y en el Omit es algo que se utiliza para indicar que el cliente envia en este caso una tarea sin id. 

### Manejo básico de errores verificando respuesta.ok.

El manejo de errores es basico pero funcional debido a que la API manda informacion diferente de si una respuesta a sido fallida o no. Y esto se puede saber con el respuesta.ok siendo un booleano de si la llamada a fallado o no. 

### Uso de index-rest

En cuanto a el codigo proporcionado por el profesor que es index-rest es un archivo de typescript en el que se hacen diferentes llamadas a la API, para obtener todas las tareas, para crear una nueva tarea, y vuelve a obtener todas las tareas y en caso de que la funcion main falle lanza un error.


**Resultados**

```bash
Cargando tareas desde la API...
Tareas iniciales: [
  { titulo: 'Texto', descripcion: 'Texto', completada: true, id: '1' },
  {
    id: '2',
    titulo: 'Hacer la práctica 1',
    descripcion: 'Proyecto tareas en memoria',
    completada: true
  }
]
Creando una nueva tarea remota...
Tarea creada: {
  id: '78b9',
  titulo: 'Tarea creada desde index-rest.ts',
  descripcion: 'Probando POST contra json-server',
  completada: false
}
Tareas tras la creación: [
  { titulo: 'Texto', descripcion: 'Texto', completada: true, id: '1' },
  {
    id: '2',
    titulo: 'Hacer la práctica 1',
    descripcion: 'Proyecto tareas en memoria',
    completada: true
  },
  {
    id: '78b9',
    titulo: 'Tarea creada desde index-rest.ts',
    descripcion: 'Probando POST contra json-server',
    completada: false
  }
]
```

### Uso de tests.