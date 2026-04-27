package L3;

import io.flutter.embedding.android.KeyboardMap;

/* JADX INFO: renamed from: L3.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0397u extends C0390m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1543c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0397u(T writer, boolean z4) {
        super(writer);
        kotlin.jvm.internal.r.f(writer, "writer");
        this.f1543c = z4;
    }

    @Override // L3.C0390m
    public void d(byte b4) {
        boolean z4 = this.f1543c;
        String strI = W2.u.i(W2.u.c(b4));
        if (z4) {
            m(strI);
        } else {
            j(strI);
        }
    }

    @Override // L3.C0390m
    public void h(int i4) {
        boolean z4 = this.f1543c;
        int iC = W2.w.c(i4);
        if (z4) {
            m(Long.toString(((long) iC) & KeyboardMap.kValueMask, 10));
        } else {
            j(Long.toString(((long) iC) & KeyboardMap.kValueMask, 10));
        }
    }

    @Override // L3.C0390m
    public void i(long j4) {
        boolean z4 = this.f1543c;
        long jC = W2.y.c(j4);
        if (z4) {
            m(AbstractC0395s.a(jC, 10));
        } else {
            j(AbstractC0396t.a(jC, 10));
        }
    }

    @Override // L3.C0390m
    public void k(short s4) {
        boolean z4 = this.f1543c;
        String strI = W2.B.i(W2.B.c(s4));
        if (z4) {
            m(strI);
        } else {
            j(strI);
        }
    }
}
