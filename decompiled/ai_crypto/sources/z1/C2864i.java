package z1;

import t1.InterfaceC2651b;

/* JADX INFO: renamed from: z1.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2864i implements InterfaceC2651b {

    /* JADX INFO: renamed from: z1.i$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C2864i f26007a = new C2864i();
    }

    public static C2864i a() {
        return a.f26007a;
    }

    public static int c() {
        return AbstractC2861f.c();
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer get() {
        return Integer.valueOf(c());
    }
}
