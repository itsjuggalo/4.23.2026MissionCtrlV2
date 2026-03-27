package w4;

import java.text.MessageFormat;
import java.util.logging.Level;
import u4.AbstractC1222d;
import u4.C1243z;
import u4.EnumC1242y;

/* JADX INFO: renamed from: w4.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1352m extends AbstractC1222d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1358o f11321d;
    public final c2 e;

    public C1352m(C1358o c1358o, c2 c2Var) {
        this.f11321d = c1358o;
        s3.D.j(c2Var, "time");
        this.e = c2Var;
    }

    public static Level v(int i) {
        int iC = S.i.c(i);
        return iC != 1 ? (iC == 2 || iC == 3) ? Level.FINE : Level.FINEST : Level.FINER;
    }

    @Override // u4.AbstractC1222d
    public final void m(int i, String str) {
        C1358o c1358o = this.f11321d;
        u4.D d4 = c1358o.f11333b;
        Level levelV = v(i);
        if (C1358o.f11331c.isLoggable(levelV)) {
            C1358o.a(d4, levelV, str);
        }
        if (!u(i) || i == 1) {
            return;
        }
        int iC = S.i.c(i);
        EnumC1242y enumC1242y = iC != 2 ? iC != 3 ? EnumC1242y.f10491a : EnumC1242y.f10493c : EnumC1242y.f10492b;
        long jF = this.e.f();
        s3.D.j(str, "description");
        new C1243z(str, enumC1242y, jF, null);
        synchronized (c1358o.f11332a) {
        }
    }

    @Override // u4.AbstractC1222d
    public final void n(int i, String str, Object... objArr) {
        m(i, (u(i) || C1358o.f11331c.isLoggable(v(i))) ? MessageFormat.format(str, objArr) : null);
    }

    public final boolean u(int i) {
        if (i != 1) {
            synchronized (this.f11321d.f11332a) {
            }
        }
        return false;
    }
}
