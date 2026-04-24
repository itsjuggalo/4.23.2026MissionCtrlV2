package r1;

import android.util.Base64;
import o1.EnumC2294f;
import r1.C2576d;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    public static abstract class a {
        public abstract p a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(EnumC2294f enumC2294f);
    }

    public static a a() {
        return new C2576d.b().d(EnumC2294f.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract EnumC2294f d();

    public boolean e() {
        return c() != null;
    }

    public p f(EnumC2294f enumC2294f) {
        return a().b(b()).d(enumC2294f).c(c()).a();
    }

    public final String toString() {
        return String.format("TransportContext(%s, %s, %s)", b(), d(), c() == null ? "" : Base64.encodeToString(c(), 2));
    }
}
