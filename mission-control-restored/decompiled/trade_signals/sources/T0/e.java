package T0;

import T0.a;
import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f7914u = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f7915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f7916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.InterfaceC0112a f7917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ByteBuffer f7918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f7919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public short[] f7920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f7921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f7922h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f7923i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f7924j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7925k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f7926l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap f7927m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7928n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7929o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f7930p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7931q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f7932r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Boolean f7933s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Bitmap.Config f7934t;

    public e(a.InterfaceC0112a interfaceC0112a) {
        this.f7916b = new int[256];
        this.f7934t = Bitmap.Config.ARGB_8888;
        this.f7917c = interfaceC0112a;
        this.f7926l = new c();
    }

    @Override // T0.a
    public synchronized Bitmap a() {
        try {
            if (this.f7926l.f7899c <= 0 || this.f7925k < 0) {
                String str = f7914u;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Unable to decode frame, frameCount=" + this.f7926l.f7899c + ", framePointer=" + this.f7925k);
                }
                this.f7929o = 1;
            }
            int i8 = this.f7929o;
            if (i8 != 1 && i8 != 2) {
                this.f7929o = 0;
                if (this.f7919e == null) {
                    this.f7919e = this.f7917c.e(255);
                }
                b bVar = (b) this.f7926l.f7901e.get(this.f7925k);
                int i9 = this.f7925k - 1;
                b bVar2 = i9 >= 0 ? (b) this.f7926l.f7901e.get(i9) : null;
                int[] iArr = bVar.f7896k;
                if (iArr == null) {
                    iArr = this.f7926l.f7897a;
                }
                this.f7915a = iArr;
                if (iArr == null) {
                    String str2 = f7914u;
                    if (Log.isLoggable(str2, 3)) {
                        Log.d(str2, "No valid color table found for frame #" + this.f7925k);
                    }
                    this.f7929o = 1;
                    return null;
                }
                if (bVar.f7891f) {
                    System.arraycopy(iArr, 0, this.f7916b, 0, iArr.length);
                    int[] iArr2 = this.f7916b;
                    this.f7915a = iArr2;
                    iArr2[bVar.f7893h] = 0;
                    if (bVar.f7892g == 2 && this.f7925k == 0) {
                        this.f7933s = Boolean.TRUE;
                    }
                }
                return r(bVar, bVar2);
            }
            String str3 = f7914u;
            if (Log.isLoggable(str3, 3)) {
                Log.d(str3, "Unable to decode frame, status=" + this.f7929o);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // T0.a
    public void b() {
        this.f7925k = (this.f7925k + 1) % this.f7926l.f7899c;
    }

    @Override // T0.a
    public int c() {
        return this.f7926l.f7899c;
    }

    @Override // T0.a
    public void clear() {
        this.f7926l = null;
        byte[] bArr = this.f7923i;
        if (bArr != null) {
            this.f7917c.d(bArr);
        }
        int[] iArr = this.f7924j;
        if (iArr != null) {
            this.f7917c.f(iArr);
        }
        Bitmap bitmap = this.f7927m;
        if (bitmap != null) {
            this.f7917c.c(bitmap);
        }
        this.f7927m = null;
        this.f7918d = null;
        this.f7933s = null;
        byte[] bArr2 = this.f7919e;
        if (bArr2 != null) {
            this.f7917c.d(bArr2);
        }
    }

    @Override // T0.a
    public int d() {
        int i8;
        if (this.f7926l.f7899c <= 0 || (i8 = this.f7925k) < 0) {
            return 0;
        }
        return m(i8);
    }

    @Override // T0.a
    public void e(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.f7934t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    @Override // T0.a
    public void f() {
        this.f7925k = -1;
    }

    @Override // T0.a
    public int g() {
        return this.f7925k;
    }

    @Override // T0.a
    public ByteBuffer getData() {
        return this.f7918d;
    }

    @Override // T0.a
    public int h() {
        return this.f7918d.limit() + this.f7923i.length + (this.f7924j.length * 4);
    }

    public final int i(int i8, int i9, int i10) {
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = i8; i16 < this.f7930p + i8; i16++) {
            byte[] bArr = this.f7923i;
            if (i16 >= bArr.length || i16 >= i9) {
                break;
            }
            int i17 = this.f7915a[bArr[i16] & 255];
            if (i17 != 0) {
                i11 += (i17 >> 24) & 255;
                i12 += (i17 >> 16) & 255;
                i13 += (i17 >> 8) & 255;
                i14 += i17 & 255;
                i15++;
            }
        }
        int i18 = i8 + i10;
        for (int i19 = i18; i19 < this.f7930p + i18; i19++) {
            byte[] bArr2 = this.f7923i;
            if (i19 >= bArr2.length || i19 >= i9) {
                break;
            }
            int i20 = this.f7915a[bArr2[i19] & 255];
            if (i20 != 0) {
                i11 += (i20 >> 24) & 255;
                i12 += (i20 >> 16) & 255;
                i13 += (i20 >> 8) & 255;
                i14 += i20 & 255;
                i15++;
            }
        }
        if (i15 == 0) {
            return 0;
        }
        return ((i11 / i15) << 24) | ((i12 / i15) << 16) | ((i13 / i15) << 8) | (i14 / i15);
    }

    public final void j(b bVar) {
        Boolean bool;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int[] iArr = this.f7924j;
        int i13 = bVar.f7889d;
        int i14 = this.f7930p;
        int i15 = i13 / i14;
        int i16 = bVar.f7887b / i14;
        int i17 = bVar.f7888c / i14;
        int i18 = bVar.f7886a / i14;
        boolean z7 = this.f7925k == 0;
        int i19 = this.f7932r;
        int i20 = this.f7931q;
        byte[] bArr = this.f7923i;
        int[] iArr2 = this.f7915a;
        Boolean bool2 = this.f7933s;
        int i21 = 8;
        int i22 = 0;
        int i23 = 0;
        int i24 = 1;
        while (true) {
            bool = bool2;
            if (i23 >= i15) {
                break;
            }
            if (bVar.f7890e) {
                if (i22 >= i15) {
                    int i25 = i24 + 1;
                    i8 = i15;
                    if (i25 == 2) {
                        i22 = 4;
                        i24 = i25;
                    } else if (i25 != 3) {
                        i24 = i25;
                        if (i25 == 4) {
                            i22 = 1;
                            i21 = 2;
                        }
                    } else {
                        i21 = 4;
                        i24 = i25;
                        i22 = 2;
                    }
                } else {
                    i8 = i15;
                }
                i9 = i22 + i21;
            } else {
                i8 = i15;
                i9 = i22;
                i22 = i23;
            }
            int i26 = i22 + i16;
            boolean z8 = i14 == 1;
            if (i26 < i20) {
                int i27 = i26 * i19;
                int i28 = i27 + i18;
                int i29 = i28 + i17;
                int i30 = i27 + i19;
                if (i30 < i29) {
                    i29 = i30;
                }
                i10 = i9;
                int i31 = i23 * i14 * bVar.f7888c;
                if (z8) {
                    int i32 = i28;
                    while (true) {
                        i11 = i16;
                        if (i32 >= i29) {
                            break;
                        }
                        int i33 = iArr2[bArr[i31] & 255];
                        if (i33 != 0) {
                            iArr[i32] = i33;
                        } else if (z7 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i31 += i14;
                        i32++;
                        i16 = i11;
                    }
                } else {
                    i11 = i16;
                    int i34 = ((i29 - i28) * i14) + i31;
                    int i35 = i28;
                    while (true) {
                        i12 = i17;
                        if (i35 >= i29) {
                            break;
                        }
                        int i36 = i(i31, i34, bVar.f7888c);
                        if (i36 != 0) {
                            iArr[i35] = i36;
                        } else if (z7 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i31 += i14;
                        i35++;
                        i17 = i12;
                    }
                    bool2 = bool;
                    i23++;
                    i16 = i11;
                    i15 = i8;
                    i17 = i12;
                    i22 = i10;
                }
            } else {
                i10 = i9;
                i11 = i16;
            }
            i12 = i17;
            bool2 = bool;
            i23++;
            i16 = i11;
            i15 = i8;
            i17 = i12;
            i22 = i10;
        }
        if (this.f7933s == null) {
            this.f7933s = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    public final void k(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.f7924j;
        int i8 = bVar2.f7889d;
        int i9 = bVar2.f7887b;
        int i10 = bVar2.f7888c;
        int i11 = bVar2.f7886a;
        boolean z7 = this.f7925k == 0;
        int i12 = this.f7932r;
        byte[] bArr = this.f7923i;
        int[] iArr2 = this.f7915a;
        int i13 = 0;
        byte b8 = -1;
        while (i13 < i8) {
            int i14 = (i13 + i9) * i12;
            int i15 = i14 + i11;
            int i16 = i15 + i10;
            int i17 = i14 + i12;
            if (i17 < i16) {
                i16 = i17;
            }
            int i18 = bVar2.f7888c * i13;
            int i19 = i15;
            while (i19 < i16) {
                byte b9 = bArr[i18];
                int i20 = i8;
                int i21 = b9 & 255;
                if (i21 != b8) {
                    int i22 = iArr2[i21];
                    if (i22 != 0) {
                        iArr[i19] = i22;
                    } else {
                        b8 = b9;
                    }
                }
                i18++;
                i19++;
                i8 = i20;
            }
            i13++;
            bVar2 = bVar;
        }
        Boolean bool = this.f7933s;
        this.f7933s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.f7933s == null && z7 && b8 != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    public final void l(b bVar) {
        int i8;
        int i9;
        short s8;
        e eVar = this;
        if (bVar != null) {
            eVar.f7918d.position(bVar.f7895j);
        }
        if (bVar == null) {
            c cVar = eVar.f7926l;
            i8 = cVar.f7902f;
            i9 = cVar.f7903g;
        } else {
            i8 = bVar.f7888c;
            i9 = bVar.f7889d;
        }
        int i10 = i8 * i9;
        byte[] bArr = eVar.f7923i;
        if (bArr == null || bArr.length < i10) {
            eVar.f7923i = eVar.f7917c.e(i10);
        }
        byte[] bArr2 = eVar.f7923i;
        if (eVar.f7920f == null) {
            eVar.f7920f = new short[4096];
        }
        short[] sArr = eVar.f7920f;
        if (eVar.f7921g == null) {
            eVar.f7921g = new byte[4096];
        }
        byte[] bArr3 = eVar.f7921g;
        if (eVar.f7922h == null) {
            eVar.f7922h = new byte[4097];
        }
        byte[] bArr4 = eVar.f7922h;
        int iP = p();
        int i11 = 1 << iP;
        int i12 = i11 + 1;
        int i13 = i11 + 2;
        int i14 = iP + 1;
        int i15 = (1 << i14) - 1;
        int i16 = 0;
        for (int i17 = 0; i17 < i11; i17++) {
            sArr[i17] = 0;
            bArr3[i17] = (byte) i17;
        }
        byte[] bArr5 = eVar.f7919e;
        int i18 = i14;
        int i19 = i13;
        int i20 = i15;
        int iO = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = -1;
        while (true) {
            if (i16 >= i10) {
                break;
            }
            if (iO == 0) {
                iO = o();
                if (iO <= 0) {
                    eVar.f7929o = 3;
                    break;
                }
                i21 = 0;
            }
            i23 += (bArr5[i21] & 255) << i22;
            i21++;
            iO--;
            int i28 = i22 + 8;
            int i29 = i19;
            int i30 = i18;
            int i31 = i27;
            int i32 = i14;
            int i33 = i25;
            while (true) {
                if (i28 < i30) {
                    i27 = i31;
                    i19 = i29;
                    i22 = i28;
                    eVar = this;
                    i25 = i33;
                    i14 = i32;
                    i18 = i30;
                    break;
                }
                int i34 = i13;
                int i35 = i23 & i20;
                i23 >>= i30;
                i28 -= i30;
                if (i35 == i11) {
                    i20 = i15;
                    i30 = i32;
                    i29 = i34;
                    i13 = i29;
                    i31 = -1;
                } else {
                    if (i35 == i12) {
                        i22 = i28;
                        i25 = i33;
                        i19 = i29;
                        i14 = i32;
                        i13 = i34;
                        i27 = i31;
                        i18 = i30;
                        eVar = this;
                        break;
                    }
                    if (i31 == -1) {
                        bArr2[i24] = bArr3[i35];
                        i24++;
                        i16++;
                        i31 = i35;
                        i33 = i31;
                        i13 = i34;
                        i28 = i28;
                    } else {
                        if (i35 >= i29) {
                            bArr4[i26] = (byte) i33;
                            i26++;
                            s8 = i31;
                        } else {
                            s8 = i35;
                        }
                        while (s8 >= i11) {
                            bArr4[i26] = bArr3[s8];
                            i26++;
                            s8 = sArr[s8];
                        }
                        i33 = bArr3[s8] & 255;
                        byte b8 = (byte) i33;
                        bArr2[i24] = b8;
                        while (true) {
                            i24++;
                            i16++;
                            if (i26 <= 0) {
                                break;
                            }
                            i26--;
                            bArr2[i24] = bArr4[i26];
                        }
                        byte[] bArr6 = bArr4;
                        if (i29 < 4096) {
                            sArr[i29] = (short) i31;
                            bArr3[i29] = b8;
                            i29++;
                            if ((i29 & i20) == 0 && i29 < 4096) {
                                i30++;
                                i20 += i29;
                            }
                        }
                        i31 = i35;
                        i13 = i34;
                        i28 = i28;
                        bArr4 = bArr6;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i24, i10, (byte) 0);
    }

    public int m(int i8) {
        if (i8 >= 0) {
            c cVar = this.f7926l;
            if (i8 < cVar.f7899c) {
                return ((b) cVar.f7901e.get(i8)).f7894i;
            }
        }
        return -1;
    }

    public final Bitmap n() {
        Boolean bool = this.f7933s;
        Bitmap bitmapA = this.f7917c.a(this.f7932r, this.f7931q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f7934t);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    public final int o() {
        int iP = p();
        if (iP <= 0) {
            return iP;
        }
        ByteBuffer byteBuffer = this.f7918d;
        byteBuffer.get(this.f7919e, 0, Math.min(iP, byteBuffer.remaining()));
        return iP;
    }

    public final int p() {
        return this.f7918d.get() & 255;
    }

    public synchronized void q(c cVar, ByteBuffer byteBuffer, int i8) {
        try {
            if (i8 <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i8);
            }
            int iHighestOneBit = Integer.highestOneBit(i8);
            this.f7929o = 0;
            this.f7926l = cVar;
            this.f7925k = -1;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f7918d = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            this.f7918d.order(ByteOrder.LITTLE_ENDIAN);
            this.f7928n = false;
            Iterator it = cVar.f7901e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((b) it.next()).f7892g == 3) {
                    this.f7928n = true;
                    break;
                }
            }
            this.f7930p = iHighestOneBit;
            int i9 = cVar.f7902f;
            this.f7932r = i9 / iHighestOneBit;
            int i10 = cVar.f7903g;
            this.f7931q = i10 / iHighestOneBit;
            this.f7923i = this.f7917c.e(i9 * i10);
            this.f7924j = this.f7917c.b(this.f7932r * this.f7931q);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Bitmap r(b bVar, b bVar2) {
        int i8;
        int i9;
        Bitmap bitmap;
        int[] iArr = this.f7924j;
        int i10 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.f7927m;
            if (bitmap2 != null) {
                this.f7917c.c(bitmap2);
            }
            this.f7927m = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f7892g == 3 && this.f7927m == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i9 = bVar2.f7892g) > 0) {
            if (i9 == 2) {
                if (!bVar.f7891f) {
                    c cVar = this.f7926l;
                    int i11 = cVar.f7908l;
                    if (bVar.f7896k == null || cVar.f7906j != bVar.f7893h) {
                        i10 = i11;
                    }
                }
                int i12 = bVar2.f7889d;
                int i13 = this.f7930p;
                int i14 = i12 / i13;
                int i15 = bVar2.f7887b / i13;
                int i16 = bVar2.f7888c / i13;
                int i17 = bVar2.f7886a / i13;
                int i18 = this.f7932r;
                int i19 = (i15 * i18) + i17;
                int i20 = (i14 * i18) + i19;
                while (i19 < i20) {
                    int i21 = i19 + i16;
                    for (int i22 = i19; i22 < i21; i22++) {
                        iArr[i22] = i10;
                    }
                    i19 += this.f7932r;
                }
            } else if (i9 == 3 && (bitmap = this.f7927m) != null) {
                int i23 = this.f7932r;
                bitmap.getPixels(iArr, 0, i23, 0, 0, i23, this.f7931q);
            }
        }
        l(bVar);
        if (bVar.f7890e || this.f7930p != 1) {
            j(bVar);
        } else {
            k(bVar);
        }
        if (this.f7928n && ((i8 = bVar.f7892g) == 0 || i8 == 1)) {
            if (this.f7927m == null) {
                this.f7927m = n();
            }
            Bitmap bitmap3 = this.f7927m;
            int i24 = this.f7932r;
            bitmap3.setPixels(iArr, 0, i24, 0, 0, i24, this.f7931q);
        }
        Bitmap bitmapN = n();
        int i25 = this.f7932r;
        bitmapN.setPixels(iArr, 0, i25, 0, 0, i25, this.f7931q);
        return bitmapN;
    }

    public e(a.InterfaceC0112a interfaceC0112a, c cVar, ByteBuffer byteBuffer, int i8) {
        this(interfaceC0112a);
        q(cVar, byteBuffer, i8);
    }
}
