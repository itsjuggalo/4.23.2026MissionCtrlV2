package w;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2590l;
import x.AbstractC2939a;

/* JADX INFO: loaded from: classes.dex */
public class f implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f23964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ long[] f23965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f23966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f23967d;

    public f() {
        this(0, 1, null);
    }

    public void b() {
        int i8 = this.f23967d;
        Object[] objArr = this.f23966c;
        for (int i9 = 0; i9 < i8; i9++) {
            objArr[i9] = null;
        }
        this.f23967d = 0;
        this.f23964a = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public f clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        AbstractC2304t.d(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        f fVar = (f) objClone;
        fVar.f23965b = (long[]) this.f23965b.clone();
        fVar.f23966c = (Object[]) this.f23966c.clone();
        return fVar;
    }

    public Object d(long j8) {
        int iB = AbstractC2939a.b(this.f23965b, this.f23967d, j8);
        if (iB < 0 || this.f23966c[iB] == g.f23968a) {
            return null;
        }
        return this.f23966c[iB];
    }

    public int e(long j8) {
        if (this.f23964a) {
            int i8 = this.f23967d;
            long[] jArr = this.f23965b;
            Object[] objArr = this.f23966c;
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                Object obj = objArr[i10];
                if (obj != g.f23968a) {
                    if (i10 != i9) {
                        jArr[i9] = jArr[i10];
                        objArr[i9] = obj;
                        objArr[i10] = null;
                    }
                    i9++;
                }
            }
            this.f23964a = false;
            this.f23967d = i9;
        }
        return AbstractC2939a.b(this.f23965b, this.f23967d, j8);
    }

    public long g(int i8) {
        int i9;
        if (i8 < 0 || i8 >= (i9 = this.f23967d)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i8).toString());
        }
        if (this.f23964a) {
            long[] jArr = this.f23965b;
            Object[] objArr = this.f23966c;
            int i10 = 0;
            for (int i11 = 0; i11 < i9; i11++) {
                Object obj = objArr[i11];
                if (obj != g.f23968a) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.f23964a = false;
            this.f23967d = i10;
        }
        return this.f23965b[i8];
    }

    public void h(long j8, Object obj) {
        int iB = AbstractC2939a.b(this.f23965b, this.f23967d, j8);
        if (iB >= 0) {
            this.f23966c[iB] = obj;
            return;
        }
        int i8 = ~iB;
        if (i8 < this.f23967d && this.f23966c[i8] == g.f23968a) {
            this.f23965b[i8] = j8;
            this.f23966c[i8] = obj;
            return;
        }
        if (this.f23964a) {
            int i9 = this.f23967d;
            long[] jArr = this.f23965b;
            if (i9 >= jArr.length) {
                Object[] objArr = this.f23966c;
                int i10 = 0;
                for (int i11 = 0; i11 < i9; i11++) {
                    Object obj2 = objArr[i11];
                    if (obj2 != g.f23968a) {
                        if (i11 != i10) {
                            jArr[i10] = jArr[i11];
                            objArr[i10] = obj2;
                            objArr[i11] = null;
                        }
                        i10++;
                    }
                }
                this.f23964a = false;
                this.f23967d = i10;
                i8 = ~AbstractC2939a.b(this.f23965b, i10, j8);
            }
        }
        int i12 = this.f23967d;
        if (i12 >= this.f23965b.length) {
            int iF = AbstractC2939a.f(i12 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.f23965b, iF);
            AbstractC2304t.e(jArrCopyOf, "copyOf(this, newSize)");
            this.f23965b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23966c, iF);
            AbstractC2304t.e(objArrCopyOf, "copyOf(this, newSize)");
            this.f23966c = objArrCopyOf;
        }
        int i13 = this.f23967d;
        if (i13 - i8 != 0) {
            long[] jArr2 = this.f23965b;
            int i14 = i8 + 1;
            AbstractC2590l.g(jArr2, jArr2, i14, i8, i13);
            Object[] objArr2 = this.f23966c;
            AbstractC2590l.h(objArr2, objArr2, i14, i8, this.f23967d);
        }
        this.f23965b[i8] = j8;
        this.f23966c[i8] = obj;
        this.f23967d++;
    }

    public void i(long j8) {
        int iB = AbstractC2939a.b(this.f23965b, this.f23967d, j8);
        if (iB < 0 || this.f23966c[iB] == g.f23968a) {
            return;
        }
        this.f23966c[iB] = g.f23968a;
        this.f23964a = true;
    }

    public int j() {
        if (this.f23964a) {
            int i8 = this.f23967d;
            long[] jArr = this.f23965b;
            Object[] objArr = this.f23966c;
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                Object obj = objArr[i10];
                if (obj != g.f23968a) {
                    if (i10 != i9) {
                        jArr[i9] = jArr[i10];
                        objArr[i9] = obj;
                        objArr[i10] = null;
                    }
                    i9++;
                }
            }
            this.f23964a = false;
            this.f23967d = i9;
        }
        return this.f23967d;
    }

    public Object k(int i8) {
        int i9;
        if (i8 < 0 || i8 >= (i9 = this.f23967d)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i8).toString());
        }
        if (this.f23964a) {
            long[] jArr = this.f23965b;
            Object[] objArr = this.f23966c;
            int i10 = 0;
            for (int i11 = 0; i11 < i9; i11++) {
                Object obj = objArr[i11];
                if (obj != g.f23968a) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.f23964a = false;
            this.f23967d = i10;
        }
        return this.f23966c[i8];
    }

    public String toString() {
        if (j() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f23967d * 28);
        sb.append('{');
        int i8 = this.f23967d;
        for (int i9 = 0; i9 < i8; i9++) {
            if (i9 > 0) {
                sb.append(", ");
            }
            sb.append(g(i9));
            sb.append('=');
            Object objK = k(i9);
            if (objK != sb) {
                sb.append(objK);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        AbstractC2304t.e(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public f(int i8) {
        if (i8 == 0) {
            this.f23965b = AbstractC2939a.f24103b;
            this.f23966c = AbstractC2939a.f24104c;
        } else {
            int iF = AbstractC2939a.f(i8);
            this.f23965b = new long[iF];
            this.f23966c = new Object[iF];
        }
    }

    public /* synthetic */ f(int i8, int i9, AbstractC2296k abstractC2296k) {
        this((i9 & 1) != 0 ? 10 : i8);
    }
}
