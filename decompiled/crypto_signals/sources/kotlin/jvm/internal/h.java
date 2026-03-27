package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends c implements g, W4.e {
    private final int arity;
    private final int flags;

    public h(int i, Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, (i6 & 1) == 1);
        this.arity = i;
        this.flags = 0;
    }

    @Override // kotlin.jvm.internal.c
    public W4.b computeReflected() {
        t.f7935a.getClass();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return getName().equals(hVar.getName()) && getSignature().equals(hVar.getSignature()) && this.flags == hVar.flags && this.arity == hVar.arity && j.a(getBoundReceiver(), hVar.getBoundReceiver()) && j.a(getOwner(), hVar.getOwner());
        }
        if (obj instanceof W4.e) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.g
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // W4.e
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // W4.e
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // W4.e
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // W4.e
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // W4.e
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        W4.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.c
    public W4.e getReflected() {
        W4.b bVarCompute = compute();
        if (bVarCompute != this) {
            return (W4.e) bVarCompute;
        }
        throw new Q4.a("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }
}
