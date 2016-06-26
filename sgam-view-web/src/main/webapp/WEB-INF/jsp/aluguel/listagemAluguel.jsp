<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<shiro:hasPermission name="sgam.faturamento.aluguel.consultar">
<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/css/plugins/dataTables/datatables.min.css" rel="stylesheet">

<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Faturamento</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Faturamento</span>
             </li>
             <li class="active">
                 <strong>Reserva de espaços</strong>
             </li>

			<shiro:hasPermission name="sgam.faturamento.aluguel.incluir">
				<div class="pull-right">
	            	<a class="label label-primary labelButton" href="${linkTo[AluguelController].formularioAluguel}">Novo</a>
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
					<table id="tableListagemAluguel" class="table table-striped table-bordered table-hover"> 
						<thead>
							<tr>
								<th>Morador</th>
								<th>Recurso</th>
								<th>Início</th>
								<th>Fim</th>
								<th>Horário</th>
								<th>Conta</th>								
								<th>Opções</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="aluguel" items="${aluguelList}">
								<tr class="linhaAluguel">
									<td>${aluguel.morador.nome}</td>
									<td>${aluguel.recurso.nome}</td>
									<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${aluguel.dataInicial}" /> </td>
									<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${aluguel.dataFinal}" /> </td>
									<td> <fmt:formatDate pattern="HH:mm" value="${aluguel.dataInicial}" /> - <fmt:formatDate pattern="HH:mm" value="${aluguel.dataFinal}" /> </td>
									
									<shiro:hasPermission name="sgam.financeiro.contas_receber.editar">
										<td> <a onclick="marcarMenuAtivo('menuFinanceiro', 'submenuContasReceber', 'collapseFinanceiro')" title="Link para acessar a respectiva conta a receber" class="editar" href="${linkTo[ContasReceberController].editarConta(aluguel.contaReceber.id)}"> Conta </a> </td>
									</shiro:hasPermission>
									<shiro:lacksPermission name="sgam.financeiro.contas_receber.editar">
										<td style="text-align: center; margin: 20px 0; padding: 10px;"> - </td>
									</shiro:lacksPermission>

									<td style="text-align: center; margin: 20px 0; padding: 10px;"> 
										<shiro:hasPermission name="sgam.faturamento.aluguel.editar">
											<a title="Editar" class="editar" href="${linkTo[AluguelController].editarAluguel(aluguel.id)}"> <i class="fa fa-edit iconeDataTable"></i> </a> &nbsp;
										</shiro:hasPermission>
										
										<shiro:hasPermission name="sgam.faturamento.aluguel.excluir"> 
											<a title="Excluir" class="remover" href="${linkTo[AluguelController].removerAluguel(aluguel.id)}"> <i class="fa fa-trash-o iconeDataTable"></i> </a>
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
<script src="${pageContext.request.contextPath}/js/paginas/aluguel/listagemAluguel.js"></script>

﻿<%@ include file="/footer.jsp" %>
</shiro:hasPermission>

<shiro:lacksPermission name="sgam.faturamento.aluguel.consultar">
	<jsp:include page="/semPermissaoAcesso.jsp" flush="true"/>
</shiro:lacksPermission>