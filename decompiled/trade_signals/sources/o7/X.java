package o7;

import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import m7.e;
import m7.m;
import o5.C2480h;

/* JADX INFO: loaded from: classes2.dex */
public final class X implements m7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final X f22148a = new X();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.l f22149b = m.d.f21534a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f22150c = "kotlin.Nothing";

    @Override // m7.e
    public String a() {
        return f22150c;
    }

    public final Void b() {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // m7.e
    public boolean c() {
        return e.a.c(this);
    }

    @Override // m7.e
    public int d(String name) {
        AbstractC2304t.f(name, "name");
        b();
        throw new C2480h();
    }

    @Override // m7.e
    public int e() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // m7.e
    public String f(int i8) {
        b();
        throw new C2480h();
    }

    @Override // m7.e
    public List g(int i8) {
        b();
        throw new C2480h();
    }

    @Override // m7.e
    public List getAnnotations() {
        return e.a.a(this);
    }

    @Override // m7.e
    public m7.e h(int i8) {
        b();
        throw new C2480h();
    }

    public int hashCode() {
        return a().hashCode() + (i().hashCode() * 31);
    }

    @Override // m7.e
    public m7.l i() {
        return f22149b;
    }

    @Override // m7.e
    public boolean isInline() {
        return e.a.b(this);
    }

    @Override // m7.e
    public boolean j(int i8) {
        b();
        throw new C2480h();
    }

    public String toString() {
        return "NothingSerialDescriptor";
    }
}
