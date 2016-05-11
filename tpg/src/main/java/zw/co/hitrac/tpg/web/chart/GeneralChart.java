package zw.co.hitrac.tpg.web.chart;

import org.apache.wicket.markup.html.image.NonCachingImage;
import org.apache.wicket.request.resource.DynamicImageResource;
import org.apache.wicket.request.resource.IResource;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pchikumba
 */
public class GeneralChart extends  NonCachingImage{
    
    private final int width;
    private final int height;

    public GeneralChart(String id, int width,int height) {
        super(id);
        this.width=width;
        this.height=height;
    }
    
    @Override
    protected IResource getImageResource(){
        return new DynamicImageResource() {

            @Override
            protected byte[] getImageData(IResource.Attributes atrbts) {
               JFreeChart chart=createData();
               return toImageData(chart.createBufferedImage(width, height));
                
                
            }
        };
    }
    
    private JFreeChart createData(){
        DefaultPieDataset dataset=new DefaultPieDataset();
        dataset.setValue("Maths", 20);
        dataset.setValue("Content", 15);
        dataset.setValue("English", 10);
        dataset.setValue("Shona", 18);
        return ChartFactory.createPieChart("Performance", dataset, true, true, true);
    }
    
}
