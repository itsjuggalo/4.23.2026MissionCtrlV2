package com.google.android.gms.internal.auth_blockstore;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.AbstractC0920y;
import com.google.android.gms.common.api.internal.InterfaceC0915t;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import w1.C1902c;
import w1.C1903d;
import w1.C1904e;
import w1.InterfaceC1901b;
import w1.f;

/* JADX INFO: loaded from: classes.dex */
public final class zzaa extends e implements InterfaceC1901b {
    private static final a.g zza;
    private static final a.AbstractC0145a zzb;
    private static final a zzc;

    static {
        a.g gVar = new a.g();
        zza = gVar;
        zzu zzuVar = new zzu();
        zzb = zzuVar;
        zzc = new a("Blockstore.API", zzuVar, gVar);
    }

    public zzaa(Context context) {
        super(context, zzc, a.d.f9667K, e.a.f9668c);
    }

    @Override // w1.InterfaceC1901b
    public final Task<Boolean> deleteBytes(final C1902c c1902c) {
        AbstractC0940s.l(c1902c, "DeleteBytesRequest cannot be null");
        return doWrite(AbstractC0920y.a().d(zzab.zzg).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth_blockstore.zzp
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zzg) ((zzf) obj).getService()).zza(new zzy(this.zza, (TaskCompletionSource) obj2), c1902c);
            }
        }).c(false).e(1669).a());
    }

    public final Task<Boolean> isEndToEndEncryptionAvailable() {
        return doRead(AbstractC0920y.a().d(zzab.zze).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth_blockstore.zzr
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zzg) ((zzf) obj).getService()).zzb(new zzz(this.zza, (TaskCompletionSource) obj2));
            }
        }).c(false).e(1651).a());
    }

    public final Task<byte[]> retrieveBytes() {
        return doRead(AbstractC0920y.a().d(zzab.zza).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth_blockstore.zzt
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zzg) ((zzf) obj).getService()).zzc(new zzx(this.zza, (TaskCompletionSource) obj2));
            }
        }).c(false).e(1570).a());
    }

    @Override // w1.InterfaceC1901b
    public final Task<Integer> storeBytes(final f fVar) {
        return doWrite(AbstractC0920y.a().d(zzab.zzd, zzab.zzf).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth_blockstore.zzq
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zzg) ((zzf) obj).getService()).zze(new zzv(this.zza, (TaskCompletionSource) obj2), fVar);
            }
        }).e(1645).c(false).a());
    }

    @Override // w1.InterfaceC1901b
    public final Task<C1904e> retrieveBytes(final C1903d c1903d) {
        AbstractC0940s.l(c1903d, "RetrieveBytesRequest cannot be null");
        return doRead(AbstractC0920y.a().d(zzab.zzh).b(new InterfaceC0915t() { // from class: com.google.android.gms.internal.auth_blockstore.zzs
            @Override // com.google.android.gms.common.api.internal.InterfaceC0915t
            public final void accept(Object obj, Object obj2) {
                ((zzg) ((zzf) obj).getService()).zzd(new zzw(this.zza, (TaskCompletionSource) obj2), c1903d);
            }
        }).c(false).e(1668).a());
    }
}
