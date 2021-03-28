package br.com.ibner.projetoweb.converter;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.stereotype.Component;

import br.com.ibner.projetoweb.controller.TarefaController;
import br.com.ibner.projetoweb.model.Responsavel;

@SuppressWarnings("rawtypes")
@Component
public class ResponsavelConverter implements Converter {

	    @Override
	    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String valueId) {

	        
			if (valueId.isEmpty())
				return null;
			try {
		        ValueExpression vex =
		                ctx.getApplication().getExpressionFactory()
		                        .createValueExpression(ctx.getELContext(),
		                                "#{tarefaController}", TarefaController.class);
				TarefaController tarefaController = (TarefaController)vex.getValue(ctx.getELContext());
		        
		        for(Responsavel responsavel: tarefaController.getResponsaveis()) {
		        	if(responsavel.getId() == Integer.parseInt(valueId)) {
		        		tarefaController.setResponsavelSelecionado(responsavel);
		        		return responsavel;
		        	}
		        }
		       
		        return tarefaController.getResponsavelSelecionado();
			} catch (Exception e) {
				return null;
			}
	        
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	    	if (value instanceof Responsavel) {
	    		Responsavel responsavel = (Responsavel) value;
				return responsavel.getId()+"";
			} else {
				return null;
			}
	    }
	
}
