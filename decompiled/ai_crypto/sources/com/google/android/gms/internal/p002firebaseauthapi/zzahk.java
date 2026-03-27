package com.google.android.gms.internal.p002firebaseauthapi;

import W1.q;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzahk implements zzaer<zzahk> {
    private static final String zza = "zzahk";
    private String zzb;
    private zzaj<zzahv> zzc;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzahk zza(String str) throws zzaci {
        zzaj<zzahv> zzajVarZza;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = q.a(jSONObject.optString("recaptchaKey"));
            if (jSONObject.has("recaptchaEnforcementState")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("recaptchaEnforcementState");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    zzajVarZza = zzaj.zza(new ArrayList());
                } else {
                    zzam zzamVarZzg = zzaj.zzg();
                    for (int i7 = 0; i7 < jSONArrayOptJSONArray.length(); i7++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i7);
                        zzamVarZzg.zza(jSONObject2 == null ? zzahv.zza(null, null) : zzahv.zza(q.a(jSONObject2.optString("provider")), q.a(jSONObject2.optString("enforcementState"))));
                    }
                    zzajVarZza = zzamVarZzg.zza();
                }
                this.zzc = zzajVarZza;
            }
            return this;
        } catch (NullPointerException e7) {
            e = e7;
            throw zzajc.zza(e, zza, str);
        } catch (JSONException e8) {
            e = e8;
            throw zzajc.zza(e, zza, str);
        }
    }

    public final String zzb(String str) {
        AbstractC1207s.e(str);
        zzaj<zzahv> zzajVar = this.zzc;
        if (zzajVar != null && !zzajVar.isEmpty()) {
            zzaj<zzahv> zzajVar2 = this.zzc;
            int size = zzajVar2.size();
            int i7 = 0;
            while (i7 < size) {
                zzahv zzahvVar = zzajVar2.get(i7);
                i7++;
                zzahv zzahvVar2 = zzahvVar;
                String strZza = zzahvVar2.zza();
                String strZzb = zzahvVar2.zzb();
                if (strZza != null && strZzb != null && strZzb.equals(str)) {
                    return zzahvVar2.zza();
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
