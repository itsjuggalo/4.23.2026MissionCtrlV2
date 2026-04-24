package y1;

import y1.C2974e;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    public static abstract class a {
        public abstract o a();

        public abstract a b(AbstractC2970a abstractC2970a);

        public abstract a c(b bVar);
    }

    public enum b {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24394a;

        b(int i8) {
            this.f24394a = i8;
        }
    }

    public static a a() {
        return new C2974e.b();
    }

    public abstract AbstractC2970a b();

    public abstract b c();
}
