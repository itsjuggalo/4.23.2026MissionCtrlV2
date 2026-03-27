package R0;

import F5.v;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4664a;

    public j(List displayFeatures) {
        r.f(displayFeatures, "displayFeatures");
        this.f4664a = displayFeatures;
    }

    public final List a() {
        return this.f4664a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !r.b(j.class, obj.getClass())) {
            return false;
        }
        return r.b(this.f4664a, ((j) obj).f4664a);
    }

    public int hashCode() {
        return this.f4664a.hashCode();
    }

    public String toString() {
        return v.R(this.f4664a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }
}
