package k3;

import java.io.File;
import k3.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d implements a.InterfaceC0251a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f14496b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        File a();
    }

    public d(a aVar, long j10) {
        this.f14495a = j10;
        this.f14496b = aVar;
    }

    @Override // k3.a.InterfaceC0251a
    public k3.a build() {
        File fileA = this.f14496b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.isDirectory() || fileA.mkdirs()) {
            return e.c(fileA, this.f14495a);
        }
        return null;
    }
}
