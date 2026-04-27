package L0;

import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.z;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4992a;

    public j(List displayFeatures) {
        AbstractC2304t.f(displayFeatures, "displayFeatures");
        this.f4992a = displayFeatures;
    }

    public final List a() {
        return this.f4992a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !AbstractC2304t.b(j.class, obj.getClass())) {
            return false;
        }
        return AbstractC2304t.b(this.f4992a, ((j) obj).f4992a);
    }

    public int hashCode() {
        return this.f4992a.hashCode();
    }

    public String toString() {
        return z.h0(this.f4992a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }
}
