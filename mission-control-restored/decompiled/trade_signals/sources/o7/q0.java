package o7;

import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import m7.e;
import o5.C2480h;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 implements m7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m7.d f22199b;

    public q0(String serialName, m7.d kind) {
        AbstractC2304t.f(serialName, "serialName");
        AbstractC2304t.f(kind, "kind");
        this.f22198a = serialName;
        this.f22199b = kind;
    }

    private final Void b() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // m7.e
    public String a() {
        return this.f22198a;
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
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return AbstractC2304t.b(a(), q0Var.a()) && AbstractC2304t.b(i(), q0Var.i());
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
    public boolean isInline() {
        return e.a.b(this);
    }

    @Override // m7.e
    public boolean j(int i8) {
        b();
        throw new C2480h();
    }

    @Override // m7.e
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public m7.d i() {
        return this.f22199b;
    }

    public String toString() {
        return "PrimitiveDescriptor(" + a() + ')';
    }
}
