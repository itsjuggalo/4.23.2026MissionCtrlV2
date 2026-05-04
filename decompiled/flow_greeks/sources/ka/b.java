package ka;

import com.google.android.gms.common.internal.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14802a;

    public b(String str) {
        this.f14802a = str;
    }

    public String a() {
        return this.f14802a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return q.b(this.f14802a, ((b) obj).f14802a);
        }
        return false;
    }

    public int hashCode() {
        return q.c(this.f14802a);
    }

    public String toString() {
        return q.d(this).a("token", this.f14802a).toString();
    }
}
