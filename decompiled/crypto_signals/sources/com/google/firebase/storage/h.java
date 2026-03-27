package com.google.firebase.storage;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f5563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f5564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5565c;

    public h(ArrayList arrayList, ArrayList arrayList2, String str) {
        this.f5563a = arrayList;
        this.f5564b = arrayList2;
        this.f5565c = str;
    }

    public static h a(f fVar, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (jSONObject.has("prefixes")) {
            JSONArray jSONArray = jSONObject.getJSONArray("prefixes");
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                if (string.endsWith("/")) {
                    string = string.substring(0, string.length() - 1);
                }
                arrayList.add(fVar.d(string));
            }
        }
        if (jSONObject.has("items")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("items");
            for (int i6 = 0; i6 < jSONArray2.length(); i6++) {
                arrayList2.add(fVar.d(jSONArray2.getJSONObject(i6).getString("name")));
            }
        }
        return new h(arrayList, arrayList2, jSONObject.optString("nextPageToken", null));
    }
}
