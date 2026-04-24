package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.AbstractC0940s;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzaid implements zzaes {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzj;
    private boolean zzh = true;
    private zzaio zzg = new zzaio();
    private zzaio zzi = new zzaio();

    public final zzaid zza(String str) {
        AbstractC0940s.e(str);
        this.zzi.zzb().add(str);
        return this;
    }

    public final zzaid zzb(String str) {
        if (str == null) {
            this.zzg.zzb().add("DISPLAY_NAME");
            return this;
        }
        this.zzb = str;
        return this;
    }

    public final zzaid zzc(String str) {
        if (str == null) {
            this.zzg.zzb().add("EMAIL");
            return this;
        }
        this.zzc = str;
        return this;
    }

    public final zzaid zzd(String str) {
        this.zza = AbstractC0940s.e(str);
        return this;
    }

    public final zzaid zze(String str) {
        this.zze = AbstractC0940s.e(str);
        return this;
    }

    public final zzaid zzf(String str) {
        if (str == null) {
            this.zzg.zzb().add("PASSWORD");
            return this;
        }
        this.zzd = str;
        return this;
    }

    public final zzaid zzg(String str) {
        if (str == null) {
            this.zzg.zzb().add("PHOTO_URL");
            return this;
        }
        this.zzf = str;
        return this;
    }

    public final zzaid zzh(String str) {
        this.zzj = str;
        return this;
    }

    public final boolean zzi(String str) {
        AbstractC0940s.e(str);
        return this.zzg.zzb().contains(str);
    }

    public final String zzd() {
        return this.zzd;
    }

    public final String zze() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final String zza() throws JSONException {
        int i4;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("returnSecureToken", this.zzh);
        if (!this.zzi.zzb().isEmpty()) {
            List<String> listZzb = this.zzi.zzb();
            JSONArray jSONArray = new JSONArray();
            for (int i5 = 0; i5 < listZzb.size(); i5++) {
                jSONArray.put(listZzb.get(i5));
            }
            jSONObject.put("deleteProvider", jSONArray);
        }
        List<String> listZzb2 = this.zzg.zzb();
        int size = listZzb2.size();
        int[] iArr = new int[size];
        for (int i6 = 0; i6 < listZzb2.size(); i6++) {
            String str = listZzb2.get(i6);
            str.getClass();
            switch (str) {
                case "DISPLAY_NAME":
                    i4 = 2;
                    break;
                case "EMAIL":
                    i4 = 1;
                    break;
                case "PHOTO_URL":
                    i4 = 4;
                    break;
                case "PASSWORD":
                    i4 = 5;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            iArr[i6] = i4;
        }
        if (size > 0) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i7 = 0; i7 < size; i7++) {
                jSONArray2.put(iArr[i7]);
            }
            jSONObject.put("deleteAttribute", jSONArray2);
        }
        String str2 = this.zza;
        if (str2 != null) {
            jSONObject.put(Constants.ID_TOKEN, str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put(Constants.EMAIL, str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            jSONObject.put("password", str4);
        }
        String str5 = this.zzb;
        if (str5 != null) {
            jSONObject.put("displayName", str5);
        }
        String str6 = this.zzf;
        if (str6 != null) {
            jSONObject.put("photoUrl", str6);
        }
        String str7 = this.zze;
        if (str7 != null) {
            jSONObject.put("oobCode", str7);
        }
        String str8 = this.zzj;
        if (str8 != null) {
            jSONObject.put("tenantId", str8);
        }
        return jSONObject.toString();
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }
}
