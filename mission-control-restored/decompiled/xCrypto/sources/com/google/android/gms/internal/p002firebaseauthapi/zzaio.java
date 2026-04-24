package com.google.android.gms.internal.p002firebaseauthapi;

import G1.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaio {
    private List<String> zza;

    public zzaio() {
        this(null);
    }

    public static zzaio zza() {
        return new zzaio(null);
    }

    public final List<String> zzb() {
        return this.zza;
    }

    private zzaio(List<String> list) {
        this.zza = new ArrayList();
    }

    public zzaio(int i4, List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.set(i5, q.a(list.get(i5)));
            }
            this.zza = Collections.unmodifiableList(list);
            return;
        }
        this.zza = Collections.EMPTY_LIST;
    }
}
