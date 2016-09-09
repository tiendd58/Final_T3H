package media.t3h.com.smartrestaurant.firebase;

import android.content.Context;

import com.firebase.client.Firebase;

/**
 * Created by duyti on 9/9/2016.
 */
public class ConfigFirebase {
    private final Firebase myFirebaseRef;

    public ConfigFirebase(Context context) {
        Firebase.setAndroidContext(context);
        myFirebaseRef = new Firebase("https://smartrestaurant-c0523.firebaseio.com/");
    }

    public Firebase getFirebaseRef(){
        return myFirebaseRef;
    }
}
