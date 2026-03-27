package I6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: I6.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0638s extends p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S5.h f4462a;

    public C0638s(S5.h annotations) {
        AbstractC2304t.f(annotations, "annotations");
        this.f4462a = annotations;
    }

    @Override // I6.p0
    public I5.d b() {
        return kotlin.jvm.internal.O.b(C0638s.class);
    }

    @Override // I6.p0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0638s a(C0638s c0638s) {
        return c0638s == null ? this : new C0638s(S5.j.a(this.f4462a, c0638s.f4462a));
    }

    public final S5.h e() {
        return this.f4462a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0638s) {
            return AbstractC2304t.b(((C0638s) obj).f4462a, this.f4462a);
        }
        return false;
    }

    @Override // I6.p0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0638s c(C0638s c0638s) {
        if (AbstractC2304t.b(c0638s, this)) {
            return this;
        }
        return null;
    }

    public int hashCode() {
        return this.f4462a.hashCode();
    }
}
