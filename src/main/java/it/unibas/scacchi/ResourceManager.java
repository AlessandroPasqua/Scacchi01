package it.unibas.scacchi;

import java.net.URL;
import javax.swing.ImageIcon;

public class ResourceManager {
            
    public ImageIcon getImageResource(String urlString) {
        URL url = ResourceManager.class.getResource(urlString);
        ImageIcon immagine = new ImageIcon(url);
        return immagine;
    }            
        
}
