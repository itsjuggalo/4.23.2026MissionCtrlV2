package xe;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements tf.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f24902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f24903b;

    public o(v kotlinClassFinder, n deserializedDescriptorResolver) {
        kotlin.jvm.internal.t.f(kotlinClassFinder, "kotlinClassFinder");
        kotlin.jvm.internal.t.f(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        this.f24902a = kotlinClassFinder;
        this.f24903b = deserializedDescriptorResolver;
    }

    @Override // tf.j
    public tf.i a(ef.b classId) {
        kotlin.jvm.internal.t.f(classId, "classId");
        x xVarA = w.a(this.f24902a, classId, hg.c.a(this.f24903b.f().g()));
        if (xVarA == null) {
            return null;
        }
        kotlin.jvm.internal.t.b(xVarA.g(), classId);
        return this.f24903b.l(xVarA);
    }
}
