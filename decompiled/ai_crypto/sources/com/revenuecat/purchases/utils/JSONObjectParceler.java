package com.revenuecat.purchases.utils;

import android.os.Parcel;
import kotlin.jvm.internal.r;
import m6.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class JSONObjectParceler implements a {
    public static final JSONObjectParceler INSTANCE = new JSONObjectParceler();

    private JSONObjectParceler() {
    }

    public JSONObject create(Parcel parcel) {
        r.f(parcel, "parcel");
        return new JSONObject(parcel.readString());
    }

    public JSONObject[] newArray(int i7) {
        return (JSONObject[]) a.C0311a.a(this, i7);
    }

    public void write(JSONObject jSONObject, Parcel parcel, int i7) {
        r.f(jSONObject, "<this>");
        r.f(parcel, "parcel");
        parcel.writeString(jSONObject.toString());
    }
}
