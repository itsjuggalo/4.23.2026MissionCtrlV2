package F4;

import F4.AbstractC0497k;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import v2.AbstractC2842h;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: F4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0489c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0489c f1753k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0505t f1754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f1755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC0488b f1757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object[][] f1759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f1760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f1761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f1762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f1763j;

    /* JADX INFO: renamed from: F4.c$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C0505t f1764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Executor f1765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f1766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AbstractC0488b f1767d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f1768e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object[][] f1769f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f1770g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f1771h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f1772i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Integer f1773j;

        public final C0489c b() {
            return new C0489c(this);
        }
    }

    /* JADX INFO: renamed from: F4.c$c, reason: collision with other inner class name */
    public static final class C0029c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f1775b;

        public C0029c(String str, Object obj) {
            this.f1774a = str;
            this.f1775b = obj;
        }

        public static C0029c b(String str) {
            AbstractC2848n.o(str, "debugString");
            return new C0029c(str, null);
        }

        public String toString() {
            return this.f1774a;
        }
    }

    static {
        b bVar = new b();
        bVar.f1769f = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        bVar.f1770g = Collections.emptyList();
        f1753k = bVar.b();
    }

    public C0489c(b bVar) {
        this.f1754a = bVar.f1764a;
        this.f1755b = bVar.f1765b;
        this.f1756c = bVar.f1766c;
        this.f1757d = bVar.f1767d;
        this.f1758e = bVar.f1768e;
        this.f1759f = bVar.f1769f;
        this.f1760g = bVar.f1770g;
        this.f1761h = bVar.f1771h;
        this.f1762i = bVar.f1772i;
        this.f1763j = bVar.f1773j;
    }

    public static b k(C0489c c0489c) {
        b bVar = new b();
        bVar.f1764a = c0489c.f1754a;
        bVar.f1765b = c0489c.f1755b;
        bVar.f1766c = c0489c.f1756c;
        bVar.f1767d = c0489c.f1757d;
        bVar.f1768e = c0489c.f1758e;
        bVar.f1769f = c0489c.f1759f;
        bVar.f1770g = c0489c.f1760g;
        bVar.f1771h = c0489c.f1761h;
        bVar.f1772i = c0489c.f1762i;
        bVar.f1773j = c0489c.f1763j;
        return bVar;
    }

    public String a() {
        return this.f1756c;
    }

    public String b() {
        return this.f1758e;
    }

    public AbstractC0488b c() {
        return this.f1757d;
    }

    public C0505t d() {
        return this.f1754a;
    }

    public Executor e() {
        return this.f1755b;
    }

    public Integer f() {
        return this.f1762i;
    }

    public Integer g() {
        return this.f1763j;
    }

    public Object h(C0029c c0029c) {
        AbstractC2848n.o(c0029c, "key");
        int i8 = 0;
        while (true) {
            Object[][] objArr = this.f1759f;
            if (i8 >= objArr.length) {
                return c0029c.f1775b;
            }
            if (c0029c.equals(objArr[i8][0])) {
                return this.f1759f[i8][1];
            }
            i8++;
        }
    }

    public List i() {
        return this.f1760g;
    }

    public boolean j() {
        return Boolean.TRUE.equals(this.f1761h);
    }

    public C0489c l(C0505t c0505t) {
        b bVarK = k(this);
        bVarK.f1764a = c0505t;
        return bVarK.b();
    }

    public C0489c m(long j8, TimeUnit timeUnit) {
        return l(C0505t.a(j8, timeUnit));
    }

    public C0489c n(Executor executor) {
        b bVarK = k(this);
        bVarK.f1765b = executor;
        return bVarK.b();
    }

    public C0489c o(int i8) {
        AbstractC2848n.h(i8 >= 0, "invalid maxsize %s", i8);
        b bVarK = k(this);
        bVarK.f1772i = Integer.valueOf(i8);
        return bVarK.b();
    }

    public C0489c p(int i8) {
        AbstractC2848n.h(i8 >= 0, "invalid maxsize %s", i8);
        b bVarK = k(this);
        bVarK.f1773j = Integer.valueOf(i8);
        return bVarK.b();
    }

    public C0489c q(C0029c c0029c, Object obj) {
        AbstractC2848n.o(c0029c, "key");
        AbstractC2848n.o(obj, "value");
        b bVarK = k(this);
        int i8 = 0;
        while (true) {
            Object[][] objArr = this.f1759f;
            if (i8 >= objArr.length) {
                i8 = -1;
                break;
            }
            if (c0029c.equals(objArr[i8][0])) {
                break;
            }
            i8++;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f1759f.length + (i8 == -1 ? 1 : 0), 2);
        bVarK.f1769f = objArr2;
        Object[][] objArr3 = this.f1759f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        Object[][] objArr4 = bVarK.f1769f;
        if (i8 == -1) {
            objArr4[this.f1759f.length] = new Object[]{c0029c, obj};
        } else {
            objArr4[i8] = new Object[]{c0029c, obj};
        }
        return bVarK.b();
    }

    public C0489c r(AbstractC0497k.a aVar) {
        ArrayList arrayList = new ArrayList(this.f1760g.size() + 1);
        arrayList.addAll(this.f1760g);
        arrayList.add(aVar);
        b bVarK = k(this);
        bVarK.f1770g = Collections.unmodifiableList(arrayList);
        return bVarK.b();
    }

    public C0489c s() {
        b bVarK = k(this);
        bVarK.f1771h = Boolean.TRUE;
        return bVarK.b();
    }

    public C0489c t() {
        b bVarK = k(this);
        bVarK.f1771h = Boolean.FALSE;
        return bVarK.b();
    }

    public String toString() {
        AbstractC2842h.b bVarD = AbstractC2842h.b(this).d("deadline", this.f1754a).d("authority", this.f1756c).d("callCredentials", this.f1757d);
        Executor executor = this.f1755b;
        return bVarD.d("executor", executor != null ? executor.getClass() : null).d("compressorName", this.f1758e).d("customOptions", Arrays.deepToString(this.f1759f)).e("waitForReady", j()).d("maxInboundMessageSize", this.f1762i).d("maxOutboundMessageSize", this.f1763j).d("streamTracerFactories", this.f1760g).toString();
    }
}
