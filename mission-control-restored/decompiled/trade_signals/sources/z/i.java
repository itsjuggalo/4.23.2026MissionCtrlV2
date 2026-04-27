package z;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class i implements Comparable {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f24581r = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f24582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f24583b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f24587f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f24591j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24584c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24585d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f24586e = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f24588g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f24589h = new float[9];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f24590i = new float[9];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b[] f24592k = new b[16];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f24593l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f24594m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f24595n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f24596o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f24597p = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HashSet f24598q = null;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f24591j = aVar;
    }

    public static void g() {
        f24581r++;
    }

    public final void a(b bVar) {
        int i8 = 0;
        while (true) {
            int i9 = this.f24593l;
            if (i8 >= i9) {
                b[] bVarArr = this.f24592k;
                if (i9 >= bVarArr.length) {
                    this.f24592k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f24592k;
                int i10 = this.f24593l;
                bVarArr2[i10] = bVar;
                this.f24593l = i10 + 1;
                return;
            }
            if (this.f24592k[i8] == bVar) {
                return;
            } else {
                i8++;
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        return this.f24584c - iVar.f24584c;
    }

    public final void i(b bVar) {
        int i8 = this.f24593l;
        int i9 = 0;
        while (i9 < i8) {
            if (this.f24592k[i9] == bVar) {
                while (i9 < i8 - 1) {
                    b[] bVarArr = this.f24592k;
                    int i10 = i9 + 1;
                    bVarArr[i9] = bVarArr[i10];
                    i9 = i10;
                }
                this.f24593l--;
                return;
            }
            i9++;
        }
    }

    public void k() {
        this.f24583b = null;
        this.f24591j = a.UNKNOWN;
        this.f24586e = 0;
        this.f24584c = -1;
        this.f24585d = -1;
        this.f24587f = 0.0f;
        this.f24588g = false;
        this.f24595n = false;
        this.f24596o = -1;
        this.f24597p = 0.0f;
        int i8 = this.f24593l;
        for (int i9 = 0; i9 < i8; i9++) {
            this.f24592k[i9] = null;
        }
        this.f24593l = 0;
        this.f24594m = 0;
        this.f24582a = false;
        Arrays.fill(this.f24590i, 0.0f);
    }

    public void l(d dVar, float f8) {
        this.f24587f = f8;
        this.f24588g = true;
        this.f24595n = false;
        this.f24596o = -1;
        this.f24597p = 0.0f;
        int i8 = this.f24593l;
        this.f24585d = -1;
        for (int i9 = 0; i9 < i8; i9++) {
            this.f24592k[i9].A(dVar, this, false);
        }
        this.f24593l = 0;
    }

    public void m(a aVar, String str) {
        this.f24591j = aVar;
    }

    public final void n(d dVar, b bVar) {
        int i8 = this.f24593l;
        for (int i9 = 0; i9 < i8; i9++) {
            this.f24592k[i9].B(dVar, bVar, false);
        }
        this.f24593l = 0;
    }

    public String toString() {
        StringBuilder sb;
        if (this.f24583b != null) {
            sb = new StringBuilder();
            sb.append("");
            sb.append(this.f24583b);
        } else {
            sb = new StringBuilder();
            sb.append("");
            sb.append(this.f24584c);
        }
        return sb.toString();
    }
}
