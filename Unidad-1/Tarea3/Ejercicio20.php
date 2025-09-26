<?php
// Ejercicio 20: Historias locas (Mad Libs)
// Reemplaza placeholders en Auxiliar/plantilla.txt con palabras aleatorias de otros ficheros

$plantilla = file_get_contents('Auxiliar/plantilla.txt');

$animales = file('Auxiliar/animales.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
$lugares = file('Auxiliar/lugares.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
$comidas = file('Auxiliar/comidas.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

if (!empty($animales) && !empty($lugares) && !empty($comidas)) {
    $animal = trim($animales[array_rand($animales)]);
    $lugar = trim($lugares[array_rand($lugares)]);
    $comida = trim($comidas[array_rand($comidas)]);

    $historia = str_replace(['[animal]', '[lugar]', '[comida]'], [$animal, $lugar, $comida], $plantilla);
    echo "Historia loca: $historia\n";
} else {
    echo "Faltan palabras en los archivos.\n";
}
?>
