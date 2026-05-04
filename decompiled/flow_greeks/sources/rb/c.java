package rb;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import p6.h;
import rb.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f19494k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f19495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f19496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rb.b f19498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f19499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object[][] f19500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f19501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f19502h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f19503i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f19504j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t f19505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Executor f19506b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f19507c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public rb.b f19508d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f19509e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object[][] f19510f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f19511g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f19512h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f19513i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Integer f19514j;

        public final c b() {
            return new c(this);
        }
    }

    /* JADX INFO: renamed from: rb.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0344c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f19516b;

        public C0344c(String str, Object obj) {
            this.f19515a = str;
            this.f19516b = obj;
        }

        public static C0344c b(String str) {
            p6.n.o(str, "debugString");
            return new C0344c(str, null);
        }

        public String toString() {
            return this.f19515a;
        }
    }

    static {
        b bVar = new b();
        bVar.f19510f = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        bVar.f19511g = Collections.EMPTY_LIST;
        f19494k = bVar.b();
    }

    public static b k(c cVar) {
        b bVar = new b();
        bVar.f19505a = cVar.f19495a;
        bVar.f19506b = cVar.f19496b;
        bVar.f19507c = cVar.f19497c;
        bVar.f19508d = cVar.f19498d;
        bVar.f19509e = cVar.f19499e;
        bVar.f19510f = cVar.f19500f;
        bVar.f19511g = cVar.f19501g;
        bVar.f19512h = cVar.f19502h;
        bVar.f19513i = cVar.f19503i;
        bVar.f19514j = cVar.f19504j;
        return bVar;
    }

    public String a() {
        return this.f19497c;
    }

    public String b() {
        return this.f19499e;
    }

    public rb.b c() {
        return this.f19498d;
    }

    public t d() {
        return this.f19495a;
    }

    public Executor e() {
        return this.f19496b;
    }

    public Integer f() {
        return this.f19503i;
    }

    public Integer g() {
        return this.f19504j;
    }

    public Object h(C0344c c0344c) {
        p6.n.o(c0344c, "key");
        int i10 = 0;
        while (true) {
            Object[][] objArr = this.f19500f;
            if (i10 >= objArr.length) {
                return c0344c.f19516b;
            }
            if (c0344c.equals(objArr[i10][0])) {
                return this.f19500f[i10][1];
            }
            i10++;
        }
    }

    public List i() {
        return this.f19501g;
    }

    public boolean j() {
        return Boolean.TRUE.equals(this.f19502h);
    }

    public c l(rb.b bVar) {
        b bVarK = k(this);
        bVarK.f19508d = bVar;
        return bVarK.b();
    }

    public c m(t tVar) {
        b bVarK = k(this);
        bVarK.f19505a = tVar;
        return bVarK.b();
    }

    public c n(long j10, TimeUnit timeUnit) {
        return m(t.a(j10, timeUnit));
    }

    public c o(Executor executor) {
        b bVarK = k(this);
        bVarK.f19506b = executor;
        return bVarK.b();
    }

    public c p(int i10) {
        p6.n.h(i10 >= 0, "invalid maxsize %s", i10);
        b bVarK = k(this);
        bVarK.f19513i = Integer.valueOf(i10);
        return bVarK.b();
    }

    public c q(int i10) {
        p6.n.h(i10 >= 0, "invalid maxsize %s", i10);
        b bVarK = k(this);
        bVarK.f19514j = Integer.valueOf(i10);
        return bVarK.b();
    }

    public c r(C0344c c0344c, Object obj) {
        p6.n.o(c0344c, "key");
        p6.n.o(obj, "value");
        b bVarK = k(this);
        int i10 = 0;
        while (true) {
            Object[][] objArr = this.f19500f;
            if (i10 >= objArr.length) {
                i10 = -1;
                break;
            }
            if (c0344c.equals(objArr[i10][0])) {
                break;
            }
            i10++;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f19500f.length + (i10 == -1 ? 1 : 0), 2);
        bVarK.f19510f = objArr2;
        Object[][] objArr3 = this.f19500f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i10 == -1) {
            bVarK.f19510f[this.f19500f.length] = new Object[]{c0344c, obj};
        } else {
            bVarK.f19510f[i10] = new Object[]{c0344c, obj};
        }
        return bVarK.b();
    }

    public c s(k.a aVar) {
        ArrayList arrayList = new ArrayList(this.f19501g.size() + 1);
        arrayList.addAll(this.f19501g);
        arrayList.add(aVar);
        b bVarK = k(this);
        bVarK.f19511g = Collections.unmodifiableList(arrayList);
        return bVarK.b();
    }

    public c t() {
        b bVarK = k(this);
        bVarK.f19512h = Boolean.TRUE;
        return bVarK.b();
    }

    public String toString() {
        h.b bVarD = p6.h.b(this).d("deadline", this.f19495a).d("authority", this.f19497c).d("callCredentials", this.f19498d);
        Executor executor = this.f19496b;
        return bVarD.d("executor", executor != null ? executor.getClass() : null).d("compressorName", this.f19499e).d("customOptions", Arrays.deepToString(this.f19500f)).e("waitForReady", j()).d("maxInboundMessageSize", this.f19503i).d("maxOutboundMessageSize", this.f19504j).d("streamTracerFactories", this.f19501g).toString();
    }

    public c u() {
        b bVarK = k(this);
        bVarK.f19512h = Boolean.FALSE;
        return bVarK.b();
    }

    public c(b bVar) {
        this.f19495a = bVar.f19505a;
        this.f19496b = bVar.f19506b;
        this.f19497c = bVar.f19507c;
        this.f19498d = bVar.f19508d;
        this.f19499e = bVar.f19509e;
        this.f19500f = bVar.f19510f;
        this.f19501g = bVar.f19511g;
        this.f19502h = bVar.f19512h;
        this.f19503i = bVar.f19513i;
        this.f19504j = bVar.f19514j;
    }
}
