package media.t3h.com.smartrestaurant.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import media.t3h.com.smartrestaurant.R;
import media.t3h.com.smartrestaurant.model.Table;

/**
 * Created by duyti on 9/8/2016.
 */
public class ListTableAdapter extends RecyclerView.Adapter<ListTableAdapter.ViewHolder> {

    private Context context;
    private List<Table> tableList;

    public ListTableAdapter(Context context, List<Table> tableList) {
        this.context = context;
        this.tableList = tableList;
    }

    @Override
    public ListTableAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_table, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListTableAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(tableList.get(position).getName());
        if(!tableList.get(position).isState()){
            holder.checkBox.setVisibility(View.INVISIBLE);
        }else{
            holder.checkBox.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CheckBox checkBox;
        private TextView tvName;
        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
