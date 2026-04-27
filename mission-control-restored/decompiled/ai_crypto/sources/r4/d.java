package r4;

import java.sql.Date;
import java.sql.Timestamp;
import l4.x;
import o4.C2311c;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f22491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2311c.b f22492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2311c.b f22493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f22494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final x f22495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final x f22496f;

    public class a extends C2311c.b {
        public a(Class cls) {
            super(cls);
        }

        @Override // o4.C2311c.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Date d(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    public class b extends C2311c.b {
        public b(Class cls) {
            super(cls);
        }

        @Override // o4.C2311c.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Timestamp d(java.util.Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z7;
        try {
            Class.forName("java.sql.Date");
            z7 = true;
        } catch (ClassNotFoundException unused) {
            z7 = false;
        }
        f22491a = z7;
        if (z7) {
            f22492b = new a(Date.class);
            f22493c = new b(Timestamp.class);
            f22494d = C2581a.f22485b;
            f22495e = C2582b.f22487b;
            f22496f = C2583c.f22489b;
            return;
        }
        f22492b = null;
        f22493c = null;
        f22494d = null;
        f22495e = null;
        f22496f = null;
    }
}
