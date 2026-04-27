package P;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public class e extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4243c;

    public e(int i7) {
        super(i7);
        this.f4243c = new Object();
    }

    @Override // P.d, P.c
    public boolean a(Object instance) {
        boolean zA;
        r.f(instance, "instance");
        synchronized (this.f4243c) {
            zA = super.a(instance);
        }
        return zA;
    }

    @Override // P.d, P.c
    public Object b() {
        Object objB;
        synchronized (this.f4243c) {
            objB = super.b();
        }
        return objB;
    }
}
