package a1;

import a1.C0779d;
import android.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    public static abstract class a {
        public abstract p a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(X0.f fVar);
    }

    public static a a() {
        return new C0779d.b().d(X0.f.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract X0.f d();

    public boolean e() {
        return c() != null;
    }

    public p f(X0.f fVar) {
        return a().b(b()).d(fVar).c(c()).a();
    }

    public final String toString() {
        return String.format("TransportContext(%s, %s, %s)", b(), d(), c() == null ? "" : Base64.encodeToString(c(), 2));
    }
}
