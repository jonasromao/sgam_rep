<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<shiro:hasPermission name="sgam.faturamento.aluguel.incluir:sgam.faturamento.aluguel.editar">

<%@ include file="/headerMenu.jsp" %> 
<%@ include file="/moradorModal.jsp" %>

<link href="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">


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
                 <a href="${linkTo[AluguelController].listagemAluguel}"><strong>Reserva de espaços</strong></a>
             </li>

			<div class="pull-right">
            	<a class="label label-default" href="${linkTo[AluguelController].listagemAluguel}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
 		<form id="aluguelForm" method="post" class="form-horizontal" action="${linkTo[AluguelController].cadastraAluguel}">
			<div class="col-lg-7">
		        <div class="ibox-content">
		        
	         		<input type="hidden" name="aluguel.id" value="${aluguel.id }"/>
	         		<input type="hidden" name="aluguel.dataEmissaoFaturamento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguel.dataEmissaoFaturamento}" />" />
	                
	                <div class="form-group">
	                	<label class="col-sm-4 control-label">Recurso</label>
	                    <div class="col-sm-8">
	                    	<select class="form-control m-b" name="aluguel.recurso.id">
	                         <option value="0">Selecione</option>
	                         <c:forEach items="${recursos}" var="recurso">
	                         	<option value="${recurso.id}" <c:if test="${aluguel.recurso.id == recurso.id}">selected="selected"</c:if> >${recurso.nome} </option>
	                         </c:forEach>
	                    	</select>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Período</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="hidden" id="dataHoraInicioAluguel" name="aluguel.dataHoraInicio" />
	                    		<input type="text" id="dataInicioAluguel" class="form-control" name="aluguel.dataInicial" value="<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${aluguel.dataInicial}" />"  data-mask="99/99/9999 99:99" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label"></label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="hidden" id="dataHoraFinalAluguel" name="aluguel.dataHoraFinal" />
	                    		<input type="text" id="dataFinalAluguel" class="form-control" name="aluguel.dataFinal" value="<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${aluguel.dataFinal}" />"  data-mask="99/99/9999 99:99" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group" >
	             		<label class="col-sm-4 control-label">Pagamento</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group" id="dataPagamentoAluguel">
	                    		<input type="text" class="form-control" name="aluguel.dataPagamento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguel.dataPagamento}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Observação</label>
	                    <div class="col-sm-8">
	                    	<textarea name="aluguel.observacao" class="form-control" rows="" cols="">${aluguel.observacao}</textarea>
	                    </div>
	                </div>
	                
				</div>

				<br/>
					
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox-content">
							<div class="form-group">
			                    <div class="col-sm-12">
			                        <a class="btn btn-outline btn-default" href="${linkTo[AluguelController].listagemAluguel}" > Cancelar</a>
			                        <button id="btnSalvarAluguel" class="btn btn-primary" type="submit"> <i class="fa fa-check"></i> Salvar</button>
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
		    
		    <div class="col-sm-5">

				<div class="ibox">
	            	<div class="ibox-content">
	            		<div class="form-group">
			                <div class="col-sm-12">
			                	<div class="input-group">
			                		<input id="idMoradorFaturamento" type="hidden" name="aluguel.morador.id" value="${aluguel.morador.id }"/> 
			                		<input id="nomeMoradorFaturamento" placeholder="Morador" type="text" name="aluguel.morador.nome" class="form-control" value="${aluguel.morador.nome}">
			                		<a class="input-group-addon" id="btnAbreModalMoradorFaturamento" style="cursor: pointer;"><i class="fa fa-user"></i></a>
			                	</div>
			            	</div>
			            </div>
	            		
						<div class="table-responsive">
		           	     	<table class="table table-striped table-hover">
		           	     		<tbody>
		           	     			<tr>
		           	     				<td> <i class="fa fa-envelope"> </i> </td>
		           	     				<td> <div id="txtEmailMoradorAluguel">${aluguel.morador.email}</div>  </td>
		           	     			</tr>
		           	     			
		           	     			<tr>
		           	     				<td> <i class="fa fa-mobile-phone"> </i> </td>
		           	     				<td> <div id="txtCelularMoradorAluguel">${aluguel.morador.telefoneCelular}</div>  </td>
		           	     			</tr>
		           	     			
		           	     			<tr>
		           	     				<td> <i class="fa fa-phone"> </i> </td>
		           	     				<td> <div id="txtTelefoneMoradorAluguel">${aluguel.morador.telefoneResidencial}</div> </td>
		           	     			</tr>
		           	     			
		           	     			<c:choose>
										<c:when test="${not empty aluguel.morador.endereco}">
											<tr>
				           	     				<td> <i class="fa fa-home"> </i> </td>
				           	     				<td> <div id="txtEnderecoFornecedorCP">${aluguel.morador.endereco}</div> </td>
				           	     			</tr> 
										</c:when>
									</c:choose>
		           	     		</tbody>
		           	     	</table>
	           	     	</div>
	           	     	
	                </div>
	          	</div>

	     	</div>
	   	</form>         
    </div>
</div>

<script src="${pageContext.request.contextPath}/manual_install_components/moment/moment-with-locales.min.js"></script>
<script src="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>

<script src="${pageContext.request.contextPath}/js/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-validation-messages.js"></script>
    
<script src="${pageContext.request.contextPath}/js/paginas/aluguel/formularioAluguel.js"></script>

﻿<%@ include file="/footer.jsp" %>
</shiro:hasPermission>

<shiro:lacksPermission name="sgam.faturamento.aluguel.incluir:sgam.faturamento.aluguel.editar">
	<jsp:include page="/semPermissaoAcesso.jsp" flush="true"/>
</shiro:lacksPermission>
