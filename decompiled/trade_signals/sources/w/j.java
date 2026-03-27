package w;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2590l;
import x.AbstractC2939a;

/* JADX INFO: loaded from: classes.dex */
public class j implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f23972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ int[] f23973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f23974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f23975d;

    public j() {
        this(0, 1, null);
    }

    public void b(int i8, Object obj) {
        int i9 = this.f23975d;
        if (i9 != 0 && i8 <= this.f23973b[i9 - 1]) {
            h(i8, obj);
            return;
        }
        if (this.f23972a && i9 >= this.f23973b.length) {
            k.d(this);
        }
        int i10 = this.f23975d;
        if (i10 >= this.f23973b.length) {
            int iE = AbstractC2939a.e(i10 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.f23973b, iE);
            AbstractC2304t.e(iArrCopyOf, "copyOf(this, newSize)");
            this.f23973b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23974c, iE);
            AbstractC2304t.e(objArrCopyOf, "copyOf(this, newSize)");
            this.f23974c = objArrCopyOf;
        }
        this.f23973b[i10] = i8;
        this.f23974c[i10] = obj;
        this.f23975d = i10 + 1;
    }

    public void c() {
        int i8 = this.f23975d;
        Object[] objArr = this.f23974c;
        for (int i9 = 0; i9 < i8; i9++) {
            objArr[i9] = null;
        }
        this.f23975d = 0;
        this.f23972a = false;
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public j clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        AbstractC2304t.d(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        j jVar = (j) objClone;
        jVar.f23973b = (int[]) this.f23973b.clone();
        jVar.f23974c = (Object[]) this.f23974c.clone();
        return jVar;
    }

    public Object e(int i8) {
        return k.c(this, i8);
    }

    public int g(int i8) {
        if (this.f23972a) {
            k.d(this);
        }
        return this.f23973b[i8];
    }

    public void h(int i8, Object obj) {
        int iA = AbstractC2939a.a(this.f23973b, this.f23975d, i8);
        if (iA >= 0) {
            this.f23974c[iA] = obj;
            return;
        }
        int i9 = ~iA;
        if (i9 < this.f23975d && this.f23974c[i9] == k.f23976a) {
            this.f23973b[i9] = i8;
            this.f23974c[i9] = obj;
            return;
        }
        if (this.f23972a && this.f23975d >= this.f23973b.length) {
            k.d(this);
            i9 = ~AbstractC2939a.a(this.f23973b, this.f23975d, i8);
        }
        int i10 = this.f23975d;
        if (i10 >= this.f23973b.length) {
            int iE = AbstractC2939a.e(i10 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.f23973b, iE);
            AbstractC2304t.e(iArrCopyOf, "copyOf(this, newSize)");
            this.f23973b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23974c, iE);
            AbstractC2304t.e(objArrCopyOf, "copyOf(this, newSize)");
            this.f23974c = objArrCopyOf;
        }
        int i11 = this.f23975d;
        if (i11 - i9 != 0) {
            int[] iArr = this.f23973b;
            int i12 = i9 + 1;
            AbstractC2590l.f(iArr, iArr, i12, i9, i11);
            Object[] objArr = this.f23974c;
            AbstractC2590l.h(objArr, objArr, i12, i9, this.f23975d);
        }
        this.f23973b[i9] = i8;
        this.f23974c[i9] = obj;
        this.f23975d++;
    }

    public int i() {
        if (this.f23972a) {
            k.d(this);
        }
        return this.f23975d;
    }

    public Object j(int i8) {
        if (this.f23972a) {
            k.d(this);
        }
        return this.f23974c[i8];
    }

    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f23975d * 28);
        sb.append('{');
        int i8 = this.f23975d;
        for (int i9 = 0; i9 < i8; i9++) {
            if (i9 > 0) {
                sb.append(", ");
            }
            sb.append(g(i9));
            sb.append('=');
            Object objJ = j(i9);
            if (objJ != this) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        AbstractC2304t.e(string, "buffer.toString()");
        return string;
    }

    public j(int i8) {
        if (i8 == 0) {
            this.f23973b = AbstractC2939a.f24102a;
            this.f23974c = AbstractC2939a.f24104c;
        } else {
            int iE = AbstractC2939a.e(i8);
            this.f23973b = new int[iE];
            this.f23974c = new Object[iE];
        }
    }

    public /* synthetic */ j(int i8, int i9, AbstractC2296k abstractC2296k) {
        this((i9 & 1) != 0 ? 10 : i8);
    }
}
