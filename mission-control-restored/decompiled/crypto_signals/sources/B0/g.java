package B0;

import android.content.Context;
import java.math.BigInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.t;
import y0.C1420h;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ g f93a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final G4.j f94b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f95c;

    static {
        t.a(h.class).b();
        f94b = F1.h.B(f.f92a);
        f95c = a.f75a;
    }

    public static b a(Context context) {
        kotlin.jvm.internal.j.e(context, "context");
        C0.a aVar = (C0.a) f94b.getValue();
        if (aVar == null) {
            E0.l lVar = E0.l.f384c;
            if (E0.l.f384c == null) {
                ReentrantLock reentrantLock = E0.l.f385d;
                reentrantLock.lock();
                try {
                    if (E0.l.f384c == null) {
                        E0.j jVar = null;
                        try {
                            C1420h c1420hB = E0.h.b();
                            if (c1420hB != null) {
                                C1420h other = C1420h.f11630f;
                                kotlin.jvm.internal.j.e(other, "other");
                                Object value = c1420hB.e.getValue();
                                kotlin.jvm.internal.j.d(value, "<get-bigInteger>(...)");
                                Object value2 = other.e.getValue();
                                kotlin.jvm.internal.j.d(value2, "<get-bigInteger>(...)");
                                if (((BigInteger) value).compareTo((BigInteger) value2) >= 0) {
                                    E0.j jVar2 = new E0.j(context);
                                    if (jVar2.e()) {
                                        jVar = jVar2;
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        E0.l.f384c = new E0.l(jVar);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            aVar = E0.l.f384c;
            kotlin.jvm.internal.j.b(aVar);
        }
        int i = o.f110b;
        b bVar = new b(aVar);
        f95c.getClass();
        return bVar;
    }
}
