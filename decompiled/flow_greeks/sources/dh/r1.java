package dh;

import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r1 implements bh.e, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bh.e f8215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f8217c;

    public r1(bh.e original) {
        kotlin.jvm.internal.t.f(original, "original");
        this.f8215a = original;
        this.f8216b = original.i() + '?';
        this.f8217c = d1.a(original);
    }

    @Override // dh.l
    public Set a() {
        return this.f8217c;
    }

    public final bh.e b() {
        return this.f8215a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r1) && kotlin.jvm.internal.t.b(this.f8215a, ((r1) obj).f8215a);
    }

    @Override // bh.e
    public List getAnnotations() {
        return this.f8215a.getAnnotations();
    }

    @Override // bh.e
    public bh.l h() {
        return this.f8215a.h();
    }

    public int hashCode() {
        return this.f8215a.hashCode() * 31;
    }

    @Override // bh.e
    public String i() {
        return this.f8216b;
    }

    @Override // bh.e
    public boolean isInline() {
        return this.f8215a.isInline();
    }

    @Override // bh.e
    public boolean j() {
        return true;
    }

    @Override // bh.e
    public int k(String name) {
        kotlin.jvm.internal.t.f(name, "name");
        return this.f8215a.k(name);
    }

    @Override // bh.e
    public int l() {
        return this.f8215a.l();
    }

    @Override // bh.e
    public String m(int i10) {
        return this.f8215a.m(i10);
    }

    @Override // bh.e
    public List n(int i10) {
        return this.f8215a.n(i10);
    }

    @Override // bh.e
    public bh.e o(int i10) {
        return this.f8215a.o(i10);
    }

    @Override // bh.e
    public boolean p(int i10) {
        return this.f8215a.p(i10);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f8215a);
        sb2.append('?');
        return sb2.toString();
    }
}
