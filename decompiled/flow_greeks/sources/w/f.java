package w;

import dd.l;
import java.util.Arrays;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f23567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ long[] f23568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f23569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f23570d;

    public f() {
        this(0, 1, null);
    }

    public void a() {
        int i10 = this.f23570d;
        Object[] objArr = this.f23569c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f23570d = 0;
        this.f23567a = false;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public f clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        t.d(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        f fVar = (f) objClone;
        fVar.f23568b = (long[]) this.f23568b.clone();
        fVar.f23569c = (Object[]) this.f23569c.clone();
        return fVar;
    }

    public Object c(long j10) {
        int iB = x.a.b(this.f23568b, this.f23570d, j10);
        if (iB < 0 || this.f23569c[iB] == g.f23571a) {
            return null;
        }
        return this.f23569c[iB];
    }

    public int d(long j10) {
        if (this.f23567a) {
            int i10 = this.f23570d;
            long[] jArr = this.f23568b;
            Object[] objArr = this.f23569c;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != g.f23571a) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.f23567a = false;
            this.f23570d = i11;
        }
        return x.a.b(this.f23568b, this.f23570d, j10);
    }

    public long f(int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.f23570d)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i10).toString());
        }
        if (this.f23567a) {
            long[] jArr = this.f23568b;
            Object[] objArr = this.f23569c;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = objArr[i13];
                if (obj != g.f23571a) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            this.f23567a = false;
            this.f23570d = i12;
        }
        return this.f23568b[i10];
    }

    public void g(long j10, Object obj) {
        int iB = x.a.b(this.f23568b, this.f23570d, j10);
        if (iB >= 0) {
            this.f23569c[iB] = obj;
            return;
        }
        int i10 = ~iB;
        if (i10 < this.f23570d && this.f23569c[i10] == g.f23571a) {
            this.f23568b[i10] = j10;
            this.f23569c[i10] = obj;
            return;
        }
        if (this.f23567a) {
            int i11 = this.f23570d;
            long[] jArr = this.f23568b;
            if (i11 >= jArr.length) {
                Object[] objArr = this.f23569c;
                int i12 = 0;
                for (int i13 = 0; i13 < i11; i13++) {
                    Object obj2 = objArr[i13];
                    if (obj2 != g.f23571a) {
                        if (i13 != i12) {
                            jArr[i12] = jArr[i13];
                            objArr[i12] = obj2;
                            objArr[i13] = null;
                        }
                        i12++;
                    }
                }
                this.f23567a = false;
                this.f23570d = i12;
                i10 = ~x.a.b(this.f23568b, i12, j10);
            }
        }
        int i14 = this.f23570d;
        if (i14 >= this.f23568b.length) {
            int iF = x.a.f(i14 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.f23568b, iF);
            t.e(jArrCopyOf, "copyOf(this, newSize)");
            this.f23568b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23569c, iF);
            t.e(objArrCopyOf, "copyOf(this, newSize)");
            this.f23569c = objArrCopyOf;
        }
        int i15 = this.f23570d;
        if (i15 - i10 != 0) {
            long[] jArr2 = this.f23568b;
            int i16 = i10 + 1;
            l.g(jArr2, jArr2, i16, i10, i15);
            Object[] objArr2 = this.f23569c;
            l.h(objArr2, objArr2, i16, i10, this.f23570d);
        }
        this.f23568b[i10] = j10;
        this.f23569c[i10] = obj;
        this.f23570d++;
    }

    public void h(long j10) {
        int iB = x.a.b(this.f23568b, this.f23570d, j10);
        if (iB < 0 || this.f23569c[iB] == g.f23571a) {
            return;
        }
        this.f23569c[iB] = g.f23571a;
        this.f23567a = true;
    }

    public int i() {
        if (this.f23567a) {
            int i10 = this.f23570d;
            long[] jArr = this.f23568b;
            Object[] objArr = this.f23569c;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != g.f23571a) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.f23567a = false;
            this.f23570d = i11;
        }
        return this.f23570d;
    }

    public Object j(int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.f23570d)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i10).toString());
        }
        if (this.f23567a) {
            long[] jArr = this.f23568b;
            Object[] objArr = this.f23569c;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj = objArr[i13];
                if (obj != g.f23571a) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            this.f23567a = false;
            this.f23570d = i12;
        }
        return this.f23569c[i10];
    }

    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f23570d * 28);
        sb2.append('{');
        int i10 = this.f23570d;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            sb2.append(f(i11));
            sb2.append('=');
            Object objJ = j(i11);
            if (objJ != sb2) {
                sb2.append(objJ);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        t.e(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public f(int i10) {
        if (i10 == 0) {
            this.f23568b = x.a.f24121b;
            this.f23569c = x.a.f24122c;
        } else {
            int iF = x.a.f(i10);
            this.f23568b = new long[iF];
            this.f23569c = new Object[iF];
        }
    }

    public /* synthetic */ f(int i10, int i11, kotlin.jvm.internal.k kVar) {
        this((i11 & 1) != 0 ? 10 : i10);
    }
}
