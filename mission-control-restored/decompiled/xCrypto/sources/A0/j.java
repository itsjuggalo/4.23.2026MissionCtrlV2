package A0;

import X2.x;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f43a;

    public j(List displayFeatures) {
        r.f(displayFeatures, "displayFeatures");
        this.f43a = displayFeatures;
    }

    public final List a() {
        return this.f43a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !r.b(j.class, obj.getClass())) {
            return false;
        }
        return r.b(this.f43a, ((j) obj).f43a);
    }

    public int hashCode() {
        return this.f43a.hashCode();
    }

    public String toString() {
        return x.Q(this.f43a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }
}
