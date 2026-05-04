package k9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f14772b = b(new HashSet());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f14773a;

    public d(Set set) {
        this.f14773a = set;
    }

    public static d b(Set set) {
        return new d(set);
    }

    public boolean a(j9.q qVar) {
        Iterator it = this.f14773a.iterator();
        while (it.hasNext()) {
            if (((j9.q) it.next()).s(qVar)) {
                return true;
            }
        }
        return false;
    }

    public Set c() {
        return this.f14773a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return this.f14773a.equals(((d) obj).f14773a);
    }

    public int hashCode() {
        return this.f14773a.hashCode();
    }

    public String toString() {
        return "FieldMask{mask=" + this.f14773a.toString() + "}";
    }
}
