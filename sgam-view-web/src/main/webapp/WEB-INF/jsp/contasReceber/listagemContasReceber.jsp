<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/css/plugins/dataTables/datatables.min.css" rel="stylesheet">

<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Contas a Receber</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Financeiro</span>
             </li>
             <li class="active">
                 <strong>Contas a Receber</strong>
             </li>

			<%-- <div class="pull-right">
            	<a class="label label-primary" href="${linkTo[ContasReceberController].formularioContasReceber}">Novo</a>
            </div> --%>

			<div class="pull-right">
            	<a class="label label-primary labelButton" href="${linkTo[ContasReceberController].formularioContasReceber}">Novo</a>
            </div>

	    <%-- <div class="pull-right">
            	<a class="label label-primary" href="${linkTo[ContasReceberController].formularioContasReceber}">Novo</a>
            </div> --%>

			<div class="pull-right">
            	<a class="label label-primary labelButton" href="${linkTo[ContasReceberController].formularioContasReceber}">Novo</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
		<div class="col-lg-12">
        	<div class="ibox-content">
        		<div class="table-responsive">
					<table id="tableListagemContasReceber" class="table table-striped table-bordered table-hover"> 
						<thead>
							<tr>
								<th>Número</th>
								<th>Nome</th>
								<th>Emissão</th>
								<th>Vencimento</th>
								<th>Valor</th>
								<th>Status</th>
								<th>Opções</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="conta" items="${contas}">
								<tr class="linhaContaReceber">
									<td>${conta.numero}</td>
									<td>${conta.nome}</td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataEmissao}" /></td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataVencimento}" /></td>
									<td><fmt:formatNumber value="${conta.valor}" type="currency"/></td>
									
									<c:choose>
										<c:when test="${conta.status eq 'Recebido'}">
											<td><span class="label label-primary">${conta.status}</span></td>
										</c:when>
										
										<c:when test="${conta.status eq 'Pendente'}">
											<td><span class="label label-warning">${conta.status}</span></td>
										</c:when>
										
										<c:otherwise>
											<td><span class="label label-danger">${conta.status}</span></td>
										</c:otherwise>
									</c:choose>
									
									<td style="text-align: center; margin: 20px 0; padding: 10px;"> 
										<a title="Editar" class="editar" href="${linkTo[ContasReceberController].editarConta(conta.id)}"> <i class="fa fa-edit iconeDataTable"></i> </a> &nbsp; 
										<a title="Excluir" class="remover" href="${linkTo[ContasReceberController].removeConta(conta.id)}"> <i class="fa fa-trash-o iconeDataTable"></i> </a> 
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
<script src="${pageContext.request.contextPath}/js/paginas/contasReceber/listagemContasReceber.js"></script>

﻿<%@ include file="/footer.jsp" %>
