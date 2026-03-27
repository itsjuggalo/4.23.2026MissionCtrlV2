package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.j2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1354j2 implements InterfaceC1384p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1334f2 f15444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC1413v2 f15445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15446c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final A1 f15447d;

    public C1354j2(AbstractC1413v2 abstractC1413v2, A1 a12, InterfaceC1334f2 interfaceC1334f2) {
        this.f15445b = abstractC1413v2;
        this.f15447d = a12;
        this.f15444a = interfaceC1334f2;
    }

    public static C1354j2 h(AbstractC1413v2 abstractC1413v2, A1 a12, InterfaceC1334f2 interfaceC1334f2) {
        return new C1354j2(abstractC1413v2, a12, interfaceC1334f2);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    public final int a(Object obj) {
        int iHashCode = ((J1) obj).zzc.hashCode();
        if (!this.f15446c) {
            return iHashCode;
        }
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    public final void b(Object obj, G2 g22) {
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    public final void c(Object obj) {
        this.f15445b.b(obj);
        this.f15447d.a(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    public final int d(Object obj) {
        int iB = ((J1) obj).zzc.b();
        if (!this.f15446c) {
            return iB;
        }
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    public final void e(Object obj, Object obj2) {
        AbstractC1393r2.u(this.f15445b, obj, obj2);
        if (this.f15446c) {
            AbstractC1393r2.t(this.f15447d, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    public final boolean f(Object obj, Object obj2) {
        if (!((J1) obj).zzc.equals(((J1) obj2).zzc)) {
            return false;
        }
        if (!this.f15446c) {
            return true;
        }
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    public final void g(Object obj, byte[] bArr, int i8, int i9, C1323d1 c1323d1) {
        J1 j12 = (J1) obj;
        if (j12.zzc == C1417w2.c()) {
            j12.zzc = C1417w2.f();
        }
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    public final Object zze() {
        InterfaceC1334f2 interfaceC1334f2 = this.f15444a;
        return interfaceC1334f2 instanceof J1 ? ((J1) interfaceC1334f2).n() : interfaceC1334f2.zzK().zzg();
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1384p2
    public final boolean zzk(Object obj) {
        android.support.v4.media.session.b.a(obj);
        throw null;
    }
}
