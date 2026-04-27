package t6;

import F5.C0548f;

/* JADX INFO: renamed from: t6.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2721k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0548f f24328a = new C0548f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24329b;

    public final void a(char[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        synchronized (this) {
            try {
                if (this.f24329b + array.length < AbstractC2719i.f24326a) {
                    this.f24329b += array.length;
                    this.f24328a.addLast(array);
                }
                E5.E e7 = E5.E.f1657a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final char[] b(int i7) {
        char[] cArr;
        synchronized (this) {
            cArr = (char[]) this.f24328a.s();
            if (cArr != null) {
                this.f24329b -= cArr.length;
            } else {
                cArr = null;
            }
        }
        return cArr == null ? new char[i7] : cArr;
    }
}
