package L3;

/* JADX INFO: renamed from: L3.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0391n extends C0390m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1542c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0391n(T writer, boolean z4) {
        super(writer);
        kotlin.jvm.internal.r.f(writer, "writer");
        this.f1542c = z4;
    }

    @Override // L3.C0390m
    public void m(String value) {
        kotlin.jvm.internal.r.f(value, "value");
        if (this.f1542c) {
            super.m(value);
        } else {
            super.j(value);
        }
    }
}
