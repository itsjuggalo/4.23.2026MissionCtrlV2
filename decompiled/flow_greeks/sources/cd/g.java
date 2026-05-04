package cd;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements k, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3851a;

    public g(Object obj) {
        this.f3851a = obj;
    }

    @Override // cd.k
    public boolean d() {
        return true;
    }

    @Override // cd.k
    public Object getValue() {
        return this.f3851a;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
