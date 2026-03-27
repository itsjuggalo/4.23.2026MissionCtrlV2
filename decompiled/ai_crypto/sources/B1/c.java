package B1;

import t1.AbstractC2653d;
import t1.InterfaceC2651b;

/* JADX INFO: loaded from: classes.dex */
public final class c implements InterfaceC2651b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f716a = new c();
    }

    public static c a() {
        return a.f716a;
    }

    public static B1.a b() {
        return (B1.a) AbstractC2653d.d(b.a());
    }

    @Override // D5.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public B1.a get() {
        return b();
    }
}
