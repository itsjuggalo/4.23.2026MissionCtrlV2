package z1;

import t1.AbstractC2653d;
import t1.InterfaceC2651b;

/* JADX INFO: renamed from: z1.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2865j implements InterfaceC2651b {

    /* JADX INFO: renamed from: z1.j$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C2865j f26008a = new C2865j();
    }

    public static C2865j a() {
        return a.f26008a;
    }

    public static AbstractC2860e c() {
        return (AbstractC2860e) AbstractC2653d.d(AbstractC2861f.d());
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC2860e get() {
        return c();
    }
}
