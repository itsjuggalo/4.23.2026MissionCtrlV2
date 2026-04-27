package kotlin.jvm.internal;

import p3.InterfaceC1715b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n extends AbstractC1580e implements m, p3.f {
    private final int arity;
    private final int flags;

    public n(int i4, Object obj, Class cls, String str, String str2, int i5) {
        super(obj, cls, str, str2, (i5 & 1) == 1);
        this.arity = i4;
        this.flags = i5 >> 1;
    }

    @Override // kotlin.jvm.internal.AbstractC1580e
    public InterfaceC1715b computeReflected() {
        return G.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            return getName().equals(nVar.getName()) && getSignature().equals(nVar.getSignature()) && this.flags == nVar.flags && this.arity == nVar.arity && r.b(getBoundReceiver(), nVar.getBoundReceiver()) && r.b(getOwner(), nVar.getOwner());
        }
        if (obj instanceof p3.f) {
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

    @Override // p3.f
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // p3.f
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // p3.f
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // p3.f
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.AbstractC1580e, p3.InterfaceC1715b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        InterfaceC1715b interfaceC1715bCompute = compute();
        if (interfaceC1715bCompute != this) {
            return interfaceC1715bCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.AbstractC1580e
    public p3.f getReflected() {
        return (p3.f) super.getReflected();
    }
}
