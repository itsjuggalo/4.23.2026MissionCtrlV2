package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import io.flutter.plugins.firebase.database.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class zzagt implements zzaez<zzagt> {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzagt";
    private String zzb;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaez
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzagt zza(String str) throws zzacn {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString("error"));
            jSONObject.getInt(Constants.ERROR_CODE);
            this.zzb = jSONObject.getString(Constants.ERROR_MESSAGE);
            return this;
        } catch (NullPointerException | JSONException e10) {
            Log.e(zza, "Failed to parse error for string [" + str + "] with exception: " + e10.getMessage());
            throw new zzacn("Failed to parse error for string [" + str + "]", e10);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return !TextUtils.isEmpty(this.zzb);
    }
}
