package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.s;
import io.flutter.plugins.firebase.auth.Constants;
import m7.e;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzahm implements zzafa {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private e zze;
    private String zzf;
    private String zzg;

    public zzahm(int i10) {
        this.zza = zza(i10);
    }

    public static zzahm zza(e eVar, String str, String str2) {
        s.e(str);
        s.e(str2);
        s.k(eVar);
        return new zzahm(7, eVar, null, str2, str, null, null);
    }

    public final e zzb() {
        return this.zze;
    }

    public final zzahm zzc(String str) {
        this.zzf = str;
        return this;
    }

    public final zzahm zzd(String str) {
        this.zzd = s.e(str);
        return this;
    }

    public final zzahm zzb(String str) {
        this.zzb = s.e(str);
        return this;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzd;
    }

    private zzahm(int i10, e eVar, String str, String str2, String str3, String str4, String str5) {
        this.zza = zza(7);
        this.zze = (e) s.k(eVar);
        this.zzb = null;
        this.zzc = str2;
        this.zzd = str3;
        this.zzf = null;
        this.zzg = null;
    }

    public final zzahm zza(e eVar) {
        this.zze = (e) s.k(eVar);
        return this;
    }

    public final zzahm zza(String str) {
        this.zzg = str;
        return this;
    }

    private static String zza(int i10) {
        if (i10 == 1) {
            return "PASSWORD_RESET";
        }
        if (i10 == 4) {
            return "VERIFY_EMAIL";
        }
        if (i10 == 6) {
            return "EMAIL_SIGNIN";
        }
        if (i10 != 7) {
            return "REQUEST_TYPE_UNSET_ENUM_VALUE";
        }
        return "VERIFY_AND_CHANGE_EMAIL";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafa
    public final String zza() throws JSONException {
        int i10;
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        str.getClass();
        i10 = 1;
        switch (str) {
            case "PASSWORD_RESET":
                break;
            case "VERIFY_EMAIL":
                i10 = 4;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                i10 = 7;
                break;
            case "EMAIL_SIGNIN":
                i10 = 6;
                break;
            default:
                i10 = 0;
                break;
        }
        jSONObject.put("requestType", i10);
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put(Constants.EMAIL, str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("newEmail", str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            jSONObject.put(Constants.ID_TOKEN, str4);
        }
        e eVar = this.zze;
        if (eVar != null) {
            jSONObject.put("androidInstallApp", eVar.S());
            jSONObject.put("canHandleCodeInApp", this.zze.R());
            if (this.zze.X() != null) {
                jSONObject.put("continueUrl", this.zze.X());
            }
            if (this.zze.V() != null) {
                jSONObject.put("iosBundleId", this.zze.V());
            }
            if (this.zze.zzd() != null) {
                jSONObject.put("iosAppStoreId", this.zze.zzd());
            }
            if (this.zze.U() != null) {
                jSONObject.put("androidPackageName", this.zze.U());
            }
            if (this.zze.T() != null) {
                jSONObject.put("androidMinimumVersion", this.zze.T());
            }
            if (this.zze.zzc() != null) {
                jSONObject.put("dynamicLinkDomain", this.zze.zzc());
            }
            if (this.zze.W() != null) {
                jSONObject.put("linkDomain", this.zze.W());
            }
        }
        String str5 = this.zzf;
        if (str5 != null) {
            jSONObject.put("tenantId", str5);
        }
        String str6 = this.zzg;
        if (str6 != null) {
            zzajk.zza(jSONObject, "captchaResp", str6);
        } else {
            zzajk.zza(jSONObject);
        }
        return jSONObject.toString();
    }
}
