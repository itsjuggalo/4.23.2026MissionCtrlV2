package W5;

import V6.A;
import X5.AbstractC0990f;
import j6.InterfaceC2260x;
import k6.C2284a;
import k6.C2285b;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements InterfaceC2260x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f9293c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f9294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2284a f9295b;

    public static final class a {
        public a() {
        }

        public final f a(Class klass) {
            AbstractC2304t.f(klass, "klass");
            C2285b c2285b = new C2285b();
            c.f9291a.b(klass, c2285b);
            C2284a c2284aN = c2285b.n();
            AbstractC2296k abstractC2296k = null;
            if (c2284aN == null) {
                return null;
            }
            return new f(klass, c2284aN, abstractC2296k);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public f(Class cls, C2284a c2284a) {
        this.f9294a = cls;
        this.f9295b = c2284a;
    }

    @Override // j6.InterfaceC2260x
    public String a() {
        StringBuilder sb = new StringBuilder();
        String name = this.f9294a.getName();
        AbstractC2304t.e(name, "getName(...)");
        sb.append(A.D(name, com.amazon.a.a.o.c.a.b.f14112a, '/', false, 4, null));
        sb.append(".class");
        return sb.toString();
    }

    @Override // j6.InterfaceC2260x
    public C2284a b() {
        return this.f9295b;
    }

    @Override // j6.InterfaceC2260x
    public void c(InterfaceC2260x.d visitor, byte[] bArr) {
        AbstractC2304t.f(visitor, "visitor");
        c.f9291a.i(this.f9294a, visitor);
    }

    @Override // j6.InterfaceC2260x
    public q6.b d() {
        return AbstractC0990f.e(this.f9294a);
    }

    @Override // j6.InterfaceC2260x
    public void e(InterfaceC2260x.c visitor, byte[] bArr) {
        AbstractC2304t.f(visitor, "visitor");
        c.f9291a.b(this.f9294a, visitor);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && AbstractC2304t.b(this.f9294a, ((f) obj).f9294a);
    }

    public final Class f() {
        return this.f9294a;
    }

    public int hashCode() {
        return this.f9294a.hashCode();
    }

    public String toString() {
        return f.class.getName() + ": " + this.f9294a;
    }

    public /* synthetic */ f(Class cls, C2284a c2284a, AbstractC2296k abstractC2296k) {
        this(cls, c2284a);
    }
}
