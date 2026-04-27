package com.google.firebase.auth.internal;

import C1.a;
import G1.c;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.a.a.o.c.a.b;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.p002firebaseauthapi.zzaag;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u.C1853a;

/* JADX INFO: loaded from: classes.dex */
final class zzbh {
    private static final a zza = new a("JSONParser", new String[0]);

    private static List<Object> zza(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            Object objZza = jSONArray.get(i4);
            if (objZza instanceof JSONArray) {
                objZza = zza((JSONArray) objZza);
            } else if (objZza instanceof JSONObject) {
                objZza = zza((JSONObject) objZza);
            }
            arrayList.add(objZza);
        }
        return arrayList;
    }

    public static Map<String, Object> zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return zza(jSONObject);
            }
            return null;
        } catch (Exception e4) {
            Log.d("JSONParser", "Failed to parse JSONObject into Map.");
            throw new zzaag(e4);
        }
    }

    public static Map<String, Object> zza(String str) {
        AbstractC0940s.e(str);
        List<String> listZza = com.google.android.gms.internal.p002firebaseauthapi.zzv.zza(b.f8816a).zza((CharSequence) str);
        if (listZza.size() < 2) {
            zza.c("Invalid idToken " + str, new Object[0]);
            return new HashMap();
        }
        try {
            Map<String, Object> mapZzb = zzb(new String(c.b(listZza.get(1)), "UTF-8"));
            return mapZzb == null ? new HashMap() : mapZzb;
        } catch (UnsupportedEncodingException e4) {
            zza.b("Unable to decode token", e4, new Object[0]);
            return new HashMap();
        }
    }

    private static Map<String, Object> zza(JSONObject jSONObject) throws JSONException {
        C1853a c1853a = new C1853a();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objZza = jSONObject.get(next);
            if (objZza instanceof JSONArray) {
                objZza = zza((JSONArray) objZza);
            } else if (objZza instanceof JSONObject) {
                objZza = zza((JSONObject) objZza);
            }
            c1853a.put(next, objZza);
        }
        return c1853a;
    }
}
