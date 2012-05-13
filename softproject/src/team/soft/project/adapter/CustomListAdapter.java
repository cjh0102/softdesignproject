package team.soft.project.adapter;

import java.util.List;

import team.soft.project.activity.R;
import team.soft.project.model.Shoes;
import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater layoutInflater;
	private int layoutId;
	private List<Shoes> items;
	
	public CustomListAdapter(Context context, int layoutID, List<Shoes> items) {
		super();
		this.context = context;
		this.layoutId = layoutID;
		this.items = items;
		layoutInflater = (LayoutInflater)context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return items.size();
	}

	public Object getItem(int index) {
		return items.get(index);
	}

	public long getItemId(int index) {
		return index;
	}

	public View getView(int index, View view, ViewGroup viewGroup) {
		if(view == null) {
			view = layoutInflater.inflate(layoutId, null);
		}
		final int position = index;
		
		TextView nameTextView = (TextView)view.findViewById(R.id.nameTextView);
		TextView colorTextView = (TextView)view.findViewById(R.id.colorTextView);
		TextView sizeTextView = (TextView)view.findViewById(R.id.sizeTextView);
		TextView priceTextView = (TextView)view.findViewById(R.id.priceTextView);
		TextView quantityTextView = (TextView)view.findViewById(R.id.quantitytextView);
		
		nameTextView.setText("이름:" + items.get(index).getName());
		colorTextView.setText("색깔:" + items.get(index).getColor());
		sizeTextView.setText("사이즈:" + items.get(index).getSize());
		priceTextView.setText("가격:" + items.get(index).getPrice());
		quantityTextView.setText("수량:" + items.get(index).getQuantity());
		
		Button removeButton = (Button)view.findViewById(R.id.removeButton);
		removeButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				items.remove(position);
				notifyDataSetChanged();
			}
		});
		
		return view;
	}
}
