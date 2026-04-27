package U1;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class o implements l, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3120a;

    public o(Object obj) {
        this.f3120a = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            return android.support.v4.media.session.a.k(this.f3120a, ((o) obj).f3120a);
        }
        return false;
    }

    @Override // U1.l
    public final Object get() {
        return this.f3120a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3120a});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.f3120a + ")";
    }
}
