package r5;

import H2.g;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import r5.AbstractC2595k;

/* JADX INFO: renamed from: r5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2587c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C2587c f22630k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2603t f22631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f22632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC2586b f22634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object[][] f22636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f22637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f22638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f22639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f22640j;

    /* JADX INFO: renamed from: r5.c$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C2603t f22641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Executor f22642b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f22643c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AbstractC2586b f22644d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f22645e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object[][] f22646f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f22647g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f22648h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f22649i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Integer f22650j;

        public final C2587c b() {
            return new C2587c(this);
        }
    }

    /* JADX INFO: renamed from: r5.c$c, reason: collision with other inner class name */
    public static final class C0351c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f22652b;

        public C0351c(String str, Object obj) {
            this.f22651a = str;
            this.f22652b = obj;
        }

        public static C0351c b(String str) {
            H2.m.o(str, "debugString");
            return new C0351c(str, null);
        }

        public String toString() {
            return this.f22651a;
        }
    }

    static {
        b bVar = new b();
        bVar.f22646f = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        bVar.f22647g = Collections.emptyList();
        f22630k = bVar.b();
    }

    public static b k(C2587c c2587c) {
        b bVar = new b();
        bVar.f22641a = c2587c.f22631a;
        bVar.f22642b = c2587c.f22632b;
        bVar.f22643c = c2587c.f22633c;
        bVar.f22644d = c2587c.f22634d;
        bVar.f22645e = c2587c.f22635e;
        bVar.f22646f = c2587c.f22636f;
        bVar.f22647g = c2587c.f22637g;
        bVar.f22648h = c2587c.f22638h;
        bVar.f22649i = c2587c.f22639i;
        bVar.f22650j = c2587c.f22640j;
        return bVar;
    }

    public String a() {
        return this.f22633c;
    }

    public String b() {
        return this.f22635e;
    }

    public AbstractC2586b c() {
        return this.f22634d;
    }

    public C2603t d() {
        return this.f22631a;
    }

    public Executor e() {
        return this.f22632b;
    }

    public Integer f() {
        return this.f22639i;
    }

    public Integer g() {
        return this.f22640j;
    }

    public Object h(C0351c c0351c) {
        H2.m.o(c0351c, SubscriberAttributeKt.JSON_NAME_KEY);
        int i7 = 0;
        while (true) {
            Object[][] objArr = this.f22636f;
            if (i7 >= objArr.length) {
                return c0351c.f22652b;
            }
            if (c0351c.equals(objArr[i7][0])) {
                return this.f22636f[i7][1];
            }
            i7++;
        }
    }

    public List i() {
        return this.f22637g;
    }

    public boolean j() {
        return Boolean.TRUE.equals(this.f22638h);
    }

    public C2587c l(AbstractC2586b abstractC2586b) {
        b bVarK = k(this);
        bVarK.f22644d = abstractC2586b;
        return bVarK.b();
    }

    public C2587c m(C2603t c2603t) {
        b bVarK = k(this);
        bVarK.f22641a = c2603t;
        return bVarK.b();
    }

    public C2587c n(Executor executor) {
        b bVarK = k(this);
        bVarK.f22642b = executor;
        return bVarK.b();
    }

    public C2587c o(int i7) {
        H2.m.h(i7 >= 0, "invalid maxsize %s", i7);
        b bVarK = k(this);
        bVarK.f22649i = Integer.valueOf(i7);
        return bVarK.b();
    }

    public C2587c p(int i7) {
        H2.m.h(i7 >= 0, "invalid maxsize %s", i7);
        b bVarK = k(this);
        bVarK.f22650j = Integer.valueOf(i7);
        return bVarK.b();
    }

    public C2587c q(C0351c c0351c, Object obj) {
        H2.m.o(c0351c, SubscriberAttributeKt.JSON_NAME_KEY);
        H2.m.o(obj, "value");
        b bVarK = k(this);
        int i7 = 0;
        while (true) {
            Object[][] objArr = this.f22636f;
            if (i7 >= objArr.length) {
                i7 = -1;
                break;
            }
            if (c0351c.equals(objArr[i7][0])) {
                break;
            }
            i7++;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f22636f.length + (i7 == -1 ? 1 : 0), 2);
        bVarK.f22646f = objArr2;
        Object[][] objArr3 = this.f22636f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i7 == -1) {
            bVarK.f22646f[this.f22636f.length] = new Object[]{c0351c, obj};
        } else {
            bVarK.f22646f[i7] = new Object[]{c0351c, obj};
        }
        return bVarK.b();
    }

    public C2587c r(AbstractC2595k.a aVar) {
        ArrayList arrayList = new ArrayList(this.f22637g.size() + 1);
        arrayList.addAll(this.f22637g);
        arrayList.add(aVar);
        b bVarK = k(this);
        bVarK.f22647g = Collections.unmodifiableList(arrayList);
        return bVarK.b();
    }

    public C2587c s() {
        b bVarK = k(this);
        bVarK.f22648h = Boolean.TRUE;
        return bVarK.b();
    }

    public C2587c t() {
        b bVarK = k(this);
        bVarK.f22648h = Boolean.FALSE;
        return bVarK.b();
    }

    public String toString() {
        g.b bVarD = H2.g.b(this).d("deadline", this.f22631a).d("authority", this.f22633c).d("callCredentials", this.f22634d);
        Executor executor = this.f22632b;
        return bVarD.d("executor", executor != null ? executor.getClass() : null).d("compressorName", this.f22635e).d("customOptions", Arrays.deepToString(this.f22636f)).e("waitForReady", j()).d("maxInboundMessageSize", this.f22639i).d("maxOutboundMessageSize", this.f22640j).d("streamTracerFactories", this.f22637g).toString();
    }

    public C2587c(b bVar) {
        this.f22631a = bVar.f22641a;
        this.f22632b = bVar.f22642b;
        this.f22633c = bVar.f22643c;
        this.f22634d = bVar.f22644d;
        this.f22635e = bVar.f22645e;
        this.f22636f = bVar.f22646f;
        this.f22637g = bVar.f22647g;
        this.f22638h = bVar.f22648h;
        this.f22639i = bVar.f22649i;
        this.f22640j = bVar.f22650j;
    }
}
