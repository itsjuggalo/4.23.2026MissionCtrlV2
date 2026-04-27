package com.google.android.gms.internal.p002firebaseauthapi;

import A1.a;
import A1.c;
import G1.g;
import G1.q;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzahn extends a implements zzaer<zzahn> {
    public static final Parcelable.Creator<zzahn> CREATOR = new zzahm();
    private static final String zza = "zzahn";
    private String zzb;
    private String zzc;
    private Long zzd;
    private String zze;
    private Long zzf;

    public zzahn() {
        this.zzf = Long.valueOf(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzahn zza(String str) throws zzaci {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = q.a(jSONObject.optString("refresh_token"));
            this.zzc = q.a(jSONObject.optString("access_token"));
            this.zzd = Long.valueOf(jSONObject.optLong("expires_in", 0L));
            this.zze = q.a(jSONObject.optString("token_type"));
            this.zzf = Long.valueOf(System.currentTimeMillis());
            return this;
        } catch (NullPointerException | JSONException e4) {
            throw zzajc.zza(e4, zza, str);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.E(parcel, 2, this.zzb, false);
        c.E(parcel, 3, this.zzc, false);
        c.z(parcel, 4, Long.valueOf(zza()), false);
        c.E(parcel, 5, this.zze, false);
        Long l4 = this.zzf;
        l4.longValue();
        c.z(parcel, 6, l4, false);
        c.b(parcel, iA);
    }

    public final long zza() {
        Long l4 = this.zzd;
        if (l4 == null) {
            return 0L;
        }
        return l4.longValue();
    }

    public final long zzb() {
        return this.zzf.longValue();
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", this.zzb);
            jSONObject.put("access_token", this.zzc);
            jSONObject.put("expires_in", this.zzd);
            jSONObject.put("token_type", this.zze);
            jSONObject.put("issued_at", this.zzf);
            return jSONObject.toString();
        } catch (JSONException e4) {
            Log.d(zza, "Failed to convert GetTokenResponse to JSON");
            throw new zzaag(e4);
        }
    }

    public final boolean zzg() {
        return g.c().currentTimeMillis() + 300000 < this.zzf.longValue() + (this.zzd.longValue() * 1000);
    }

    public static zzahn zzb(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzahn zzahnVar = new zzahn();
            zzahnVar.zzb = jSONObject.optString("refresh_token", null);
            zzahnVar.zzc = jSONObject.optString("access_token", null);
            zzahnVar.zzd = Long.valueOf(jSONObject.optLong("expires_in"));
            zzahnVar.zze = jSONObject.optString("token_type", null);
            zzahnVar.zzf = Long.valueOf(jSONObject.optLong("issued_at"));
            return zzahnVar;
        } catch (JSONException e4) {
            Log.d(zza, "Failed to read GetTokenResponse from JSONObject");
            throw new zzaag(e4);
        }
    }

    public final void zzc(String str) {
        this.zzb = AbstractC0940s.e(str);
    }

    public zzahn(String str, String str2, Long l4, String str3) {
        this(str, str2, l4, str3, Long.valueOf(System.currentTimeMillis()));
    }

    public zzahn(String str, String str2, Long l4, String str3, Long l5) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = l4;
        this.zze = str3;
        this.zzf = l5;
    }

    public final String zzd() {
        return this.zzb;
    }
}
