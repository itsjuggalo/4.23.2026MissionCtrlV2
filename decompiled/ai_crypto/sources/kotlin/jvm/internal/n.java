package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n extends AbstractC2143e implements m, X5.f {
    private final int arity;
    private final int flags;

    public n(int i7, Object obj, Class cls, String str, String str2, int i8) {
        super(obj, cls, str, str2, (i8 & 1) == 1);
        this.arity = i7;
        this.flags = i8 >> 1;
    }

    @Override // kotlin.jvm.internal.AbstractC2143e
    public X5.b computeReflected() {
        return H.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            return getName().equals(nVar.getName()) && getSignature().equals(nVar.getSignature()) && this.flags == nVar.flags && this.arity == nVar.arity && r.b(getBoundReceiver(), nVar.getBoundReceiver()) && r.b(getOwner(), nVar.getOwner());
        }
        if (obj instanceof X5.f) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.m
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // X5.f
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // X5.f
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // X5.f
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // X5.f
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // X5.f
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        X5.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.AbstractC2143e
    public X5.f getReflected() {
        return (X5.f) super.getReflected();
    }
}
