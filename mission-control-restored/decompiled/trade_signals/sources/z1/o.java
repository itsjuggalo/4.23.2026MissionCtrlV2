package z1;

import w1.AbstractC2901d;
import w1.C2900c;
import w1.InterfaceC2905h;
import z1.C3002c;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    public static abstract class a {
        public abstract o a();

        public abstract a b(C2900c c2900c);

        public abstract a c(AbstractC2901d abstractC2901d);

        public abstract a d(InterfaceC2905h interfaceC2905h);

        public abstract a e(p pVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new C3002c.b();
    }

    public abstract C2900c b();

    public abstract AbstractC2901d c();

    public byte[] d() {
        return (byte[]) e().apply(c().c());
    }

    public abstract InterfaceC2905h e();

    public abstract p f();

    public abstract String g();
}
