package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final I f18250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final X5.c[] f18251b;

    static {
        I i7 = null;
        try {
            i7 = (I) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (i7 == null) {
            i7 = new I();
        }
        f18250a = i7;
        f18251b = new X5.c[0];
    }

    public static X5.f a(n nVar) {
        return f18250a.a(nVar);
    }

    public static X5.c b(Class cls) {
        return f18250a.b(cls);
    }

    public static X5.e c(Class cls) {
        return f18250a.c(cls, "");
    }

    public static X5.g d(u uVar) {
        return f18250a.d(uVar);
    }

    public static X5.h e(y yVar) {
        return f18250a.e(yVar);
    }

    public static X5.i f(A a7) {
        return f18250a.f(a7);
    }

    public static String g(m mVar) {
        return f18250a.g(mVar);
    }

    public static String h(s sVar) {
        return f18250a.h(sVar);
    }
}
