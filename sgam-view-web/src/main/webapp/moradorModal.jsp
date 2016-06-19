<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="${pageContext.request.contextPath}/css/plugins/dataTables/datatables.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">

	<div class="modal inmodal fade" id="modalSelecaoMorador" tabindex="-1" role="dialog"  aria-hidden="true" >
        <div class="modal-dialog modal-lg" style="width:50%;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">Morador</h4>
                    <small class="font-bold">Selecione um morador</small>
                </div>
                <div class="modal-body">
   					<div class="ibox-content">
	                    <div class="form-horizontal">
	                    	<div class="row">
								<div class="col-sm-12">
									<div class="input-group">
		                                <input type="text" id="nomeModalMorador" placeholder="Digite o nome do morador " class="input form-control">
		                                <span class="input-group-btn">
		                                	<a id="btnFiltrar" class="btn btn btn-primary" > <i class="fa fa-search"></i> Filtrar</a>
		                                </span>
		                            </div>	
								</div>
							</div>
							
							<br/>
							
							<div class="row">
								<div class="col-sm-12">
									<table id="tableListagemMoradoresModal" class="table table-striped table-bordered table-hover"> 
										<thead>
											<tr>
												<th>Nome</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
							</div>
	                    </div>
					</div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-outline btn-default" data-dismiss="modal"> Cancelar</button>
                    <button type="button" id="btnSelecionarModal" class="btn btn-primary"> <i class="fa fa-check"></i> Selecionar</button>
                </div>
            </div>
        </div>
    </div>
    
    <input type="hidden" id="idMoradorModal" />
    <input type="hidden" id="nomeMoradorModal" />
    <input type="hidden" id="origemTelaModal" />
    
    <script src="${pageContext.request.contextPath}/js/plugins/dataTables/datatables.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/paginas/modal/moradorModal.js"></script>