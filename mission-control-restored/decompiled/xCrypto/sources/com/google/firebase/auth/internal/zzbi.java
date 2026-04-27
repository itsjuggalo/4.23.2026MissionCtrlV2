package com.google.firebase.auth.internal;

import C1.a;
import com.google.android.gms.internal.p002firebaseauthapi.zzaag;
import com.google.firebase.auth.GetTokenResult;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbi {
    private static final a zza = new a("GetTokenResultFactory", new String[0]);

    public static GetTokenResult zza(String str) {
        Map map;
        try {
            map = zzbh.zza(str);
        } catch (zzaag e4) {
            zza.b("Error parsing token claims", e4, new Object[0]);
            map = new HashMap();
        }
        return new GetTokenResult(str, map);
    }
}
