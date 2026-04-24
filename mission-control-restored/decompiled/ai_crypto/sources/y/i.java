package y;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f25418o = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25420b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f25424f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f25428j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25421c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25422d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25423e = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25425g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f25426h = new float[9];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f25427i = new float[9];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C2830b[] f25429k = new C2830b[16];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f25430l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f25431m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public HashSet f25432n = null;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f25428j = aVar;
    }

    public static void b() {
        f25418o++;
    }

    public final void a(C2830b c2830b) {
        int i7 = 0;
        while (true) {
            int i8 = this.f25430l;
            if (i7 >= i8) {
                C2830b[] c2830bArr = this.f25429k;
                if (i8 >= c2830bArr.length) {
                    this.f25429k = (C2830b[]) Arrays.copyOf(c2830bArr, c2830bArr.length * 2);
                }
                C2830b[] c2830bArr2 = this.f25429k;
                int i9 = this.f25430l;
                c2830bArr2[i9] = c2830b;
                this.f25430l = i9 + 1;
                return;
            }
            if (this.f25429k[i7] == c2830b) {
                return;
            } else {
                i7++;
            }
        }
    }

    public final void c(C2830b c2830b) {
        int i7 = this.f25430l;
        int i8 = 0;
        while (i8 < i7) {
            if (this.f25429k[i8] == c2830b) {
                while (i8 < i7 - 1) {
                    C2830b[] c2830bArr = this.f25429k;
                    int i9 = i8 + 1;
                    c2830bArr[i8] = c2830bArr[i9];
                    i8 = i9;
                }
                this.f25430l--;
                return;
            }
            i8++;
        }
    }

    public void d() {
        this.f25420b = null;
        this.f25428j = a.UNKNOWN;
        this.f25423e = 0;
        this.f25421c = -1;
        this.f25422d = -1;
        this.f25424f = 0.0f;
        this.f25425g = false;
        int i7 = this.f25430l;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f25429k[i8] = null;
        }
        this.f25430l = 0;
        this.f25431m = 0;
        this.f25419a = false;
        Arrays.fill(this.f25427i, 0.0f);
    }

    public void e(d dVar, float f7) {
        this.f25424f = f7;
        this.f25425g = true;
        int i7 = this.f25430l;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f25429k[i8].B(dVar, this, false);
        }
        this.f25430l = 0;
    }

    public void f(a aVar, String str) {
        this.f25428j = aVar;
    }

    public final void g(C2830b c2830b) {
        int i7 = this.f25430l;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f25429k[i8].C(c2830b, false);
        }
        this.f25430l = 0;
    }

    public String toString() {
        if (this.f25420b != null) {
            return "" + this.f25420b;
        }
        return "" + this.f25421c;
    }
}
