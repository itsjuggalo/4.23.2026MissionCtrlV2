package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class C extends AbstractC2143e implements X5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18245a;

    public C(Object obj, Class cls, String str, String str2, int i7) {
        super(obj, cls, str, str2, (i7 & 1) == 1);
        this.f18245a = (i7 & 2) == 2;
    }

    @Override // kotlin.jvm.internal.AbstractC2143e
    public X5.b compute() {
        return this.f18245a ? this : super.compute();
    }

    @Override // kotlin.jvm.internal.AbstractC2143e
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public X5.j getReflected() {
        if (this.f18245a) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
        }
        return (X5.j) super.getReflected();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C) {
            C c7 = (C) obj;
            return getOwner().equals(c7.getOwner()) && getName().equals(c7.getName()) && getSignature().equals(c7.getSignature()) && r.b(getBoundReceiver(), c7.getBoundReceiver());
        }
        if (obj instanceof X5.j) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        X5.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
