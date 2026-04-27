package o1;

/* JADX INFO: renamed from: o1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2292d {
    public static AbstractC2292d f(Object obj) {
        return new C2289a(null, obj, EnumC2294f.DEFAULT, null, null);
    }

    public static AbstractC2292d g(Object obj, AbstractC2295g abstractC2295g) {
        return new C2289a(null, obj, EnumC2294f.DEFAULT, abstractC2295g, null);
    }

    public static AbstractC2292d h(Object obj) {
        return new C2289a(null, obj, EnumC2294f.HIGHEST, null, null);
    }

    public abstract Integer a();

    public abstract AbstractC2293e b();

    public abstract Object c();

    public abstract EnumC2294f d();

    public abstract AbstractC2295g e();
}
