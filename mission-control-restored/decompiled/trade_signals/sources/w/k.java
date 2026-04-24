package w;

import kotlin.jvm.internal.AbstractC2304t;
import x.AbstractC2939a;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f23976a = new Object();

    public static final Object c(j jVar, int i8) {
        Object obj;
        AbstractC2304t.f(jVar, "<this>");
        int iA = AbstractC2939a.a(jVar.f23973b, jVar.f23975d, i8);
        if (iA < 0 || (obj = jVar.f23974c[iA]) == f23976a) {
            return null;
        }
        return obj;
    }

    public static final void d(j jVar) {
        int i8 = jVar.f23975d;
        int[] iArr = jVar.f23973b;
        Object[] objArr = jVar.f23974c;
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            Object obj = objArr[i10];
            if (obj != f23976a) {
                if (i10 != i9) {
                    iArr[i9] = iArr[i10];
                    objArr[i9] = obj;
                    objArr[i10] = null;
                }
                i9++;
            }
        }
        jVar.f23972a = false;
        jVar.f23975d = i9;
    }
}
