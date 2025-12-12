import sqlite3 from 'sqlite3';
import { Tarea } from './models';

export interface RepositorioTareasSqlite {
    obtenerTodas(): Promise<Tarea[]>;
    obtenerPorId(id: number): Promise<Tarea | null>;
    crear(tarea: Omit<Tarea, 'id'>): Promise<Tarea>;
    actualizar(id: number, tarea: Partial<Tarea>): Promise<boolean>;
    eliminar(id: number): Promise<boolean>;
}

export class RepositorioTareasSqliteImpl implements RepositorioTareasSqlite {

    private db: sqlite3.Database;
    private dbPath: string = 'tareas.db';

    constructor() {
        this.db = new sqlite3.Database(this.dbPath);
        this.inicializarTabla();
    }

    private inicializarTabla(): void {
        const sql = `
      CREATE TABLE IF NOT EXISTS tareas (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        titulo TEXT NOT NULL,
        descripcion TEXT,
        completada BOOLEAN DEFAULT false
      )
    `;
    };

    obtenerTodas(): Promise<Tarea[]> {
        throw new Error('Method not implemented.');
    }
    obtenerPorId(id: number): Promise<Tarea | null> {
        throw new Error('Method not implemented.');
    }
    crear(tarea: Omit<Tarea, 'id'>): Promise<Tarea> {
        throw new Error('Method not implemented.');
    }
    actualizar(id: number, tarea: Partial<Tarea>): Promise<boolean> {
        throw new Error('Method not implemented.');
    }
    eliminar(id: number): Promise<boolean> {
        throw new Error('Method not implemented.');
    }
}