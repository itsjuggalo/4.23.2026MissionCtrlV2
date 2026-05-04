package fe;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ef.f f9446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bg.j f9447b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(ef.f underlyingPropertyName, bg.j underlyingType) {
        super(null);
        kotlin.jvm.internal.t.f(underlyingPropertyName, "underlyingPropertyName");
        kotlin.jvm.internal.t.f(underlyingType, "underlyingType");
        this.f9446a = underlyingPropertyName;
        this.f9447b = underlyingType;
    }

    @Override // fe.q1
    public boolean a(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        return kotlin.jvm.internal.t.b(this.f9446a, name);
    }

    public final ef.f c() {
        return this.f9446a;
    }

    public final bg.j d() {
        return this.f9447b;
    }

    public String toString() {
        return "InlineClassRepresentation(underlyingPropertyName=" + this.f9446a + ", underlyingType=" + this.f9447b + ')';
    }
}
