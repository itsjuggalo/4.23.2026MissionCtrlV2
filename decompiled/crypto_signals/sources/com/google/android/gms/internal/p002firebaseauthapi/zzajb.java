package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.I;
import j2.O;
import org.json.JSONException;
import org.json.JSONObject;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class zzajb extends AbstractC1255a implements zzafa {
    public static final Parcelable.Creator<zzajb> CREATOR = new zzaja();
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

    public zzajb() {
        this.zzi = true;
        this.zzj = true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.T(parcel, 2, this.zza, false);
        u0.T(parcel, 3, this.zzb, false);
        u0.T(parcel, 4, this.zzc, false);
        u0.T(parcel, 5, this.zzd, false);
        u0.T(parcel, 6, this.zze, false);
        u0.T(parcel, 7, this.zzf, false);
        u0.T(parcel, 8, this.zzg, false);
        u0.T(parcel, 9, this.zzh, false);
        boolean z6 = this.zzi;
        u0.b0(parcel, 10, 4);
        parcel.writeInt(z6 ? 1 : 0);
        boolean z7 = this.zzj;
        u0.b0(parcel, 11, 4);
        parcel.writeInt(z7 ? 1 : 0);
        u0.T(parcel, 12, this.zzk, false);
        u0.T(parcel, 13, this.zzl, false);
        u0.T(parcel, 14, this.zzm, false);
        u0.T(parcel, 15, this.zzn, false);
        boolean z8 = this.zzo;
        u0.b0(parcel, 16, 4);
        parcel.writeInt(z8 ? 1 : 0);
        u0.T(parcel, 17, this.zzp, false);
        u0.a0(iX, parcel);
    }

    public final zzajb zza(boolean z6) {
        this.zzj = false;
        return this;
    }

    public final zzajb zzb(boolean z6) {
        this.zzo = true;
        return this;
    }

    public final zzajb zzc(boolean z6) {
        this.zzi = true;
        return this;
    }

    public final zzajb zza(String str) {
        I.d(str);
        this.zzb = str;
        return this;
    }

    public final zzajb zzb(String str) {
        this.zzn = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafa
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoCreate", this.zzj);
        jSONObject.put("returnSecureToken", this.zzi);
        String str = this.zzb;
        if (str != null) {
            jSONObject.put("idToken", str);
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

    public zzajb(O o3, String str) {
        I.g(o3);
        String str2 = o3.f7657a;
        I.d(str2);
        this.zzl = str2;
        I.d(str);
        this.zzm = str;
        String str3 = o3.f7659c;
        I.d(str3);
        this.zze = str3;
        this.zzi = true;
        this.zzg = "providerId=" + this.zze;
    }

    public zzajb(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
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
        I.d(str3);
        this.zze = str3;
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

    public zzajb(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z6, boolean z7, String str9, String str10, String str11, String str12, boolean z8, String str13) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = z6;
        this.zzj = z7;
        this.zzk = str9;
        this.zzl = str10;
        this.zzm = str11;
        this.zzn = str12;
        this.zzo = z8;
        this.zzp = str13;
    }
}
