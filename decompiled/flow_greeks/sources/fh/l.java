package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dd.i f9591a = new dd.i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9592b;

    public final void a(char[] array) {
        kotlin.jvm.internal.t.f(array, "array");
        synchronized (this) {
            try {
                if (this.f9592b + array.length < j.f9583a) {
                    this.f9592b += array.length;
                    this.f9591a.addLast(array);
                }
                cd.h0 h0Var = cd.h0.f3852a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final char[] b(int i10) {
        char[] cArr;
        synchronized (this) {
            cArr = (char[]) this.f9591a.y();
            if (cArr != null) {
                this.f9592b -= cArr.length;
            } else {
                cArr = null;
            }
        }
        return cArr == null ? new char[i10] : cArr;
    }
}
