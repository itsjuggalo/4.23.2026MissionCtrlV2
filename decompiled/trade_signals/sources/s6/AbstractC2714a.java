package s6;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import s6.p;

/* JADX INFO: renamed from: s6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2714a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f23120a = 0;

    /* JADX INFO: renamed from: s6.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0396a implements p.a {

        /* JADX INFO: renamed from: s6.a$a$a, reason: collision with other inner class name */
        public static final class C0397a extends FilterInputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f23121a;

            public C0397a(InputStream inputStream, int i8) {
                super(inputStream);
                this.f23121a = i8;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.f23121a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f23121a <= 0) {
                    return -1;
                }
                int i8 = super.read();
                if (i8 >= 0) {
                    this.f23121a--;
                }
                return i8;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j8) throws IOException {
                long jSkip = super.skip(Math.min(j8, this.f23121a));
                if (jSkip >= 0) {
                    this.f23121a = (int) (((long) this.f23121a) - jSkip);
                }
                return jSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i8, int i9) throws IOException {
                int i10 = this.f23121a;
                if (i10 <= 0) {
                    return -1;
                }
                int i11 = super.read(bArr, i8, Math.min(i9, i10));
                if (i11 >= 0) {
                    this.f23121a -= i11;
                }
                return i11;
            }
        }

        public static v i(p pVar) {
            return new v(pVar);
        }
    }

    public v f() {
        return new v(this);
    }

    public void i(OutputStream outputStream) throws IOException {
        int iC = c();
        C2719f c2719fI = C2719f.I(outputStream, C2719f.t(C2719f.u(iC) + iC));
        c2719fI.n0(iC);
        h(c2719fI);
        c2719fI.H();
    }
}
