package io.flutter.plugins.firebase.firestore.utils;

import android.util.Log;
import com.google.firebase.firestore.FirebaseFirestoreException;
import io.flutter.plugins.firebase.crashlytics.Constants;
import io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreException;
import io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestorePlugin;
import io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ExceptionConverter {
    public static Map<String, String> createDetails(Exception exc) {
        FlutterFirebaseFirestoreException flutterFirebaseFirestoreException;
        HashMap map = new HashMap();
        if (exc != null) {
            if (exc instanceof FirebaseFirestoreException) {
                flutterFirebaseFirestoreException = new FlutterFirebaseFirestoreException((FirebaseFirestoreException) exc, exc.getCause());
            } else if (exc.getCause() == null || !(exc.getCause() instanceof FirebaseFirestoreException)) {
                flutterFirebaseFirestoreException = null;
            } else {
                flutterFirebaseFirestoreException = new FlutterFirebaseFirestoreException((FirebaseFirestoreException) exc.getCause(), exc.getCause().getCause() != null ? exc.getCause().getCause() : exc.getCause());
            }
            if (flutterFirebaseFirestoreException != null) {
                map.put("code", flutterFirebaseFirestoreException.getCode());
                map.put(Constants.MESSAGE, flutterFirebaseFirestoreException.getMessage());
            }
            if (map.containsKey("code")) {
                String str = (String) map.get("code");
                Objects.requireNonNull(str);
                if (str.equals("unknown")) {
                    Log.e("FLTFirebaseFirestore", "An unknown error occurred", exc);
                }
            }
        }
        return map;
    }

    public static void sendErrorToFlutter(GeneratedAndroidFirebaseFirestore.Result result, Exception exc) {
        result.error(new GeneratedAndroidFirebaseFirestore.FlutterError(FlutterFirebaseFirestorePlugin.DEFAULT_ERROR_CODE, exc != null ? exc.getMessage() : null, createDetails(exc)));
    }
}
