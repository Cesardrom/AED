<?php
// Ejercicio 17: Generador de nombres para superhéroes
// Combina palabras de Auxiliar/adjetivos.txt y Auxiliar/animales.txt

$adjetivos = file('Auxiliar/adjetivos.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
$animales = file('Auxiliar/animales.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

if (!empty($adjetivos) && !empty($animales)) {
    $adj = trim($adjetivos[array_rand($adjetivos)]);
    $animal = trim($animales[array_rand($animales)]);
    echo "Nombre de superhéroe: $adj $animal\n";
} else {
    echo "No se encontraron adjetivos o animales en los archivos.\n";
}
?>
