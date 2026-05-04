package w;

import dd.l;
import java.util.Arrays;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f23575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ int[] f23576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f23577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f23578d;

    public j() {
        this(0, 1, null);
    }

    public void a(int i10, Object obj) {
        int i11 = this.f23578d;
        if (i11 != 0 && i10 <= this.f23576b[i11 - 1]) {
            g(i10, obj);
            return;
        }
        if (this.f23575a && i11 >= this.f23576b.length) {
            k.d(this);
        }
        int i12 = this.f23578d;
        if (i12 >= this.f23576b.length) {
            int iE = x.a.e(i12 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.f23576b, iE);
            t.e(iArrCopyOf, "copyOf(this, newSize)");
            this.f23576b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23577c, iE);
            t.e(objArrCopyOf, "copyOf(this, newSize)");
            this.f23577c = objArrCopyOf;
        }
        this.f23576b[i12] = i10;
        this.f23577c[i12] = obj;
        this.f23578d = i12 + 1;
    }

    public void b() {
        int i10 = this.f23578d;
        Object[] objArr = this.f23577c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f23578d = 0;
        this.f23575a = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public j clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        t.d(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        j jVar = (j) objClone;
        jVar.f23576b = (int[]) this.f23576b.clone();
        jVar.f23577c = (Object[]) this.f23577c.clone();
        return jVar;
    }

    public Object d(int i10) {
        return k.c(this, i10);
    }

    public int f(int i10) {
        if (this.f23575a) {
            k.d(this);
        }
        return this.f23576b[i10];
    }

    public void g(int i10, Object obj) {
        int iA = x.a.a(this.f23576b, this.f23578d, i10);
        if (iA >= 0) {
            this.f23577c[iA] = obj;
            return;
        }
        int i11 = ~iA;
        if (i11 < this.f23578d && this.f23577c[i11] == k.f23579a) {
            this.f23576b[i11] = i10;
            this.f23577c[i11] = obj;
            return;
        }
        if (this.f23575a && this.f23578d >= this.f23576b.length) {
            k.d(this);
            i11 = ~x.a.a(this.f23576b, this.f23578d, i10);
        }
        int i12 = this.f23578d;
        if (i12 >= this.f23576b.length) {
            int iE = x.a.e(i12 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.f23576b, iE);
            t.e(iArrCopyOf, "copyOf(this, newSize)");
            this.f23576b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23577c, iE);
            t.e(objArrCopyOf, "copyOf(this, newSize)");
            this.f23577c = objArrCopyOf;
        }
        int i13 = this.f23578d;
        if (i13 - i11 != 0) {
            int[] iArr = this.f23576b;
            int i14 = i11 + 1;
            l.f(iArr, iArr, i14, i11, i13);
            Object[] objArr = this.f23577c;
            l.h(objArr, objArr, i14, i11, this.f23578d);
        }
        this.f23576b[i11] = i10;
        this.f23577c[i11] = obj;
        this.f23578d++;
    }

    public int h() {
        if (this.f23575a) {
            k.d(this);
        }
        return this.f23578d;
    }

    public Object i(int i10) {
        if (this.f23575a) {
            k.d(this);
        }
        return this.f23577c[i10];
    }

    public String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f23578d * 28);
        sb2.append('{');
        int i10 = this.f23578d;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            sb2.append(f(i11));
            sb2.append('=');
            Object objI = i(i11);
            if (objI != this) {
                sb2.append(objI);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        t.e(string, "buffer.toString()");
        return string;
    }

    public j(int i10) {
        if (i10 == 0) {
            this.f23576b = x.a.f24120a;
            this.f23577c = x.a.f24122c;
        } else {
            int iE = x.a.e(i10);
            this.f23576b = new int[iE];
            this.f23577c = new Object[iE];
        }
    }

    public /* synthetic */ j(int i10, int i11, kotlin.jvm.internal.k kVar) {
        this((i11 & 1) != 0 ? 10 : i10);
    }
}
