package T0;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f7911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f7912c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f7910a = new byte[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7913d = 0;

    public void a() {
        this.f7911b = null;
        this.f7912c = null;
    }

    public final boolean b() {
        return this.f7912c.f7898b != 0;
    }

    public c c() {
        if (this.f7911b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.f7912c;
        }
        k();
        if (!b()) {
            h();
            c cVar = this.f7912c;
            if (cVar.f7899c < 0) {
                cVar.f7898b = 1;
            }
        }
        return this.f7912c;
    }

    public final int d() {
        try {
            return this.f7911b.get() & 255;
        } catch (Exception unused) {
            this.f7912c.f7898b = 1;
            return 0;
        }
    }

    public final void e() {
        this.f7912c.f7900d.f7886a = n();
        this.f7912c.f7900d.f7887b = n();
        this.f7912c.f7900d.f7888c = n();
        this.f7912c.f7900d.f7889d = n();
        int iD = d();
        boolean z7 = (iD & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iD & 7) + 1);
        b bVar = this.f7912c.f7900d;
        bVar.f7890e = (iD & 64) != 0;
        if (z7) {
            bVar.f7896k = g(iPow);
        } else {
            bVar.f7896k = null;
        }
        this.f7912c.f7900d.f7895j = this.f7911b.position();
        r();
        if (b()) {
            return;
        }
        c cVar = this.f7912c;
        cVar.f7899c++;
        cVar.f7901e.add(cVar.f7900d);
    }

    public final void f() {
        int iD = d();
        this.f7913d = iD;
        if (iD <= 0) {
            return;
        }
        int i8 = 0;
        int i9 = 0;
        while (true) {
            try {
                i9 = this.f7913d;
                if (i8 >= i9) {
                    return;
                }
                i9 -= i8;
                this.f7911b.get(this.f7910a, i8, i9);
                i8 += i9;
            } catch (Exception e8) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i8 + " count: " + i9 + " blockSize: " + this.f7913d, e8);
                }
                this.f7912c.f7898b = 1;
                return;
            }
        }
    }

    public final int[] g(int i8) {
        byte[] bArr = new byte[i8 * 3];
        int[] iArr = null;
        try {
            this.f7911b.get(bArr);
            iArr = new int[256];
            int i9 = 0;
            int i10 = 0;
            while (i9 < i8) {
                int i11 = bArr[i10] & 255;
                int i12 = i10 + 2;
                int i13 = bArr[i10 + 1] & 255;
                i10 += 3;
                int i14 = i9 + 1;
                iArr[i9] = (i13 << 8) | (i11 << 16) | (-16777216) | (bArr[i12] & 255);
                i9 = i14;
            }
        } catch (BufferUnderflowException e8) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e8);
            }
            this.f7912c.f7898b = 1;
        }
        return iArr;
    }

    public final void h() {
        i(Integer.MAX_VALUE);
    }

    public final void i(int i8) {
        boolean z7 = false;
        while (!z7 && !b() && this.f7912c.f7899c <= i8) {
            int iD = d();
            if (iD == 33) {
                int iD2 = d();
                if (iD2 != 1) {
                    if (iD2 == 249) {
                        this.f7912c.f7900d = new b();
                        j();
                    } else if (iD2 != 254 && iD2 == 255) {
                        f();
                        StringBuilder sb = new StringBuilder();
                        for (int i9 = 0; i9 < 11; i9++) {
                            sb.append((char) this.f7910a[i9]);
                        }
                        if (sb.toString().equals("NETSCAPE2.0")) {
                            m();
                        }
                    }
                }
                q();
            } else if (iD == 44) {
                c cVar = this.f7912c;
                if (cVar.f7900d == null) {
                    cVar.f7900d = new b();
                }
                e();
            } else if (iD != 59) {
                this.f7912c.f7898b = 1;
            } else {
                z7 = true;
            }
        }
    }

    public final void j() {
        d();
        int iD = d();
        b bVar = this.f7912c.f7900d;
        int i8 = (iD & 28) >> 2;
        bVar.f7892g = i8;
        if (i8 == 0) {
            bVar.f7892g = 1;
        }
        bVar.f7891f = (iD & 1) != 0;
        int iN = n();
        if (iN < 2) {
            iN = 10;
        }
        b bVar2 = this.f7912c.f7900d;
        bVar2.f7894i = iN * 10;
        bVar2.f7893h = d();
        d();
    }

    public final void k() {
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < 6; i8++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f7912c.f7898b = 1;
            return;
        }
        l();
        if (!this.f7912c.f7904h || b()) {
            return;
        }
        c cVar = this.f7912c;
        cVar.f7897a = g(cVar.f7905i);
        c cVar2 = this.f7912c;
        cVar2.f7908l = cVar2.f7897a[cVar2.f7906j];
    }

    public final void l() {
        this.f7912c.f7902f = n();
        this.f7912c.f7903g = n();
        int iD = d();
        c cVar = this.f7912c;
        cVar.f7904h = (iD & 128) != 0;
        cVar.f7905i = (int) Math.pow(2.0d, (iD & 7) + 1);
        this.f7912c.f7906j = d();
        this.f7912c.f7907k = d();
    }

    public final void m() {
        do {
            f();
            byte[] bArr = this.f7910a;
            if (bArr[0] == 1) {
                this.f7912c.f7909m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f7913d <= 0) {
                return;
            }
        } while (!b());
    }

    public final int n() {
        return this.f7911b.getShort();
    }

    public final void o() {
        this.f7911b = null;
        Arrays.fill(this.f7910a, (byte) 0);
        this.f7912c = new c();
        this.f7913d = 0;
    }

    public d p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f7911b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.f7911b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public final void q() {
        int iD;
        do {
            iD = d();
            this.f7911b.position(Math.min(this.f7911b.position() + iD, this.f7911b.limit()));
        } while (iD > 0);
    }

    public final void r() {
        d();
        q();
    }
}
