import { RepositorioTareasSqliteImpl } from '../src/repositorioTareasSqlite';
import { Tarea } from '../src/models';

describe('RepositorioTareasSqlite', () => {
  let repositorio: RepositorioTareasSqliteImpl;

  beforeEach(() => {
    repositorio = new RepositorioTareasSqliteImpl();
  });

  afterEach(() => {
    repositorio.cerrar();
  });

  test('debe crear una tarea', async () => {
    const nuevaTarea = {
      titulo: 'Tarea de prueba',
      descripcion: 'Descripción de prueba',
      completada: false
    };

    const tareaCreada = await repositorio.crear(nuevaTarea);
    expect(tareaCreada.id).toBeDefined();
    expect(tareaCreada.titulo).toBe(nuevaTarea.titulo);
  });

  test('debe obtener todas las tareas', async () => {
    const tareas = await repositorio.obtenerTodas();
    expect(Array.isArray(tareas)).toBe(true);
  });
});
