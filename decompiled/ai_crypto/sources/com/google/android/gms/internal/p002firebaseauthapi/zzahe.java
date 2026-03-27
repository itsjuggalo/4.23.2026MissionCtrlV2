package com.google.android.gms.internal.p002firebaseauthapi;

import Z2.C0753e;
import com.google.android.gms.common.internal.AbstractC1207s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzahe implements zzaes {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private C0753e zze;
    private String zzf;
    private String zzg;

    public zzahe(int i7) {
        this.zza = zza(i7);
    }

    public static zzahe zza(C0753e c0753e, String str, String str2) {
        AbstractC1207s.e(str);
        AbstractC1207s.e(str2);
        AbstractC1207s.k(c0753e);
        return new zzahe(7, c0753e, null, str2, str, null, null);
    }

    public final C0753e zzb() {
        return this.zze;
    }

    public final zzahe zzc(String str) {
        this.zzf = str;
        return this;
    }

    public final zzahe zzd(String str) {
        this.zzd = AbstractC1207s.e(str);
        return this;
    }

    public final zzahe zzb(String str) {
        this.zzb = AbstractC1207s.e(str);
        return this;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzd;
    }

    private zzahe(int i7, C0753e c0753e, String str, String str2, String str3, String str4, String str5) {
        this.zza = zza(7);
        this.zze = (C0753e) AbstractC1207s.k(c0753e);
        this.zzb = null;
        this.zzc = str2;
        this.zzd = str3;
        this.zzf = null;
        this.zzg = null;
    }

    public final zzahe zza(C0753e c0753e) {
        this.zze = (C0753e) AbstractC1207s.k(c0753e);
        return this;
    }

    public final zzahe zza(String str) {
        this.zzg = str;
        return this;
    }

    private static String zza(int i7) {
        if (i7 == 1) {
            return "PASSWORD_RESET";
        }
        if (i7 == 4) {
            return "VERIFY_EMAIL";
        }
        if (i7 == 6) {
            return "EMAIL_SIGNIN";
        }
        if (i7 != 7) {
            return "REQUEST_TYPE_UNSET_ENUM_VALUE";
        }
        return "VERIFY_AND_CHANGE_EMAIL";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final String zza() throws JSONException {
        int i7;
        i7 = 1;
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        str.hashCode();
        switch (str) {
            case "PASSWORD_RESET":
                break;
            case "VERIFY_EMAIL":
                i7 = 4;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                i7 = 7;
                break;
            case "EMAIL_SIGNIN":
                i7 = 6;
                break;
            default:
                i7 = 0;
                break;
        }
        jSONObject.put("requestType", i7);
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put("email", str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("newEmail", str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            jSONObject.put("idToken", str4);
        }
        C0753e c0753e = this.zze;
        if (c0753e != null) {
            jSONObject.put("androidInstallApp", c0753e.B());
            jSONObject.put("canHandleCodeInApp", this.zze.A());
            if (this.zze.G() != null) {
                jSONObject.put("continueUrl", this.zze.G());
            }
            if (this.zze.E() != null) {
                jSONObject.put("iosBundleId", this.zze.E());
            }
            if (this.zze.zzd() != null) {
                jSONObject.put("iosAppStoreId", this.zze.zzd());
            }
            if (this.zze.D() != null) {
                jSONObject.put("androidPackageName", this.zze.D());
            }
            if (this.zze.C() != null) {
                jSONObject.put("androidMinimumVersion", this.zze.C());
            }
            if (this.zze.zzc() != null) {
                jSONObject.put("dynamicLinkDomain", this.zze.zzc());
            }
            if (this.zze.F() != null) {
                jSONObject.put("linkDomain", this.zze.F());
            }
        }
        String str5 = this.zzf;
        if (str5 != null) {
            jSONObject.put("tenantId", str5);
        }
        String str6 = this.zzg;
        if (str6 != null) {
            zzajc.zza(jSONObject, "captchaResp", str6);
        } else {
            zzajc.zza(jSONObject);
        }
        return jSONObject.toString();
    }
}
