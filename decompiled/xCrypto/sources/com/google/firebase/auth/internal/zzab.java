package com.google.firebase.auth.internal;

import A1.a;
import A1.c;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.p002firebaseauthapi.zzaag;
import com.google.android.gms.internal.p002firebaseauthapi.zzahc;
import com.google.android.gms.internal.p002firebaseauthapi.zzaht;
import com.google.firebase.auth.UserInfo;
import io.flutter.plugins.firebase.auth.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzab extends a implements UserInfo {
    public static final Parcelable.Creator<zzab> CREATOR = new zzaa();
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private Uri zze;
    private String zzf;
    private String zzg;
    private boolean zzh;
    private String zzi;

    public zzab(zzaht zzahtVar) {
        AbstractC0940s.k(zzahtVar);
        this.zza = zzahtVar.zzd();
        this.zzb = AbstractC0940s.e(zzahtVar.zzf());
        this.zzc = zzahtVar.zzb();
        Uri uriZza = zzahtVar.zza();
        if (uriZza != null) {
            this.zzd = uriZza.toString();
            this.zze = uriZza;
        }
        this.zzf = zzahtVar.zzc();
        this.zzg = zzahtVar.zze();
        this.zzh = false;
        this.zzi = zzahtVar.zzg();
    }

    public static zzab zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzab(jSONObject.optString("userId"), jSONObject.optString(Constants.PROVIDER_ID), jSONObject.optString(Constants.EMAIL), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e4) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzaag(e4);
        }
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getDisplayName() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getEmail() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getPhoneNumber() {
        return this.zzg;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzd) && this.zze == null) {
            this.zze = Uri.parse(this.zzd);
        }
        return this.zze;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getProviderId() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getUid() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final boolean isEmailVerified() {
        return this.zzh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.E(parcel, 1, getUid(), false);
        c.E(parcel, 2, getProviderId(), false);
        c.E(parcel, 3, getDisplayName(), false);
        c.E(parcel, 4, this.zzd, false);
        c.E(parcel, 5, getEmail(), false);
        c.E(parcel, 6, getPhoneNumber(), false);
        c.g(parcel, 7, isEmailVerified());
        c.E(parcel, 8, this.zzi, false);
        c.b(parcel, iA);
    }

    public final String zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.zza);
            jSONObject.putOpt(Constants.PROVIDER_ID, this.zzb);
            jSONObject.putOpt("displayName", this.zzc);
            jSONObject.putOpt("photoUrl", this.zzd);
            jSONObject.putOpt(Constants.EMAIL, this.zzf);
            jSONObject.putOpt("phoneNumber", this.zzg);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzh));
            jSONObject.putOpt("rawUserInfo", this.zzi);
            return jSONObject.toString();
        } catch (JSONException e4) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzaag(e4);
        }
    }

    public zzab(zzahc zzahcVar, String str) {
        AbstractC0940s.k(zzahcVar);
        AbstractC0940s.e(str);
        this.zza = AbstractC0940s.e(zzahcVar.zzi());
        this.zzb = str;
        this.zzf = zzahcVar.zzh();
        this.zzc = zzahcVar.zzg();
        Uri uriZzc = zzahcVar.zzc();
        if (uriZzc != null) {
            this.zzd = uriZzc.toString();
            this.zze = uriZzc;
        }
        this.zzh = zzahcVar.zzm();
        this.zzi = null;
        this.zzg = zzahcVar.zzj();
    }

    public final String zza() {
        return this.zzi;
    }

    public zzab(String str, String str2, String str3, String str4, String str5, String str6, boolean z4, String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzf = str3;
        this.zzg = str4;
        this.zzc = str5;
        this.zzd = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.zze = Uri.parse(this.zzd);
        }
        this.zzh = z4;
        this.zzi = str7;
    }
}
