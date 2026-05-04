package s8;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import s8.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f20098b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a.b f20101e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataInputStream f20097a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f20099c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f20100d = new byte[112];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f20102f = false;

    public h(c cVar) {
        this.f20098b = null;
        this.f20098b = cVar;
    }

    public final void a(boolean z10, byte b10, byte[] bArr) {
        if (b10 == 9) {
            if (!z10) {
                throw new e("PING must not fragment across frames");
            }
            c(bArr);
            return;
        }
        a.b bVar = this.f20101e;
        if (bVar != null && b10 != 0) {
            throw new e("Failed to continue outstanding frame");
        }
        if (bVar == null && b10 == 0) {
            throw new e("Received continuing frame, but there's nothing to continue");
        }
        if (bVar == null) {
            this.f20101e = a.a(b10);
        }
        if (!this.f20101e.a(bArr)) {
            throw new e("Failed to decode frame");
        }
        if (z10) {
            g gVarB = this.f20101e.b();
            this.f20101e = null;
            if (gVarB == null) {
                throw new e("Failed to decode whole message");
            }
            this.f20099c.f(gVarB);
        }
    }

    public final void b(e eVar) {
        h();
        this.f20098b.k(eVar);
    }

    public final void c(byte[] bArr) {
        if (bArr.length > 125) {
            throw new e("PING frame too long");
        }
        this.f20098b.m(bArr);
    }

    public final long d(byte[] bArr, int i10) {
        return (((long) bArr[i10]) << 56) + (((long) (bArr[i10 + 1] & 255)) << 48) + (((long) (bArr[i10 + 2] & 255)) << 40) + (((long) (bArr[i10 + 3] & 255)) << 32) + (((long) (bArr[i10 + 4] & 255)) << 24) + ((long) ((bArr[i10 + 5] & 255) << 16)) + ((long) ((bArr[i10 + 6] & 255) << 8)) + ((long) (bArr[i10 + 7] & 255));
    }

    public final int e(byte[] bArr, int i10, int i11) throws IOException {
        this.f20097a.readFully(bArr, i10, i11);
        return i11;
    }

    public void f() {
        int iE;
        byte[] bArr;
        byte b10;
        boolean z10;
        long jD;
        this.f20099c = this.f20098b.g();
        while (!this.f20102f) {
            try {
                iE = e(this.f20100d, 0, 1);
                bArr = this.f20100d;
                b10 = bArr[0];
                z10 = (b10 & 128) != 0;
            } catch (SocketTimeoutException unused) {
            } catch (IOException e10) {
                b(new e("IO Error", e10));
            } catch (e e11) {
                b(e11);
            }
            if ((b10 & 112) != 0) {
                throw new e("Invalid frame received");
            }
            byte b11 = (byte) (b10 & 15);
            int iE2 = iE + e(bArr, iE, 1);
            byte[] bArr2 = this.f20100d;
            byte b12 = bArr2[1];
            if (b12 < 126) {
                jD = b12;
            } else if (b12 == 126) {
                e(bArr2, iE2, 2);
                byte[] bArr3 = this.f20100d;
                jD = (((long) (bArr3[2] & 255)) << 8) | ((long) (bArr3[3] & 255));
            } else {
                jD = b12 == 127 ? d(this.f20100d, (iE2 + e(bArr2, iE2, 8)) - 8) : 0L;
            }
            int i10 = (int) jD;
            byte[] bArr4 = new byte[i10];
            e(bArr4, 0, i10);
            if (b11 == 8) {
                this.f20098b.l();
            } else if (b11 != 10) {
                if (b11 != 1 && b11 != 2 && b11 != 9 && b11 != 0) {
                    throw new e("Unsupported opcode: " + ((int) b11));
                }
                a(z10, b11, bArr4);
            }
        }
    }

    public void g(DataInputStream dataInputStream) {
        this.f20097a = dataInputStream;
    }

    public void h() {
        this.f20102f = true;
    }
}
