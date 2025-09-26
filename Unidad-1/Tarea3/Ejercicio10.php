<?php
    $filename = "Auxiliar/datos.json";
    $data = file_get_contents($filename);
    $decoded_data = json_decode($data);
    print_r($decoded_data);
?>