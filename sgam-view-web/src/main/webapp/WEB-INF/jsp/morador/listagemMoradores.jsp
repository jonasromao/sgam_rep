<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<shiro:hasPermission name="sgam.cadastros.morador.consultar">

<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/css/plugins/dataTables/datatables.min.css" rel="stylesheet">

<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Moradores</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Cadastros</span>
             </li>
             <li class="active">
                 <strong>Moradores</strong>
             </li>
			
			<shiro:hasPermission name="sgam.cadastros.morador.incluir">
				<div class="pull-right">
	            	<a class="label label-primary labelButton" href="${linkTo[MoradorController].formularioMorador}">Novo</a>
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
					<table id="tableListagemMoradores" class="table table-striped table-bordered table-hover"> 
						<thead>
							<tr>
								<th>Nome</th>
								<th>Celular</th>
								<th>Cidade</th>
								<th>Bairro</th>
								<th>Rua</th>
								<th>Associado?</th>
								<th>Opções</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="morador" items="${moradores}">
								<tr class="linhaMorador">
									<td>${morador.nome}</td>
									<td>${morador.telefoneCelular}</td>
									<td>${morador.endereco.cidade}</td>
									<td>${morador.endereco.bairro}</td>
									<td>${morador.endereco.rua}</td>
									
									<c:choose>
										<c:when test="${morador.associado eq 'Não'}">
											<td><span class="label label-danger">${morador.associado}</span></td>
										</c:when>
										
										<c:otherwise>
											<td><span class="label label-primary">${morador.associado}</span></td>
										</c:otherwise>
									</c:choose>
									
									<td style="text-align: center; margin: 20px 0; padding: 10px;"> 
										<shiro:hasPermission name="sgam.cadastros.morador.editar">
											<a title="Editar" class="editar" href="${linkTo[MoradorController].editarMorador(morador.id)}"> <i class="fa fa-edit iconeDataTable"></i> </a> &nbsp;
										</shiro:hasPermission>
										
										<shiro:hasPermission name="sgam.cadastros.morador.excluir">
											<a title="Excluir" class="remover" href="${linkTo[MoradorController].removeMorador(morador.id)}"> <i class="fa fa-trash-o iconeDataTable"></i> </a>
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
<script src="${pageContext.request.contextPath}/js/paginas/morador/listagemMoradores.js"></script>

﻿<%@ include file="/footer.jsp" %>

</shiro:hasPermission>

<shiro:lacksPermission name="sgam.cadastros.morador.consultar">
	<jsp:include page="/semPermissaoAcesso.jsp" flush="true"/>
</shiro:lacksPermission>