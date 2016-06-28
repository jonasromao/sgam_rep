<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<shiro:hasPermission name="sgam.configuracoes.usuario.incluir">

<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/css/plugins/dataTables/datatables.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">

<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Usuários</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Configurações</span>
             </li>
             <li class="active">
                 <a href="${linkTo[UsuarioController].listagemUsuario}"><strong>Usuário</strong></a>
             </li>

			<div class="pull-right">
            	<a class="label label-default" href="${linkTo[UsuarioController].listagemUsuario}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
 		<form id="usuarioForm" method="post" class="form-horizontal" action="${linkTo[UsuarioController].cadastrarUsuario}">
			<div class="col-lg-6">
		        <div class="ibox-content">
	         		<input id="idUsuario" type="hidden" name="usuario.id" value="${usuario.id }"/>
	         	
	             	<div class="form-group">
	             		<label class="col-sm-4 control-label">Nome</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="usuario.nome" value="${usuario.nome}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Cargo</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="usuario.cargo" value="${usuario.cargo}">
	                    </div>
	                </div>

	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Email</label>
	                    <div class="col-sm-8">
	                    	<input type="email" class="form-control" name="usuario.email" value="${usuario.email}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Celular</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="usuario.telefone" value="${usuario.telefone}" data-mask="99999-9999">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Login</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="usuario.login" value="${usuario.login}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Senha</label>
	                    <div class="col-sm-8">
	                    	<input id="senha" type="password" class="form-control" name="usuario.senha" value="" >
	                    </div>
	                </div>
				</div>
				
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox-content">
							<div class="form-group">
			                    <div class="col-sm-12">
			                        <a class="btn btn-outline btn-default" href="${linkTo[UsuarioController].listagemUsuario}"> Cancelar</a>
			                        <button id="btnSalvarUsuario" class="btn btn-primary" type="submit"> <i class="fa fa-check"></i> Salvar</button>
			                    </div>
			                </div>			
						</div>
					</div>
				</div>	
				
				<ul class="errors">
					<c:forEach items="${errors}" var="error">
						<li>
							${error.category}: ${error.message}
						</li>
					</c:forEach>
				</ul>

		    </div> 

			<div class="col-lg-6">
			    <div class="ibox-content">
					<fieldset>
	    				<legend>Perfil</legend>
	    				
        				<table id="tabelaPerfil" class="table table-condensed table-hover">
							<thead>
	                			<tr>
	                				<th>
		                				<div class="checkbox checkbox-success">
	                               			<input id="checkboxAll" type="checkbox">
	                 						<label for="checkboxAll"></label>
	                           			</div>
	                				</th>
	                    			<th>Perfil</th>
	                			</tr>
                			</thead>
                			<tbody>
	                			<c:forEach items="${listaPerfis}" var="perfil">
									<tr>
										<td>
											<div class="checkbox checkbox-success">
                                    			<input type="checkbox" class="marcar" name="usuario.perfis" id="${perfil.id}" value="${perfil.id}">
                                    			<label for="${perfil.id}"></label>
                                			</div>
										</td>

										<td>
											${perfil.nome}
										</td>
									</tr>
			 					</c:forEach>
                			</tbody>
						</table>
	    			</fieldset>
		    	</div>
			</div>
			
			<br/>
			
			

	   	</form>         
    </div>
</div>

<c:forEach items="${usuario.perfis}" var="perfil">
	<input type="hidden" class="perfisMarcados" value="${perfil.id}" />
</c:forEach>

<script src="${pageContext.request.contextPath}/js/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-validation-messages.js"></script>

<script src="${pageContext.request.contextPath}/js/plugins/jasny/jasny-bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/dataTables/datatables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/paginas/usuario/formularioUsuario.js"></script>

﻿<%@include file="/footer.jsp" %>

</shiro:hasPermission>

<shiro:lacksPermission name="sgam.configuracoes.usuario.incluir">
	<jsp:include page="/semPermissaoAcesso.jsp" flush="true"/>
</shiro:lacksPermission>
