package U;

import e3.w;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f3070d = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f3072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f3073c = 0;

    public m(w wVar, int i) {
        this.f3072b = wVar;
        this.f3071a = i;
    }

    public final int a(int i) {
        V.a aVarB = b();
        int iA = aVarB.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) aVarB.f254d;
        int i6 = iA + aVarB.f251a;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i6) + i6 + 4);
    }

    public final V.a b() {
        ThreadLocal threadLocal = f3070d;
        V.a aVar = (V.a) threadLocal.get();
        if (aVar == null) {
            aVar = new V.a();
            threadLocal.set(aVar);
        }
        V.b bVar = (V.b) this.f3072b.f6191b;
        int iA = bVar.a(6);
        if (iA != 0) {
            int i = iA + bVar.f251a;
            int i6 = (this.f3071a * 4) + ((ByteBuffer) bVar.f254d).getInt(i) + i + 4;
            int i7 = ((ByteBuffer) bVar.f254d).getInt(i6) + i6;
            ByteBuffer byteBuffer = (ByteBuffer) bVar.f254d;
            aVar.f254d = byteBuffer;
            if (byteBuffer != null) {
                aVar.f251a = i7;
                int i8 = i7 - byteBuffer.getInt(i7);
                aVar.f252b = i8;
                aVar.f253c = ((ByteBuffer) aVar.f254d).getShort(i8);
                return aVar;
            }
            aVar.f251a = 0;
            aVar.f252b = 0;
            aVar.f253c = 0;
        }
        return aVar;
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        V.a aVarB = b();
        int iA = aVarB.a(4);
        sb.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) aVarB.f254d).getInt(iA + aVarB.f251a) : 0));
        sb.append(", codepoints:");
        V.a aVarB2 = b();
        int iA2 = aVarB2.a(16);
        if (iA2 != 0) {
            int i6 = iA2 + aVarB2.f251a;
            i = ((ByteBuffer) aVarB2.f254d).getInt(((ByteBuffer) aVarB2.f254d).getInt(i6) + i6);
        } else {
            i = 0;
        }
        for (int i7 = 0; i7 < i; i7++) {
            sb.append(Integer.toHexString(a(i7)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
