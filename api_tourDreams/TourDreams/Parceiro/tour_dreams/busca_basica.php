<?php

	header("Cache-Control: no-store, no-cache, must-revalidate, max-age=0");
    header("Cache-Control: post-check=0, pre-check=0", false);
    header("Pragma: no-cache");
	ini_set('default_charset','UTF-8');	
	header("Content-Type: text/html; charset=ISO-8859-1", true);
	header("Content-Type: text/html; charset=UTF-8", true);
	
	include_once 'conexao.php';
	
	if (isset($_POST['busca_basica'])) {
		
		$busca_basica = $_POST['busca_basica'];


		$sql = $dbcon->query("select  distinct vf.*, pd.descricao_produto, pd.foto_principal, view_ava.media_geral from view_filtros as vf
			inner join view_produto as pd
			on pd.id_produto = vf.id_produto
			left join view_avaliacoes as view_ava
			on view_ava.id_produto = vf.id_produto
				where vf.nome_caracteristica LIKE '%$busca_basica%' or vf.nome_fantasia LIKE '%$busca_basica%'
				or vf.logradouro LIKE '%$busca_basica%' or vf.bairro LIKE '%$busca_basica%'
				or vf.cidade LIKE '%$busca_basica%' or vf.estado LIKE '%$busca_basica%'
				or vf.pais LIKE '%$busca_basica%'
				group by vf.id_produto;");

				
				
		if(mysqli_num_rows($sql) > 0){
			
			$lista = [];
			
			while($dados = $sql->fetch_array()){
				$obj = array("id_produto" => $dados['id_produto'], 
				"img_produto_busca" => $dados['foto_principal'],
				"nome_produto_busca" => $dados['nome_fantasia'],
				"local_produto_busca" => ($dados['cidade'] . " - " .$dados['estado']. " , " .$dados['pais']),
				"nota_produto_busca" => number_format ($dados['media_geral'], 1, "." , "."),
				"preco_produto_busca" => "R$ ". number_format($dados['preco'], 2, "," , "."),
				);
				$lista[] = $obj;
			}
			
			echo json_encode($lista);
				
		} else {
			echo ("Erro");
			
		}
	}elseif (isset($_POST['busca_home'])){
		
		$busca_home = $_POST['busca_home'];
		$localizacao = $_POST['localizacao'];
		$dt_entrada = $_POST['dt_entrada'];
		$dt_saida = $_POST['dt_saida'];
		
		$data_in_banco = implode("-",array_reverse(explode("/",$dt_entrada)));
		$data_out_banco = implode("-",array_reverse(explode("/",$dt_saida)));
		
		$sql_code = $dbcon->query("select vp.id_produto, rs.*, vp.nome_fantasia, vp.cidade, vp.estado, vp.pais, vp.preco_diaria, vp.foto_principal, view_ava.limpeza, 
							view_ava.atendimento, view_ava.restaurante, view_ava.lazer, view_ava.media_geral from tbl_reserva as rs
						inner join tbl_quartos as quarto
						on quarto.id_quarto = rs.id_quarto
						inner join view_produto as vp
						on vp.id_produto = quarto.id_produto
						left join view_avaliacoes as view_ava
						on view_ava.id_produto = vp.id_produto
						where rs.id_quarto not in (select id_quarto from tbl_reserva where('$data_in_banco' between dt_entrada and dt_saida) or ('$data_out_banco' between dt_entrada and dt_saida))
							and vp.estado LIKE '%$localizacao%';");
		
		if(mysqli_num_rows($sql_code) > 0){
			
			$lista = [];
			
			while($dados = $sql_code->fetch_array()){
				$obj = array("id_produto" => $dados['id_produto'], 
				"img_produto_busca" => $dados['foto_principal'],
				"nome_produto_busca" => $dados['nome_fantasia'],
				"local_produto_busca" => ($dados['cidade'] . " - " .$dados['estado']. " , " .$dados['pais']),
				"nota_produto_busca" => number_format ($dados['media_geral'], 1, "." , "."),
				"preco_produto_busca" => "R$ ". number_format($dados['preco_diaria'], 2, "," , "."),
				);
				$lista[] = $obj;
			}
			
			echo json_encode($lista);
				
		} else {
			echo ("Erro");
			
		}
		
	}
	
	
	
	
 ?>