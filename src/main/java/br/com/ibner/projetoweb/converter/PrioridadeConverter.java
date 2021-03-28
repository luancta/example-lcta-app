package br.com.ibner.projetoweb.converter;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.stereotype.Component;

import br.com.ibner.projetoweb.controller.TarefaController;
import br.com.ibner.projetoweb.model.Prioridade;

@SuppressWarnings("rawtypes")
@Component
public class PrioridadeConverter implements Converter {

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
	        
	        for(Prioridade prioridade: tarefaController.getPrioridades()) {
	        	if(prioridade.getId() == Integer.parseInt(valueId)) {
	        		tarefaController.setPrioridadeSelecionada(prioridade);
	        		return prioridade;
	        	}
	        }
	       
	        return tarefaController.getPrioridadeSelecionada();
		} catch (Exception e) {
			return null;
		}
        
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
    	if (value instanceof Prioridade) {
    		Prioridade prioridade = (Prioridade) value;
			return prioridade.getId()+"";
		} else {
			return null;
		}
    }
	
}
