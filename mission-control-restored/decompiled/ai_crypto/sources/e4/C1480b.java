package e4;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: e4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1480b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Runtime f13616f = Runtime.getRuntime();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f13617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f13618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13619c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13621e = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13620d = false;

    public C1480b(InputStream inputStream, int i7) {
        this.f13617a = inputStream;
        this.f13618b = new byte[i7];
    }

    public int a(int i7) {
        int i8 = this.f13619c;
        int i9 = 0;
        if (i7 <= i8) {
            int i10 = i8 - i7;
            this.f13619c = i10;
            byte[] bArr = this.f13618b;
            System.arraycopy(bArr, i7, bArr, 0, i10);
            return i7;
        }
        this.f13619c = 0;
        while (i9 < i7) {
            int iSkip = (int) this.f13617a.skip(i7 - i9);
            if (iSkip > 0) {
                i9 += iSkip;
            } else if (iSkip != 0) {
                continue;
            } else {
                if (this.f13617a.read() == -1) {
                    break;
                }
                i9++;
            }
        }
        return i9;
    }

    public int b() {
        return this.f13619c;
    }

    public void c() throws IOException {
        this.f13617a.close();
    }

    public int d(int i7) throws IOException {
        if (i7 > this.f13618b.length) {
            i7 = Math.min(i7, g(i7));
        }
        while (true) {
            int i8 = this.f13619c;
            if (i8 >= i7) {
                break;
            }
            int i9 = this.f13617a.read(this.f13618b, i8, i7 - i8);
            if (i9 == -1) {
                this.f13620d = true;
                break;
            }
            this.f13619c += i9;
        }
        return this.f13619c;
    }

    public byte[] e() {
        return this.f13618b;
    }

    public boolean f() {
        return this.f13620d;
    }

    public final int g(int i7) {
        int iMax = Math.max(this.f13618b.length * 2, i7);
        Runtime runtime = f13616f;
        long jMaxMemory = runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
        if (!this.f13621e || iMax >= jMaxMemory) {
            Log.w("AdaptiveStreamBuffer", "Turning off adaptive buffer resizing to conserve memory.");
        } else {
            try {
                byte[] bArr = new byte[iMax];
                System.arraycopy(this.f13618b, 0, bArr, 0, this.f13619c);
                this.f13618b = bArr;
            } catch (OutOfMemoryError unused) {
                Log.w("AdaptiveStreamBuffer", "Turning off adaptive buffer resizing due to low memory.");
                this.f13621e = false;
            }
        }
        return this.f13618b.length;
    }
}
