package l4;

import l4.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a {
        public abstract o a();

        public abstract a b(i4.c cVar);

        public abstract a c(i4.d dVar);

        public abstract a d(i4.h hVar);

        public abstract a e(p pVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new c.b();
    }

    public abstract i4.c b();

    public abstract i4.d c();

    public byte[] d() {
        return (byte[]) e().apply(c().c());
    }

    public abstract i4.h e();

    public abstract p f();

    public abstract String g();
}
