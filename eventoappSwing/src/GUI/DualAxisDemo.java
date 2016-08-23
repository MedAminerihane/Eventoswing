package GUI; 
import DaoClasse.OffreDao;
import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 * A simple demonstration application showing how to create a dual axis chart based on data
 * from two {@link CategoryDataset} instances.
 *
 */
public class DualAxisDemo extends JFrame {

    /**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     */
    public DualAxisDemo(final String title) {

        super(title);

        final CategoryDataset dataset1 = createDataset1();

        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "Nombre d'offre par categorie",      
            "Category",               
            "Nombre",                  
            dataset1,                 
            PlotOrientation.VERTICAL,
            true,                     
            true,                     
            false                     
        );

        
        chart.setBackgroundPaint(Color.white);

        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(0xEE, 0xEE, 0xFF));
        plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

        
        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        final ValueAxis axis2 = new NumberAxis("Secondary");
        plot.setRangeAxis(1, axis2);

        final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
        renderer2.setToolTipGenerator(new StandardCategoryToolTipGenerator());
        plot.setRenderer(1, renderer2);
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.REVERSE);
        // OPTIONAL CUSTOMISATION COMPLETED.

        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    
    private CategoryDataset createDataset1() {
        OffreDao test=new OffreDao();
        List<String> cate=test.DisplayAllCategorie();
       
        final String series1 = "Nombre D'offre Par Categorie";

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String cate1 : cate) {
            
        
        dataset.addValue(test.Recherchebycategorie(cate1).size(), series1, cate1);
        

    }
        return dataset;

    }

    
    }