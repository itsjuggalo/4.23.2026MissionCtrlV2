package io.flutter.plugins.firebase.firestore.utils;

import android.util.Log;
import com.google.firebase.firestore.f;
import io.flutter.plugins.firebase.database.Constants;
import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestoreException;
import io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestorePlugin;
import io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class ExceptionConverter {
    public static Map<String, String> createDetails(Exception exc) {
        FlutterFirebaseFirestoreException flutterFirebaseFirestoreException;
        HashMap map = new HashMap();
        if (exc != null) {
            if (exc instanceof f) {
                flutterFirebaseFirestoreException = new FlutterFirebaseFirestoreException((f) exc, exc.getCause());
            } else if (exc.getCause() == null || !(exc.getCause() instanceof f)) {
                flutterFirebaseFirestoreException = null;
            } else {
                flutterFirebaseFirestoreException = new FlutterFirebaseFirestoreException((f) exc.getCause(), exc.getCause().getCause() != null ? exc.getCause().getCause() : exc.getCause());
            }
            if (flutterFirebaseFirestoreException != null) {
                map.put(Constants.ERROR_CODE, flutterFirebaseFirestoreException.getCode());
                map.put(Constants.ERROR_MESSAGE, flutterFirebaseFirestoreException.getMessage());
            }
            if (map.containsKey(Constants.ERROR_CODE)) {
                String str = (String) map.get(Constants.ERROR_CODE);
                Objects.requireNonNull(str);
                if (str.equals(FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE)) {
                    Log.e("FLTFirebaseFirestore", FlutterFirebaseDatabaseException.UNKNOWN_ERROR_MESSAGE, exc);
                }
            }
        }
        return map;
    }

    public static void sendErrorToFlutter(GeneratedAndroidFirebaseFirestore.Result result, Exception exc) {
        result.error(new GeneratedAndroidFirebaseFirestore.FlutterError(FlutterFirebaseFirestorePlugin.DEFAULT_ERROR_CODE, exc != null ? exc.getMessage() : null, createDetails(exc)));
    }
}
