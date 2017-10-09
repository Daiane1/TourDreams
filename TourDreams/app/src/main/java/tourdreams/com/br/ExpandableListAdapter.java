package tourdreams.com.br;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 16165886 on 04/10/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listHeaders; // List of Headers
    // List View content as a Map of Header with its Items
    private HashMap<String, List<ItemPojo>> listItems;

    public ExpandableListAdapter(Context context, List<String> listHeader,
                                 HashMap<String, List<ItemPojo>> listItems) {
        this.context = context;
        this.listHeaders = listHeader;
        this.listItems = listItems;
    }

    @Override
    public ItemPojo getChild(int groupPosition, int itemPosititon) {
        return this.listItems.get(this.listHeaders.get(groupPosition))
                .get(itemPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int item) {
        return item;
    }

    @Override
    public View getChildView(int groupPosition, final int itemPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item_reserva, null);
        }

        ImageView img_sub_item = (ImageView) convertView.findViewById(R.id.image_sub_item);
        img_sub_item.setImageResource(getChild(groupPosition, itemPosition).getImage_sub_item());

        TextView nome_sub_item = (TextView) convertView.findViewById(R.id.nome_sub_item);
        nome_sub_item.setText(getChild(groupPosition, itemPosition).getNome_sub_item());

        TextView local_sub_item = (TextView) convertView.findViewById(R.id.local_sub_item);
        local_sub_item.setText(getChild(groupPosition, itemPosition).getLocal_sub_item());

        TextView checkin_sub_item = (TextView) convertView.findViewById(R.id.checkin_sub_item);
        checkin_sub_item.setText(getChild(groupPosition, itemPosition).getCheckin_sub_item());

        TextView checkout_sub_item = (TextView) convertView.findViewById(R.id.checkout_sub_item);
        checkout_sub_item.setText(getChild(groupPosition, itemPosition).getCheckout_sub_item());

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listItems.get(this.listHeaders.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listHeaders.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listHeaders.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.header_expandable_list_reservas, null);
        }

        TextView header = (TextView) convertView.findViewById(R.id.header);
        header.setTypeface(null, Typeface.BOLD);
        header.setText(headerTitle);
        /*TextView count = (TextView) convertView.findViewById(R.id.count);
        count.setTextColor(Color.DKGRAY);
        count.setText(" (" + getChildrenCount(groupPosition) + ")");*/

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
