package o7;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 implements m7.e, InterfaceC2515l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m7.e f22204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f22206c;

    public s0(m7.e original) {
        AbstractC2304t.f(original, "original");
        this.f22204a = original;
        this.f22205b = original.a() + '?';
        this.f22206c = AbstractC2502e0.a(original);
    }

    @Override // m7.e
    public String a() {
        return this.f22205b;
    }

    @Override // o7.InterfaceC2515l
    public Set b() {
        return this.f22206c;
    }

    @Override // m7.e
    public boolean c() {
        return true;
    }

    @Override // m7.e
    public int d(String name) {
        AbstractC2304t.f(name, "name");
        return this.f22204a.d(name);
    }

    @Override // m7.e
    public int e() {
        return this.f22204a.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s0) && AbstractC2304t.b(this.f22204a, ((s0) obj).f22204a);
    }

    @Override // m7.e
    public String f(int i8) {
        return this.f22204a.f(i8);
    }

    @Override // m7.e
    public List g(int i8) {
        return this.f22204a.g(i8);
    }

    @Override // m7.e
    public List getAnnotations() {
        return this.f22204a.getAnnotations();
    }

    @Override // m7.e
    public m7.e h(int i8) {
        return this.f22204a.h(i8);
    }

    public int hashCode() {
        return this.f22204a.hashCode() * 31;
    }

    @Override // m7.e
    public m7.l i() {
        return this.f22204a.i();
    }

    @Override // m7.e
    public boolean isInline() {
        return this.f22204a.isInline();
    }

    @Override // m7.e
    public boolean j(int i8) {
        return this.f22204a.j(i8);
    }

    public final m7.e k() {
        return this.f22204a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22204a);
        sb.append('?');
        return sb.toString();
    }
}
