package H;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f488a = new float[20];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f489b = new long[20];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f490c = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f491d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f492e = 0;

    public static float f(float f4) {
        return (f4 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f4) * 2.0f));
    }

    public void a(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f491d != 0 && eventTime - this.f489b[this.f492e] > 40) {
            b();
        }
        int i4 = (this.f492e + 1) % 20;
        this.f492e = i4;
        int i5 = this.f491d;
        if (i5 != 20) {
            this.f491d = i5 + 1;
        }
        this.f488a[i4] = motionEvent.getAxisValue(26);
        this.f489b[this.f492e] = eventTime;
    }

    public final void b() {
        this.f491d = 0;
        this.f490c = 0.0f;
    }

    public void c(int i4, float f4) {
        float fE = e() * i4;
        this.f490c = fE;
        if (fE < (-Math.abs(f4))) {
            this.f490c = -Math.abs(f4);
        } else if (this.f490c > Math.abs(f4)) {
            this.f490c = Math.abs(f4);
        }
    }

    public float d(int i4) {
        if (i4 != 26) {
            return 0.0f;
        }
        return this.f490c;
    }

    public final float e() {
        long[] jArr;
        long j4;
        int i4 = this.f491d;
        if (i4 < 2) {
            return 0.0f;
        }
        int i5 = this.f492e;
        int i6 = ((i5 + 20) - (i4 - 1)) % 20;
        long j5 = this.f489b[i5];
        while (true) {
            jArr = this.f489b;
            j4 = jArr[i6];
            if (j5 - j4 <= 100) {
                break;
            }
            this.f491d--;
            i6 = (i6 + 1) % 20;
        }
        int i7 = this.f491d;
        if (i7 < 2) {
            return 0.0f;
        }
        if (i7 == 2) {
            int i8 = (i6 + 1) % 20;
            if (j4 == jArr[i8]) {
                return 0.0f;
            }
            return this.f488a[i8] / (r2 - j4);
        }
        float fAbs = 0.0f;
        int i9 = 0;
        for (int i10 = 0; i10 < this.f491d - 1; i10++) {
            int i11 = i10 + i6;
            long[] jArr2 = this.f489b;
            long j6 = jArr2[i11 % 20];
            int i12 = (i11 + 1) % 20;
            if (jArr2[i12] != j6) {
                i9++;
                float f4 = f(fAbs);
                float f5 = this.f488a[i12] / (this.f489b[i12] - j6);
                fAbs += (f5 - f4) * Math.abs(f5);
                if (i9 == 1) {
                    fAbs *= 0.5f;
                }
            }
        }
        return f(fAbs);
    }
}
