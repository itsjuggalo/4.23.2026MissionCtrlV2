package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzamz extends zzamw {
    public zzamz() {
        super();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamw
    public final void zzd() {
        if (!zze()) {
            for (int i4 = 0; i4 < zza(); i4++) {
                Map.Entry entryZza = zza(i4);
                if (((zzakt) entryZza.getKey()).zze()) {
                    entryZza.setValue(Collections.unmodifiableList((List) entryZza.getValue()));
                }
            }
            for (Map.Entry entry : zzb()) {
                if (((zzakt) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzd();
    }
}
