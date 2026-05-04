package ke;

import java.util.List;
import kotlin.jvm.internal.t;
import tf.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f14837b = new j();

    @Override // tf.w
    public void a(fe.b descriptor) {
        t.f(descriptor, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + descriptor);
    }

    @Override // tf.w
    public void b(fe.e descriptor, List unresolvedSuperClasses) {
        t.f(descriptor, "descriptor");
        t.f(unresolvedSuperClasses, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + descriptor.getName() + ", unresolved classes " + unresolvedSuperClasses);
    }
}
