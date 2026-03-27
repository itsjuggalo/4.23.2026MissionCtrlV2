package H3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f2633b = b(new HashSet());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f2634a;

    public d(Set set) {
        this.f2634a = set;
    }

    public static d b(Set set) {
        return new d(set);
    }

    public boolean a(G3.q qVar) {
        Iterator it = this.f2634a.iterator();
        while (it.hasNext()) {
            if (((G3.q) it.next()).p(qVar)) {
                return true;
            }
        }
        return false;
    }

    public Set c() {
        return this.f2634a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return this.f2634a.equals(((d) obj).f2634a);
    }

    public int hashCode() {
        return this.f2634a.hashCode();
    }

    public String toString() {
        return "FieldMask{mask=" + this.f2634a.toString() + "}";
    }
}
