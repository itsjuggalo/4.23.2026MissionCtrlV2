package c5;

/* JADX INFO: loaded from: classes.dex */
public final class h extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f4955a;

    public h(Throwable th) {
        this.f4955a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return kotlin.jvm.internal.j.a(this.f4955a, ((h) obj).f4955a);
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f4955a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // c5.i
    public final String toString() {
        return "Closed(" + this.f4955a + ')';
    }
}
