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
        <title>TourDreams | Detalhes</title>


        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel='stylesheet' type='text/css'>



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
        <link rel="stylesheet" href="assets/css/lightslider.min.css">
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
      	   include('menu.php');
        ?>



        <div class="content-area single-property" style="background-color: #FFF;">&nbsp;
            <div class="container">

            <div class="clearfix padding-top-40" >

                <div class="col-md-8 single-property-content prp-style-2">
                        <div class="">
                            <div class="row">
                                <div class="light-slide-item">
                                    <div class="clearfix">
                                        <ul id="image-gallery" class="gallery list-unstyled cS-hidden">
										<?php
										if (isset ($_GET['id_produto'])) {
												$id_produto = (int)$_GET['id_produto'];
												$sql = "select * from view_fotos_produtos where id_produto =".$id_produto;
												$select = mysql_query($sql);
												while($rs = mysql_fetch_array($select)){

										?>
											<?php echo "<li data-thumb='Parceiro/Arquivos/".$rs['foto_detalhes']."'>"?>
                                                <?php echo "<img src='Parceiro/Arquivos/".$rs['foto_detalhes']."'>"?>
                                            </li>
										<?php
											}
										}
										?>
                                        </ul>
                                    </div>
                                </div>
                            </div>

						<div class="single-property-wrapper">
                            <div class="single-property-header">
                                <h1 class="property-title pull-left">Características</h1>
                            </div>

                            <div class="property-meta entry-meta clearfix ">

								<?php
								if (isset ($_GET['id_produto'])) {
									$id_produto = (int)$_GET['id_produto'];
									$sql = "select * from view_caracteristica where id_produto =".$id_produto;
									$select = mysql_query($sql);
									while($rs = mysql_fetch_array($select)){
								?>
                                <div class="col-xs-3 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-garage">
                                        <i class="fa <?php echo($rs['foto_caracteristica']);?>"></i>
                                    </span>
                                    <span class="property-info-entry">
                                        <span class="property-info-label"><?php echo($rs['nome_caracteristica']);?></span>
                                    </span>
                                </div>
								<?php
									}
								}
								?>


                            </div>

                            <div class="single-property-wrapper">

                                <div class="section">
                                    <h4 class="s-property-title">Descrição</h4>
									<?php
									if (isset ($_GET['id_produto'])) {
										$id_produto = (int)$_GET['id_produto'];
										$sql = "select * from view_produto where id_produto =".$id_produto;
										$select = mysql_query($sql);
										while($rs = mysql_fetch_array($select)){
									?>
                                    <div class="s-property-content">
                                        <p><?php echo($rs['descricao_produto']);?></p>
                                    </div>
									<?php
										}
									}
									?>
                                </div>


                            </div>



                        </div>


						<section id="comments" class="comments wow fadeInRight animated">
                            <h4 class="text-uppercase wow fadeInLeft animated">2 Comentários</h4>


                            <div class="row comment">
                                <div class="col-sm-3 col-md-2 text-center-xs">
                                    <p>
                                        <img src="assets/img/client-face1.png" class="img-responsive img-circle" alt="">
                                    </p>
                                </div>
                                <div class="col-sm-9 col-md-10">
                                    <h5 class="text-uppercase">Nome Pessoa</h5>
                                    <p class="posted"><i class="fa fa-clock-o"></i> 31 de Agosto de 2017 às 14:30</p>
                                    <p>Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos.</p>
                                </div>
                            </div>



                            <div class="row comment last">

                                <div class="col-sm-3 col-md-2 text-center-xs">
                                    <p>
                                        <img src="assets/img/client-face1.png" class="img-responsive img-circle" alt="">
                                    </p>
                                </div>

                                <div class="col-sm-9 col-md-10">
                                   <h5 class="text-uppercase">Nome Pessoa</h5>
                                    <p class="posted"><i class="fa fa-clock-o"></i> 31 de Agosto de 2017 às 14:30</p>
                                    <p>Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos.</p>
                                </div>

                            </div>

                        </section>

					<div class="container">


						<h4 class="text-uppercase wow fadeInLeft animated">Quartos disponíveis</h4>
						<div class="row">
							<ul class="thumbnails">
								<?php
									if (isset ($_GET['id_produto'])) {
										$id_produto = (int)$_GET['id_produto'];
										$sql = "select * from view_quartos where id_produto =".$id_produto;
										$select = mysql_query($sql);
										while($rs = mysql_fetch_array($select)){
											$preco_diaria=$rs['preco_diaria'];
											$id_quarto=$rs['id_quarto'];
											$_SESSION['id_quarto'] = $id_quarto;
								?>
								<div class="col-md-4">
									<div class="thumbnail" id="quartos">
										<?php echo "<img class= 'img-responsive' src='Parceiro/Arquivos/".$rs['foto_quarto']."'>"?>
										<div class="caption">
											<h4><?php echo($rs['descricao_quarto']);?></h4>
										<div class="property-meta entry-meta clearfix ">
											<?php
												$sql = "select * from view_carac_quartos where id_quarto =".$_SESSION['id_quarto'];
												$select = mysql_query($sql);
												while($rs_consulta = mysql_fetch_array($select)){
											?>
											<div class="col-xs-3 col-sm-3 col-md-3 p-b-15">
												<span class="property-info-icon icon-garage">
													<i class="fa <?php echo($rs_consulta['foto_caracteristica_quarto']);?>"></i>
												</span>
												<span class="property-info-entry">
													<span class="property-info-label"><?php echo($rs_consulta['caracteristica_quarto']);?></span>
												</span>
											</div>
											<?php
												}
											?>
										</div>
											<h4 align="center">R$ <?php echo number_format($preco_diaria, 2, ',', '');?></h4>
										</div>
									</div>
								</div>
								<?php
									}
								}
								?>
							</ul>
						</div>
					</div>
                    </div>
                </div>

				<div class="col-md-4 p0">
                        <aside class="sidebar sidebar-property blog-asside-right property-style2">
                            <div class="dealer-widget">
                                <div class="dealer-content">
                                    <div class="inner-wrapper">
									<?php
									if (isset ($_GET['id_produto'])) {
										$id_produto = (int)$_GET['id_produto'];
										$sql = "select * from view_produto where id_produto =".$id_produto;
										$select = mysql_query($sql);
										while($rs = mysql_fetch_array($select)){
											$preco_diaria=$rs['preco_diaria'];
									?>
                                        <div class="single-property-header">
                                            <h1 class="property-title"><?php echo($rs['nome_fantasia']);?></h1>
                                            <span class="property-price">R$ <?php echo number_format($preco_diaria, 2, ',', '');?></span>
                                        </div>
									<?php
										}
									}
									?>
                                    </div>
                                </div>
                            </div>

						<?php
						if(isset($_POST['btn_verificar'])){
								$entrada = $_POST['entrada'];
								$saida = $_POST['saida'];
							if($saida < $entrada){
								echo "<script type='text/javascript'>
								window.alert('Datas Inválidas')
								</script>";
							}
						}
						
						?>

						<form action="detalhes_produto.php?id_produto=<?php echo $_GET['id_produto']?>&id_cliente=<?php echo $_GET['id_cliente']?>&nome_cliente=<?php echo $_GET['nome_cliente']?>#quartos" method="post">
							<div class="col-sm-6">
                                <div class="form-group">
									<i class="fa fa-calendar"></i>   <label>Entrada</label>
                                    <input type="date" class="form-control" name="entrada">
                                </div>
                            </div>


							<div class="col-sm-6">
                                <div class="form-group">
									<i class="fa fa-calendar"></i>   <label>Saída</label>
                                    <input type="date" class="form-control" name="saida">
                                </div>
                            </div>

						
							
								<div class="col-sm-12 text-center">
									<a href="">
										<button class="btn btn-primary"><i class="fa fa-paper-plane" name="btn_verificar"></i>  Verificar</button>
									</a>
								</div>
						</form>

                        </aside>
                </div>





			</div>
            </div>
        </div>

      
        <?php      	
      	   include('rodape.php');
        ?>
        <script src="assets/js/vendor/modernizr-2.6.2.min.js"></script>
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
        <script type="text/javascript" src="assets/js/lightslider.min.js"></script>
        <script src="assets/js/main.js"></script>

        <script>
                            $(document).ready(function () {

                                $('#image-gallery').lightSlider({
                                    gallery: true,
                                    item: 1,
                                    thumbItem: 9,
                                    slideMargin: 0,
                                    speed: 500,
                                    auto: true,
                                    loop: true,
                                    onSliderLoad: function () {
                                        $('#image-gallery').removeClass('cS-hidden');
                                    }
                                });
                            });
        </script>

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
