package com.google.android.gms.internal.p002firebaseauthapi;

import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zza {
    private static zza zza = new zzc();

    public static synchronized zza zza() {
        return zza;
    }

    public abstract URLConnection zza(URL url, String str);
}
