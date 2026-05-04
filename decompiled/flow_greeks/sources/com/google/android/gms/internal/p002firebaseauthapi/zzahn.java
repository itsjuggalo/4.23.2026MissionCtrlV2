package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzahn {
    private List<zzahk> zza;

    public zzahn() {
        this.zza = new ArrayList();
    }

    public final List<zzahk> zza() {
        return this.zza;
    }

    public zzahn(List<zzahk> list) {
        this.zza = Collections.unmodifiableList(list);
    }
}
