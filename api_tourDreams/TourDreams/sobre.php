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
        <title>TourDreams | Sobre</title>

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



		<div class="row">
			<div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
                <h2>A nossa história  </h2>
            </div>
        </div>

		<div class="content-area blog-page padding-top-40" style="background-color: #FFF; padding-bottom: 55px;">
            <div class="container">
                <div class="row">
                    <div class="blog-lst col-md-12 pl0">

						<?php
							$sql = "select * from tbl_sobre";
							$select = mysql_query($sql);
							while($rs = mysql_fetch_array($select)){
						?>

                        <section class="post">

                            <div class="image wow fadeInLeft animated">
                                <a href="#">
									 <?php echo "<img src='CMS/Arquivos/".$rs['foto_descricao']."'>"?>
                                </a>
                            </div>
                            <p class="intro"><?php echo($rs['descricao']);?></p>
						</section>
						<?php
							}
						?>
                    </div>
                </div>

            </div>
        </div>

			<div class="row">
				<div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
					<h2>Comentários dos nossos funcionários  </h2>
				</div>
			</div>

				<div class="container">
					<div class="row">
										<div class="col-md-12" data-wow-delay="0.2s">
											<div class="carousel slide" data-ride="carousel" id="quote-carousel">
												<!-- Bottom Carousel Indicators -->
												<ol class="carousel-indicators">
													<li data-target="#quote-carousel" data-slide-to="0" class="active"><img class="img-responsive " src="blog.jpg" alt="">
													</li>
													<li data-target="#quote-carousel" data-slide-to="1"><img class="img-responsive" src="blog.jpg" alt="">
													</li>
													<li data-target="#quote-carousel" data-slide-to="2"><img class="img-responsive" src="blog.jpg" alt="">
													</li>
												</ol>

												<!-- Carousel Slides / Quotes -->
												<div class="carousel-inner text-center">

													<!-- Quote 1 -->
													<div class="item active">
														<blockquote>
															<div class="row">
																<div class="col-sm-8 col-sm-offset-2">

																	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. !</p>
																	<small>Funcionaria</small>
																</div>
															</div>
														</blockquote>
													</div>
													<!-- Quote 2 -->
													<div class="item">
														<blockquote>
															<div class="row">
																<div class="col-sm-8 col-sm-offset-2">

																	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. </p>
																	<small>Funcionaria</small>
																</div>
															</div>
														</blockquote>
													</div>
													<!-- Quote 3 -->
													<div class="item">
														<blockquote>
															<div class="row">
																<div class="col-sm-8 col-sm-offset-2">

																	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. .</p>
																	<small>Funcionaria</small>
																</div>
															</div>
														</blockquote>
													</div>
												</div>

												<!-- Carousel Buttons Next/Prev -->
												<a data-slide="prev" href="#quote-carousel" class="left carousel-control"><i class="fa fa-chevron-left"></i></a>
												<a data-slide="next" href="#quote-carousel" class="right carousel-control"><i class="fa fa-chevron-right"></i></a>
											</div>
										</div>
					</div>
				</div>


		<div class="count-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
                        <h2>O Sucesso da TourDreams </h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 col-xs-12 percent-blocks m-main" data-waypoint-scroll="true">
                        <div class="row">
                            <div class="col-sm-3 col-xs-6">
                                <div class="count-item">
                                    <div class="count-item-circle">
                                        <span class="pe-7s-users"></span>
                                    </div>
                                    <div class="chart" data-percent="5000">
                                        <h2 class="percent" id="counter">0</h2>
                                        <h5>Clientes </h5>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 col-xs-6">
                                <div class="count-item">
                                    <div class="count-item-circle">
                                        <span class="pe-7s-home"></span>
                                    </div>
                                    <div class="chart" data-percent="12000">
                                        <h2 class="percent" id="counter1">0</h2>
                                        <h5>Produtos</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 col-xs-6">
                                <div class="count-item">
                                    <div class="count-item-circle">
                                        <span class="pe-7s-flag"></span>
                                    </div>
                                    <div class="chart" data-percent="120">
                                        <h2 class="percent" id="counter2">0</h2>
                                        <h5>Cidades </h5>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 col-xs-6">
                                <div class="count-item">
                                    <div class="count-item-circle">
                                        <span class="pe-7s-graph2"></span>
                                    </div>
                                    <div class="chart" data-percent="5000">
                                        <h2 class="percent"  id="counter3">5000</h2>
                                        <h5>Reservas</h5>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

		<div class="row">
            <div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
                <h2>Parceiros </h2>
            </div>
        </div>

		<div class="container">
			<div class="col-xs-12">
				<div class="carousel slide" id="myCarousel">
					<div class="carousel-inner">
						<div class="item active">
								<ul class="thumbnails">
								<?php
									$sql = "select * from tbl_parceiros";
									$select = mysql_query($sql);
									while($rs = mysql_fetch_array($select)){
								?>
									<li class="col-sm-3">
										<div class="fff">
											<div class="thumbnail">
												<a href="#"><?php echo "<img src='Parceiro/Arquivos/".$rs['logo_parceiro']."'>"?></a>
											</div>
										</div>
									</li>
									<?php
										}
									?>
								</ul>
						</div>
					</div>


					<nav>
						<ul class="control-box pager">
							<li><a data-slide="prev" href="#myCarousel" class=""><i class="glyphicon glyphicon-chevron-left"></i></a></li>
							<li><a data-slide="next" href="#myCarousel" class=""><i class="glyphicon glyphicon-chevron-right"></i></li>
						</ul>
					</nav>
				</div>

			</div>

		</div>


















        <!-- Footer area-->
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

    </body>




</html>
