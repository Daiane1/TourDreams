package tourdreams.com.br;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 16165886 on 04/10/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> list_dados_header;
    private HashMap<String, List<String>> listHashMap;

    public ExpandableListAdapter(Context context, List<String> list_dados_header, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.list_dados_header = list_dados_header;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return list_dados_header.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listHashMap.get(list_dados_header.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return list_dados_header.get(i);
    }

    @Override
    public Object getChild(int i, int il) {
        return listHashMap.get(list_dados_header.get(i)).get(il);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int il) {
        return il;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String titulo_header = (String)getGroup(i);

        if (view == null){
            LayoutInflater layoutInflater =  (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_group_reserva, null);
        }
        TextView list_header = (TextView)view.findViewById(R.id.list_header);
        list_header.setTypeface(null, Typeface.BOLD);
        list_header.setText(titulo_header);
        return  view;
    }

    @Override
    public View getChildView(int i, int il, boolean b, View view, ViewGroup parent) {
        final String child_text = (String)getChild(i, il);
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_item_reserva,null);
        }
        TextView txtListChild = (TextView) view.findViewById(R.id.list_header);
        txtListChild.setText(child_text);
        return  view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
