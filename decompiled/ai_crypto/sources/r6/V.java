package r6;

import E5.C0462g;
import java.util.List;
import p6.e;
import p6.j;

/* JADX INFO: loaded from: classes2.dex */
public final class V implements p6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final V f22849a = new V();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.i f22850b = j.d.f22097a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f22851c = "kotlin.Nothing";

    @Override // p6.e
    public String a() {
        return f22851c;
    }

    public final Void b() {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // p6.e
    public boolean c() {
        return e.a.c(this);
    }

    @Override // p6.e
    public int d(String name) {
        kotlin.jvm.internal.r.f(name, "name");
        b();
        throw new C0462g();
    }

    @Override // p6.e
    public p6.i e() {
        return f22850b;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // p6.e
    public int f() {
        return 0;
    }

    @Override // p6.e
    public String g(int i7) {
        b();
        throw new C0462g();
    }

    @Override // p6.e
    public List getAnnotations() {
        return e.a.a(this);
    }

    @Override // p6.e
    public List h(int i7) {
        b();
        throw new C0462g();
    }

    public int hashCode() {
        return a().hashCode() + (e().hashCode() * 31);
    }

    @Override // p6.e
    public p6.e i(int i7) {
        b();
        throw new C0462g();
    }

    @Override // p6.e
    public boolean isInline() {
        return e.a.b(this);
    }

    @Override // p6.e
    public boolean j(int i7) {
        b();
        throw new C0462g();
    }

    public String toString() {
        return "NothingSerialDescriptor";
    }
}
