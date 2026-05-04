package z;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i implements Comparable {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f25501r = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25503b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f25507f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f25511j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25504c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25505d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25506e = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25508g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f25509h = new float[9];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f25510i = new float[9];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b[] f25512k = new b[16];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f25513l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f25514m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f25515n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f25516o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f25517p = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HashSet f25518q = null;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f25511j = aVar;
    }

    public static void c() {
        f25501r++;
    }

    public final void a(b bVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f25513l;
            if (i10 >= i11) {
                b[] bVarArr = this.f25512k;
                if (i11 >= bVarArr.length) {
                    this.f25512k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f25512k;
                int i12 = this.f25513l;
                bVarArr2[i12] = bVar;
                this.f25513l = i12 + 1;
                return;
            }
            if (this.f25512k[i10] == bVar) {
                return;
            } else {
                i10++;
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        return this.f25504c - iVar.f25504c;
    }

    public final void h(b bVar) {
        int i10 = this.f25513l;
        int i11 = 0;
        while (i11 < i10) {
            if (this.f25512k[i11] == bVar) {
                while (i11 < i10 - 1) {
                    b[] bVarArr = this.f25512k;
                    int i12 = i11 + 1;
                    bVarArr[i11] = bVarArr[i12];
                    i11 = i12;
                }
                this.f25513l--;
                return;
            }
            i11++;
        }
    }

    public void i() {
        this.f25503b = null;
        this.f25511j = a.UNKNOWN;
        this.f25506e = 0;
        this.f25504c = -1;
        this.f25505d = -1;
        this.f25507f = 0.0f;
        this.f25508g = false;
        this.f25515n = false;
        this.f25516o = -1;
        this.f25517p = 0.0f;
        int i10 = this.f25513l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f25512k[i11] = null;
        }
        this.f25513l = 0;
        this.f25514m = 0;
        this.f25502a = false;
        Arrays.fill(this.f25510i, 0.0f);
    }

    public void k(d dVar, float f10) {
        this.f25507f = f10;
        this.f25508g = true;
        this.f25515n = false;
        this.f25516o = -1;
        this.f25517p = 0.0f;
        int i10 = this.f25513l;
        this.f25505d = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f25512k[i11].A(dVar, this, false);
        }
        this.f25513l = 0;
    }

    public void l(a aVar, String str) {
        this.f25511j = aVar;
    }

    public final void m(d dVar, b bVar) {
        int i10 = this.f25513l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f25512k[i11].B(dVar, bVar, false);
        }
        this.f25513l = 0;
    }

    public String toString() {
        if (this.f25503b != null) {
            return "" + this.f25503b;
        }
        return "" + this.f25504c;
    }
}
