package J3;

import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements H3.e, InterfaceC0339l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H3.e f937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f939c;

    public j0(H3.e original) {
        kotlin.jvm.internal.r.f(original, "original");
        this.f937a = original;
        this.f938b = original.a() + '?';
        this.f939c = Z.a(original);
    }

    @Override // H3.e
    public String a() {
        return this.f938b;
    }

    @Override // J3.InterfaceC0339l
    public Set b() {
        return this.f939c;
    }

    @Override // H3.e
    public boolean c() {
        return true;
    }

    @Override // H3.e
    public int d(String name) {
        kotlin.jvm.internal.r.f(name, "name");
        return this.f937a.d(name);
    }

    @Override // H3.e
    public H3.i e() {
        return this.f937a.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j0) && kotlin.jvm.internal.r.b(this.f937a, ((j0) obj).f937a);
    }

    @Override // H3.e
    public int f() {
        return this.f937a.f();
    }

    @Override // H3.e
    public String g(int i4) {
        return this.f937a.g(i4);
    }

    @Override // H3.e
    public List getAnnotations() {
        return this.f937a.getAnnotations();
    }

    @Override // H3.e
    public List h(int i4) {
        return this.f937a.h(i4);
    }

    public int hashCode() {
        return this.f937a.hashCode() * 31;
    }

    @Override // H3.e
    public H3.e i(int i4) {
        return this.f937a.i(i4);
    }

    @Override // H3.e
    public boolean isInline() {
        return this.f937a.isInline();
    }

    @Override // H3.e
    public boolean j(int i4) {
        return this.f937a.j(i4);
    }

    public final H3.e k() {
        return this.f937a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f937a);
        sb.append('?');
        return sb.toString();
    }
}
