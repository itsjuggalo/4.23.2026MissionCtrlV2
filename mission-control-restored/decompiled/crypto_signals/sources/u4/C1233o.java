package u4;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: u4.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1233o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f10466a = Logger.getLogger(C1233o.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1233o f10467b = new C1233o();

    public static C1233o b() {
        ((n0) AbstractC1231m.f10460a).getClass();
        C1233o c1233o = (C1233o) n0.f10465b.get();
        C1233o c1233o2 = f10467b;
        if (c1233o == null) {
            c1233o = c1233o2;
        }
        return c1233o == null ? c1233o2 : c1233o;
    }

    public final C1233o a() {
        ((n0) AbstractC1231m.f10460a).getClass();
        ThreadLocal threadLocal = n0.f10465b;
        C1233o c1233o = (C1233o) threadLocal.get();
        C1233o c1233o2 = f10467b;
        if (c1233o == null) {
            c1233o = c1233o2;
        }
        threadLocal.set(this);
        return c1233o == null ? c1233o2 : c1233o;
    }

    public final void c(C1233o c1233o) {
        if (c1233o == null) {
            throw new NullPointerException("toAttach");
        }
        ((n0) AbstractC1231m.f10460a).getClass();
        ThreadLocal threadLocal = n0.f10465b;
        C1233o c1233o2 = (C1233o) threadLocal.get();
        C1233o c1233o3 = f10467b;
        if (c1233o2 == null) {
            c1233o2 = c1233o3;
        }
        if (c1233o2 != this) {
            n0.f10464a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (c1233o != c1233o3) {
            threadLocal.set(c1233o);
        } else {
            threadLocal.set(null);
        }
    }
}
