package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p extends f implements o, wd.h {
    private final int arity;
    private final int flags;

    public p(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, (i11 & 1) == 1);
        this.arity = i10;
        this.flags = i11 >> 1;
    }

    @Override // kotlin.jvm.internal.f
    public wd.c computeReflected() {
        return n0.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return getName().equals(pVar.getName()) && getSignature().equals(pVar.getSignature()) && this.flags == pVar.flags && this.arity == pVar.arity && t.b(getBoundReceiver(), pVar.getBoundReceiver()) && t.b(getOwner(), pVar.getOwner());
        }
        if (obj instanceof wd.h) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.o
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // wd.h
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // wd.h
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // wd.h
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // wd.h
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // wd.c, wd.h
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        wd.c cVarCompute = compute();
        if (cVarCompute != this) {
            return cVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.f
    public wd.h getReflected() {
        return (wd.h) super.getReflected();
    }
}
