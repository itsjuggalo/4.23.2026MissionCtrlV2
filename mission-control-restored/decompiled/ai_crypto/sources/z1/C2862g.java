package z1;

import t1.AbstractC2653d;
import t1.InterfaceC2651b;

/* JADX INFO: renamed from: z1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2862g implements InterfaceC2651b {

    /* JADX INFO: renamed from: z1.g$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C2862g f26005a = new C2862g();
    }

    public static C2862g a() {
        return a.f26005a;
    }

    public static String b() {
        return (String) AbstractC2653d.d(AbstractC2861f.a());
    }

    @Override // D5.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public String get() {
        return b();
    }
}
