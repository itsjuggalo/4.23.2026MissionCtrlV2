package P6;

import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: P6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0788a implements Iterable, C5.a {

    /* JADX INFO: renamed from: P6.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0090a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6486a;

        public AbstractC0090a(int i8) {
            this.f6486a = i8;
        }

        public final Object c(AbstractC0788a thisRef) {
            AbstractC2304t.f(thisRef, "thisRef");
            return thisRef.a().get(this.f6486a);
        }
    }

    public abstract c a();

    public abstract z d();

    public final void e(I5.d tClass, Object value) {
        AbstractC2304t.f(tClass, "tClass");
        AbstractC2304t.f(value, "value");
        String strQ = tClass.q();
        AbstractC2304t.c(strQ);
        f(strQ, value);
    }

    public abstract void f(String str, Object obj);

    public final boolean isEmpty() {
        return a().a() == 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return a().iterator();
    }
}
