package G4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f531a;

    public g(Throwable exception) {
        kotlin.jvm.internal.j.e(exception, "exception");
        this.f531a = exception;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return kotlin.jvm.internal.j.a(this.f531a, ((g) obj).f531a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f531a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f531a + ')';
    }
}
