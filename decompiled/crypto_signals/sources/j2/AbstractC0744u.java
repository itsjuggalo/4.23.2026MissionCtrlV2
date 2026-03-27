package j2;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import com.google.android.gms.internal.p002firebaseauthapi.zzt;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q.C0910b;
import s3.AbstractC1024h;
import x1.C1402a;

/* JADX INFO: renamed from: j2.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0744u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1402a f7734a = new C1402a("JSONParser", new String[0]);

    public static ArrayList a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object objC = jSONArray.get(i);
            if (objC instanceof JSONArray) {
                objC = a((JSONArray) objC);
            } else if (objC instanceof JSONObject) {
                objC = c((JSONObject) objC);
            }
            arrayList.add(objC);
        }
        return arrayList;
    }

    public static Map b(String str) {
        com.google.android.gms.common.internal.I.d(str);
        List<String> listZza = zzt.zza('.').zza((CharSequence) str);
        int size = listZza.size();
        C1402a c1402a = f7734a;
        if (size < 2) {
            c1402a.c(AbstractC1024h.b("Invalid idToken ", str), new Object[0]);
            return new HashMap();
        }
        String str2 = listZza.get(1);
        try {
            C0910b c0910bD = d(new String(str2 == null ? null : Base64.decode(str2, 11), "UTF-8"));
            return c0910bD == null ? new HashMap() : c0910bD;
        } catch (UnsupportedEncodingException e) {
            c1402a.b("Unable to decode token", e, new Object[0]);
            return new HashMap();
        }
    }

    public static C0910b c(JSONObject jSONObject) throws JSONException {
        C0910b c0910b = new C0910b();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objC = jSONObject.get(next);
            if (objC instanceof JSONArray) {
                objC = a((JSONArray) objC);
            } else if (objC instanceof JSONObject) {
                objC = c((JSONObject) objC);
            }
            c0910b.put(next, objC);
        }
        return c0910b;
    }

    public static C0910b d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return c(jSONObject);
            }
            return null;
        } catch (Exception e) {
            Log.d("JSONParser", "Failed to parse JSONObject into Map.");
            throw new zzaao(e);
        }
    }
}
