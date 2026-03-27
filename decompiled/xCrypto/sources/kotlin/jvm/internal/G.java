package kotlin.jvm.internal;

import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final H f13411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InterfaceC1716c[] f13412b;

    static {
        H h4 = null;
        try {
            h4 = (H) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (h4 == null) {
            h4 = new H();
        }
        f13411a = h4;
        f13412b = new InterfaceC1716c[0];
    }

    public static p3.f a(n nVar) {
        return f13411a.a(nVar);
    }

    public static InterfaceC1716c b(Class cls) {
        return f13411a.b(cls);
    }

    public static p3.e c(Class cls) {
        return f13411a.c(cls, "");
    }

    public static p3.g d(u uVar) {
        return f13411a.d(uVar);
    }

    public static p3.i e(y yVar) {
        return f13411a.e(yVar);
    }

    public static p3.j f(A a4) {
        return f13411a.f(a4);
    }

    public static String g(m mVar) {
        return f13411a.g(mVar);
    }

    public static String h(s sVar) {
        return f13411a.h(sVar);
    }
}
