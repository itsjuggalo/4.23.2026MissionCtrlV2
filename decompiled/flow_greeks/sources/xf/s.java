package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ge.h f25045a;

    public s(ge.h annotations) {
        kotlin.jvm.internal.t.f(annotations, "annotations");
        this.f25045a = annotations;
    }

    @Override // xf.o1
    public wd.d b() {
        return kotlin.jvm.internal.n0.b(s.class);
    }

    @Override // xf.o1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public s a(s sVar) {
        return sVar == null ? this : new s(ge.j.a(this.f25045a, sVar.f25045a));
    }

    public final ge.h e() {
        return this.f25045a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof s) {
            return kotlin.jvm.internal.t.b(((s) obj).f25045a, this.f25045a);
        }
        return false;
    }

    @Override // xf.o1
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public s c(s sVar) {
        if (kotlin.jvm.internal.t.b(sVar, this)) {
            return this;
        }
        return null;
    }

    public int hashCode() {
        return this.f25045a.hashCode();
    }
}
