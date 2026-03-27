package c5;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f4956b = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4957a;

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return kotlin.jvm.internal.j.a(this.f4957a, ((j) obj).f4957a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f4957a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f4957a;
        if (obj instanceof h) {
            return ((h) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
