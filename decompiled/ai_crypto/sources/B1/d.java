package B1;

import t1.AbstractC2653d;
import t1.InterfaceC2651b;

/* JADX INFO: loaded from: classes.dex */
public final class d implements InterfaceC2651b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f717a = new d();
    }

    public static d a() {
        return a.f717a;
    }

    public static B1.a c() {
        return (B1.a) AbstractC2653d.d(b.b());
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public B1.a get() {
        return c();
    }
}
