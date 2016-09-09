package media.t3h.com.smartrestaurant.firebase;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import media.t3h.com.smartrestaurant.model.Table;

/**
 * Created by duyti on 9/9/2016.
 */
public class UtilsData {
    private static final String KEY_COLECTION_TABLE = "Table";
    private ConfigFirebase configFirebase;
    Context context;
    private ArrayList<Table> listTable = new ArrayList<>();

    public UtilsData(Context context) {
        this.configFirebase = new ConfigFirebase(context);
        this.context = context;
    }

    public ArrayList<Table> getAllTable() {
        listTable.clear();
        Firebase firebase = configFirebase.getFirebaseRef();
        firebase.child(KEY_COLECTION_TABLE).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.i("table", dataSnapshot.getValue().toString());
                try {
                    JSONObject jsonObject = new JSONObject(dataSnapshot.getValue().toString());
                    listTable.add(new Table(jsonObject.getString("name"), jsonObject.getString("waiter")
                            , jsonObject.getString("status")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        return listTable;
    }

    public ArrayList<Table> getEmptyTable() {
        listTable.clear();
        Firebase firebase = configFirebase.getFirebaseRef();
        firebase.child(KEY_COLECTION_TABLE).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                try {
                    JSONObject jsonObject = new JSONObject(dataSnapshot.getValue().toString());
                    if (jsonObject.getString("status").equals("0")) {
                        Log.i("table empty", dataSnapshot.getValue().toString());
                        listTable.add(new Table(jsonObject.getString("name"), jsonObject.getString("waiter")
                                , jsonObject.getString("status")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        return listTable;
    }

    public ArrayList<Table> getBookedTable() {
        listTable.clear();
        Firebase firebase = configFirebase.getFirebaseRef();
        firebase.child(KEY_COLECTION_TABLE).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.i("table", dataSnapshot.getValue().toString());
                try {
                    JSONObject jsonObject = new JSONObject(dataSnapshot.getValue().toString());
                    if (jsonObject.getString("status").equals("1")) {
                        Log.i("table booked", dataSnapshot.getValue().toString());
                        listTable.add(new Table(jsonObject.getString("name"), jsonObject.getString("waiter")
                                , jsonObject.getString("status")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        return listTable;
    }

}
