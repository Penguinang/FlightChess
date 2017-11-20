package FlightChess.View;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 自定义的图片类
 */
@SuppressWarnings("serial")
class ImageComponent extends Component{
    BufferedImage img;
    
    /**
     * @param path  图片路径，以项目根目录开始
     */
    ImageComponent(String path){
        try{
            img = ImageIO.read(new File(path));
        }catch(IOException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);            
        }
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(img, 0,0,null);
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(img.getWidth(),img.getHeight());
    }
}