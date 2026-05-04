package xe;

import fe.g1;
import fe.h1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements g1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final se.d0 f24928b;

    public y(se.d0 packageFragment) {
        kotlin.jvm.internal.t.f(packageFragment, "packageFragment");
        this.f24928b = packageFragment;
    }

    @Override // fe.g1
    public h1 a() {
        h1 NO_SOURCE_FILE = h1.f9484a;
        kotlin.jvm.internal.t.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    public String toString() {
        return this.f24928b + ": " + this.f24928b.O0().keySet();
    }
}
