package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class X1 implements InterfaceC1324d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1324d2[] f15373a;

    public X1(InterfaceC1324d2... interfaceC1324d2Arr) {
        this.f15373a = interfaceC1324d2Arr;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1324d2
    public final InterfaceC1319c2 zzb(Class cls) {
        for (int i8 = 0; i8 < 2; i8++) {
            InterfaceC1324d2 interfaceC1324d2 = this.f15373a[i8];
            if (interfaceC1324d2.zzc(cls)) {
                return interfaceC1324d2.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1324d2
    public final boolean zzc(Class cls) {
        for (int i8 = 0; i8 < 2; i8++) {
            if (this.f15373a[i8].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
