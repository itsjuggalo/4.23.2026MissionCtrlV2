package f3;

import android.util.Log;
import com.google.android.gms.common.api.a;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f9330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f9331c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f9329a = new byte[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9332d = 0;

    public void a() {
        this.f9330b = null;
        this.f9331c = null;
    }

    public final boolean b() {
        return this.f9331c.f9317b != 0;
    }

    public c c() {
        if (this.f9330b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.f9331c;
        }
        k();
        if (!b()) {
            h();
            c cVar = this.f9331c;
            if (cVar.f9318c < 0) {
                cVar.f9317b = 1;
            }
        }
        return this.f9331c;
    }

    public final int d() {
        try {
            return this.f9330b.get() & 255;
        } catch (Exception unused) {
            this.f9331c.f9317b = 1;
            return 0;
        }
    }

    public final void e() {
        this.f9331c.f9319d.f9305a = n();
        this.f9331c.f9319d.f9306b = n();
        this.f9331c.f9319d.f9307c = n();
        this.f9331c.f9319d.f9308d = n();
        int iD = d();
        boolean z10 = (iD & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iD & 7) + 1);
        b bVar = this.f9331c.f9319d;
        bVar.f9309e = (iD & 64) != 0;
        if (z10) {
            bVar.f9315k = g(iPow);
        } else {
            bVar.f9315k = null;
        }
        this.f9331c.f9319d.f9314j = this.f9330b.position();
        r();
        if (b()) {
            return;
        }
        c cVar = this.f9331c;
        cVar.f9318c++;
        cVar.f9320e.add(cVar.f9319d);
    }

    public final void f() {
        int iD = d();
        this.f9332d = iD;
        if (iD <= 0) {
            return;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            try {
                i11 = this.f9332d;
                if (i10 >= i11) {
                    return;
                }
                i11 -= i10;
                this.f9330b.get(this.f9329a, i10, i11);
                i10 += i11;
            } catch (Exception e10) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i10 + " count: " + i11 + " blockSize: " + this.f9332d, e10);
                }
                this.f9331c.f9317b = 1;
                return;
            }
        }
    }

    public final int[] g(int i10) {
        byte[] bArr = new byte[i10 * 3];
        int[] iArr = null;
        try {
            this.f9330b.get(bArr);
            iArr = new int[256];
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = bArr[i12] & 255;
                int i14 = i12 + 2;
                int i15 = bArr[i12 + 1] & 255;
                i12 += 3;
                int i16 = i11 + 1;
                iArr[i11] = (i15 << 8) | (i13 << 16) | (-16777216) | (bArr[i14] & 255);
                i11 = i16;
            }
            return iArr;
        } catch (BufferUnderflowException e10) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e10);
            }
            this.f9331c.f9317b = 1;
            return iArr;
        }
    }

    public final void h() {
        i(a.e.API_PRIORITY_OTHER);
    }

    public final void i(int i10) {
        boolean z10 = false;
        while (!z10 && !b() && this.f9331c.f9318c <= i10) {
            int iD = d();
            if (iD == 33) {
                int iD2 = d();
                if (iD2 == 1) {
                    q();
                } else if (iD2 == 249) {
                    this.f9331c.f9319d = new b();
                    j();
                } else if (iD2 == 254) {
                    q();
                } else if (iD2 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i11 = 0; i11 < 11; i11++) {
                        sb2.append((char) this.f9329a[i11]);
                    }
                    if (sb2.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (iD == 44) {
                c cVar = this.f9331c;
                if (cVar.f9319d == null) {
                    cVar.f9319d = new b();
                }
                e();
            } else if (iD != 59) {
                this.f9331c.f9317b = 1;
            } else {
                z10 = true;
            }
        }
    }

    public final void j() {
        d();
        int iD = d();
        b bVar = this.f9331c.f9319d;
        int i10 = (iD & 28) >> 2;
        bVar.f9311g = i10;
        if (i10 == 0) {
            bVar.f9311g = 1;
        }
        bVar.f9310f = (iD & 1) != 0;
        int iN = n();
        if (iN < 2) {
            iN = 10;
        }
        b bVar2 = this.f9331c.f9319d;
        bVar2.f9313i = iN * 10;
        bVar2.f9312h = d();
        d();
    }

    public final void k() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 6; i10++) {
            sb2.append((char) d());
        }
        if (!sb2.toString().startsWith("GIF")) {
            this.f9331c.f9317b = 1;
            return;
        }
        l();
        if (!this.f9331c.f9323h || b()) {
            return;
        }
        c cVar = this.f9331c;
        cVar.f9316a = g(cVar.f9324i);
        c cVar2 = this.f9331c;
        cVar2.f9327l = cVar2.f9316a[cVar2.f9325j];
    }

    public final void l() {
        this.f9331c.f9321f = n();
        this.f9331c.f9322g = n();
        int iD = d();
        c cVar = this.f9331c;
        cVar.f9323h = (iD & 128) != 0;
        cVar.f9324i = (int) Math.pow(2.0d, (iD & 7) + 1);
        this.f9331c.f9325j = d();
        this.f9331c.f9326k = d();
    }

    public final void m() {
        do {
            f();
            byte[] bArr = this.f9329a;
            if (bArr[0] == 1) {
                this.f9331c.f9328m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f9332d <= 0) {
                return;
            }
        } while (!b());
    }

    public final int n() {
        return this.f9330b.getShort();
    }

    public final void o() {
        this.f9330b = null;
        Arrays.fill(this.f9329a, (byte) 0);
        this.f9331c = new c();
        this.f9332d = 0;
    }

    public d p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f9330b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.f9330b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public final void q() {
        int iD;
        do {
            iD = d();
            this.f9330b.position(Math.min(this.f9330b.position() + iD, this.f9330b.limit()));
        } while (iD > 0);
    }

    public final void r() {
        d();
        q();
    }
}
