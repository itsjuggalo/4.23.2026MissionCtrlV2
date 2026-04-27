package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzv {
    private final zzf zza;
    private final zzab zzb;
    private final int zzc;

    private zzv(zzab zzabVar) {
        this(zzabVar, false, zzj.zza, a.e.API_PRIORITY_OTHER);
    }

    public static zzv zza(char c7) {
        final zzh zzhVar = new zzh(c7);
        zzw.zza(zzhVar);
        return new zzv(new zzab() { // from class: com.google.android.gms.internal.firebase-auth-api.zzy
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzab
            public final Iterator zza(zzv zzvVar, CharSequence charSequence) {
                return new zzaa(zzvVar, charSequence, zzhVar);
            }
        });
    }

    private zzv(zzab zzabVar, boolean z7, zzf zzfVar, int i7) {
        this.zzb = zzabVar;
        this.zza = zzfVar;
        this.zzc = a.e.API_PRIORITY_OTHER;
    }

    public static zzv zza(String str) {
        final zzl zzlVarZza = zzr.zza(str);
        if (!zzlVarZza.zza("").zzc()) {
            return new zzv(new zzab() { // from class: com.google.android.gms.internal.firebase-auth-api.zzx
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzab
                public final Iterator zza(zzv zzvVar, CharSequence charSequence) {
                    return new zzz(zzvVar, charSequence, zzlVarZza.zza(charSequence));
                }
            });
        }
        throw new IllegalArgumentException(zzr.zza("The pattern may not match the empty string: %s", zzlVarZza));
    }

    public final List<String> zza(CharSequence charSequence) {
        zzw.zza(charSequence);
        Iterator<String> itZza = this.zzb.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (itZza.hasNext()) {
            arrayList.add(itZza.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
