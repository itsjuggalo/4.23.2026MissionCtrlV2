package w1;

/* JADX INFO: renamed from: w1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2901d {
    public static AbstractC2901d f(Object obj) {
        return new C2898a(null, obj, EnumC2903f.DEFAULT, null, null);
    }

    public static AbstractC2901d g(Object obj, AbstractC2904g abstractC2904g) {
        return new C2898a(null, obj, EnumC2903f.DEFAULT, abstractC2904g, null);
    }

    public static AbstractC2901d h(Object obj) {
        return new C2898a(null, obj, EnumC2903f.HIGHEST, null, null);
    }

    public abstract Integer a();

    public abstract AbstractC2902e b();

    public abstract Object c();

    public abstract EnumC2903f d();

    public abstract AbstractC2904g e();
}
