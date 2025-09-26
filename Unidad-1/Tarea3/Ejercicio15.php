<?php
// Ejercicio 15: Lista de chistes (rotativos)
// Muestra un chiste distinto en cada ejecución desde Auxiliar/chistes.txt

$chistes = file('Auxiliar/chistes.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

if (!empty($chistes)) {
    $ultimo = (int)file_get_contents('Auxiliar/ultimo_chiste.txt');
    $indice = $ultimo % count($chistes);
    echo "Chiste: " . trim($chistes[$indice]) . "\n";
    file_put_contents('Auxiliar/ultimo_chiste.txt', ($indice + 1) % count($chistes));
} else {
    echo "No se encontraron chistes en el archivo.\n";
}
?>
