package w;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f23579a = new Object();

    public static final Object c(j jVar, int i10) {
        Object obj;
        t.f(jVar, "<this>");
        int iA = x.a.a(jVar.f23576b, jVar.f23578d, i10);
        if (iA < 0 || (obj = jVar.f23577c[iA]) == f23579a) {
            return null;
        }
        return obj;
    }

    public static final void d(j jVar) {
        int i10 = jVar.f23578d;
        int[] iArr = jVar.f23576b;
        Object[] objArr = jVar.f23577c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f23579a) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        jVar.f23575a = false;
        jVar.f23578d = i11;
    }
}
