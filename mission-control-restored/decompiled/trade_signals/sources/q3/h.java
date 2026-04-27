package q3;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import q3.AbstractC2631a;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f22581b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AbstractC2631a.b f22584e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataInputStream f22580a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f22582c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f22583d = new byte[112];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f22585f = false;

    public h(c cVar) {
        this.f22581b = null;
        this.f22581b = cVar;
    }

    public final void a(boolean z7, byte b8, byte[] bArr) {
        if (b8 == 9) {
            if (!z7) {
                throw new e("PING must not fragment across frames");
            }
            c(bArr);
            return;
        }
        AbstractC2631a.b bVar = this.f22584e;
        if (bVar != null && b8 != 0) {
            throw new e("Failed to continue outstanding frame");
        }
        if (bVar == null && b8 == 0) {
            throw new e("Received continuing frame, but there's nothing to continue");
        }
        if (bVar == null) {
            this.f22584e = AbstractC2631a.a(b8);
        }
        if (!this.f22584e.a(bArr)) {
            throw new e("Failed to decode frame");
        }
        if (z7) {
            g gVarB = this.f22584e.b();
            this.f22584e = null;
            if (gVarB == null) {
                throw new e("Failed to decode whole message");
            }
            this.f22582c.d(gVarB);
        }
    }

    public final void b(e eVar) {
        h();
        this.f22581b.k(eVar);
    }

    public final void c(byte[] bArr) {
        if (bArr.length > 125) {
            throw new e("PING frame too long");
        }
        this.f22581b.m(bArr);
    }

    public final long d(byte[] bArr, int i8) {
        return (((long) bArr[i8]) << 56) + (((long) (bArr[i8 + 1] & 255)) << 48) + (((long) (bArr[i8 + 2] & 255)) << 40) + (((long) (bArr[i8 + 3] & 255)) << 32) + (((long) (bArr[i8 + 4] & 255)) << 24) + ((long) ((bArr[i8 + 5] & 255) << 16)) + ((long) ((bArr[i8 + 6] & 255) << 8)) + ((long) (bArr[i8 + 7] & 255));
    }

    public final int e(byte[] bArr, int i8, int i9) throws IOException {
        this.f22580a.readFully(bArr, i8, i9);
        return i9;
    }

    public void f() {
        int iE;
        byte[] bArr;
        byte b8;
        boolean z7;
        long jD;
        this.f22582c = this.f22581b.g();
        while (!this.f22585f) {
            try {
                iE = e(this.f22583d, 0, 1);
                bArr = this.f22583d;
                b8 = bArr[0];
                z7 = (b8 & 128) != 0;
            } catch (SocketTimeoutException unused) {
            } catch (IOException e8) {
                b(new e("IO Error", e8));
            } catch (e e9) {
                b(e9);
            }
            if ((b8 & 112) != 0) {
                throw new e("Invalid frame received");
            }
            byte b9 = (byte) (b8 & 15);
            int iE2 = iE + e(bArr, iE, 1);
            byte[] bArr2 = this.f22583d;
            byte b10 = bArr2[1];
            if (b10 < 126) {
                jD = b10;
            } else if (b10 == 126) {
                e(bArr2, iE2, 2);
                byte[] bArr3 = this.f22583d;
                jD = (((long) (bArr3[2] & 255)) << 8) | ((long) (bArr3[3] & 255));
            } else {
                jD = b10 == 127 ? d(this.f22583d, (iE2 + e(bArr2, iE2, 8)) - 8) : 0L;
            }
            int i8 = (int) jD;
            byte[] bArr4 = new byte[i8];
            e(bArr4, 0, i8);
            if (b9 == 8) {
                this.f22581b.l();
            } else if (b9 != 10) {
                if (b9 != 1 && b9 != 2 && b9 != 9 && b9 != 0) {
                    throw new e("Unsupported opcode: " + ((int) b9));
                }
                a(z7, b9, bArr4);
            }
        }
    }

    public void g(DataInputStream dataInputStream) {
        this.f22580a = dataInputStream;
    }

    public void h() {
        this.f22585f = true;
    }
}
