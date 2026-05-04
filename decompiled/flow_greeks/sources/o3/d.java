package o3;

import c4.k;
import i3.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f17476a;

    public d(Object obj) {
        this.f17476a = k.e(obj);
    }

    @Override // i3.v
    public final int c() {
        return 1;
    }

    @Override // i3.v
    public Class d() {
        return this.f17476a.getClass();
    }

    @Override // i3.v
    public final Object get() {
        return this.f17476a;
    }

    @Override // i3.v
    public void b() {
    }
}
