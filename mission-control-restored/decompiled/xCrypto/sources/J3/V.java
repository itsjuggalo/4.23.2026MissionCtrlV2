package J3;

import H3.e;
import H3.j;
import W2.C0739g;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class V implements H3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final V f892a = new V();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.i f893b = j.d.f769a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f894c = "kotlin.Nothing";

    @Override // H3.e
    public String a() {
        return f894c;
    }

    public final Void b() {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // H3.e
    public boolean c() {
        return e.a.c(this);
    }

    @Override // H3.e
    public int d(String name) {
        kotlin.jvm.internal.r.f(name, "name");
        b();
        throw new C0739g();
    }

    @Override // H3.e
    public H3.i e() {
        return f893b;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // H3.e
    public int f() {
        return 0;
    }

    @Override // H3.e
    public String g(int i4) {
        b();
        throw new C0739g();
    }

    @Override // H3.e
    public List getAnnotations() {
        return e.a.a(this);
    }

    @Override // H3.e
    public List h(int i4) {
        b();
        throw new C0739g();
    }

    public int hashCode() {
        return a().hashCode() + (e().hashCode() * 31);
    }

    @Override // H3.e
    public H3.e i(int i4) {
        b();
        throw new C0739g();
    }

    @Override // H3.e
    public boolean isInline() {
        return e.a.b(this);
    }

    @Override // H3.e
    public boolean j(int i4) {
        b();
        throw new C0739g();
    }

    public String toString() {
        return "NothingSerialDescriptor";
    }
}
