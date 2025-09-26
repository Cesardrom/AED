<?php
// Ejercicio 14: Generador de excusas divertidas
// Lee excusas de Auxiliar/excusas.txt y muestra una aleatoria

$excusas = file('Auxiliar/excusas.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

if (!empty($excusas)) {
    $indiceAleatorio = array_rand($excusas);
    echo "Excusa aleatoria: " . trim($excusas[$indiceAleatorio]) . "\n";
} else {
    echo "No se encontraron excusas en el archivo.\n";
}
?>
