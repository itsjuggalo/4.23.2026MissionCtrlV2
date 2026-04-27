package com.google.firebase.auth;

import A1.a;
import A1.c;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzal extends a {
    public static final Parcelable.Creator<zzal> CREATOR = new zzan();
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzal(String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public static com.google.android.gms.internal.p002firebaseauthapi.zzaj<zzal> zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return com.google.android.gms.internal.p002firebaseauthapi.zzaj.zza(new ArrayList());
        }
        com.google.android.gms.internal.p002firebaseauthapi.zzam zzamVarZzg = com.google.android.gms.internal.p002firebaseauthapi.zzaj.zzg();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i4);
            zzamVarZzg.zza(new zzal(jSONObject.getString("credentialId"), jSONObject.getString("name"), jSONObject.getString("displayName")));
        }
        return zzamVarZzg.zza();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.E(parcel, 1, this.zza, false);
        c.E(parcel, 2, this.zzb, false);
        c.E(parcel, 3, this.zzc, false);
        c.b(parcel, iA);
    }

    public static final zzal zza(JSONObject jSONObject) {
        return new zzal(jSONObject.getString("credentialId"), jSONObject.getString("name"), jSONObject.getString("displayName"));
    }

    public static final JSONObject zza(zzal zzalVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("credentialId", zzalVar.zza);
        jSONObject.put("name", zzalVar.zzb);
        jSONObject.put("displayName", zzalVar.zzc);
        return jSONObject;
    }
}
