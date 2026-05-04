package w2;

import dd.a0;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f23660a;

    public s(List displayFeatures) {
        kotlin.jvm.internal.t.f(displayFeatures, "displayFeatures");
        this.f23660a = displayFeatures;
    }

    public final List a() {
        return this.f23660a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !kotlin.jvm.internal.t.b(s.class, obj.getClass())) {
            return false;
        }
        return kotlin.jvm.internal.t.b(this.f23660a, ((s) obj).f23660a);
    }

    public int hashCode() {
        return this.f23660a.hashCode();
    }

    public String toString() {
        return a0.i0(this.f23660a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }
}
