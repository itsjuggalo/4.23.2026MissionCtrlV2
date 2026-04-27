package m3;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Runtime f8469f = Runtime.getRuntime();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f8470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f8471b = new byte[262144];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8472c = 0;
    public boolean e = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8473d = false;

    public d(InputStream inputStream) {
        this.f8470a = inputStream;
    }

    public final int a(int i) {
        int i6 = this.f8472c;
        int i7 = 0;
        if (i <= i6) {
            int i8 = i6 - i;
            this.f8472c = i8;
            byte[] bArr = this.f8471b;
            System.arraycopy(bArr, i, bArr, 0, i8);
            return i;
        }
        this.f8472c = 0;
        while (i7 < i) {
            InputStream inputStream = this.f8470a;
            int iSkip = (int) inputStream.skip(i - i7);
            if (iSkip > 0) {
                i7 += iSkip;
            } else if (iSkip != 0) {
                continue;
            } else {
                if (inputStream.read() == -1) {
                    break;
                }
                i7++;
            }
        }
        return i7;
    }

    public final void b(int i) throws IOException {
        byte[] bArr = this.f8471b;
        if (i > bArr.length) {
            int iMax = Math.max(bArr.length * 2, i);
            Runtime runtime = f8469f;
            long jMaxMemory = runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
            if (!this.e || iMax >= jMaxMemory) {
                Log.w("AdaptiveStreamBuffer", "Turning off adaptive buffer resizing to conserve memory.");
            } else {
                try {
                    byte[] bArr2 = new byte[iMax];
                    System.arraycopy(this.f8471b, 0, bArr2, 0, this.f8472c);
                    this.f8471b = bArr2;
                } catch (OutOfMemoryError unused) {
                    Log.w("AdaptiveStreamBuffer", "Turning off adaptive buffer resizing due to low memory.");
                    this.e = false;
                }
            }
            i = Math.min(i, this.f8471b.length);
        }
        while (true) {
            int i6 = this.f8472c;
            if (i6 >= i) {
                return;
            }
            int i7 = this.f8470a.read(this.f8471b, i6, i - i6);
            if (i7 == -1) {
                this.f8473d = true;
                return;
            }
            this.f8472c += i7;
        }
    }
}
