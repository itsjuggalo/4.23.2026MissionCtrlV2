package R5;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class A extends r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q6.f f7193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final M6.j f7194b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(q6.f underlyingPropertyName, M6.j underlyingType) {
        super(null);
        AbstractC2304t.f(underlyingPropertyName, "underlyingPropertyName");
        AbstractC2304t.f(underlyingType, "underlyingType");
        this.f7193a = underlyingPropertyName;
        this.f7194b = underlyingType;
    }

    @Override // R5.r0
    public boolean a(q6.f name) {
        AbstractC2304t.f(name, "name");
        return AbstractC2304t.b(this.f7193a, name);
    }

    public final q6.f c() {
        return this.f7193a;
    }

    public final M6.j d() {
        return this.f7194b;
    }

    public String toString() {
        return "InlineClassRepresentation(underlyingPropertyName=" + this.f7193a + ", underlyingType=" + this.f7194b + ')';
    }
}
