package q1;

import q1.C2554e;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    public static abstract class a {
        public abstract o a();

        public abstract a b(AbstractC2550a abstractC2550a);

        public abstract a c(b bVar);
    }

    public enum b {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f22241a;

        b(int i7) {
            this.f22241a = i7;
        }
    }

    public static a a() {
        return new C2554e.b();
    }

    public abstract AbstractC2550a b();

    public abstract b c();
}
