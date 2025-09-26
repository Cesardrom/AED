<?php
    $filename = "Auxiliar/numeros.txt";
    $file = fopen($filename, 'w');
    for($i = 1; $i <= 10; $i++){
        fwrite($file, "$i \n");
    }
    fclose($file);
    echo file_get_contents($filename);
?>