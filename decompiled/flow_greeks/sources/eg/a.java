package eg;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements Iterable, qd.a {

    /* JADX INFO: renamed from: eg.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class AbstractC0168a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8875a;

        public AbstractC0168a(int i10) {
            this.f8875a = i10;
        }

        public final Object c(a thisRef) {
            kotlin.jvm.internal.t.f(thisRef, "thisRef");
            return thisRef.a().get(this.f8875a);
        }
    }

    public abstract c a();

    public abstract z c();

    public abstract void e(String str, Object obj);

    public final void f(wd.d tClass, Object value) {
        kotlin.jvm.internal.t.f(tClass, "tClass");
        kotlin.jvm.internal.t.f(value, "value");
        String strB = tClass.b();
        kotlin.jvm.internal.t.c(strB);
        e(strB, value);
    }

    public final boolean isEmpty() {
        return a().a() == 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return a().iterator();
    }
}
