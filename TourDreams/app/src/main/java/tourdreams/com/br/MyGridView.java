package tourdreams.com.br;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListView;

/**
 * Created by 16165846 on 09/10/2017.
 */

public class MyGridView  extends GridView {

    public MyGridView  (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridView  (Context context) {
        super(context);
    }

    public MyGridView  (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}