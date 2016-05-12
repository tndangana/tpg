package zw.co.hitrac.tpg.web.chart;

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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
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
public class AdvancedPerformanceChart extends NonCachingImage {
    
    private final int width;
    private final int height;
    private final Long studentId;
    
    @SpringBean
    private ResultSheetRepo resultSheetRepo;
    @SpringBean
    private StudentRepo studentRepo;
    @SpringBean
    private SubjectRepo subjectRepo;
    
    public AdvancedPerformanceChart(String id, Long studentId, int width, int height) {
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
        
        Map<Subject, XYSeries> map = new LinkedHashMap<Subject, XYSeries>();
        
        for (Subject subject : subjectRepo.findAll()) {
            map.put(subject, new XYSeries(subject.getSubjectname()));
        }
        
        int i = 1;
        for (ResultSheet resultSheet : resultSheets) {
            Subject subject = resultSheet.getSubject();
            map.get(subject).add(i++, resultSheet.getActualmark());
        }
        
        final XYSeriesCollection dataset = new XYSeriesCollection();
        for (Subject subject : map.keySet()) {
            dataset.addSeries(map.get(subject));
        }
        
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "Performance Analysis for "+student.getStudentname(),      // chart title
            "X",                      // x axis label
            "Y",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );
        
            // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
  //      legend.setDisplaySeriesShapes(true);
        
        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        //renderer.setSeriesLinesVisible(0, false);
        //renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
       
    }
    
}
