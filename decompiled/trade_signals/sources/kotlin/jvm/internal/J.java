package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class J extends AbstractC2291f implements I5.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20465a;

    public J(Object obj, Class cls, String str, String str2, int i8) {
        super(obj, cls, str, str2, (i8 & 1) == 1);
        this.f20465a = (i8 & 2) == 2;
    }

    @Override // kotlin.jvm.internal.AbstractC2291f
    public I5.c compute() {
        return this.f20465a ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof J) {
            J j8 = (J) obj;
            return getOwner().equals(j8.getOwner()) && getName().equals(j8.getName()) && getSignature().equals(j8.getSignature()) && AbstractC2304t.b(getBoundReceiver(), j8.getBoundReceiver());
        }
        if (obj instanceof I5.m) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.jvm.internal.AbstractC2291f
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public I5.m getReflected() {
        if (this.f20465a) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        return (I5.m) super.getReflected();
    }

    public String toString() {
        I5.c cVarCompute = compute();
        if (cVarCompute != this) {
            return cVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
