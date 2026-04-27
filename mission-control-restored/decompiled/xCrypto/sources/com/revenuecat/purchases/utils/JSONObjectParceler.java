package com.revenuecat.purchases.utils;

import E3.a;
import android.os.Parcel;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class JSONObjectParceler implements E3.a {
    public static final JSONObjectParceler INSTANCE = new JSONObjectParceler();

    private JSONObjectParceler() {
    }

    public JSONObject create(Parcel parcel) {
        r.f(parcel, "parcel");
        return new JSONObject(parcel.readString());
    }

    public JSONObject[] newArray(int i4) {
        return (JSONObject[]) a.C0017a.a(this, i4);
    }

    public void write(JSONObject jSONObject, Parcel parcel, int i4) {
        r.f(jSONObject, "<this>");
        r.f(parcel, "parcel");
        parcel.writeString(jSONObject.toString());
    }
}
