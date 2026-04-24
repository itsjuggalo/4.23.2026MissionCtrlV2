package r1;

import o1.AbstractC2292d;
import o1.C2291c;
import o1.InterfaceC2296h;
import r1.C2575c;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    public static abstract class a {
        public abstract o a();

        public abstract a b(C2291c c2291c);

        public abstract a c(AbstractC2292d abstractC2292d);

        public abstract a d(InterfaceC2296h interfaceC2296h);

        public abstract a e(p pVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new C2575c.b();
    }

    public abstract C2291c b();

    public abstract AbstractC2292d c();

    public byte[] d() {
        return (byte[]) e().apply(c().c());
    }

    public abstract InterfaceC2296h e();

    public abstract p f();

    public abstract String g();
}
