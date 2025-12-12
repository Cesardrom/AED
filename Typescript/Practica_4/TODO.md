# TODO - Práctica 4: Doble persistencia de tareas (SQLite3 local + API REST remota con H2)

## Estado actual del proyecto
- ✅ Proyecto TypeScript creado
- ✅ Modelo `Tarea` definido en `src/models.ts`
- ✅ Configuración básica de package.json y tsconfig.json

## Pasos detallados a completar

### 1. Configuración del proyecto TypeScript
- ✅ 1.1. Instalar dependencias necesarias para SQLite3 (`sqlite3` y `@types/sqlite3`)
- ✅ 1.2. Instalar dependencias para cliente HTTP (`node-fetch` o `axios`)
- ✅ 1.3. Configurar scripts en package.json:
  - ✅ `npm run build` (compilar TypeScript a dist/)
  - ✅ `npm start` (ejecutar el proyecto compilado)
  - ✅ `npm run dev` (ejecutar con ts-node para desarrollo)
- ✅ 1.4. Actualizar tsconfig.json para incluir directorios src/ y dist/

### 2. Implementación de la persistencia local (SQLite3)
- ✅ 2.1. Crear módulo `src/repositorioTareasSqlite.ts`
- [ ] 2.2. Implementar conexión a base de datos SQLite3
- [ ] 2.3. Crear tabla `tareas` si no existe
- [ ] 2.4. Implementar métodos CRUD:
  - [ ] `obtenerTodas(): Promise<Tarea[]>`
  - [ ] `obtenerPorId(id: number): Promise<Tarea | null>`
  - [ ] `crear(tarea: Omit<Tarea, 'id'>): Promise<Tarea>`
  - [ ] `actualizar(id: number, tarea: Partial<Tarea>): Promise<boolean>`
  - [ ] `eliminar(id: number): Promise<boolean>`

### 3. Desarrollo de la API REST en Java (Spring Boot + H2)
- ✅ 3.1. Crear proyecto Spring Boot
- ✅ 3.2. Configurar dependencia H2 database
- ✅ 3.3. Crear entidad `Tarea` en Java
- ✅ 3.4. Crear repositorio JPA para tareas
- ✅ 3.5. Implementar controlador REST con endpoints:
  - ✅ `GET /api/tareas` (listar todas)
  - ✅ `GET /api/tareas/{id}` (obtener por id)
  - ✅ `POST /api/tareas` (crear)
  - ✅ `PUT /api/tareas/{id}` (actualizar)
  - ✅ `DELETE /api/tareas/{id}` (eliminar)
- ✅ 3.6. Configurar aplicación.properties para H2
- ✅ 3.7. Probar endpoints con Postman o similar

### 4. Implementación del cliente REST en TypeScript
- [ ] 4.1. Crear módulo `src/apiTareasRemota.ts`
- [ ] 4.2. Configurar URL base de la API (variable de entorno)
- [ ] 4.3. Implementar métodos para consumir endpoints:
  - [ ] `obtenerTodas(): Promise<Tarea[]>`
  - [ ] `obtenerPorId(id: number): Promise<Tarea>`
  - [ ] `crear(tarea: Omit<Tarea, 'id'>): Promise<Tarea>`
  - [ ] `actualizar(id: number, tarea: Partial<Tarea>): Promise<Tarea>`
  - [ ] `eliminar(id: number): Promise<boolean>`

### 5. Capa de servicio con doble origen
- [ ] 5.1. Crear módulo `src/servicioTareas.ts`
- [ ] 5.2. Definir tipo `OrigenDatos` ('local' | 'remoto')
- [ ] 5.3. Implementar servicio que combine ambos orígenes:
  - [ ] Constructor que reciba repositorio local y cliente remoto
  - [ ] `listar(origen: OrigenDatos, filtro?: 'todas' | 'pendientes' | 'completadas'): Promise<Tarea[]>`
  - [ ] `crear(origen: OrigenDatos, tarea: Omit<Tarea, 'id'>): Promise<Tarea>`
  - [ ] `actualizar(origen: OrigenDatos, id: number, tarea: Partial<Tarea>): Promise<boolean>`
  - [ ] `eliminar(origen: OrigenDatos, id: number): Promise<boolean>`

