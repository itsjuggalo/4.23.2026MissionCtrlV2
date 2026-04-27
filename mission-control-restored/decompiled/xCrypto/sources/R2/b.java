package R2;

import K2.Q;
import K2.a0;
import K2.l0;
import Z1.m;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.protobuf.AbstractC1063j;
import com.google.protobuf.C1070q;
import com.google.protobuf.D;
import com.google.protobuf.W;
import com.google.protobuf.g0;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile C1070q f3564a = C1070q.b();

    public static final class a implements a0.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ThreadLocal f3565d = new ThreadLocal();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g0 f3566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final W f3567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3568c;

        public a(W w4, int i4) {
            this.f3567b = (W) m.o(w4, "defaultInstance cannot be null");
            this.f3566a = w4.getParserForType();
            this.f3568c = i4;
        }

        @Override // K2.a0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public W a(InputStream inputStream) {
            AbstractC1063j abstractC1063jG;
            byte[] bArr;
            if ((inputStream instanceof R2.a) && ((R2.a) inputStream).g() == this.f3566a) {
                try {
                    return ((R2.a) inputStream).f();
                } catch (IllegalStateException unused) {
                }
            }
            try {
                if (inputStream instanceof Q) {
                    int iAvailable = inputStream.available();
                    if (iAvailable <= 0 || iAvailable > 4194304) {
                        if (iAvailable == 0) {
                            return this.f3567b;
                        }
                        abstractC1063jG = null;
                    } else {
                        ThreadLocal threadLocal = f3565d;
                        Reference reference = (Reference) threadLocal.get();
                        if (reference == null || (bArr = (byte[]) reference.get()) == null || bArr.length < iAvailable) {
                            bArr = new byte[iAvailable];
                            threadLocal.set(new WeakReference(bArr));
                        }
                        int i4 = iAvailable;
                        while (i4 > 0) {
                            int i5 = inputStream.read(bArr, iAvailable - i4, i4);
                            if (i5 == -1) {
                                break;
                            }
                            i4 -= i5;
                        }
                        if (i4 != 0) {
                            throw new RuntimeException("size inaccurate: " + iAvailable + " != " + (iAvailable - i4));
                        }
                        abstractC1063jG = AbstractC1063j.m(bArr, 0, iAvailable);
                    }
                } else {
                    abstractC1063jG = null;
                }
                if (abstractC1063jG == null) {
                    abstractC1063jG = AbstractC1063j.g(inputStream);
                }
                abstractC1063jG.K(Integer.MAX_VALUE);
                int i6 = this.f3568c;
                if (i6 >= 0) {
                    abstractC1063jG.J(i6);
                }
                try {
                    return d(abstractC1063jG);
                } catch (D e4) {
                    throw l0.f1229s.q("Invalid protobuf byte sequence").p(e4).d();
                }
            } catch (IOException e5) {
                throw new RuntimeException(e5);
            }
        }

        public final W d(AbstractC1063j abstractC1063j) throws D {
            W w4 = (W) this.f3566a.a(abstractC1063j, b.f3564a);
            try {
                abstractC1063j.a(0);
                return w4;
            } catch (D e4) {
                e4.k(w4);
                throw e4;
            }
        }

        @Override // K2.a0.c
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public InputStream b(W w4) {
            return new R2.a(w4, this.f3566a);
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        m.o(inputStream, "inputStream cannot be null!");
        m.o(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
        long j4 = 0;
        while (true) {
            int i4 = inputStream.read(bArr);
            if (i4 == -1) {
                return j4;
            }
            outputStream.write(bArr, 0, i4);
            j4 += (long) i4;
        }
    }

    public static a0.c b(W w4) {
        return new a(w4, -1);
    }
}
