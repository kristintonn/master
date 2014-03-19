package no.ntnu.master.application;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.iguanaui.controls.DataChart;
import com.iguanaui.controls.axes.CategoryXAxis;
import com.iguanaui.controls.axes.NumericAxis;
import com.iguanaui.controls.axes.NumericYAxis;
import com.iguanaui.controls.valuecategory.ColumnSeries;
import com.iguanaui.controls.valuecategory.ValueCategorySeries;
import de.akquinet.android.androlog.Log;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

public class HelloAndroidActivity extends Activity {

    private DataChart chart;
    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Initializes the logging
        Log.init();

        // Log a message (only on dev platform)
        Log.i(this, "onCreate");
        
        int foo[] = {1,2,3,4,5};
        List<String> categories;
        categories = new ArrayList<String>();
        //categories.add("Ha");
        //categories.add("He");
        //categories.add("Hi");
        CategoryXAxis categoryAxis = new CategoryXAxis();
        categoryAxis.setVisibility(View.VISIBLE);
        categoryAxis.setDataSource(categories);
        
        chart.scales().add(categoryAxis);
        NumericAxis valueAxis = new NumericYAxis();
        valueAxis.setVisibility(View.VISIBLE);
        chart.scales().add(valueAxis);
        
        ValueCategorySeries series = new ColumnSeries();
        List<List<Float>> columnList = new ArrayList<List<Float>>();
        List<Float> column1 = new ArrayList<Float>();
        column1.add(new Float(8));
        column1.add(new Float(12));
        column1.add(new Float(16));
        columnList.add(null);
        series.setDataSource(column1);
        //findViewById(RESULT_OK)
        //addView
        chart.series().add(series);
        try {
            setContentView(chart);
        } catch (Exception e) {
            Log.i(e.getMessage() + "..." + e.getStackTrace().toString());
        }
        
        
    }

}

