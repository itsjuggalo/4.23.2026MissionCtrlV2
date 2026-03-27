package T;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f7779a = new float[20];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f7780b = new long[20];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f7781c = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7782d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7783e = 0;

    public static float f(float f8) {
        return (f8 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f8) * 2.0f));
    }

    public void a(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f7782d != 0 && eventTime - this.f7780b[this.f7783e] > 40) {
            b();
        }
        int i8 = (this.f7783e + 1) % 20;
        this.f7783e = i8;
        int i9 = this.f7782d;
        if (i9 != 20) {
            this.f7782d = i9 + 1;
        }
        this.f7779a[i8] = motionEvent.getAxisValue(26);
        this.f7780b[this.f7783e] = eventTime;
    }

    public final void b() {
        this.f7782d = 0;
        this.f7781c = 0.0f;
    }

    public void c(int i8, float f8) {
        float fAbs;
        float fE = e() * i8;
        this.f7781c = fE;
        if (fE < (-Math.abs(f8))) {
            fAbs = -Math.abs(f8);
        } else if (this.f7781c <= Math.abs(f8)) {
            return;
        } else {
            fAbs = Math.abs(f8);
        }
        this.f7781c = fAbs;
    }

    public float d(int i8) {
        if (i8 != 26) {
            return 0.0f;
        }
        return this.f7781c;
    }

    public final float e() {
        long[] jArr;
        long j8;
        int i8 = this.f7782d;
        if (i8 < 2) {
            return 0.0f;
        }
        int i9 = this.f7783e;
        int i10 = ((i9 + 20) - (i8 - 1)) % 20;
        long j9 = this.f7780b[i9];
        while (true) {
            jArr = this.f7780b;
            j8 = jArr[i10];
            if (j9 - j8 <= 100) {
                break;
            }
            this.f7782d--;
            i10 = (i10 + 1) % 20;
        }
        int i11 = this.f7782d;
        if (i11 < 2) {
            return 0.0f;
        }
        if (i11 == 2) {
            int i12 = (i10 + 1) % 20;
            if (j8 == jArr[i12]) {
                return 0.0f;
            }
            return this.f7779a[i12] / (r2 - j8);
        }
        float fAbs = 0.0f;
        int i13 = 0;
        for (int i14 = 0; i14 < this.f7782d - 1; i14++) {
            int i15 = i14 + i10;
            long[] jArr2 = this.f7780b;
            long j10 = jArr2[i15 % 20];
            int i16 = (i15 + 1) % 20;
            if (jArr2[i16] != j10) {
                i13++;
                float f8 = f(fAbs);
                float f9 = this.f7779a[i16] / (this.f7780b[i16] - j10);
                fAbs += (f9 - f8) * Math.abs(f9);
                if (i13 == 1) {
                    fAbs *= 0.5f;
                }
            }
        }
        return f(fAbs);
    }
}
