package q2;

import java.util.Set;
import s2.z;

/* JADX INFO: loaded from: classes.dex */
public final class m extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f14272a = new z(false);

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof m) && ((m) obj).f14272a.equals(this.f14272a);
        }
        return true;
    }

    public int hashCode() {
        return this.f14272a.hashCode();
    }

    public void q(String str, j jVar) {
        z zVar = this.f14272a;
        if (jVar == null) {
            jVar = l.f14271a;
        }
        zVar.put(str, jVar);
    }

    public Set r() {
        return this.f14272a.entrySet();
    }

    public boolean s(String str) {
        return this.f14272a.containsKey(str);
    }

    public j t(String str) {
        return (j) this.f14272a.remove(str);
    }
}
