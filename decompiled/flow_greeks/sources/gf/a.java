package gf;

import gf.p;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10622a = 0;

    public v e() {
        return new v(this);
    }

    public void h(OutputStream outputStream) throws IOException {
        int iB = b();
        f fVarI = f.I(outputStream, f.t(f.u(iB) + iB));
        fVarI.n0(iB);
        g(fVarI);
        fVarI.H();
    }

    /* JADX INFO: renamed from: gf.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class AbstractC0191a implements p.a {
        public static v h(p pVar) {
            return new v(pVar);
        }

        /* JADX INFO: renamed from: gf.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0192a extends FilterInputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f10623a;

            public C0192a(InputStream inputStream, int i10) {
                super(inputStream);
                this.f10623a = i10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.f10623a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f10623a <= 0) {
                    return -1;
                }
                int i10 = super.read();
                if (i10 >= 0) {
                    this.f10623a--;
                }
                return i10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j10) throws IOException {
                long jSkip = super.skip(Math.min(j10, this.f10623a));
                if (jSkip >= 0) {
                    this.f10623a = (int) (((long) this.f10623a) - jSkip);
                }
                return jSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) throws IOException {
                int i12 = this.f10623a;
                if (i12 <= 0) {
                    return -1;
                }
                int i13 = super.read(bArr, i10, Math.min(i11, i12));
                if (i13 >= 0) {
                    this.f10623a -= i13;
                }
                return i13;
            }
        }
    }
}
