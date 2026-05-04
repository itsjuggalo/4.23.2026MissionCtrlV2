package com.google.android.gms.internal.auth_blockstore;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import h5.b;
import h5.c;
import h5.d;
import h5.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaa extends f implements b {
    private static final a.g zza;
    private static final a.AbstractC0094a zzb;
    private static final a zzc;

    static {
        a.g gVar = new a.g();
        zza = gVar;
        zzu zzuVar = new zzu();
        zzb = zzuVar;
        zzc = new a("Blockstore.API", zzuVar, gVar);
    }

    public zzaa(Context context) {
        super(context, zzc, a.d.J, f.a.f5486c);
    }

    @Override // h5.b
    public final Task<Boolean> deleteBytes(final c cVar) {
        s.l(cVar, "DeleteBytesRequest cannot be null");
        return doWrite(v.a().d(zzab.zzg).b(new q() { // from class: com.google.android.gms.internal.auth_blockstore.zzp
            @Override // com.google.android.gms.common.api.internal.q
            public final void accept(Object obj, Object obj2) {
                ((zzg) ((zzf) obj).getService()).zza(new zzy(this.zza, (TaskCompletionSource) obj2), cVar);
            }
        }).c(false).e(1669).a());
    }

    public final Task<Boolean> isEndToEndEncryptionAvailable() {
        return doRead(v.a().d(zzab.zze).b(new q() { // from class: com.google.android.gms.internal.auth_blockstore.zzr
            @Override // com.google.android.gms.common.api.internal.q
            public final void accept(Object obj, Object obj2) {
                ((zzg) ((zzf) obj).getService()).zzb(new zzz(this.zza, (TaskCompletionSource) obj2));
            }
        }).c(false).e(1651).a());
    }

    public final Task<byte[]> retrieveBytes() {
        return doRead(v.a().d(zzab.zza).b(new q() { // from class: com.google.android.gms.internal.auth_blockstore.zzt
            @Override // com.google.android.gms.common.api.internal.q
            public final void accept(Object obj, Object obj2) {
                ((zzg) ((zzf) obj).getService()).zzc(new zzx(this.zza, (TaskCompletionSource) obj2));
            }
        }).c(false).e(1570).a());
    }

    @Override // h5.b
    public final Task<Integer> storeBytes(final h5.f fVar) {
        return doWrite(v.a().d(zzab.zzd, zzab.zzf).b(new q() { // from class: com.google.android.gms.internal.auth_blockstore.zzq
            @Override // com.google.android.gms.common.api.internal.q
            public final void accept(Object obj, Object obj2) {
                ((zzg) ((zzf) obj).getService()).zze(new zzv(this.zza, (TaskCompletionSource) obj2), fVar);
            }
        }).e(1645).c(false).a());
    }

    @Override // h5.b
    public final Task<e> retrieveBytes(final d dVar) {
        s.l(dVar, "RetrieveBytesRequest cannot be null");
        return doRead(v.a().d(zzab.zzh).b(new q() { // from class: com.google.android.gms.internal.auth_blockstore.zzs
            @Override // com.google.android.gms.common.api.internal.q
            public final void accept(Object obj, Object obj2) {
                ((zzg) ((zzf) obj).getService()).zzd(new zzw(this.zza, (TaskCompletionSource) obj2), dVar);
            }
        }).c(false).e(1668).a());
    }
}
