package com.google.android.gms.internal.p002firebaseauthapi;

import A1.a;
import A1.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.auth.internal.zzr;
import io.flutter.plugins.firebase.auth.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzait extends a implements zzaes {
    public static final Parcelable.Creator<zzait> CREATOR = new zzais();
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private boolean zzi;
    private boolean zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private String zzn;
    private boolean zzo;
    private String zzp;

    public zzait() {
        this.zzi = true;
        this.zzj = true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.E(parcel, 2, this.zza, false);
        c.E(parcel, 3, this.zzb, false);
        c.E(parcel, 4, this.zzc, false);
        c.E(parcel, 5, this.zzd, false);
        c.E(parcel, 6, this.zze, false);
        c.E(parcel, 7, this.zzf, false);
        c.E(parcel, 8, this.zzg, false);
        c.E(parcel, 9, this.zzh, false);
        c.g(parcel, 10, this.zzi);
        c.g(parcel, 11, this.zzj);
        c.E(parcel, 12, this.zzk, false);
        c.E(parcel, 13, this.zzl, false);
        c.E(parcel, 14, this.zzm, false);
        c.E(parcel, 15, this.zzn, false);
        c.g(parcel, 16, this.zzo);
        c.E(parcel, 17, this.zzp, false);
        c.b(parcel, iA);
    }

    public final zzait zza(boolean z4) {
        this.zzj = false;
        return this;
    }

    public final zzait zzb(boolean z4) {
        this.zzo = true;
        return this;
    }

    public final zzait zzc(boolean z4) {
        this.zzi = true;
        return this;
    }

    public final zzait zza(String str) {
        this.zzb = AbstractC0940s.e(str);
        return this;
    }

    public final zzait zzb(String str) {
        this.zzn = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoCreate", this.zzj);
        jSONObject.put("returnSecureToken", this.zzi);
        String str = this.zzb;
        if (str != null) {
            jSONObject.put(Constants.ID_TOKEN, str);
        }
        String str2 = this.zzg;
        if (str2 != null) {
            jSONObject.put("postBody", str2);
        }
        String str3 = this.zzn;
        if (str3 != null) {
            jSONObject.put("tenantId", str3);
        }
        String str4 = this.zzp;
        if (str4 != null) {
            jSONObject.put("pendingToken", str4);
        }
        if (!TextUtils.isEmpty(this.zzl)) {
            jSONObject.put("sessionId", this.zzl);
        }
        if (!TextUtils.isEmpty(this.zzm)) {
            jSONObject.put("requestUri", this.zzm);
        } else {
            String str5 = this.zza;
            if (str5 != null) {
                jSONObject.put("requestUri", str5);
            }
        }
        jSONObject.put("returnIdpCredential", this.zzo);
        return jSONObject.toString();
    }

    public zzait(zzr zzrVar, String str) {
        AbstractC0940s.k(zzrVar);
        this.zzl = AbstractC0940s.e(zzrVar.zzd());
        this.zzm = AbstractC0940s.e(str);
        this.zze = AbstractC0940s.e(zzrVar.zzc());
        this.zzi = true;
        this.zzg = "providerId=" + this.zze;
    }

    public zzait(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.zza = "http://localhost";
        this.zzc = str;
        this.zzd = str2;
        this.zzh = str5;
        this.zzk = str6;
        this.zzn = str7;
        this.zzp = str8;
        this.zzi = true;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(this.zzd) && TextUtils.isEmpty(this.zzk)) {
            throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
        }
        this.zze = AbstractC0940s.e(str3);
        this.zzf = null;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.zzc)) {
            sb.append("id_token=");
            sb.append(this.zzc);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzd)) {
            sb.append("access_token=");
            sb.append(this.zzd);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzf)) {
            sb.append("identifier=");
            sb.append(this.zzf);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            sb.append("oauth_token_secret=");
            sb.append(this.zzh);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzk)) {
            sb.append("code=");
            sb.append(this.zzk);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(str9)) {
            sb.append("nonce=");
            sb.append(str9);
            sb.append("&");
        }
        sb.append("providerId=");
        sb.append(this.zze);
        this.zzg = sb.toString();
        this.zzj = true;
    }

    public zzait(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z4, boolean z5, String str9, String str10, String str11, String str12, boolean z6, String str13) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = z4;
        this.zzj = z5;
        this.zzk = str9;
        this.zzl = str10;
        this.zzm = str11;
        this.zzn = str12;
        this.zzo = z6;
        this.zzp = str13;
    }
}
