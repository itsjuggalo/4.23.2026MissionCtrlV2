package q7;

import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import p5.C2587i;

/* JADX INFO: renamed from: q7.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2654l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2587i f22893a = new C2587i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22894b;

    public final void a(char[] array) {
        AbstractC2304t.f(array, "array");
        synchronized (this) {
            try {
                if (this.f22894b + array.length < AbstractC2652j.f22891a) {
                    this.f22894b += array.length;
                    this.f22893a.addLast(array);
                }
                C2470H c2470h = C2470H.f21956a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final char[] b(int i8) {
        char[] cArr;
        synchronized (this) {
            cArr = (char[]) this.f22893a.L();
            if (cArr != null) {
                this.f22894b -= cArr.length;
            } else {
                cArr = null;
            }
        }
        return cArr == null ? new char[i8] : cArr;
    }
}
