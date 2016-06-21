<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<shiro:hasPermission name="sgam.configuracoes.usuario.consultar">
<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/css/plugins/dataTables/datatables.min.css" rel="stylesheet">

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
                 <strong>Usuário</strong>
             </li>

			<shiro:hasPermission name="sgam.configuracoes.usuario.incluir">
				<div class="pull-right">
	            	<a class="label label-primary labelButton" href="${linkTo[UsuarioController].formularioUsuario}">Novo</a>
	            </div>
			</shiro:hasPermission>
         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
		<div class="col-lg-12">
        	<div class="ibox-content">
        		<div class="table-responsive">
					<table id="tableListagemUsuarios" class="table table-striped table-bordered table-hover"> 
						<thead>
							<tr>
								<th>Login</th>
								<th>Nome</th>
								<th>Email</th>
								<th>Telefone</th>
								<th>Opções</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="usuario" items="${usuarios}">
								<tr class="linhaUsuario">
									<td>${usuario.login}</td>
									<td>${usuario.nome}</td>
									<td>${usuario.email}</td>
									<td>${usuario.telefone}</td>
									<td style="text-align: center; margin: 20px 0; padding: 10px;"> 
										<shiro:hasPermission name="sgam.configuracoes.usuario.editar">
										<a title="Editar" class="editar" href="${linkTo[UsuarioController].editarUsuario(usuario.id)}"> <i class="fa fa-edit iconeDataTable"></i> </a> &nbsp;
										</shiro:hasPermission>
										
										<shiro:hasPermission name="sgam.configuracoes.usuario.excluir"> 
										<a title="Excluir" class="remover" href="${linkTo[UsuarioController].removerUsuario(usuario.id)}"> <i class="fa fa-trash-o iconeDataTable"></i> </a>
										</shiro:hasPermission> 
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
	    </div>            
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/plugins/dataTables/datatables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/paginas/usuario/listagemUsuario.js"></script>

﻿<%@ include file="/footer.jsp" %>

</shiro:hasPermission>

<shiro:lacksPermission name="sgam.configuracoes.usuario.consultar">
	<jsp:include page="/semPermissaoAcesso.jsp" flush="true"/>
</shiro:lacksPermission>