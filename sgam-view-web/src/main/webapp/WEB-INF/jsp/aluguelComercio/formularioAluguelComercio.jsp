<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<shiro:hasPermission name="sgam.faturamento.aluguel_comercio.incluir:sgam.faturamento.aluguel_comercio.editar">

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
                 <a href="${linkTo[AluguelComercioController].listagemAluguelComercio}"><strong>Comércio</strong></a>
             </li>

			<div class="pull-right">
            	<a class="label label-default" href="${linkTo[AluguelComercioController].listagemAluguelComercio}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
 		<form id="aluguelComercioForm" method="post" class="form-horizontal" action="${linkTo[AluguelComercioController].cadastraAluguelComercio}">
			<div class="col-lg-6">
			<fieldset>
			    <legend>Geral</legend>
		        <div class="ibox-content">
		        
	         		<input type="hidden" name="aluguelComercio.id" value="${aluguelComercio.id }"/>
	         		<input type="hidden" name="aluguelComercio.aluguel.dataEmissaoFaturamento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguelComercio.aluguel.dataEmissaoFaturamento}" />" />
	         		     		
	         	
	             	<div class="form-group">
		            	<label class="col-sm-4 control-label">Morador</label>
		                <div class="col-sm-8">
		                	<div class="input-group">
		                		<input id="idMoradorFaturamento" type="hidden" name="aluguelComercio.aluguel.morador.id" value="${aluguelComercio.aluguel.morador.id }"/> 
		                		<input id="nomeMoradorFaturamento" type="text" placeholder="Selecione um morador" class="form-control" name="aluguelComercio.aluguel.morador.nome" value="${aluguelComercio.aluguel.morador.nome}">
		                		<a class="input-group-addon" id="btnAbreModalMoradorFaturamento" style="cursor: pointer;"><i class="fa fa-user"></i></a>
		                	</div>
		            	</div>
		            </div>
	                
	                <div class="form-group">
	                	<label class="col-sm-4 control-label">Recurso</label>
	                    <div class="col-sm-8">
	                    	<select class="form-control m-b" name="aluguelComercio.aluguel.recurso.id">
	                         <option value="0">Selecione</option>
	                         <c:forEach items="${recursos}" var="recurso">
	                         	<option value="${recurso.id}" <c:if test="${aluguelComercio.aluguel.recurso.id == recurso.id}">selected="selected"</c:if> >${recurso.nome} </option>
	                         </c:forEach>
	                    	</select>
	                    </div>
	                </div>
	                
	                <div class="form-group" >
	             		<label class="col-sm-4 control-label">Período</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group periodo">
	                    		<input type="hidden" id="dataHoraInicioAluguelComercio" name="aluguelComercio.aluguel.dataHoraInicio" />
	                    		<input type="text" id="dataInicioAluguelComercio" class="form-control" name="aluguelComercio.aluguel.dataInicial" value="<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${aluguelComercio.aluguel.dataInicial}" />"  data-mask="99/99/9999 99:99" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group" >
	             		<label class="col-sm-4 control-label"></label>
	                    <div class="col-sm-8">
	                    	<div class="input-group periodo">
	                    		<input type="hidden" id="dataHoraFinalAluguelComercio" name="aluguelComercio.aluguel.dataHoraFinal" />
	                    		<input type="text" id="dataFinalAluguelComercio" class="form-control" name="aluguelComercio.aluguel.dataFinal" value="<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${aluguelComercio.aluguel.dataFinal}" />"  data-mask="99/99/9999 99:99" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>          
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Observação</label>
	                    <div class="col-sm-8">
	                    	<textarea name="aluguelComercio.aluguel.observacao" class="form-control" rows="" cols="">${aluguelComercio.aluguel.observacao}</textarea>
	                    </div>
	                </div>
	                
				</div>
				</fieldset>
				<br/>
					
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox-content">
							<div class="form-group">
			                    <div class="col-sm-12">
			                        <a class="btn btn-outline btn-default" href="${linkTo[AluguelComercioController].listagemAluguelComercio}" > Cancelar</a>
			                        <button id="btnSalvarAluguelComercio" class="btn btn-primary" type="submit"> <i class="fa fa-check"></i> Salvar</button>
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
		    <fieldset>
			    <legend>Comércio</legend>
			    <div class="ibox-content">
			    	
			    	<div class="form-group">
		            	<label class="col-sm-4 control-label">Atividade</label>
		              	<div class="col-sm-8">
		            		<input type="text" class="form-control" name="aluguelComercio.nome" value="${aluguelComercio.nome}">
		                </div>
		        	</div>
			    	
		   			<div class="form-group">
		            	<label class="col-sm-4 control-label">Alvará</label>
		              	<div class="col-sm-8">
		            		<input type="text" class="form-control" name="aluguelComercio.numeroAlvara" value="${aluguelComercio.numeroAlvara}">
		                </div>
		        	</div>
		        	
		        	<div class="form-group">
	             		<label class="col-sm-4 control-label">Data Emissão</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="aluguelComercio.dataEmissao" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguelComercio.dataEmissao}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group" >
	             		<label class="col-sm-4 control-label">Data Vencimento</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="aluguelComercio.dataVencimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguelComercio.dataVencimento}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Largura</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control qtde" name="aluguelComercio.larguraBarraca" value="<fmt:formatNumber value="${aluguelComercio.larguraBarraca}" type="number"  pattern="#,##0.00"/>" >
		                </div>
		          	</div>
		          	
		          	<div class="form-group">
		            	<label class="col-sm-4 control-label">Comprimento</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control qtde" name="aluguelComercio.comprimentoBarraca" value="<fmt:formatNumber value="${aluguelComercio.comprimentoBarraca}" type="number"  pattern="#,##0.00"/>" >
		                </div>
		          	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Quantidade Pessoas</label>
		                <div class="col-sm-8">
		                	<input type="text" id="qtdePessoasAluguelComercio" class="form-control" name="aluguelComercio.qtdePessoas" value="${aluguelComercio.qtdePessoas}">
		                </div>
		          	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Equipamentos</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="aluguelComercio.equipamentos" value="${aluguelComercio.equipamentos}">
		                </div>
		          	</div>
		          	
		          	<div class="form-group">
		            	<label class="col-sm-4 control-label">Produtos</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="aluguelComercio.produtos" value="${aluguelComercio.produtos}">
		                </div>
		          	</div>
		          	
			    </div> 
			    </fieldset>
		   	</div> 
	   	</form>         
    </div>
</div>

<script src="${pageContext.request.contextPath}/manual_install_components/moment/moment-with-locales.min.js"></script>
<script src="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/manual_install_components/jquery-maskmoney/jquery.maskMoney.min.js"></script>   

<script src="${pageContext.request.contextPath}/js/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-validation-messages.js"></script>

<script src="${pageContext.request.contextPath}/js/paginas/aluguelComercio/formularioAluguelComercio.js"></script>

﻿<%@ include file="/footer.jsp" %>

</shiro:hasPermission>

<shiro:lacksPermission name="sgam.faturamento.aluguel_comercio.incluir:sgam.faturamento.aluguel_comercio.editar">
	<jsp:include page="/semPermissaoAcesso.jsp" flush="true"/>
</shiro:lacksPermission>