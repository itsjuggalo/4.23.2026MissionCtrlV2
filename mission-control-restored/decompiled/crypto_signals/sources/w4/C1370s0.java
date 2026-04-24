package w4;

import java.text.MessageFormat;
import java.util.logging.Level;
import u4.AbstractC1222d;

/* JADX INFO: renamed from: w4.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1370s0 extends AbstractC1222d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u4.D f11374d;

    @Override // u4.AbstractC1222d
    public final void m(int i, String str) {
        u4.D d4 = this.f11374d;
        Level levelV = C1352m.v(i);
        if (C1358o.f11331c.isLoggable(levelV)) {
            C1358o.a(d4, levelV, str);
        }
    }

    @Override // u4.AbstractC1222d
    public final void n(int i, String str, Object... objArr) {
        u4.D d4 = this.f11374d;
        Level levelV = C1352m.v(i);
        if (C1358o.f11331c.isLoggable(levelV)) {
            C1358o.a(d4, levelV, MessageFormat.format(str, objArr));
        }
    }
}
