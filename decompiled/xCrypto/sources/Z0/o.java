package Z0;

import Z0.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    public static abstract class a {
        public abstract o a();

        public abstract a b(Z0.a aVar);

        public abstract a c(b bVar);
    }

    public enum b {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5899a;

        b(int i4) {
            this.f5899a = i4;
        }
    }

    public static a a() {
        return new e.b();
    }

    public abstract Z0.a b();

    public abstract b c();
}
