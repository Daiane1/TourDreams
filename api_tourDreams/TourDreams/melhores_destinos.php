<?php

session_start();

include("conexao_banco.php");

if(isset($_POST['btnRegistrar_parceiro']))
{
  $empresa = $_POST['empresa'];
  $nome_parceiro = $_POST['nome_parceiro'];
  $cnpj = $_POST['cnpj'];
  $senha = $_POST['senha'];
  $gerente = $_POST['gerente'];
  $telefone = $_POST['telefone'];
  $celular = $_POST['celular'];
  $email = $_POST['email'];



  $sql="insert into tbl_parceiros(nome_empresa, nome_fantasia, cnpj, senha, nome_gerente, telefone, celular, email)";
  $sql=$sql."values('".$empresa."', '".$nome_parceiro."', '".$cnpj."', '".$senha."', '".$gerente."', '".$celular."', '".$telefone."', '".$email."')";
  mysql_query($sql);

	$id_parceiro=mysql_insert_id();

	$sql = "SELECT * FROM tbl_parceiros where id_parceiro='".$id_parceiro."'";
	$sqlResult = mysql_query($sql);

  if($consulta=mysql_fetch_array($sqlResult)){
		$id = $consulta['id_parceiro'];
		$nome_empresa = $consulta['nome_empresa'];
		header("location:Parceiro/cadastro_parceiro.php?nome_empresa=".$nome_empresa."&id_parceiro=".$id);
	}
}

 ?>

<?php


	if(isset($_POST['btn_logar_parceiro']))
	{
		$cnpj=$_POST['cnpj'];
		$senha=$_POST['senha'];


		include("conexao_banco.php");

		$sql = "SELECT * FROM tbl_parceiros where cnpj = '".$cnpj."' AND senha= '".$senha."'";
		$sqlResult = mysql_query($sql);

		if(mysql_num_rows ($sqlResult) > 0){
			$_SESSION['cnpj'] = $cnpj;
			$_SESSION['senha'] = $senha;

			if($consulta=mysql_fetch_array($sqlResult)){
				header("location:Parceiro/index.php");
			}

		}else{
			echo "<script type='text/javascript'>
			window.alert('Login ou Senha inválidos')
			</script>";
		}
	}
?>

<?php
		$cor = "#fff";
		$sql = "select * from tbl_cores";
		$select = mysql_query($sql);
		if($rsConsulta=mysql_fetch_array($select)){
			$cores=$rsConsulta['cores'];
		}
?>

