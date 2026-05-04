package dh;

import bh.e;
import bh.m;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class w0 implements bh.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w0 f8241a = new w0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.l f8242b = m.d.f3405a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8243c = "kotlin.Nothing";

    public final Void a() {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // bh.e
    public List getAnnotations() {
        return e.a.a(this);
    }

    @Override // bh.e
    public bh.l h() {
        return f8242b;
    }

    public int hashCode() {
        return i().hashCode() + (h().hashCode() * 31);
    }

    @Override // bh.e
    public String i() {
        return f8243c;
    }

    @Override // bh.e
    public boolean isInline() {
        return e.a.b(this);
    }

    @Override // bh.e
    public boolean j() {
        return e.a.c(this);
    }

    @Override // bh.e
    public int k(String name) {
        kotlin.jvm.internal.t.f(name, "name");
        a();
        throw new cd.h();
    }

    @Override // bh.e
    public int l() {
        return 0;
    }

    @Override // bh.e
    public String m(int i10) {
        a();
        throw new cd.h();
    }

    @Override // bh.e
    public List n(int i10) {
        a();
        throw new cd.h();
    }

    @Override // bh.e
    public bh.e o(int i10) {
        a();
        throw new cd.h();
    }

    @Override // bh.e
    public boolean p(int i10) {
        a();
        throw new cd.h();
    }

    public String toString() {
        return "NothingSerialDescriptor";
    }
}
