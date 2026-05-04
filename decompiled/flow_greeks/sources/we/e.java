package we;

import ge.c;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements ge.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f23952a = new e();

    @Override // ge.c
    public Map a() {
        b();
        throw new cd.h();
    }

    public final Void b() {
        throw new IllegalStateException("No methods should be called on this descriptor. Only its presence matters");
    }

    @Override // ge.c
    public ef.c e() {
        return c.a.a(this);
    }

    @Override // ge.c
    public xf.r0 getType() {
        b();
        throw new cd.h();
    }

    @Override // ge.c
    public fe.g1 j() {
        b();
        throw new cd.h();
    }

    public String toString() {
        return "[EnhancedType]";
    }
}
