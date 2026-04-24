package G4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f532a;

    public /* synthetic */ h(Object obj) {
        this.f532a = obj;
    }

    public static final Throwable a(Object obj) {
        if (obj instanceof g) {
            return ((g) obj).f531a;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return kotlin.jvm.internal.j.a(this.f532a, ((h) obj).f532a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f532a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f532a;
        if (obj instanceof g) {
            return ((g) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
