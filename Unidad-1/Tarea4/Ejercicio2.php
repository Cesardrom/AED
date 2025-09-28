<?php

countWords();

function countWords(){
    $filename = "Auxiliar/texto.txt";
    $filename2 = "Auxiliar/estadisticas.csv";


    $text = file_get_contents($filename);
    $text = strtolower($text);
    $words = str_word_count($text, 1);

    $frecuency = array_count_values($words);

    $file = fopen($filename2,"w");

    foreach ($frecuency as $word => $cuantity) {
        fwrite($file,  "$word, $cuantity\n");
    }
    fclose($file);
}



?>