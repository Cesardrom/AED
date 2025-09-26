<?php
// Ejercicio 13: Canción aleatoria
// Lee canciones de Auxiliar/canciones.txt y muestra una al azar

$canciones = file('Auxiliar/canciones.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

if (!empty($canciones)) {
    $indiceAleatorio = array_rand($canciones);
    echo "Canción aleatoria: " . trim($canciones[$indiceAleatorio]) . "\n";
} else {
    echo "No se encontraron canciones en el archivo.\n";
}
?>
