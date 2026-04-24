package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.auth.ActionCodeSettings;
import io.flutter.plugins.firebase.auth.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzahe implements zzaes {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private ActionCodeSettings zze;
    private String zzf;
    private String zzg;

    public zzahe(int i4) {
        this.zza = zza(i4);
    }

    public static zzahe zza(ActionCodeSettings actionCodeSettings, String str, String str2) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.k(actionCodeSettings);
        return new zzahe(7, actionCodeSettings, null, str2, str, null, null);
    }

    public final ActionCodeSettings zzb() {
        return this.zze;
    }

    public final zzahe zzc(String str) {
        this.zzf = str;
        return this;
    }

    public final zzahe zzd(String str) {
        this.zzd = AbstractC0940s.e(str);
        return this;
    }

    public final zzahe zzb(String str) {
        this.zzb = AbstractC0940s.e(str);
        return this;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzd;
    }

    private zzahe(int i4, ActionCodeSettings actionCodeSettings, String str, String str2, String str3, String str4, String str5) {
        this.zza = zza(7);
        this.zze = (ActionCodeSettings) AbstractC0940s.k(actionCodeSettings);
        this.zzb = null;
        this.zzc = str2;
        this.zzd = str3;
        this.zzf = null;
        this.zzg = null;
    }

    public final zzahe zza(ActionCodeSettings actionCodeSettings) {
        this.zze = (ActionCodeSettings) AbstractC0940s.k(actionCodeSettings);
        return this;
    }

    public final zzahe zza(String str) {
        this.zzg = str;
        return this;
    }

    private static String zza(int i4) {
        if (i4 == 1) {
            return "PASSWORD_RESET";
        }
        if (i4 == 4) {
            return "VERIFY_EMAIL";
        }
        if (i4 == 6) {
            return "EMAIL_SIGNIN";
        }
        if (i4 != 7) {
            return "REQUEST_TYPE_UNSET_ENUM_VALUE";
        }
        return "VERIFY_AND_CHANGE_EMAIL";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final String zza() throws JSONException {
        int i4;
        i4 = 1;
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        str.getClass();
        switch (str) {
            case "PASSWORD_RESET":
                break;
            case "VERIFY_EMAIL":
                i4 = 4;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                i4 = 7;
                break;
            case "EMAIL_SIGNIN":
                i4 = 6;
                break;
            default:
                i4 = 0;
                break;
        }
        jSONObject.put("requestType", i4);
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
        ActionCodeSettings actionCodeSettings = this.zze;
        if (actionCodeSettings != null) {
            jSONObject.put("androidInstallApp", actionCodeSettings.getAndroidInstallApp());
            jSONObject.put("canHandleCodeInApp", this.zze.canHandleCodeInApp());
            if (this.zze.getUrl() != null) {
                jSONObject.put("continueUrl", this.zze.getUrl());
            }
            if (this.zze.getIOSBundle() != null) {
                jSONObject.put("iosBundleId", this.zze.getIOSBundle());
            }
            if (this.zze.zzd() != null) {
                jSONObject.put("iosAppStoreId", this.zze.zzd());
            }
            if (this.zze.getAndroidPackageName() != null) {
                jSONObject.put("androidPackageName", this.zze.getAndroidPackageName());
            }
            if (this.zze.getAndroidMinimumVersion() != null) {
                jSONObject.put("androidMinimumVersion", this.zze.getAndroidMinimumVersion());
            }
            if (this.zze.zzc() != null) {
                jSONObject.put("dynamicLinkDomain", this.zze.zzc());
            }
            if (this.zze.getLinkDomain() != null) {
                jSONObject.put("linkDomain", this.zze.getLinkDomain());
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
