package X2;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static Map a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return d(jSONObject);
            }
            return null;
        } catch (Exception e7) {
            b.f().b("Failed to parse JSONObject into Map:\n" + e7);
            return Collections.emptyMap();
        }
    }

    public static Map b(String str) {
        AbstractC1207s.e(str);
        String[] strArrSplit = str.split("\\.", -1);
        if (strArrSplit.length < 2) {
            b.f().d("Invalid token (too few subsections):\n" + str);
            return Collections.emptyMap();
        }
        try {
            Map mapA = a(new String(Base64.decode(strArrSplit[1], 11), "UTF-8"));
            return mapA == null ? Collections.emptyMap() : mapA;
        } catch (UnsupportedEncodingException e7) {
            b.f().d("Unable to decode token (charset unknown):\n" + e7);
            return Collections.emptyMap();
        }
    }

    public static List c(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
            Object objD = jSONArray.get(i7);
            if (objD instanceof JSONArray) {
                objD = c((JSONArray) objD);
            } else if (objD instanceof JSONObject) {
                objD = d((JSONObject) objD);
            }
            arrayList.add(objD);
        }
        return arrayList;
    }

    public static Map d(JSONObject jSONObject) throws JSONException {
        C2736a c2736a = new C2736a();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objD = jSONObject.get(next);
            if (objD instanceof JSONArray) {
                objD = c((JSONArray) objD);
            } else if (objD instanceof JSONObject) {
                objD = d((JSONObject) objD);
            } else if (objD.equals(JSONObject.NULL)) {
                objD = null;
            }
            c2736a.put(next, objD);
        }
        return c2736a;
    }
}
