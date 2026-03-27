package z1;

import android.util.Base64;
import w1.EnumC2903f;
import z1.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    public static abstract class a {
        public abstract p a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(EnumC2903f enumC2903f);
    }

    public static a a() {
        return new d.b().d(EnumC2903f.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract EnumC2903f d();

    public boolean e() {
        return c() != null;
    }

    public p f(EnumC2903f enumC2903f) {
        return a().b(b()).d(enumC2903f).c(c()).a();
    }

    public final String toString() {
        return String.format("TransportContext(%s, %s, %s)", b(), d(), c() == null ? "" : Base64.encodeToString(c(), 2));
    }
}
