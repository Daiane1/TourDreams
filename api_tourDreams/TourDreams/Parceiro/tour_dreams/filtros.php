<?php

	header("Cache-Control: no-store, no-cache, must-revalidate, max-age=0");
    header("Cache-Control: post-check=0, pre-check=0", false);
    header("Pragma: no-cache");
	ini_set('default_charset','UTF-8');	
	header("Content-Type: text/html; charset=ISO-8859-1", true);
	header("Content-Type: text/html; charset=UTF-8", true);
	
	include_once 'conexao.php';
	
	$filtro_basico = $_POST['filtro_basico'];
	
	$sql = $dbcon->query("select * from view_filtros
        where nome_caracteristica LIKE '%$filtro_basico%' or nome_fantasia LIKE '%$filtro_basico%'
		or logradouro LIKE '%$filtro_basico%' or bairro LIKE '%$filtro_basico%'
		or cidade LIKE '%$filtro_basico%' or estado LIKE '%$filtro_basico%'
		or pais LIKE '%$filtro_basico%';");
		
	if(mysqli_num_rows($sql) > 0){
		
		$lista = [];
		
		while($dados = $sql->fetch_array()){
			$obj = array("nome_caracteristica" => $dados['nome_caracteristica'], 
			"foto_caracteristica" => $dados['foto_mobile'],
			);
			$lista[] = $obj;
		}
		
		echo json_encode($lista);
			
	} else {
		echo ("Erro");
		
	}


?>