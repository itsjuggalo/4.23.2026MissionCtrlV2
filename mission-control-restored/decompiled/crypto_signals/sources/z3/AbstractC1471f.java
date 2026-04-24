package z3;

import java.sql.Date;
import java.sql.Timestamp;
import z3.C1466a;
import z3.C1467b;

/* JADX INFO: renamed from: z3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1471f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f11765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1466a.C0000a f11766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1467b.a f11767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1468c f11768d;

    static {
        boolean z6;
        try {
            Class.forName("java.sql.Date");
            z6 = true;
        } catch (ClassNotFoundException unused) {
            z6 = false;
        }
        f11765a = z6;
        if (!z6) {
            f11766b = null;
            f11767c = null;
            f11768d = null;
        } else {
            new C1470e(Date.class, 0);
            new C1470e(Timestamp.class, 1);
            f11766b = C1466a.f11758b;
            f11767c = C1467b.f11760b;
            f11768d = C1469d.f11762b;
        }
    }
}
