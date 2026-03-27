package t6;

/* JADX INFO: renamed from: t6.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2724n extends C2723m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f24335c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2724n(T writer, boolean z7) {
        super(writer);
        kotlin.jvm.internal.r.f(writer, "writer");
        this.f24335c = z7;
    }

    @Override // t6.C2723m
    public void m(String value) {
        kotlin.jvm.internal.r.f(value, "value");
        if (this.f24335c) {
            super.m(value);
        } else {
            super.j(value);
        }
    }
}
