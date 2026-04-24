package kotlin.jvm.internal;

import p3.InterfaceC1715b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class C extends AbstractC1580e implements p3.h {
    private final boolean syntheticJavaProperty;

    public C(Object obj, Class cls, String str, String str2, int i4) {
        super(obj, cls, str, str2, (i4 & 1) == 1);
        this.syntheticJavaProperty = (i4 & 2) == 2;
    }

    @Override // kotlin.jvm.internal.AbstractC1580e
    public InterfaceC1715b compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C) {
            C c4 = (C) obj;
            return getOwner().equals(c4.getOwner()) && getName().equals(c4.getName()) && getSignature().equals(c4.getSignature()) && r.b(getBoundReceiver(), c4.getBoundReceiver());
        }
        if (obj instanceof p3.h) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // p3.h
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // p3.h
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        InterfaceC1715b interfaceC1715bCompute = compute();
        if (interfaceC1715bCompute != this) {
            return interfaceC1715bCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.AbstractC1580e
    public p3.h getReflected() {
        if (this.syntheticJavaProperty) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        return (p3.h) super.getReflected();
    }
}
