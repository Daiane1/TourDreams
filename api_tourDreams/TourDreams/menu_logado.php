<?php
		$cor = "#fff";
		$sql = "select * from tbl_cores";
		$select = mysql_query($sql);
		if($rsConsulta=mysql_fetch_array($select)){
			$cores=$rsConsulta['cores'];
		}
?>


<nav class="navbar navbar-default ">
    <div class="container">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.php?id_cliente=<?php echo$_GET['id_cliente'];?>&nome_cliente=<?php echo$_GET['nome_cliente'];?>"><img src="assets/img/logo_tourdreams.png" alt=""></a>
        </div>


        <div class="collapse navbar-collapse yamm" id="navigation">
            <div class="button navbar-right">
                 <a class="" href="perfil.php?id_cliente=<?php echo$_GET['id_cliente'];?>&nome_cliente=<?php echo$_GET['nome_cliente'];?>"><button class="navbar-btn nav-button wow bounceInRight login" data-wow-delay="0.45s">Meu Perfil</button></a>
				 <a class="" href="index.php"><button class="navbar-btn nav-button wow bounceInRight login" data-wow-delay="0.45s">Logout</button></a>
			</div>
            <ul class="main-nav nav navbar-nav navbar-right">
    <li class="dropdown ymm-sw " data-wow-delay="0.1s">
                    <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="index.php?id_cliente=<?php echo$_GET['id_cliente'];?>&nome_cliente=<?php echo$_GET['nome_cliente'];?>">Home</a></li>
                </li>
    <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="melhores_destinos.php?id_cliente=<?php echo$_GET['id_cliente'];?>&nome_cliente=<?php echo$_GET['nome_cliente'];?>">Destinos</a></li>
    <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="blog.php?id_cliente=<?php echo$_GET['id_cliente'];?>&nome_cliente=<?php echo$_GET['nome_cliente'];?>">Blog</a></li>
                <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="fale_conosco.php?id_cliente=<?php echo$_GET['id_cliente'];?>&nome_cliente=<?php echo$_GET['nome_cliente'];?>">Fale Conosco</a></li>
    <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="sobre.php?id_cliente=<?php echo$_GET['id_cliente'];?>&nome_cliente=<?php echo$_GET['nome_cliente'];?>">Sobre</a></li>
    <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="promocao.php?id_cliente=<?php echo$_GET['id_cliente'];?>&nome_cliente=<?php echo$_GET['nome_cliente'];?>">Promoções</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title" id="myModalLabel">Seja nosso Parceiro</h4>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-8" style="border-right: 1px dotted #C2C2C2;padding-right: 30px;">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#Login" data-toggle="tab">Parceiro</a></li>
              <li><a href="#Registration" data-toggle="tab">Registrar</a></li>
            </ul>
            <div class="tab-content">
              <div class="tab-pane active" id="Login">
                <form role="form" class="form-horizontal" method="post" action="index.php">
                <div class="form-group">
                  <label for="email" class="col-sm-2 control-label">
                    CNPJ</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="email1" placeholder="CNPJ" maxlength="8" name="cnpj" />
                  </div>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1" class="col-sm-2 control-label">Senha</label>
                  <div class="col-sm-10">
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Senha" name="senha" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-2">
                  </div>
                  <div class="col-sm-10">
                    <button name="btn_logar_parceiro" type="submit" class="btn btn-primary btn-sm">Logar como Parceiro</button>
                  </div>
                </div>
                </form>
              </div>

              <div class="tab-pane" id="Registration">
                <form method="post" role="form" class="form-horizontal" action="index.php">
                <div class="form-group">
                  <label for="email" class="col-sm-2 control-label">Empresa</label>
                  <div class="col-sm-10">
                    <input name="empresa" type="text" class="form-control" id="email" placeholder="Empresa" />
                  </div>
                </div>
                <div class="form-group">
                  <label for="email" class="col-sm-2 control-label">Nome</label>
                  <div class="col-sm-10">
                    <input name="nome_parceiro" type="text" class="form-control" id="email" placeholder="Nome Fantasia" />
                  </div>
                </div>
                <div class="form-group">
                  <label for="mobile" class="col-sm-2 control-label">CNPJ</label>
                  <div class="col-sm-10">
                    <input name="cnpj" type="text" class="form-control" id="mobile" placeholder="CNPJ da empresa" maxlength="8"/>
                  </div>
                </div>
                <div class="form-group">
                  <label for="password" class="col-sm-2 control-label">Senha</label>
                  <div class="col-sm-10">
                    <input name="senha" type="password" class="form-control" id="password" placeholder="Senha de acesso" />
                  </div>
                </div>
                <div class="form-group">
                  <label for="password" class="col-sm-2 control-label">Gerente</label>
                  <div class="col-sm-10">
                    <input name="gerente" type="text" class="form-control" id="password" placeholder="Gerente do hotel/pousada/resort"/>
                  </div>
                </div>
                <div class="form-group">
                  <label for="password" class="col-sm-2 control-label">Celular</label>
                  <div class="col-sm-10">
                    <input name="celular" type="text" class="form-control" id="password" onkeyup="mascaraCelular( this, mtel );" placeholder="Celular do gerente" maxlength="15" />
                  </div>
                </div>
                <div class="form-group">
                  <label for="password" class="col-sm-2 control-label">Telefone</label>
                  <div class="col-sm-10">
                    <input name="telefone" type="text" class="form-control" onkeyup="mascaraCelular( this, mtel );"  id="password" placeholder="Telefone da empresa" maxlength="14" />
                  </div>
                </div>
                <div class="form-group">
                  <label for="password" class="col-sm-2 control-label">Email</label>
                  <div class="col-sm-10">
                    <input name="email" type="email" class="form-control" id="password" placeholder="Email do gerente" />
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-2">
                  </div>
                  <div class="col-sm-10">
                    <button name="btnRegistrar_parceiro" type="submit" class="btn btn-primary btn-sm">Quero ser um parceiro</button>
                  </div>
                </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
