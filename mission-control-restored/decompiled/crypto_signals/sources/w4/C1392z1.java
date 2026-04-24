package w4;

import u4.C1234p;
import u4.InterfaceC1227i;

/* JADX INFO: renamed from: w4.z1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1392z1 implements E1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11445b;

    public /* synthetic */ C1392z1(Object obj, int i) {
        this.f11444a = i;
        this.f11445b = obj;
    }

    @Override // w4.E1
    public final void a(K1 k12) {
        switch (this.f11444a) {
            case 0:
                k12.f10932a.b((InterfaceC1227i) this.f11445b);
                break;
            case 1:
                k12.f10932a.i((C1234p) this.f11445b);
                break;
            default:
                k12.f10932a.d((u4.r) this.f11445b);
                break;
        }
    }
}
