package S1;

import Q1.C0792d;
import com.google.android.gms.common.internal.AbstractC1293m;

/* JADX INFO: loaded from: classes.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0870b f7334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0792d f7335b;

    public /* synthetic */ A(C0870b c0870b, C0792d c0792d, AbstractC0893z abstractC0893z) {
        this.f7334a = c0870b;
        this.f7335b = c0792d;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof A)) {
            A a8 = (A) obj;
            if (AbstractC1293m.a(this.f7334a, a8.f7334a) && AbstractC1293m.a(this.f7335b, a8.f7335b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC1293m.b(this.f7334a, this.f7335b);
    }

    public final String toString() {
        return AbstractC1293m.c(this).a("key", this.f7334a).a("feature", this.f7335b).toString();
    }
}
