package w6;

import I6.S;
import R5.H;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f24077a;

    public g(Object obj) {
        this.f24077a = obj;
    }

    public abstract S a(H h8);

    public Object b() {
        return this.f24077a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            Object objB = b();
            g gVar = obj instanceof g ? (g) obj : null;
            if (!AbstractC2304t.b(objB, gVar != null ? gVar.b() : null)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Object objB = b();
        if (objB != null) {
            return objB.hashCode();
        }
        return 0;
    }

    public String toString() {
        return String.valueOf(b());
    }
}
