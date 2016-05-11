package zw.co.hitrac.tpg.web.page;

import java.util.Date;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.tpg.TpgPageParametersUtil;
import zw.co.hitrac.tpg.business.service.StudentService;
import zw.co.hitrac.tpg.web.chart.PerformanceChart;
import zw.co.hitrac.tpg.web.model.StudentModel;

/**
 *
 * @author pchikumba
 */
public class StudentViewPage extends WebPage {

    private StudentModel studentModel;

    public StudentViewPage(PageParameters parameters) {
        super(parameters);
        createModel(parameters);

        add(new PerformanceChart("performanceChart", studentModel.getObject().getId(), 500, 500));

    }

    private void createModel(PageParameters parameters) {
        Long id = TpgPageParametersUtil.extractId(parameters);
        studentModel = new StudentModel(id);
    }

}
