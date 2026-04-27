package V1;

import N1.C0094g0;
import a.AbstractC0284a;
import java.util.Arrays;
import s3.D;
import t2.u0;
import u4.C1221c;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3191a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f3194d;

    public b(C1221c c1221c, int i, boolean z6) {
        D.j(c1221c, "callOptions");
        this.f3194d = c1221c;
        this.f3192b = i;
        this.f3193c = z6;
    }

    public static int c(int i, int i6) {
        if (i6 < 0) {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
        int iHighestOneBit = i + (i >> 1) + 1;
        if (iHighestOneBit < i6) {
            iHighestOneBit = Integer.highestOneBit(i6 - 1) << 1;
        }
        return iHighestOneBit < 0 ? com.google.android.gms.common.api.f.API_PRIORITY_OTHER : iHighestOneBit;
    }

    public void a(Object obj) {
        obj.getClass();
        d(this.f3192b + 1);
        Object[] objArr = (Object[]) this.f3194d;
        int i = this.f3192b;
        this.f3192b = i + 1;
        objArr[i] = obj;
    }

    public void b(Object... objArr) {
        int length = objArr.length;
        D1.b.d(length, objArr);
        d(this.f3192b + length);
        System.arraycopy(objArr, 0, (Object[]) this.f3194d, this.f3192b, length);
        this.f3192b += length;
    }

    public void d(int i) {
        Object[] objArr = (Object[]) this.f3194d;
        if (objArr.length < i) {
            this.f3194d = Arrays.copyOf(objArr, c(objArr.length, i));
            this.f3193c = false;
        } else if (this.f3193c) {
            this.f3194d = (Object[]) objArr.clone();
            this.f3193c = false;
        }
    }

    public String toString() {
        switch (this.f3191a) {
            case 1:
                C0094g0 c0094g0J = AbstractC0284a.J(this);
                c0094g0J.a((C1221c) this.f3194d, "callOptions");
                c0094g0J.d("previousAttempts", String.valueOf(this.f3192b));
                c0094g0J.c("isTransparentRetry", this.f3193c);
                return c0094g0J.toString();
            default:
                return super.toString();
        }
    }

    public b() {
        u0.g(4, "initialCapacity");
        this.f3194d = new Object[4];
        this.f3192b = 0;
    }
}
