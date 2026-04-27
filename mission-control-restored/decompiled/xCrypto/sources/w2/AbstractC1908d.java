package w2;

import java.sql.Date;
import java.sql.Timestamp;
import q2.x;
import t2.C1786c;

/* JADX INFO: renamed from: w2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1908d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f15577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1786c.b f15578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1786c.b f15579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f15580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final x f15581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final x f15582f;

    /* JADX INFO: renamed from: w2.d$a */
    public class a extends C1786c.b {
        public a(Class cls) {
            super(cls);
        }

        @Override // t2.C1786c.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Date d(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    /* JADX INFO: renamed from: w2.d$b */
    public class b extends C1786c.b {
        public b(Class cls) {
            super(cls);
        }

        @Override // t2.C1786c.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Timestamp d(java.util.Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z4;
        try {
            Class.forName("java.sql.Date");
            z4 = true;
        } catch (ClassNotFoundException unused) {
            z4 = false;
        }
        f15577a = z4;
        if (z4) {
            f15578b = new a(Date.class);
            f15579c = new b(Timestamp.class);
            f15580d = C1905a.f15571b;
            f15581e = C1906b.f15573b;
            f15582f = C1907c.f15575b;
            return;
        }
        f15578b = null;
        f15579c = null;
        f15580d = null;
        f15581e = null;
        f15582f = null;
    }
}
