package l4;

import java.util.Set;
import n4.z;

/* JADX INFO: loaded from: classes.dex */
public final class m extends AbstractC2177j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f18380a = new z(false);

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof m) && ((m) obj).f18380a.equals(this.f18380a));
    }

    public int hashCode() {
        return this.f18380a.hashCode();
    }

    public void n(String str, AbstractC2177j abstractC2177j) {
        z zVar = this.f18380a;
        if (abstractC2177j == null) {
            abstractC2177j = l.f18379a;
        }
        zVar.put(str, abstractC2177j);
    }

    public Set p() {
        return this.f18380a.entrySet();
    }

    public boolean q(String str) {
        return this.f18380a.containsKey(str);
    }

    public AbstractC2177j r(String str) {
        return (AbstractC2177j) this.f18380a.remove(str);
    }
}
