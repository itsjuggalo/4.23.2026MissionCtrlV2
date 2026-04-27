package y5;

import H2.m;
import com.google.android.gms.common.api.a;
import com.google.protobuf.AbstractC1241j;
import com.google.protobuf.C1248q;
import com.google.protobuf.D;
import com.google.protobuf.V;
import com.google.protobuf.f0;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import r5.Q;
import r5.a0;
import r5.l0;

/* JADX INFO: renamed from: y5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2849b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile C1248q f25780a = C1248q.b();

    /* JADX INFO: renamed from: y5.b$a */
    public static final class a implements a0.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ThreadLocal f25781d = new ThreadLocal();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f0 f25782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f25783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f25784c;

        public a(V v7, int i7) {
            this.f25783b = (V) m.o(v7, "defaultInstance cannot be null");
            this.f25782a = v7.j();
            this.f25784c = i7;
        }

        @Override // r5.a0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public V a(InputStream inputStream) {
            AbstractC1241j abstractC1241jG;
            byte[] bArr;
            if ((inputStream instanceof C2848a) && ((C2848a) inputStream).A() == this.f25782a) {
                try {
                    return ((C2848a) inputStream).i();
                } catch (IllegalStateException unused) {
                }
            }
            try {
                if (inputStream instanceof Q) {
                    int iAvailable = inputStream.available();
                    if (iAvailable <= 0 || iAvailable > 4194304) {
                        if (iAvailable == 0) {
                            return this.f25783b;
                        }
                        abstractC1241jG = null;
                    } else {
                        ThreadLocal threadLocal = f25781d;
                        Reference reference = (Reference) threadLocal.get();
                        if (reference == null || (bArr = (byte[]) reference.get()) == null || bArr.length < iAvailable) {
                            bArr = new byte[iAvailable];
                            threadLocal.set(new WeakReference(bArr));
                        }
                        int i7 = iAvailable;
                        while (i7 > 0) {
                            int i8 = inputStream.read(bArr, iAvailable - i7, i7);
                            if (i8 == -1) {
                                break;
                            }
                            i7 -= i8;
                        }
                        if (i7 != 0) {
                            throw new RuntimeException("size inaccurate: " + iAvailable + " != " + (iAvailable - i7));
                        }
                        abstractC1241jG = AbstractC1241j.l(bArr, 0, iAvailable);
                    }
                } else {
                    abstractC1241jG = null;
                }
                if (abstractC1241jG == null) {
                    abstractC1241jG = AbstractC1241j.g(inputStream);
                }
                abstractC1241jG.I(a.e.API_PRIORITY_OTHER);
                int i9 = this.f25784c;
                if (i9 >= 0) {
                    abstractC1241jG.H(i9);
                }
                try {
                    return d(abstractC1241jG);
                } catch (D e7) {
                    throw l0.f22719s.q("Invalid protobuf byte sequence").p(e7).d();
                }
            } catch (IOException e8) {
                throw new RuntimeException(e8);
            }
        }

        public final V d(AbstractC1241j abstractC1241j) throws D {
            V v7 = (V) this.f25782a.a(abstractC1241j, AbstractC2849b.f25780a);
            try {
                abstractC1241j.a(0);
                return v7;
            } catch (D e7) {
                e7.k(v7);
                throw e7;
            }
        }

        @Override // r5.a0.c
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public InputStream b(V v7) {
            return new C2848a(v7, this.f25782a);
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        m.o(inputStream, "inputStream cannot be null!");
        m.o(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j7 = 0;
        while (true) {
            int i7 = inputStream.read(bArr);
            if (i7 == -1) {
                return j7;
            }
            outputStream.write(bArr, 0, i7);
            j7 += (long) i7;
        }
    }

    public static a0.c b(V v7) {
        return new a(v7, -1);
    }
}
