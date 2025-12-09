// ejemplos/02-tipos-compuestos.ts
type Id = number | string;

let id1: Id = 123;
let id2: Id = "abc-123";

type ConFecha = { creadoEn: Date };
type ConId = { id: number };

type EntidadConIdYFecha = ConFecha & ConId;

const registro: EntidadConIdYFecha = {
  id: 1,
  creadoEn: new Date(),
};