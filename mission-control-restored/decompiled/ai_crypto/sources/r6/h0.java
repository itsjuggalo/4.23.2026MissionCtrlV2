package r6;

import E5.C0462g;
import java.util.List;
import p6.e;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 implements p6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p6.d f22889b;

    public h0(String serialName, p6.d kind) {
        kotlin.jvm.internal.r.f(serialName, "serialName");
        kotlin.jvm.internal.r.f(kind, "kind");
        this.f22888a = serialName;
        this.f22889b = kind;
    }

    private final Void b() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // p6.e
    public String a() {
        return this.f22888a;
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

    @Override // p6.e
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public p6.d e() {
        return this.f22889b;
    }

    public String toString() {
        return "PrimitiveDescriptor(" + a() + ')';
    }
}
