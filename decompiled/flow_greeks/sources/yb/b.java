package yb;

import com.google.android.gms.common.api.a;
import com.google.protobuf.d0;
import com.google.protobuf.e1;
import com.google.protobuf.j;
import com.google.protobuf.q;
import com.google.protobuf.u0;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import p6.n;
import rb.k1;
import rb.q0;
import rb.z0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile q f25335a = q.b();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements z0.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ThreadLocal f25336d = new ThreadLocal();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e1 f25337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u0 f25338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f25339c;

        public a(u0 u0Var, int i10) {
            this.f25338b = (u0) n.o(u0Var, "defaultInstance cannot be null");
            this.f25337a = u0Var.j();
            this.f25339c = i10;
        }

        @Override // rb.z0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public u0 a(InputStream inputStream) {
            j jVarG;
            byte[] bArr;
            if ((inputStream instanceof yb.a) && ((yb.a) inputStream).e() == this.f25337a) {
                try {
                    return ((yb.a) inputStream).c();
                } catch (IllegalStateException unused) {
                }
            }
            try {
                if (inputStream instanceof q0) {
                    int iAvailable = inputStream.available();
                    if (iAvailable <= 0 || iAvailable > 4194304) {
                        if (iAvailable == 0) {
                            return this.f25338b;
                        }
                        jVarG = null;
                    } else {
                        ThreadLocal threadLocal = f25336d;
                        Reference reference = (Reference) threadLocal.get();
                        if (reference == null || (bArr = (byte[]) reference.get()) == null || bArr.length < iAvailable) {
                            bArr = new byte[iAvailable];
                            threadLocal.set(new WeakReference(bArr));
                        }
                        int i10 = iAvailable;
                        while (i10 > 0) {
                            int i11 = inputStream.read(bArr, iAvailable - i10, i10);
                            if (i11 == -1) {
                                break;
                            }
                            i10 -= i11;
                        }
                        if (i10 != 0) {
                            throw new RuntimeException("size inaccurate: " + iAvailable + " != " + (iAvailable - i10));
                        }
                        jVarG = j.l(bArr, 0, iAvailable);
                    }
                } else {
                    jVarG = null;
                }
                if (jVarG == null) {
                    jVarG = j.g(inputStream);
                }
                jVarG.I(a.e.API_PRIORITY_OTHER);
                int i12 = this.f25339c;
                if (i12 >= 0) {
                    jVarG.H(i12);
                }
                try {
                    return d(jVarG);
                } catch (d0 e10) {
                    throw k1.f19606s.r("Invalid protobuf byte sequence").q(e10).d();
                }
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
        }

        public final u0 d(j jVar) throws d0 {
            u0 u0Var = (u0) this.f25337a.b(jVar, b.f25335a);
            try {
                jVar.a(0);
                return u0Var;
            } catch (d0 e10) {
                e10.k(u0Var);
                throw e10;
            }
        }

        @Override // rb.z0.c
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public InputStream b(u0 u0Var) {
            return new yb.a(u0Var, this.f25337a);
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        n.o(inputStream, "inputStream cannot be null!");
        n.o(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j10 = 0;
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                return j10;
            }
            outputStream.write(bArr, 0, i10);
            j10 += (long) i10;
        }
    }

    public static z0.c b(u0 u0Var) {
        return new a(u0Var, -1);
    }
}
