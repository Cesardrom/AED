<?php
// Ejercicio 16: Adivina la palabra
// Elige una palabra de Auxiliar/palabras.txt y muestra solo la primera y última letra, el usuario debe adivinarla

$palabras = file('Auxiliar/palabras.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

if (!empty($palabras)) {
    $palabra = trim($palabras[array_rand($palabras)]);
    $longitud = strlen($palabra);
    if ($longitud > 2) {
        $pista = $palabra[0] . str_repeat('.', $longitud - 2) . $palabra[$longitud - 1];
    } else {
        $pista = $palabra; // Si es corta, mostrar completa
    }
    echo "Adivina la palabra: $pista\n";

    while (true) {
        $adivinanza = readline("Tu adivinanza: ");
        if (strtolower(trim($adivinanza)) === strtolower($palabra)) {
            echo "¡Correcto! La palabra era: $palabra\n";
            break;
        } else {
            echo "Incorrecto, intenta de nuevo.\n";
        }
    }
} else {
    echo "No se encontraron palabras en el archivo.\n";
}
?>