<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>TourDreams | Destinos</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link  rel='stylesheet' type='text/css'>



        <link rel="stylesheet" href="assets/css/normalize.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/fontello.css">
        <link href="assets/fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
        <link href="assets/fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
        <link href="assets/css/animate.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" href="assets/css/bootstrap-select.min.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/icheck.min_all.css">
        <link rel="stylesheet" href="assets/css/price-range.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.css">
        <link rel="stylesheet" href="assets/css/owl.theme.css">
        <link rel="stylesheet" href="assets/css/owl.transitions.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/responsive.css">

	<style type="text/css">
		.header-connect{
			padding-top: 10px;
			background-color:<?php switch ($cores) {case "": echo $cor;break; default: echo $cores;break;}?>;
		}
	</style>

    </head>
    <body>



        <div class="header-connect">
            <div class="container">
                <div class="row">
                    <div class="col-md-5 col-sm-8  col-xs-12">
                        <div class="header-half header-call">
                            <p>
                                <span><i class="pe-7s-call"></i> (11) 4222-2020</span>
                                <span><i class="pe-7s-mail"></i> tour_dreams@tour.com</span>
                            </p>
                        </div>
                    </div>
                    <div class="col-md-2 col-md-offset-5  col-sm-3 col-sm-offset-1  col-xs-12">
                        <div class="header-half header-social">
                            <ul class="list-inline">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <?php
        @$id_cliente = $_GET['id_cliente'];

      	 if ($id_cliente) {
      	   include('menu_logado.php');
      	 }else {
           include('menu_nLogado.php');
         }
        ?>


        <div class="properties-area recent-property" style="background-color: #FFF;">
            <div class="container">
                <div class="row">

                <div class="col-md-3 p0 padding-top-40">
                    <div class="blog-asside-right pr0">
                        <div class="panel panel-default sidebar-menu wow fadeInRight animated" >
                            <div class="panel-heading">
                                <h3 class="panel-title">Filtrar</h3>
                            </div>
                            <div class="panel-body search-widget">
                                <form action="" class=" form-inline">
                                    <fieldset>
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <input type="text" class="form-control" placeholder="País ou Estado">
                                            </div>
                                        </div>
                                    </fieldset>


									 <fieldset>
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <input type="text" class="form-control" placeholder="Cidade">
                                            </div>
                                        </div>
                                    </fieldset>


									<div class="panel-heading">
										<h3 class="panel-title">Características</h3>
									</div>




                                    <fieldset class="padding-5">
                                        <div class="row">
											<?php
											$sql = "select * from tbl_caracteristicas where id_caracteristicas > 0";
											$select = mysql_query($sql) or die (mysql_error());
											while($rs = mysql_fetch_array($select)){
												$sql = '';
												$sql .= ' IN ("' . implode('","', $rs) . '")';
											?>
                                            <div class="col-xs-6">
                                                <div class="checkbox">
                                                    <label><input type="checkbox" value="<?php echo $rs['id_caracteristicas'];?>"> <?php echo $rs['nome_caracteristica'];?></label>
                                                </div>
                                            </div>
											<?php
												}
											?>
                                        </div>
                                    </fieldset>









									<div class="panel-heading">
										<h3 class="panel-title">Preço Desejado</h3>
									</div>

									<div class="form-group">
										<select id="basic" class="selectpicker show-tick form-control">
											<option>R$25,00 - R$100,99</option>
											<option>R$101,00 - R$150,99</option>
											<option>R$151,00 - R$200,99</option>
											<option>R$201,00 - R$250,99</option>
										</select>
									</div>



									<div class="panel-heading">
										<h3 class="panel-title">Estilo de Viagem</h3>
									</div>

									<div class="form-group">
										<select id="basic" class="selectpicker show-tick form-control" name="selectViagem">
												<?php
												$sql = "select * from tbl_tipo_viagem a where id_tipo_viagem > 0";

												if($nome_tipo_viagem != ''){
													$sql = $sql . " and id_tipo_viagem !=".$id_tipo_viagem;
													?>
													<option value="<?php echo($id_tipo_viagem);?>"><?php echo($nome_tipo_viagem);?></option>
												<?php }?>


												<?php
													$select = mysql_query($sql);
													while($rs = mysql_fetch_array($select)){
												?>
													<option value="<?php echo($rs['id_tipo_viagem']);?>"><?php echo($rs['nome_tipo_viagem']);?></option>
												<?php
													}
												?>
										</select>
									</div>


									<div class="panel-heading">
										<h3 class="panel-title">Hospedagem Desejado</h3>
									</div>

									<div class="form-group">
										<select id="basic" class="selectpicker show-tick form-control" name="selectHospedagem">
											<?php
											$sql = "select * from tbl_estilo_produto where id_estilo_produto > 0";

											if($nome_estilo_produto != ''){
												$sql = $sql . " and id_estilo_produto !=".$id_estilo_produto;
												?>
												<option value="<?php echo($id_estilo_produto);?>"><?php echo($nome_estilo_produto);?></option>
											<?php }?>


											<?php
												$select = mysql_query($sql);
												while($rs = mysql_fetch_array($select)){
											?>
												<option value="<?php echo($rs['id_estilo_produto']);?>"><?php echo($rs['nome_estilo_produto']);?></option>
											<?php
												}
											?>
										</select>
									</div>

                                    <fieldset>
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <input class="button btn largesearch-btn" value="Filtrar" type="submit" name="btn_filtrar">
                                            </div>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-9  pr0 padding-top-40 properties-page">
                    <div class="col-md-12 clear">
                        <div id="list-type" class="proerty-th">

						<?php
						@$estado = (string)$_GET['estado'];
						@$cidade = (string)$_GET['cidade'];
						@$selectHospedagem = (int)$_GET['selectHospedagem'];
						@$selectViagem = (int)$_GET['selectViagem'];

						$sql = "select * from view_produto where status = 'Aprovado'";

						if($estado !=''){
							$sql = $sql . "and estado LIKE'%$estado%'";
						}

						if($cidade !=''){
							$sql = $sql . "and cidade LIKE'%$cidade%'";
						}

						if($selectHospedagem !=''){
							$sql = $sql . "and id_estilo LIKE '%$selectHospedagem%'";
						}

						if($selectViagem !=''){
							$sql = $sql . "and id_tipo LIKE '%$selectViagem%'";
						}

						$select = mysql_query($sql) or die (mysql_error());



						while($rs = mysql_fetch_array($select)){
							$preco_diaria=$rs['preco_diaria'];
						?>
                            <div class="col-sm-6 col-md-4 p0">
                                    <div class="box-two proerty-item">
                                        <div class="item-thumb">
                                            <a href="detalhes_produto.php?id_produto=<?php echo $rs['id_produto'];?>"><?php echo "<img src='Parceiro/Arquivos/".$rs['foto_principal']."'>"?></a>
                                        </div>

                                        <div class="item-entry overflow">
											<h5><a href="detalhes_produto.php?id_produto=<?php echo $rs['id_produto'];?>" ><?php echo($rs['nome_fantasia']);?></a></h5>
											<div class="dot-hr"></div>
											<span class="pull-left"><i class="fa fa-binoculars"></i>  <b>Milhas :</b> <?php echo($rs['qtd_milhas']);?> </span>
											<span class="proerty-price pull-right">R$ <?php echo number_format($preco_diaria, 2, ',', '');?></span>
										</div>

										<div class="vote">
											<label>
												<input  name="fb" value="1" />
												<i class="fa"></i>
											</label>
											<label>
												<input name="fb" value="2" />
												<i class="fa"></i>
											</label>
											<label>
												<input  name="fb" value="3" />
												<i class="fa"></i>
											</label>
											<label>
												<input  name="fb" value="4" />
												<i class="fa"></i>
											</label>
											<label>
												<input name="fb" value="5" />
												<i class="fa"></i>
											</label>
										</div>
                                    </div>
                            </div>
							<?php
								}

							?>
                        </div>
                    </div>


                </div>
                </div>
            </div>
        </div>

        <?php
          @$id_cliente = $_GET['id_cliente'];

           if ($id_cliente) {
             include('rodape_logado.php');
           }else {
             include('rodape_nLogado.php');
           }
        ?>

      <script src="assets/js/modernizr-2.6.2.min.js"></script>
        <script src="assets/js/jquery-1.10.2.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/bootstrap-select.min.js"></script>
        <script src="assets/js/bootstrap-hover-dropdown.js"></script>
        <script src="assets/js/easypiechart.min.js"></script>
        <script src="assets/js/jquery.easypiechart.min.js"></script>
        <script src="assets/js/owl.carousel.min.js"></script>
        <script src="assets/js/wow.js"></script>
        <script src="assets/js/icheck.min.js"></script>
        <script src="assets/js/price-range.js"></script>
        <script src="assets/js/main.js"></script>


        <script>
      		function mascaraCelular(o,f){
      		v_obj=o
      		v_fun=f
      		setTimeout("execmascara()",1)
      		}
      		function execmascara(){
      			v_obj.value=v_fun(v_obj.value)
      		}
      		function mtel(v){
      			v=v.replace(/\D/g,"");
      			v=v.replace(/^(\d{2})(\d)/g,"($1) $2");
      			v=v.replace(/(\d)(\d{4})$/,"$1-$2");
      			return v;
      		}

      		</script>
    </body>
</html>
