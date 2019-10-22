
package xmlprobaler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XMLprobaLer {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
//      le o documento XML que se xenerou no exercicio anterior usando os metodos apropiados
//as clases a usar son moi similares:
//XMLInputFactory 
//XMLStreamReader
        
        //ruta del archivo del ejercicio anterior
        File fichero = new File("/home/oracle/Desktop/AD/Eje13/xmlproba.xml");
        
        //este metodo de File te permite la lectura del archivo anterior
        FileReader ficheroleer = new FileReader(fichero);
        
        //Definición de una implementación abstracta de un factory para obtener streams
        //El metodo .newInstance de XMLInputFactory crea una nueva instancia factory
        XMLInputFactory xmlFactory = XMLInputFactory.newInstance();
        //permite solo la lectura de archivos XML
        XMLStreamReader xmlReader = xmlFactory.createXMLStreamReader(ficheroleer);
        
        //Esta parte del código va leyendo
        //una a una la etiquetas existentes
        //.next() pasa a la siguiente
        //.getLocaleName() obtiene el nombre
        xmlReader.next();
        System.out.println(xmlReader.getLocalName());
        
         xmlReader.next();
        System.out.println(xmlReader.getLocalName());
        
        xmlReader.next();
        System.out.println(xmlReader.getLocalName());
        
        //.getText nos permite imprimir texto
         xmlReader.next();
        System.out.println(xmlReader.getText());
        
        int Evento =0;
        
        //.hasNext solo revisa si queda algo aún por leer
        //sigue leyendo si devuelve true
        //devuleve false, para de leer
        while(xmlReader.hasNext()){
            Evento = xmlReader.getEventType();
            
            //nos indica que el próximo evneto  es un startElement
            if(Evento == XMLStreamConstants.START_ELEMENT){
                
                String etiqueta = xmlReader.getLocalName();
                if(etiqueta == "autor"){
                    
                    System.out.println(xmlReader.getAttributeValue(0));
                }else if(etiqueta == "nome"){
                    xmlReader.getElementText();
                    
                }else if(etiqueta == "titulo"){
                xmlReader.getElementText();
                
                
            }
                xmlReader.next();
            }
            xmlReader.close();
        }
        
    }
    
}
