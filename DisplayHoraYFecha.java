/**
 * Write a description of class DisplayHoraYFecha here.
 * 
 * @oschariv (Oscar Charro Rivera) 
 * @1.1 (17/11/2016)
 */
public class DisplayHoraYFecha
{       
    private NumberDisplay horas;
    private NumberDisplay minutos;
    private DisplayDosDigitos dia;
    private DisplayDosDigitos mes;
    private DisplayDosDigitos anno;
    
    private boolean mostrarHora;
    private boolean mostrarFecha;
   
    
    
    /**
     * Constructor for objects of class DisplayHoraYFecha.
     * Seleccionar true o false para los parametros.
     * true - true -> muestra fecha y hora.
     * true - false -> solo muestra la hora.
     * false - true -> solo muestra la fecha.
     * false - false -> no muestra nada.
     */
    public DisplayHoraYFecha(boolean soloHora, boolean soloFecha)
    {
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        dia = new DisplayDosDigitos(31);
        mes = new DisplayDosDigitos(13);
        anno = new DisplayDosDigitos(100);
        
        mostrarHora = soloHora;
        mostrarFecha = soloFecha;       
    }
    
    

    /**
     * Metodo avanzarMomento
     */
    public void avanzarMomento()
    {
        minutos.increment();       
        if (minutos.getValue() == 0) {
            horas.increment();
            if (horas.getValue() == 0) {
                dia.incrementaValor();
                if (dia.getValor() == 1) {
                    mes.incrementaValor();
                    if (mes.getValor() == 1) {
                        anno.incrementaValor();
                    }
                    
                }
                
            }
            
        }
        
    }
    
    /**
     * Metodo avanzarMomento
     */
    public void setMomento(int nuevaHora, int nuevoMinuto, 
                           int nuevoDia, int nuevoMes, int nuevoAnyo)
    {
        if (nuevaHora >= 0 && nuevaHora < 24 && 
            nuevoMinuto >= 0 && nuevoMinuto < 60 && 
            nuevoDia > 0 && nuevoDia < 31 &&
            nuevoMes > 0 && nuevoMes < 13 && 
            nuevoAnyo > 0 && nuevoAnyo < 100) {
            
            minutos.setValue(nuevoMinuto);
            horas.setValue(nuevaHora);
            dia.setValor(nuevoDia);
            mes.setValor(nuevoMes);
            anno.setValor(nuevoAnyo);
        }
    }
        
    public String getMomento()
    {
        String momento = "";
        String displayHora = horas.getDisplayValue() + ":" + 
                             minutos.getDisplayValue();
                             
        String displayFecha = dia.getValorDelDisplay() + "/" + 
                              mes.getValorDelDisplay() + "/" + 
                              anno.getValorDelDisplay();
                              
        if (mostrarHora  && mostrarFecha) {
            momento = displayHora + " " + displayFecha;
        }
        else if (mostrarHora && !mostrarFecha) {
            momento = displayHora;
        }
        else if (!mostrarHora && mostrarFecha) {
            momento = displayFecha;
        }
        
        
        return momento; 
    }
    
    public String getMomento(boolean horaMostrar, boolean fechaMostrar)
    {
        String momento = "";
        String displayHora = horas.getDisplayValue() + ":" + 
                             minutos.getDisplayValue();
                             
        String displayFecha = dia.getValorDelDisplay() + "/" + 
                              mes.getValorDelDisplay() + "/" + 
                              anno.getValorDelDisplay();
        
        if (horaMostrar  && fechaMostrar) {
            momento = displayHora + " " + displayFecha;
        }
        else if (horaMostrar && !fechaMostrar) {
            momento = displayHora;
        }
        else if (!horaMostrar && fechaMostrar) {
            momento = displayFecha;
        }
        
        return momento; 
    }
}