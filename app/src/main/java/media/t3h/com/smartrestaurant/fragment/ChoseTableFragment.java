package media.t3h.com.smartrestaurant.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

import media.t3h.com.smartrestaurant.R;
import media.t3h.com.smartrestaurant.adapter.ListTableAdapter;
import media.t3h.com.smartrestaurant.firebase.UtilsData;
import media.t3h.com.smartrestaurant.model.Table;

/**
 * Created by Ngoc on 9/3/2016.
 */
public class ChoseTableFragment extends Fragment {

    private Dialog dialog;

    private SwipeRefreshLayout contactListRefresher;
    private ListTableAdapter adapter;
    private ArrayList<Table> listTable;
    private UtilsData utilsData;

    public ChoseTableFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book_table, container, false);
        initViews(rootView);
        contactListRefresher.setColorSchemeResources(R.color.colorPrimary);
        contactListRefresher.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.notifyDataSetChanged();
                contactListRefresher.setRefreshing(false);
            }
        });
        return rootView;
    }

    private void initViews(View rootView) {
        utilsData = new UtilsData(getContext());
        contactListRefresher = (SwipeRefreshLayout) rootView.findViewById(R.id.contactListRefresher);
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab_filter_table);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog();
            }
        });

        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.rv_list_table);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);

        listTable = prepareData();

        adapter = new ListTableAdapter(getContext(),listTable);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private ArrayList<Table> prepareData() {
        return utilsData.getAllTable();
    }

    private ArrayList<Table> prepareEmptyTableData() {
        return utilsData.getEmptyTable();
    }

    private ArrayList<Table> prepareBookedTableData() {
        return utilsData.getBookedTable();
    }


    public void customDialog(){

        dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogbox_filter_table);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Window window = dialog.getWindow();
        WindowManager.LayoutParams param = window.getAttributes();
        param.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        dialog.setCanceledOnTouchOutside(true);
        // initialize the item of the dialog box, whose id is demo1
        View filterAll =(View) dialog.findViewById(R.id.filter_all);
        // it call when click on the item whose id is demo1.
        filterAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listTable.clear();
                listTable.addAll(prepareData());
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });

        View filterEmpty =(View) dialog.findViewById(R.id.filter_available);
        // it call when click on the item whose id is demo1.
        filterEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listTable.clear();
                listTable.addAll(prepareEmptyTableData());
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });

        View filterBooked =(View) dialog.findViewById(R.id.filter_unavailable);
        // it call when click on the item whose id is demo1.
        filterBooked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listTable.clear();
                listTable.addAll(prepareBookedTableData());
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        // it show the dialog box
        dialog.show();

    }
}
