package team.soft.project.adapter;

import java.util.List;

import team.soft.project.activity.R;
import team.soft.project.model.Shoes;
import android.app.Service;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SaleListAdapter extends BaseAdapter {
	private Context context;
	private int layoutId;
	private List<Shoes> items;
	private LayoutInflater layoutInflater;
	
	public SaleListAdapter(Context context, int layoutId, List<Shoes> items) {
		super();
		this.context = context;
		this.layoutId = layoutId;
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
		final int position = index;
		
		if (view == null) {
			view = layoutInflater.inflate(layoutId, null);
		}
		
		TextView nameTextView = (TextView)view.findViewById(R.id.nameTextView);
		TextView colorTextView = (TextView)view.findViewById(R.id.colorTextView);
		TextView sizeTextView = (TextView)view.findViewById(R.id.sizeTextView);
		TextView priceTextView = (TextView)view.findViewById(R.id.priceTextView);
		TextView saleTextView = (TextView)view.findViewById(R.id.saleTextView);
		
		nameTextView.setText(items.get(index).getName());
		colorTextView.setText("색깔:" + items.get(index).getColor());
		sizeTextView.setText("사이즈:" + items.get(index).getSize());
		priceTextView.setText("가격:" + Integer.toString(items.get(index).getPrice()));
		saleTextView.setText("판매수량:" + Integer.toString(items.get(index).getQuantity()));
		
		Log.d("판매한량", Integer.toString(items.get(index).getQuantity()));
		
		view.findViewById(R.id.removeButton).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				items.remove(position);
				notifyDataSetChanged();
			}
		});
		return view;
	}

}
