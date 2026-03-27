package kotlin.jvm.internal;

/* JADX INFO: renamed from: kotlin.jvm.internal.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2301p extends AbstractC2291f implements InterfaceC2300o, I5.h {
    private final int arity;
    private final int flags;

    public AbstractC2301p(int i8, Object obj, Class cls, String str, String str2, int i9) {
        super(obj, cls, str, str2, (i9 & 1) == 1);
        this.arity = i8;
        this.flags = i9 >> 1;
    }

    @Override // kotlin.jvm.internal.AbstractC2291f
    public I5.c computeReflected() {
        return O.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2301p) {
            AbstractC2301p abstractC2301p = (AbstractC2301p) obj;
            return getName().equals(abstractC2301p.getName()) && getSignature().equals(abstractC2301p.getSignature()) && this.flags == abstractC2301p.flags && this.arity == abstractC2301p.arity && AbstractC2304t.b(getBoundReceiver(), abstractC2301p.getBoundReceiver()) && AbstractC2304t.b(getOwner(), abstractC2301p.getOwner());
        }
        if (obj instanceof I5.h) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.InterfaceC2300o
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // I5.h
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // I5.h
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // I5.h
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // I5.h
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // I5.c
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        I5.c cVarCompute = compute();
        if (cVarCompute != this) {
            return cVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.AbstractC2291f
    public I5.h getReflected() {
        return (I5.h) super.getReflected();
    }
}
