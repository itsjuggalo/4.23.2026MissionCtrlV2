package b6;

/* JADX INFO: loaded from: classes2.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q5.k f8967b;

    public D(Object obj, Q5.k kVar) {
        this.f8966a = obj;
        this.f8967b = kVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d7 = (D) obj;
        return kotlin.jvm.internal.r.b(this.f8966a, d7.f8966a) && kotlin.jvm.internal.r.b(this.f8967b, d7.f8967b);
    }

    public int hashCode() {
        Object obj = this.f8966a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f8967b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f8966a + ", onCancellation=" + this.f8967b + ')';
    }
}
