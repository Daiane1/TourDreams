<?php

	header("Cache-Control: no-store, no-cache, must-revalidate, max-age=0");
    header("Cache-Control: post-check=0, pre-check=0", false);
    header("Pragma: no-cache");
	ini_set('default_charset','UTF-8');
	header("Content-Type: text/html; charset=ISO-8859-1", true);
	header("Content-Type: text/html; charset=UTF-8", true);

	include_once 'conexao.php';

	$id_produto = $_GET['id_produto'];
	$sql = $dbcon->query("select * from view_quartos where id_produto='$id_produto'");
	
	$lista = [];
	
	if(mysqli_num_rows($sql) > 0){
		while($dados = $sql->fetch_array()){
		
			$carac_quarto=array();
			$sql_2 =$dbcon->query("select * from view_carac_quarto where id_quarto=".$dados['id_quarto']." limit 2");
			if(mysqli_num_rows($sql_2)>0){
				while($dados_carac = $sql_2->fetch_array()){
					$carac_quarto[] = array ("caracteristicas_quarto" => utf8_encode($dados_carac['caracteristica_quarto']),
											"foto_caracteristicas" => utf8_encode($dados_carac['foto_caracteristica_quarto'])
											);
				}
			  }
				
			$obj = array("id_quarto" => utf8_encode ($dados['id_quarto']) ,
			  "descricao_quarto" => utf8_encode ($dados['descricao_quarto']),
			  "preco_diaria" => utf8_encode ($dados['preco_diaria']),
			  "foto_quarto" => utf8_encode ($dados['foto_quarto']),			  
			  "array_carac_quarto" => $carac_quarto);
	  

			$lista[] = $obj;
			
				
		}
		
		
		
		echo json_encode($lista);


	}

?>
