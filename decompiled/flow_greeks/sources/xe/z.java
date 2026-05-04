package xe;

import fe.h1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z implements vf.s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f24929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final tf.y f24930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f24931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vf.r f24932e;

    public z(x binaryClass, tf.y yVar, boolean z10, vf.r abiStability) {
        kotlin.jvm.internal.t.f(binaryClass, "binaryClass");
        kotlin.jvm.internal.t.f(abiStability, "abiStability");
        this.f24929b = binaryClass;
        this.f24930c = yVar;
        this.f24931d = z10;
        this.f24932e = abiStability;
    }

    @Override // fe.g1
    public h1 a() {
        h1 NO_SOURCE_FILE = h1.f9484a;
        kotlin.jvm.internal.t.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @Override // vf.s
    public String c() {
        return "Class '" + this.f24929b.g().a().a() + '\'';
    }

    public final x d() {
        return this.f24929b;
    }

    public String toString() {
        return z.class.getSimpleName() + ": " + this.f24929b;
    }
}
