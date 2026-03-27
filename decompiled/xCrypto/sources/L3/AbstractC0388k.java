package L3;

import X2.C0760g;

/* JADX INFO: renamed from: L3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0388k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0760g f1535a = new C0760g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1536b;

    public final void a(char[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        synchronized (this) {
            try {
                if (this.f1536b + array.length < AbstractC0386i.f1533a) {
                    this.f1536b += array.length;
                    this.f1535a.addLast(array);
                }
                W2.E e4 = W2.E.f5463a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final char[] b(int i4) {
        char[] cArr;
        synchronized (this) {
            cArr = (char[]) this.f1535a.u();
            if (cArr != null) {
                this.f1536b -= cArr.length;
            } else {
                cArr = null;
            }
        }
        return cArr == null ? new char[i4] : cArr;
    }
}
