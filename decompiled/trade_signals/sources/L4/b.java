package L4;

import F4.O;
import F4.Y;
import F4.j0;
import com.google.protobuf.AbstractC1468g;
import com.google.protobuf.C1474m;
import com.google.protobuf.C1482v;
import com.google.protobuf.J;
import com.google.protobuf.S;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile C1474m f5023a = C1474m.b();

    public static final class a implements Y.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ThreadLocal f5024d = new ThreadLocal();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S f5025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final J f5026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5027c;

        public a(J j8, int i8) {
            this.f5026b = (J) AbstractC2848n.o(j8, "defaultInstance cannot be null");
            this.f5025a = j8.j();
            this.f5027c = i8;
        }

        @Override // F4.Y.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public J a(InputStream inputStream) {
            AbstractC1468g abstractC1468gG;
            byte[] bArr;
            if ((inputStream instanceof L4.a) && ((L4.a) inputStream).e() == this.f5025a) {
                try {
                    return ((L4.a) inputStream).c();
                } catch (IllegalStateException unused) {
                }
            }
            try {
                if (inputStream instanceof O) {
                    int iAvailable = inputStream.available();
                    if (iAvailable <= 0 || iAvailable > 4194304) {
                        if (iAvailable == 0) {
                            return this.f5026b;
                        }
                        abstractC1468gG = null;
                    } else {
                        ThreadLocal threadLocal = f5024d;
                        Reference reference = (Reference) threadLocal.get();
                        if (reference == null || (bArr = (byte[]) reference.get()) == null || bArr.length < iAvailable) {
                            bArr = new byte[iAvailable];
                            threadLocal.set(new WeakReference(bArr));
                        }
                        int i8 = iAvailable;
                        while (i8 > 0) {
                            int i9 = inputStream.read(bArr, iAvailable - i8, i8);
                            if (i9 == -1) {
                                break;
                            }
                            i8 -= i9;
                        }
                        if (i8 != 0) {
                            throw new RuntimeException("size inaccurate: " + iAvailable + " != " + (iAvailable - i8));
                        }
                        abstractC1468gG = AbstractC1468g.j(bArr, 0, iAvailable);
                    }
                } else {
                    abstractC1468gG = null;
                }
                if (abstractC1468gG == null) {
                    abstractC1468gG = AbstractC1468g.g(inputStream);
                }
                abstractC1468gG.G(Integer.MAX_VALUE);
                int i10 = this.f5027c;
                if (i10 >= 0) {
                    abstractC1468gG.F(i10);
                }
                try {
                    return d(abstractC1468gG);
                } catch (C1482v e8) {
                    throw j0.f1811s.r("Invalid protobuf byte sequence").q(e8).d();
                }
            } catch (IOException e9) {
                throw new RuntimeException(e9);
            }
        }

        public final J d(AbstractC1468g abstractC1468g) throws C1482v {
            J j8 = (J) this.f5025a.b(abstractC1468g, b.f5023a);
            try {
                abstractC1468g.a(0);
                return j8;
            } catch (C1482v e8) {
                e8.k(j8);
                throw e8;
            }
        }

        @Override // F4.Y.c
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public InputStream b(J j8) {
            return new L4.a(j8, this.f5025a);
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        AbstractC2848n.o(inputStream, "inputStream cannot be null!");
        AbstractC2848n.o(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j8 = 0;
        while (true) {
            int i8 = inputStream.read(bArr);
            if (i8 == -1) {
                return j8;
            }
            outputStream.write(bArr, 0, i8);
            j8 += (long) i8;
        }
    }

    public static Y.c b(J j8) {
        return new a(j8, -1);
    }
}
