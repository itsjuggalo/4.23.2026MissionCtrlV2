package z4;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import u5.C1250g;
import u5.E;
import u5.G;
import u5.y;

/* JADX INFO: loaded from: classes.dex */
public final class e implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f11799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f11801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11802d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public short f11803f;

    public e(y yVar) {
        this.f11799a = yVar;
    }

    @Override // u5.E
    public final long a(long j4, C1250g c1250g) throws IOException {
        int i;
        int iH;
        do {
            int i6 = this.e;
            y yVar = this.f11799a;
            if (i6 == 0) {
                yVar.p(this.f11803f);
                this.f11803f = (short) 0;
                if ((this.f11801c & 4) == 0) {
                    i = this.f11802d;
                    int iA = i.a(yVar);
                    this.e = iA;
                    this.f11800b = iA;
                    byte bD = (byte) (yVar.d() & 255);
                    this.f11801c = (byte) (yVar.d() & 255);
                    Logger logger = i.f11814a;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(f.a(true, this.f11802d, this.f11800b, bD, this.f11801c));
                    }
                    iH = yVar.h() & com.google.android.gms.common.api.f.API_PRIORITY_OTHER;
                    this.f11802d = iH;
                    if (bD != 9) {
                        i.c("%s != TYPE_CONTINUATION", Byte.valueOf(bD));
                        throw null;
                    }
                }
            } else {
                long jA = yVar.a(Math.min(j4, i6), c1250g);
                if (jA != -1) {
                    this.e -= (int) jA;
                    return jA;
                }
            }
            return -1L;
        } while (iH == i);
        i.c("TYPE_CONTINUATION streamId changed", new Object[0]);
        throw null;
    }

    @Override // u5.E
    public final G b() {
        return this.f11799a.f10555a.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