### 6. Implementación de sincronización
- [ ] 6.1. Añadir método de sincronización en `servicioTareas.ts`
- [ ] 6.2. Implementar `sincronizarRemotoALocal(): Promise<void>`
- [ ] 6.3. Estrategia de sincronización:
  - [ ] Opción A: Eliminar todas las locales y recrear desde remoto
  - [ ] Opción B: Sincronización incremental (recomendado)
- [ ] 6.4. Manejar errores de sincronización

### 7. Punto de entrada y CLI
- [ ] 7.1. Crear módulo `src/index.ts`
- [ ] 7.2. Instanciar dependencias (repositorio local, cliente remoto, servicio)
- [ ] 7.3. Implementar flujo de ejemplo:
  - [ ] Mostrar tareas remotas
  - [ ] Sincronizar remoto → local
  - [ ] Mostrar tareas locales
  - [ ] Crear tarea en local
  - [ ] Crear tarea en remoto
  - [ ] Mostrar ambas fuentes

### 8. Tests automáticos
- [ ] 8.1. Configurar framework de testing (`jest` + `@types/jest`)
- [ ] 8.2. Crear tests para repositorio SQLite3:
  - [ ] Test de conexión y creación de tabla
  - [ ] Tests de operaciones CRUD
- [ ] 8.3. Crear tests para cliente REST:
  - [ ] Tests de endpoints (mocking)
- [ ] 8.4. Crear tests para servicio:
  - [ ] Test de selección de origen
  - [ ] Test de sincronización
- [ ] 8.5. Configurar script `npm test`

### 9. Documentación y configuración final
- [ ] 9.1. Crear README.md con:
  - [ ] Descripción del proyecto
  - [ ] Instrucciones de instalación y ejecución
  - [ ] Estructura de carpetas
  - [ ] Configuración de la API remota
  - [ ] Explicación de la sincronización
  - [ ] Ejemplos de uso
- [ ] 9.2. Crear archivo `.env` de ejemplo para configuración
- [ ] 9.3. Actualizar .gitignore para incluir:
  - [ ] Archivos compilados (dist/)
  - [ ] Base de datos SQLite (tareas.db)
  - [ ] Variables de entorno (.env)
- [ ] 9.4. Probar el flujo completo de la aplicación

### 10. Validación final
- [ ] 10.1. Verificar que todos los tests pasen
- [ ] 10.2. Probar la aplicación desde línea de comandos
- [ ] 10.3. Verificar sincronización remoto → local
- [ ] 10.4. Comprobar operaciones CRUD en ambas fuentes
- [ ] 10.5. Revisar documentación completa

## Dependencias adicionales a instalar

```bash
# Para SQLite3
npm install sqlite3
npm install --save-dev @types/sqlite3

# Para cliente HTTP
npm install axios
# o alternativamente: npm install node-fetch

# Para testing
npm install --save-dev jest @types/jest ts-jest
```

## Archivos a crear

1. `src/repositorioTareasSqlite.ts`
2. `src/apiTareasRemota.ts`
3. `src/servicioTareas.ts`
4. `src/index.ts`
5. `tests/` (directorio completo)
6. `README.md`
7. `.env.example`

## Archivos a modificar

1. `package.json` (añadir scripts y dependencias)
2. `tsconfig.json` (configurar rootDir y outDir)
3. `.gitignore` (añadir archivos a ignorar)

## Configuración de la API Java (Spring Boot)

La API REST en Java se desarrollará por separado y debe:
- Usar Spring Boot con H2 embedded
- Exponer endpoints REST en puerto 8080 (por defecto)
- Manejar las mismas operaciones CRUD que SQLite3
- Tener CORS habilitado para permitir acceso desde TypeScript
