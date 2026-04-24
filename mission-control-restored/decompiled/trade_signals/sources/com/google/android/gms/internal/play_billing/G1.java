package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class G1 implements InterfaceC1324d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final G1 f15164a = new G1();

    public static G1 a() {
        return f15164a;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1324d2
    public final InterfaceC1319c2 zzb(Class cls) {
        if (!J1.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (InterfaceC1319c2) J1.m(cls.asSubclass(J1.class)).f(3, null, null);
        } catch (Exception e8) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e8);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1324d2
    public final boolean zzc(Class cls) {
        return J1.class.isAssignableFrom(cls);
    }
}
