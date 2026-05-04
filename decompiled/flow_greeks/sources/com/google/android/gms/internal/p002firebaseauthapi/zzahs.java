package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t5.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class zzahs implements zzaez<zzahs> {
    private static final String zza = "zzahs";
    private String zzb;
    private zzah<zzaid> zzc;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaez
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzahs zza(String str) throws zzacn {
        zzah<zzaid> zzahVarZzg;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = p.a(jSONObject.optString("recaptchaKey"));
            if (jSONObject.has("recaptchaEnforcementState")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("recaptchaEnforcementState");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    zzahVarZzg = zzah.zzg();
                } else {
                    zzak zzakVarZzf = zzah.zzf();
                    for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i10);
                        zzakVarZzf.zza(jSONObject2 == null ? zzaid.zza(null, null) : zzaid.zza(p.a(jSONObject2.optString("provider")), p.a(jSONObject2.optString("enforcementState"))));
                    }
                    zzahVarZzg = zzakVarZzf.zza();
                }
                this.zzc = zzahVarZzg;
            }
            return this;
        } catch (NullPointerException e10) {
            e = e10;
            throw zzajk.zza(e, zza, str);
        } catch (JSONException e11) {
            e = e11;
            throw zzajk.zza(e, zza, str);
        }
    }

    public final String zzb(String str) {
        s.e(str);
        zzah<zzaid> zzahVar = this.zzc;
        if (zzahVar != null && !zzahVar.isEmpty()) {
            zzah<zzaid> zzahVar2 = this.zzc;
            int size = zzahVar2.size();
            int i10 = 0;
            while (i10 < size) {
                zzaid zzaidVar = zzahVar2.get(i10);
                i10++;
                zzaid zzaidVar2 = zzaidVar;
                String strZza = zzaidVar2.zza();
                String strZzb = zzaidVar2.zzb();
                if (strZza != null && strZzb != null && strZzb.equals(str)) {
                    return zzaidVar2.zza();
                }
            }
        }
        return null;
    }

    public final boolean zzc(String str) {
        String strZzb = zzb(str);
        if (strZzb == null) {
            return false;
        }
        return strZzb.equals("ENFORCE") || strZzb.equals("AUDIT");
    }

    public final String zza() {
        return this.zzb;
    }
}
