package J3;

import H3.e;
import W2.C0739g;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements H3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H3.d f932b;

    public h0(String serialName, H3.d kind) {
        kotlin.jvm.internal.r.f(serialName, "serialName");
        kotlin.jvm.internal.r.f(kind, "kind");
        this.f931a = serialName;
        this.f932b = kind;
    }

    private final Void b() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // H3.e
    public String a() {
        return this.f931a;
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return kotlin.jvm.internal.r.b(a(), h0Var.a()) && kotlin.jvm.internal.r.b(e(), h0Var.e());
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

    @Override // H3.e
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public H3.d e() {
        return this.f932b;
    }

    public String toString() {
        return "PrimitiveDescriptor(" + a() + ')';
    }
}
