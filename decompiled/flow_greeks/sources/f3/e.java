package f3;

import android.graphics.Bitmap;
import android.util.Log;
import f3.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f9333u = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f9334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f9335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.InterfaceC0172a f9336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ByteBuffer f9337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f9338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public short[] f9339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f9340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f9341h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f9342i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f9343j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9344k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f9345l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap f9346m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9347n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f9348o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f9349p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f9350q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f9351r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Boolean f9352s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Bitmap.Config f9353t;

    public e(a.InterfaceC0172a interfaceC0172a, c cVar, ByteBuffer byteBuffer, int i10) {
        this(interfaceC0172a);
        q(cVar, byteBuffer, i10);
    }

    @Override // f3.a
    public int a() {
        return this.f9337d.limit() + this.f9342i.length + (this.f9343j.length * 4);
    }

    @Override // f3.a
    public synchronized Bitmap b() {
        try {
            if (this.f9345l.f9318c <= 0 || this.f9344k < 0) {
                String str = f9333u;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Unable to decode frame, frameCount=" + this.f9345l.f9318c + ", framePointer=" + this.f9344k);
                }
                this.f9348o = 1;
            }
            int i10 = this.f9348o;
            if (i10 != 1 && i10 != 2) {
                this.f9348o = 0;
                if (this.f9338e == null) {
                    this.f9338e = this.f9336c.e(255);
                }
                b bVar = (b) this.f9345l.f9320e.get(this.f9344k);
                int i11 = this.f9344k - 1;
                b bVar2 = i11 >= 0 ? (b) this.f9345l.f9320e.get(i11) : null;
                int[] iArr = bVar.f9315k;
                if (iArr == null) {
                    iArr = this.f9345l.f9316a;
                }
                this.f9334a = iArr;
                if (iArr == null) {
                    String str2 = f9333u;
                    if (Log.isLoggable(str2, 3)) {
                        Log.d(str2, "No valid color table found for frame #" + this.f9344k);
                    }
                    this.f9348o = 1;
                    return null;
                }
                if (bVar.f9310f) {
                    System.arraycopy(iArr, 0, this.f9335b, 0, iArr.length);
                    int[] iArr2 = this.f9335b;
                    this.f9334a = iArr2;
                    iArr2[bVar.f9312h] = 0;
                    if (bVar.f9311g == 2 && this.f9344k == 0) {
                        this.f9352s = Boolean.TRUE;
                    }
                }
                return r(bVar, bVar2);
            }
            String str3 = f9333u;
            if (Log.isLoggable(str3, 3)) {
                Log.d(str3, "Unable to decode frame, status=" + this.f9348o);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // f3.a
    public void c() {
        this.f9344k = (this.f9344k + 1) % this.f9345l.f9318c;
    }

    @Override // f3.a
    public void clear() {
        this.f9345l = null;
        byte[] bArr = this.f9342i;
        if (bArr != null) {
            this.f9336c.d(bArr);
        }
        int[] iArr = this.f9343j;
        if (iArr != null) {
            this.f9336c.f(iArr);
        }
        Bitmap bitmap = this.f9346m;
        if (bitmap != null) {
            this.f9336c.c(bitmap);
        }
        this.f9346m = null;
        this.f9337d = null;
        this.f9352s = null;
        byte[] bArr2 = this.f9338e;
        if (bArr2 != null) {
            this.f9336c.d(bArr2);
        }
    }

    @Override // f3.a
    public int d() {
        return this.f9345l.f9318c;
    }

    @Override // f3.a
    public int e() {
        int i10;
        if (this.f9345l.f9318c <= 0 || (i10 = this.f9344k) < 0) {
            return 0;
        }
        return m(i10);
    }

    @Override // f3.a
    public void f(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.f9353t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    @Override // f3.a
    public void g() {
        this.f9344k = -1;
    }

    @Override // f3.a
    public ByteBuffer getData() {
        return this.f9337d;
    }

    @Override // f3.a
    public int h() {
        return this.f9344k;
    }

    public final int i(int i10, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = i10; i18 < this.f9349p + i10; i18++) {
            byte[] bArr = this.f9342i;
            if (i18 >= bArr.length || i18 >= i11) {
                break;
            }
            int i19 = this.f9334a[bArr[i18] & 255];
            if (i19 != 0) {
                i13 += (i19 >> 24) & 255;
                i14 += (i19 >> 16) & 255;
                i15 += (i19 >> 8) & 255;
                i16 += i19 & 255;
                i17++;
            }
        }
        int i20 = i10 + i12;
        for (int i21 = i20; i21 < this.f9349p + i20; i21++) {
            byte[] bArr2 = this.f9342i;
            if (i21 >= bArr2.length || i21 >= i11) {
                break;
            }
            int i22 = this.f9334a[bArr2[i21] & 255];
            if (i22 != 0) {
                i13 += (i22 >> 24) & 255;
                i14 += (i22 >> 16) & 255;
                i15 += (i22 >> 8) & 255;
                i16 += i22 & 255;
                i17++;
            }
        }
        if (i17 == 0) {
            return 0;
        }
        return ((i13 / i17) << 24) | ((i14 / i17) << 16) | ((i15 / i17) << 8) | (i16 / i17);
    }

    public final void j(b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int[] iArr = this.f9343j;
        int i14 = bVar.f9308d;
        int i15 = this.f9349p;
        int i16 = i14 / i15;
        int i17 = bVar.f9306b / i15;
        int i18 = bVar.f9307c / i15;
        int i19 = bVar.f9305a / i15;
        boolean z10 = this.f9344k == 0;
        int i20 = this.f9351r;
        int i21 = this.f9350q;
        byte[] bArr = this.f9342i;
        int[] iArr2 = this.f9334a;
        Boolean bool = this.f9352s;
        int i22 = 8;
        int i23 = 0;
        int i24 = 0;
        int i25 = 1;
        while (i24 < i16) {
            int[] iArr3 = iArr;
            if (bVar.f9309e) {
                if (i23 >= i16) {
                    int i26 = i25 + 1;
                    i10 = i16;
                    if (i26 == 2) {
                        i25 = i26;
                        i23 = 4;
                    } else if (i26 == 3) {
                        i25 = i26;
                        i22 = 4;
                        i23 = 2;
                    } else if (i26 != 4) {
                        i25 = i26;
                    } else {
                        i25 = i26;
                        i23 = 1;
                        i22 = 2;
                    }
                } else {
                    i10 = i16;
                }
                i11 = i23 + i22;
            } else {
                i10 = i16;
                i11 = i23;
                i23 = i24;
            }
            int i27 = i23 + i17;
            boolean z11 = i15 == 1;
            if (i27 < i21) {
                int i28 = i27 * i20;
                int i29 = i28 + i19;
                int i30 = i29 + i18;
                int i31 = i28 + i20;
                if (i31 < i30) {
                    i30 = i31;
                }
                i12 = i11;
                int i32 = i24 * i15 * bVar.f9307c;
                if (z11) {
                    int i33 = i29;
                    while (i33 < i30) {
                        int i34 = i33;
                        int i35 = iArr2[bArr[i32] & 255];
                        if (i35 != 0) {
                            iArr3[i34] = i35;
                        } else if (z10 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i32 += i15;
                        i33 = i34 + 1;
                    }
                } else {
                    int i36 = ((i30 - i29) * i15) + i32;
                    i13 = i15;
                    int i37 = i29;
                    while (i37 < i30) {
                        int i38 = i30;
                        int i39 = i(i32, i36, bVar.f9307c);
                        if (i39 != 0) {
                            iArr3[i37] = i39;
                        } else if (z10 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i32 += i13;
                        i37++;
                        i30 = i38;
                    }
                    i24++;
                    i15 = i13;
                    iArr = iArr3;
                    i16 = i10;
                    i23 = i12;
                }
            } else {
                i12 = i11;
            }
            i13 = i15;
            i24++;
            i15 = i13;
            iArr = iArr3;
            i16 = i10;
            i23 = i12;
        }
        if (this.f9352s == null) {
            this.f9352s = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    public final void k(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.f9343j;
        int i10 = bVar2.f9308d;
        int i11 = bVar2.f9306b;
        int i12 = bVar2.f9307c;
        int i13 = bVar2.f9305a;
        boolean z10 = this.f9344k == 0;
        int i14 = this.f9351r;
        byte[] bArr = this.f9342i;
        int[] iArr2 = this.f9334a;
        int i15 = 0;
        byte b10 = -1;
        while (i15 < i10) {
            int i16 = (i15 + i11) * i14;
            int i17 = i16 + i13;
            int i18 = i17 + i12;
            int i19 = i16 + i14;
            if (i19 < i18) {
                i18 = i19;
            }
            int i20 = bVar2.f9307c * i15;
            int i21 = i17;
            while (i21 < i18) {
                byte b11 = bArr[i20];
                int[] iArr3 = iArr;
                int i22 = b11 & 255;
                if (i22 != b10) {
                    int i23 = iArr2[i22];
                    if (i23 != 0) {
                        iArr3[i21] = i23;
                    } else {
                        b10 = b11;
                    }
                }
                i20++;
                i21++;
                iArr = iArr3;
            }
            i15++;
            bVar2 = bVar;
        }
        Boolean bool = this.f9352s;
        this.f9352s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.f9352s == null && z10 && b10 != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v15, types: [short] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final void l(b bVar) {
        int i10;
        int i11;
        byte[] bArr;
        short s10;
        e eVar = this;
        if (bVar != null) {
            eVar.f9337d.position(bVar.f9314j);
        }
        if (bVar == null) {
            c cVar = eVar.f9345l;
            i10 = cVar.f9321f;
            i11 = cVar.f9322g;
        } else {
            i10 = bVar.f9307c;
            i11 = bVar.f9308d;
        }
        int i12 = i10 * i11;
        byte[] bArr2 = eVar.f9342i;
        if (bArr2 == null || bArr2.length < i12) {
            eVar.f9342i = eVar.f9336c.e(i12);
        }
        byte[] bArr3 = eVar.f9342i;
        if (eVar.f9339f == null) {
            eVar.f9339f = new short[4096];
        }
        short[] sArr = eVar.f9339f;
        if (eVar.f9340g == null) {
            eVar.f9340g = new byte[4096];
        }
        byte[] bArr4 = eVar.f9340g;
        if (eVar.f9341h == null) {
            eVar.f9341h = new byte[4097];
        }
        byte[] bArr5 = eVar.f9341h;
        int iP = eVar.p();
        int i13 = 1 << iP;
        int i14 = i13 + 1;
        int i15 = i13 + 2;
        int i16 = iP + 1;
        int i17 = (1 << i16) - 1;
        byte b10 = 0;
        for (int i18 = 0; i18 < i13; i18++) {
            sArr[i18] = 0;
            bArr4[i18] = (byte) i18;
        }
        byte[] bArr6 = eVar.f9338e;
        int i19 = i16;
        int i20 = i15;
        int i21 = i17;
        int i22 = 0;
        int iO = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = -1;
        while (true) {
            if (i22 >= i12) {
                break;
            }
            if (iO == 0) {
                iO = eVar.o();
                if (iO <= 0) {
                    eVar.f9348o = 3;
                    break;
                }
                i23 = b10;
            }
            i25 += (bArr6[i23] & 255) << i24;
            i23++;
            iO--;
            int i30 = i24 + 8;
            int i31 = i20;
            int i32 = i19;
            int i33 = i29;
            short[] sArr2 = sArr;
            int i34 = i27;
            while (true) {
                bArr = bArr4;
                if (i30 < i32) {
                    i20 = i31;
                    i27 = i34;
                    break;
                }
                int i35 = i25 & i21;
                i25 >>= i32;
                i30 -= i32;
                if (i35 == i13) {
                    i32 = i16;
                    i31 = i15;
                    i21 = i17;
                    bArr4 = bArr;
                    i33 = -1;
                } else {
                    if (i35 == i14) {
                        i27 = i34;
                        i20 = i31;
                        break;
                    }
                    byte[] bArr7 = bArr5;
                    if (i33 == -1) {
                        bArr3[i26] = bArr[i35];
                        i26++;
                        i22++;
                        i33 = i35;
                        i34 = i33;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                    } else {
                        if (i35 >= i31) {
                            bArr7[i28] = (byte) i34;
                            i28++;
                            s10 = i33;
                        } else {
                            s10 = i35;
                        }
                        while (s10 >= i13) {
                            bArr7[i28] = bArr[s10];
                            i28++;
                            s10 = sArr2[s10];
                        }
                        int i36 = bArr[s10] & 255;
                        byte b11 = (byte) i36;
                        bArr3[i26] = b11;
                        while (true) {
                            i26++;
                            i22++;
                            if (i28 <= 0) {
                                break;
                            }
                            i28--;
                            bArr3[i26] = bArr7[i28];
                        }
                        if (i31 < 4096) {
                            sArr2[i31] = (short) i33;
                            bArr[i31] = b11;
                            i31++;
                            if ((i31 & i21) == 0 && i31 < 4096) {
                                i32++;
                                i21 += i31;
                            }
                        }
                        i33 = i35;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                        i34 = i36;
                    }
                }
            }
            i24 = i30;
            sArr = sArr2;
            bArr4 = bArr;
            b10 = 0;
            i29 = i33;
            i19 = i32;
            eVar = this;
        }
        Arrays.fill(bArr3, i26, i12, b10);
    }

    public int m(int i10) {
        if (i10 < 0) {
            return -1;
        }
        c cVar = this.f9345l;
        if (i10 < cVar.f9318c) {
            return ((b) cVar.f9320e.get(i10)).f9313i;
        }
        return -1;
    }

    public final Bitmap n() {
        Boolean bool = this.f9352s;
        Bitmap bitmapA = this.f9336c.a(this.f9351r, this.f9350q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f9353t);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    public final int o() {
        int iP = p();
        if (iP <= 0) {
            return iP;
        }
        ByteBuffer byteBuffer = this.f9337d;
        byteBuffer.get(this.f9338e, 0, Math.min(iP, byteBuffer.remaining()));
        return iP;
    }

    public final int p() {
        return this.f9337d.get() & 255;
    }

    public synchronized void q(c cVar, ByteBuffer byteBuffer, int i10) {
        try {
            if (i10 <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
            }
            int iHighestOneBit = Integer.highestOneBit(i10);
            this.f9348o = 0;
            this.f9345l = cVar;
            this.f9344k = -1;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f9337d = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            this.f9337d.order(ByteOrder.LITTLE_ENDIAN);
            this.f9347n = false;
            Iterator it = cVar.f9320e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((b) it.next()).f9311g == 3) {
                    this.f9347n = true;
                    break;
                }
            }
            this.f9349p = iHighestOneBit;
            int i11 = cVar.f9321f;
            this.f9351r = i11 / iHighestOneBit;
            int i12 = cVar.f9322g;
            this.f9350q = i12 / iHighestOneBit;
            this.f9342i = this.f9336c.e(i11 * i12);
            this.f9343j = this.f9336c.b(this.f9351r * this.f9350q);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Bitmap r(b bVar, b bVar2) {
        int i10;
        int i11;
        Bitmap bitmap;
        int[] iArr = this.f9343j;
        int i12 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.f9346m;
            if (bitmap2 != null) {
                this.f9336c.c(bitmap2);
            }
            this.f9346m = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f9311g == 3 && this.f9346m == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i11 = bVar2.f9311g) > 0) {
            if (i11 == 2) {
                if (!bVar.f9310f) {
                    c cVar = this.f9345l;
                    int i13 = cVar.f9327l;
                    if (bVar.f9315k == null || cVar.f9325j != bVar.f9312h) {
                        i12 = i13;
                    }
                }
                int i14 = bVar2.f9308d;
                int i15 = this.f9349p;
                int i16 = i14 / i15;
                int i17 = bVar2.f9306b / i15;
                int i18 = bVar2.f9307c / i15;
                int i19 = bVar2.f9305a / i15;
                int i20 = this.f9351r;
                int i21 = (i17 * i20) + i19;
                int i22 = (i16 * i20) + i21;
                while (i21 < i22) {
                    int i23 = i21 + i18;
                    for (int i24 = i21; i24 < i23; i24++) {
                        iArr[i24] = i12;
                    }
                    i21 += this.f9351r;
                }
            } else if (i11 == 3 && (bitmap = this.f9346m) != null) {
                int i25 = this.f9351r;
                bitmap.getPixels(iArr, 0, i25, 0, 0, i25, this.f9350q);
            }
        }
        l(bVar);
        if (bVar.f9309e || this.f9349p != 1) {
            j(bVar);
        } else {
            k(bVar);
        }
        if (this.f9347n && ((i10 = bVar.f9311g) == 0 || i10 == 1)) {
            if (this.f9346m == null) {
                this.f9346m = n();
            }
            Bitmap bitmap3 = this.f9346m;
            int i26 = this.f9351r;
            bitmap3.setPixels(iArr, 0, i26, 0, 0, i26, this.f9350q);
        }
        Bitmap bitmapN = n();
        int i27 = this.f9351r;
        bitmapN.setPixels(iArr, 0, i27, 0, 0, i27, this.f9350q);
        return bitmapN;
    }

    public e(a.InterfaceC0172a interfaceC0172a) {
        this.f9335b = new int[256];
        this.f9353t = Bitmap.Config.ARGB_8888;
        this.f9336c = interfaceC0172a;
        this.f9345l = new c();
    }
}
