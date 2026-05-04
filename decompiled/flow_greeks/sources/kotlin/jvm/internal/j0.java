package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j0 extends f implements wd.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14942a;

    public j0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
        this.f14942a = (i10 & 2) == 2;
    }

    @Override // kotlin.jvm.internal.f
    public wd.c compute() {
        return this.f14942a ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j0) {
            j0 j0Var = (j0) obj;
            return getOwner().equals(j0Var.getOwner()) && getName().equals(j0Var.getName()) && getSignature().equals(j0Var.getSignature()) && t.b(getBoundReceiver(), j0Var.getBoundReceiver());
        }
        if (obj instanceof wd.m) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.jvm.internal.f
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public wd.m getReflected() {
        if (this.f14942a) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        return (wd.m) super.getReflected();
    }

    public String toString() {
        wd.c cVarCompute = compute();
        if (cVarCompute != this) {
            return cVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
