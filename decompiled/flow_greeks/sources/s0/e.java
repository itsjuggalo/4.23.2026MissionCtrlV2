package s0;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f19928c;

    public e(int i10) {
        super(i10);
        this.f19928c = new Object();
    }

    @Override // s0.d, s0.c
    public boolean a(Object instance) {
        boolean zA;
        t.f(instance, "instance");
        synchronized (this.f19928c) {
            zA = super.a(instance);
        }
        return zA;
    }

    @Override // s0.d, s0.c
    public Object b() {
        Object objB;
        synchronized (this.f19928c) {
            objB = super.b();
        }
        return objB;
    }
}
