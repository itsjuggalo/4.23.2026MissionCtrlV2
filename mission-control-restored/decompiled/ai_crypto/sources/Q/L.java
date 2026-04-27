package Q;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f4377a = new float[20];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f4378b = new long[20];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f4379c = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4380d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4381e = 0;

    public static float f(float f7) {
        return (f7 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f7) * 2.0f));
    }

    public void a(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f4380d != 0 && eventTime - this.f4378b[this.f4381e] > 40) {
            b();
        }
        int i7 = (this.f4381e + 1) % 20;
        this.f4381e = i7;
        int i8 = this.f4380d;
        if (i8 != 20) {
            this.f4380d = i8 + 1;
        }
        this.f4377a[i7] = motionEvent.getAxisValue(26);
        this.f4378b[this.f4381e] = eventTime;
    }

    public final void b() {
        this.f4380d = 0;
        this.f4379c = 0.0f;
    }

    public void c(int i7, float f7) {
        float fE = e() * i7;
        this.f4379c = fE;
        if (fE < (-Math.abs(f7))) {
            this.f4379c = -Math.abs(f7);
        } else if (this.f4379c > Math.abs(f7)) {
            this.f4379c = Math.abs(f7);
        }
    }

    public float d(int i7) {
        if (i7 != 26) {
            return 0.0f;
        }
        return this.f4379c;
    }

    public final float e() {
        long[] jArr;
        long j7;
        int i7 = this.f4380d;
        if (i7 < 2) {
            return 0.0f;
        }
        int i8 = this.f4381e;
        int i9 = ((i8 + 20) - (i7 - 1)) % 20;
        long j8 = this.f4378b[i8];
        while (true) {
            jArr = this.f4378b;
            j7 = jArr[i9];
            if (j8 - j7 <= 100) {
                break;
            }
            this.f4380d--;
            i9 = (i9 + 1) % 20;
        }
        int i10 = this.f4380d;
        if (i10 < 2) {
            return 0.0f;
        }
        if (i10 == 2) {
            int i11 = (i9 + 1) % 20;
            if (j7 == jArr[i11]) {
                return 0.0f;
            }
            return this.f4377a[i11] / (r2 - j7);
        }
        float fAbs = 0.0f;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f4380d - 1; i13++) {
            int i14 = i13 + i9;
            long[] jArr2 = this.f4378b;
            long j9 = jArr2[i14 % 20];
            int i15 = (i14 + 1) % 20;
            if (jArr2[i15] != j9) {
                i12++;
                float f7 = f(fAbs);
                float f8 = this.f4377a[i15] / (this.f4378b[i15] - j9);
                fAbs += (f8 - f7) * Math.abs(f8);
                if (i12 == 1) {
                    fAbs *= 0.5f;
                }
            }
        }
        return f(fAbs);
    }
}
