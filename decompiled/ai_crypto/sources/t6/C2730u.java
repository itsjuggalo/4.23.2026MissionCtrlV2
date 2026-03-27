package t6;

/* JADX INFO: renamed from: t6.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2730u extends C2723m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f24336c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2730u(T writer, boolean z7) {
        super(writer);
        kotlin.jvm.internal.r.f(writer, "writer");
        this.f24336c = z7;
    }

    @Override // t6.C2723m
    public void d(byte b7) {
        boolean z7 = this.f24336c;
        String strI = E5.u.i(E5.u.b(b7));
        if (z7) {
            m(strI);
        } else {
            j(strI);
        }
    }

    @Override // t6.C2723m
    public void h(int i7) {
        boolean z7 = this.f24336c;
        int iB = E5.w.b(i7);
        if (z7) {
            m(Long.toString(((long) iB) & 4294967295L, 10));
        } else {
            j(Long.toString(((long) iB) & 4294967295L, 10));
        }
    }

    @Override // t6.C2723m
    public void i(long j7) {
        boolean z7 = this.f24336c;
        long jB = E5.y.b(j7);
        if (z7) {
            m(AbstractC2728s.a(jB, 10));
        } else {
            j(AbstractC2729t.a(jB, 10));
        }
    }

    @Override // t6.C2723m
    public void k(short s7) {
        boolean z7 = this.f24336c;
        String strI = E5.B.i(E5.B.b(s7));
        if (z7) {
            m(strI);
        } else {
            j(strI);
        }
    }
}
