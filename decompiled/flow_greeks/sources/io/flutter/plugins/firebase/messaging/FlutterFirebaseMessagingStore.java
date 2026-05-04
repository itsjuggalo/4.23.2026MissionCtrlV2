package io.flutter.plugins.firebase.messaging;

import android.content.SharedPreferences;
import com.google.firebase.messaging.s0;
import io.flutter.plugins.firebase.database.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseMessagingStore {
    private static final String KEY_NOTIFICATION_IDS = "notification_ids";
    private static final int MAX_SIZE_NOTIFICATIONS = 100;
    private static final String PREFERENCES_FILE = "io.flutter.plugins.firebase.messaging";
    private static FlutterFirebaseMessagingStore instance;
    private final String DELIMITER = com.amazon.a.a.o.b.f.f4598a;
    private SharedPreferences preferences;

    public static FlutterFirebaseMessagingStore getInstance() {
        if (instance == null) {
            instance = new FlutterFirebaseMessagingStore();
        }
        return instance;
    }

    private SharedPreferences getPreferences() {
        if (this.preferences == null) {
            this.preferences = ContextHolder.getApplicationContext().getSharedPreferences("io.flutter.plugins.firebase.messaging", 0);
        }
        return this.preferences;
    }

    private Map<String, Object> jsonObjectToMap(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objJsonObjectToMap = jSONObject.get(next);
            if (objJsonObjectToMap instanceof JSONArray) {
                objJsonObjectToMap = jsonArrayToList((JSONArray) objJsonObjectToMap);
            } else if (objJsonObjectToMap instanceof JSONObject) {
                objJsonObjectToMap = jsonObjectToMap((JSONObject) objJsonObjectToMap);
            }
            map.put(next, objJsonObjectToMap);
        }
        return map;
    }

    public Map<String, Object> getFirebaseMessageMap(String str) {
        String preferencesStringValue = getPreferencesStringValue(str, null);
        if (preferencesStringValue != null) {
            try {
                HashMap map = new HashMap(1);
                Map<String, Object> mapJsonObjectToMap = jsonObjectToMap(new JSONObject(preferencesStringValue));
                mapJsonObjectToMap.put("to", str);
                map.put(Constants.ERROR_MESSAGE, mapJsonObjectToMap);
                return map;
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public String getPreferencesStringValue(String str, String str2) {
        return getPreferences().getString(str, str2);
    }

    public List<Object> jsonArrayToList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object objJsonObjectToMap = jSONArray.get(i10);
            if (objJsonObjectToMap instanceof JSONArray) {
                objJsonObjectToMap = jsonArrayToList((JSONArray) objJsonObjectToMap);
            } else if (objJsonObjectToMap instanceof JSONObject) {
                objJsonObjectToMap = jsonObjectToMap((JSONObject) objJsonObjectToMap);
            }
            arrayList.add(objJsonObjectToMap);
        }
        return arrayList;
    }

    public void removeFirebaseMessage(String str) {
        getPreferences().edit().remove(str).apply();
        String preferencesStringValue = getPreferencesStringValue(KEY_NOTIFICATION_IDS, "");
        if (preferencesStringValue.isEmpty()) {
            return;
        }
        setPreferencesStringValue(KEY_NOTIFICATION_IDS, preferencesStringValue.replace(str + com.amazon.a.a.o.b.f.f4598a, ""));
    }

    public void setPreferencesStringValue(String str, String str2) {
        getPreferences().edit().putString(str, str2).apply();
    }

    public void storeFirebaseMessage(s0 s0Var) {
        setPreferencesStringValue(s0Var.U(), new JSONObject(FlutterFirebaseMessagingUtils.remoteMessageToMap(s0Var)).toString());
        String strReplace = getPreferencesStringValue(KEY_NOTIFICATION_IDS, "") + s0Var.U() + com.amazon.a.a.o.b.f.f4598a;
        ArrayList arrayList = new ArrayList(Arrays.asList(strReplace.split(com.amazon.a.a.o.b.f.f4598a)));
        if (arrayList.size() > 100) {
            String str = (String) arrayList.get(0);
            getPreferences().edit().remove(str).apply();
            strReplace = strReplace.replace(str + com.amazon.a.a.o.b.f.f4598a, "");
        }
        setPreferencesStringValue(KEY_NOTIFICATION_IDS, strReplace);
    }
}
