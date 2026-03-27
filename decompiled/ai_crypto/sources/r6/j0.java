package r6;

import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 implements p6.e, InterfaceC2625l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p6.e f22894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f22896c;

    public j0(p6.e original) {
        kotlin.jvm.internal.r.f(original, "original");
        this.f22894a = original;
        this.f22895b = original.a() + '?';
        this.f22896c = Z.a(original);
    }

    @Override // p6.e
    public String a() {
        return this.f22895b;
    }

    @Override // r6.InterfaceC2625l
    public Set b() {
        return this.f22896c;
    }

    @Override // p6.e
    public boolean c() {
        return true;
    }

    @Override // p6.e
    public int d(String name) {
        kotlin.jvm.internal.r.f(name, "name");
        return this.f22894a.d(name);
    }

    @Override // p6.e
    public p6.i e() {
        return this.f22894a.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j0) && kotlin.jvm.internal.r.b(this.f22894a, ((j0) obj).f22894a);
    }

    @Override // p6.e
    public int f() {
        return this.f22894a.f();
    }

    @Override // p6.e
    public String g(int i7) {
        return this.f22894a.g(i7);
    }

    @Override // p6.e
    public List getAnnotations() {
        return this.f22894a.getAnnotations();
    }

    @Override // p6.e
    public List h(int i7) {
        return this.f22894a.h(i7);
    }

    public int hashCode() {
        return this.f22894a.hashCode() * 31;
    }

    @Override // p6.e
    public p6.e i(int i7) {
        return this.f22894a.i(i7);
    }

    @Override // p6.e
    public boolean isInline() {
        return this.f22894a.isInline();
    }

    @Override // p6.e
    public boolean j(int i7) {
        return this.f22894a.j(i7);
    }

    public final p6.e k() {
        return this.f22894a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22894a);
        sb.append('?');
        return sb.toString();
    }
}
