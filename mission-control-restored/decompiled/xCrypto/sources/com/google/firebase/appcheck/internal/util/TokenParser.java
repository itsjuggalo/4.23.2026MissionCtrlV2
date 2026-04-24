package com.google.firebase.appcheck.internal.util;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u.C1853a;

/* JADX INFO: loaded from: classes.dex */
public class TokenParser {
    private static Map<String, Object> parseJsonIntoMap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return toMap(jSONObject);
            }
            return null;
        } catch (Exception e4) {
            Logger.getLogger().d("Failed to parse JSONObject into Map:\n" + e4);
            return Collections.EMPTY_MAP;
        }
    }

    public static Map<String, Object> parseTokenClaims(String str) {
        AbstractC0940s.e(str);
        String[] strArrSplit = str.split("\\.", -1);
        if (strArrSplit.length < 2) {
            Logger.getLogger().e("Invalid token (too few subsections):\n" + str);
            return Collections.EMPTY_MAP;
        }
        try {
            Map<String, Object> jsonIntoMap = parseJsonIntoMap(new String(Base64.decode(strArrSplit[1], 11), "UTF-8"));
            return jsonIntoMap == null ? Collections.EMPTY_MAP : jsonIntoMap;
        } catch (UnsupportedEncodingException e4) {
            Logger.getLogger().e("Unable to decode token (charset unknown):\n" + e4);
            return Collections.EMPTY_MAP;
        }
    }

    private static List<Object> toList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            Object map = jSONArray.get(i4);
            if (map instanceof JSONArray) {
                map = toList((JSONArray) map);
            } else if (map instanceof JSONObject) {
                map = toMap((JSONObject) map);
            }
            arrayList.add(map);
        }
        return arrayList;
    }

    private static Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        C1853a c1853a = new C1853a();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object map = jSONObject.get(next);
            if (map instanceof JSONArray) {
                map = toList((JSONArray) map);
            } else if (map instanceof JSONObject) {
                map = toMap((JSONObject) map);
            } else if (map.equals(JSONObject.NULL)) {
                map = null;
            }
            c1853a.put(next, map);
        }
        return c1853a;
    }
}
