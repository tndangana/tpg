package zw.co.hitrac.tpg.web.chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.image.NonCachingImage;
import org.apache.wicket.request.resource.DynamicImageResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import zw.co.hitrac.tpg.business.domain.ResultSheet;
import zw.co.hitrac.tpg.business.domain.Student;
import zw.co.hitrac.tpg.business.domain.Subject;
import zw.co.hitrac.tpg.business.repository.ResultSheetRepo;
import zw.co.hitrac.tpg.business.repository.StudentRepo;
import zw.co.hitrac.tpg.business.repository.SubjectRepo;

/**
 *
 * @author g-birds
 */
public class AdvancedPerformanceChart2 extends NonCachingImage {
    
    private final int width;
    private final int height;
    private final Long studentId;
    
    @SpringBean
    private ResultSheetRepo resultSheetRepo;
    @SpringBean
    private StudentRepo studentRepo;
    @SpringBean
    private SubjectRepo subjectRepo;
    
    public AdvancedPerformanceChart2(String id, Long studentId, int width, int height) {
        super(id);
        this.width = width;
        this.height = height;
        this.studentId = studentId;
        Injector.get().inject(this);
    }
    
    @Override
    protected IResource getImageResource() {
        return new DynamicImageResource() {
            
            @Override
            protected byte[] getImageData(IResource.Attributes atrbts) {
                JFreeChart chart = createData();
                return toImageData(chart.createBufferedImage(width, height));
            }
        };
    }
    
    public JFreeChart createData() {
        Student student = studentRepo.findOne(studentId);
        List<ResultSheet> resultSheets = resultSheetRepo.findByStudent(student);
        
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (ResultSheet resultSheet : resultSheets) {
             dataset.addValue(resultSheet.getActualmark(), resultSheet.getSubject().getSubjectname(), resultSheet.getPeriod().getTerm()+" "+resultSheet.getLevel().getLeveltype());
             
            
        }
        
        final JFreeChart chart = ChartFactory.createLineChart(
            "Performance Analysis for "+student.getStudentname(),       // chart title
            "Period",                    // domain axis label
            "Mark",                   // range axis label
            dataset,                   // data
            PlotOrientation.VERTICAL,  // orientation
            true,                      // include legend
            true,                      // tooltips
            false                      // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
//        final StandardLegend legend = (StandardLegend) chart.getLegend();
  //      legend.setDisplaySeriesShapes(true);
    //    legend.setShapeScaleX(1.5);
      //  legend.setShapeScaleY(1.5);
        //legend.setDisplaySeriesLines(true);

        chart.setBackgroundPaint(Color.white);

        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.white);

        // customise the range axis...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);

        // ****************************************************************************
        // * JFREECHART DEVELOPER GUIDE                                               *
        // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
        // * to purchase from Object Refinery Limited:                                *
        // *                                                                          *
        // * http://www.object-refinery.com/jfreechart/guide.html                     *
        // *                                                                          *
        // * Sales are used to provide funding for the JFreeChart project - please    * 
        // * support us so that we can continue developing free software.             *
        // ****************************************************************************
        
        // customise the renderer...
        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
//       renderer.setDrawShapes(true);

        /*renderer.setSeriesStroke(
            0, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {10.0f, 6.0f}, 0.0f
            )
        );
        renderer.setSeriesStroke(
            1, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {6.0f, 6.0f}, 0.0f
            )
        );
        renderer.setSeriesStroke(
            2, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {2.0f, 6.0f}, 0.0f
            )
        */
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
       
    }
    
}
