package m2;

/* JADX INFO: renamed from: m2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2351d {

    /* JADX INFO: renamed from: m2.d$a */
    public static abstract class a {
        public abstract AbstractC2351d a();

        public abstract a b(boolean z7);
    }

    public static AbstractC2351d c(int i8) {
        return d(i8).a();
    }

    public static a d(int i8) {
        C2343A c2343a = new C2343A();
        c2343a.c(i8);
        c2343a.b(false);
        return c2343a;
    }

    public abstract boolean a();

    public abstract int b();
}
