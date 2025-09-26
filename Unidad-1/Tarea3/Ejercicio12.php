<?php
$archivo = 'Auxiliar/ranking.txt';
$ranking = [];

$lineas = file($archivo);
foreach ($lineas as $linea) {
    $partes = explode(': ', $linea);
    if (count($partes) == 2) {
        $juego = $partes[0];
        $puntuacion = (int)$partes[1];
        $ranking[] = [$juego, $puntuacion];
    }
}

usort($ranking, function($a, $b) {
    return $b[1] <=> $a[1];
});

echo "Top 3 juegos:\n";
for ($i = 0; $i < min(3, count($ranking)); $i++) {
    echo ($i + 1) . ". " . $ranking[$i][0] . ": " . $ranking[$i][1] . "\n";
}
?>
