package S;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public class f extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f7293c;

    public f(int i8) {
        super(i8);
        this.f7293c = new Object();
    }

    @Override // S.e, S.d
    public boolean a(Object instance) {
        boolean zA;
        AbstractC2304t.f(instance, "instance");
        synchronized (this.f7293c) {
            zA = super.a(instance);
        }
        return zA;
    }

    @Override // S.e, S.d
    public Object b() {
        Object objB;
        synchronized (this.f7293c) {
            objB = super.b();
        }
        return objB;
    }
}
