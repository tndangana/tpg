/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.tpg.web.chart;

import java.util.List;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.image.NonCachingImage;
import org.apache.wicket.request.resource.DynamicImageResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import zw.co.hitrac.tpg.business.domain.ResultSheet;
import zw.co.hitrac.tpg.business.domain.Student;
import zw.co.hitrac.tpg.business.repository.ResultSheetRepo;
import zw.co.hitrac.tpg.business.repository.StudentRepo;

/**
 *
 * @author g-birds
 */
public class PerformanceChart extends NonCachingImage {

    private final int width;
    private final int height;
    private final Long studentId;

    @SpringBean
    private ResultSheetRepo resultSheetRepo;
    @SpringBean
    private StudentRepo studentRepo;
    

    public PerformanceChart(String id,Long studentId,int width, int height) {
        super(id);
        this.width = width;
        this.height = height;
        this.studentId=studentId;
        Injector.get().inject(this);
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
    
    public JFreeChart createData(){
        DefaultPieDataset dataset=new DefaultPieDataset();     
        Student student=studentRepo.findOne(studentId);
        List<ResultSheet> resultSheets=resultSheetRepo.findByStudent(student);
        for(ResultSheet resultSheet:resultSheets){
        dataset.setValue(resultSheet.getSubject().getSubjectname()+" ["+resultSheet.getPeriod().getTerm()+"]",resultSheet.getActualmark());       
        }
        return ChartFactory.createPieChart("Assessment for "+student.getStudentname(), dataset, true, true, true);
    }

}
