package com.google.firebase.storage;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.google.firebase.storage.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1224j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f12451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f12452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12453c;

    public C1224j(List list, List list2, String str) {
        this.f12451a = list;
        this.f12452b = list2;
        this.f12453c = str;
    }

    public static C1224j a(C1220f c1220f, JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (jSONObject.has("prefixes")) {
            JSONArray jSONArray = jSONObject.getJSONArray("prefixes");
            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                String string = jSONArray.getString(i7);
                if (string.endsWith("/")) {
                    string = string.substring(0, string.length() - 1);
                }
                arrayList.add(c1220f.n(string));
            }
        }
        if (jSONObject.has("items")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("items");
            for (int i8 = 0; i8 < jSONArray2.length(); i8++) {
                arrayList2.add(c1220f.n(jSONArray2.getJSONObject(i8).getString("name")));
            }
        }
        return new C1224j(arrayList, arrayList2, jSONObject.optString("nextPageToken", null));
    }

    public List b() {
        return this.f12452b;
    }

    public String c() {
        return this.f12453c;
    }

    public List d() {
        return this.f12451a;
    }
}
