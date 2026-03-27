package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.I;
import i2.C0656b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzahm implements zzafa {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private C0656b zze;
    private String zzf;
    private String zzg;

    public zzahm(int i) {
        this.zza = zza(i);
    }

    public static zzahm zza(C0656b c0656b, String str, String str2) {
        I.d(str);
        I.d(str2);
        I.g(c0656b);
        return new zzahm(7, c0656b, null, str2, str, null, null);
    }

    public final C0656b zzb() {
        return this.zze;
    }

    public final zzahm zzc(String str) {
        this.zzf = str;
        return this;
    }

    public final zzahm zzd(String str) {
        I.d(str);
        this.zzd = str;
        return this;
    }

    public final zzahm zzb(String str) {
        I.d(str);
        this.zzb = str;
        return this;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzd;
    }

    private zzahm(int i, C0656b c0656b, String str, String str2, String str3, String str4, String str5) {
        this.zza = zza(7);
        I.g(c0656b);
        this.zze = c0656b;
        this.zzb = null;
        this.zzc = str2;
        this.zzd = str3;
        this.zzf = null;
        this.zzg = null;
    }

    public final zzahm zza(C0656b c0656b) {
        I.g(c0656b);
        this.zze = c0656b;
        return this;
    }

    public final zzahm zza(String str) {
        this.zzg = str;
        return this;
    }

    private static String zza(int i) {
        if (i == 1) {
            return "PASSWORD_RESET";
        }
        if (i == 4) {
            return "VERIFY_EMAIL";
        }
        if (i == 6) {
            return "EMAIL_SIGNIN";
        }
        if (i != 7) {
            return "REQUEST_TYPE_UNSET_ENUM_VALUE";
        }
        return "VERIFY_AND_CHANGE_EMAIL";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafa
    public final String zza() throws JSONException {
        int i;
        i = 1;
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        str.getClass();
        switch (str) {
            case "PASSWORD_RESET":
                break;
            case "VERIFY_EMAIL":
                i = 4;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                i = 7;
                break;
            case "EMAIL_SIGNIN":
                i = 6;
                break;
            default:
                i = 0;
                break;
        }
        jSONObject.put("requestType", i);
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
        C0656b c0656b = this.zze;
        if (c0656b != null) {
            jSONObject.put("androidInstallApp", c0656b.e);
            jSONObject.put("canHandleCodeInApp", this.zze.f6779k);
            String str5 = this.zze.f6774a;
            if (str5 != null) {
                jSONObject.put("continueUrl", str5);
            }
            String str6 = this.zze.f6775b;
            if (str6 != null) {
                jSONObject.put("iosBundleId", str6);
            }
            String str7 = this.zze.f6776c;
            if (str7 != null) {
                jSONObject.put("iosAppStoreId", str7);
            }
            String str8 = this.zze.f6777d;
            if (str8 != null) {
                jSONObject.put("androidPackageName", str8);
            }
            String str9 = this.zze.f6778f;
            if (str9 != null) {
                jSONObject.put("androidMinimumVersion", str9);
            }
            String str10 = this.zze.f6782n;
            if (str10 != null) {
                jSONObject.put("dynamicLinkDomain", str10);
            }
            String str11 = this.zze.f6783o;
            if (str11 != null) {
                jSONObject.put("linkDomain", str11);
            }
        }
        String str12 = this.zzf;
        if (str12 != null) {
            jSONObject.put("tenantId", str12);
        }
        String str13 = this.zzg;
        if (str13 != null) {
            zzajk.zza(jSONObject, "captchaResp", str13);
        } else {
            zzajk.zza(jSONObject);
        }
        return jSONObject.toString();
    }
}
