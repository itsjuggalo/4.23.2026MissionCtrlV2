package q7;

import io.flutter.embedding.android.KeyboardMap;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2464B;
import o5.C2467E;

/* JADX INFO: renamed from: q7.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2663v extends C2656n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f22901c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2663v(A writer, boolean z7) {
        super(writer);
        AbstractC2304t.f(writer, "writer");
        this.f22901c = z7;
    }

    @Override // q7.C2656n
    public void e(byte b8) {
        boolean z7 = this.f22901c;
        String strK = o5.x.k(o5.x.b(b8));
        if (z7) {
            n(strK);
        } else {
            k(strK);
        }
    }

    @Override // q7.C2656n
    public void i(int i8) {
        boolean z7 = this.f22901c;
        int iB = o5.z.b(i8);
        if (z7) {
            n(Long.toString(((long) iB) & KeyboardMap.kValueMask, 10));
        } else {
            k(Long.toString(((long) iB) & KeyboardMap.kValueMask, 10));
        }
    }

    @Override // q7.C2656n
    public void j(long j8) {
        boolean z7 = this.f22901c;
        long jB = C2464B.b(j8);
        if (z7) {
            n(AbstractC2661t.a(jB, 10));
        } else {
            k(AbstractC2662u.a(jB, 10));
        }
    }

    @Override // q7.C2656n
    public void l(short s8) {
        boolean z7 = this.f22901c;
        String strK = C2467E.k(C2467E.b(s8));
        if (z7) {
            n(strK);
        } else {
            k(strK);
        }
    }
}
