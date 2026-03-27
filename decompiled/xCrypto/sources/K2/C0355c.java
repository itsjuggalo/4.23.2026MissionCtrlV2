package K2;

import K2.AbstractC0363k;
import Z1.g;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: K2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0355c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0355c f1140k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0371t f1141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f1142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC0354b f1144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object[][] f1146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f1147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f1148h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f1149i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f1150j;

    /* JADX INFO: renamed from: K2.c$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C0371t f1151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Executor f1152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f1153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AbstractC0354b f1154d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f1155e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object[][] f1156f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f1157g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f1158h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f1159i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Integer f1160j;

        public final C0355c b() {
            return new C0355c(this);
        }
    }

    /* JADX INFO: renamed from: K2.c$c, reason: collision with other inner class name */
    public static final class C0031c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f1162b;

        public C0031c(String str, Object obj) {
            this.f1161a = str;
            this.f1162b = obj;
        }

        public static C0031c b(String str) {
            Z1.m.o(str, "debugString");
            return new C0031c(str, null);
        }

        public String toString() {
            return this.f1161a;
        }
    }

    static {
        b bVar = new b();
        bVar.f1156f = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        bVar.f1157g = Collections.EMPTY_LIST;
        f1140k = bVar.b();
    }

    public static b k(C0355c c0355c) {
        b bVar = new b();
        bVar.f1151a = c0355c.f1141a;
        bVar.f1152b = c0355c.f1142b;
        bVar.f1153c = c0355c.f1143c;
        bVar.f1154d = c0355c.f1144d;
        bVar.f1155e = c0355c.f1145e;
        bVar.f1156f = c0355c.f1146f;
        bVar.f1157g = c0355c.f1147g;
        bVar.f1158h = c0355c.f1148h;
        bVar.f1159i = c0355c.f1149i;
        bVar.f1160j = c0355c.f1150j;
        return bVar;
    }

    public String a() {
        return this.f1143c;
    }

    public String b() {
        return this.f1145e;
    }

    public AbstractC0354b c() {
        return this.f1144d;
    }

    public C0371t d() {
        return this.f1141a;
    }

    public Executor e() {
        return this.f1142b;
    }

    public Integer f() {
        return this.f1149i;
    }

    public Integer g() {
        return this.f1150j;
    }

    public Object h(C0031c c0031c) {
        Z1.m.o(c0031c, "key");
        int i4 = 0;
        while (true) {
            Object[][] objArr = this.f1146f;
            if (i4 >= objArr.length) {
                return c0031c.f1162b;
            }
            if (c0031c.equals(objArr[i4][0])) {
                return this.f1146f[i4][1];
            }
            i4++;
        }
    }

    public List i() {
        return this.f1147g;
    }

    public boolean j() {
        return Boolean.TRUE.equals(this.f1148h);
    }

    public C0355c l(AbstractC0354b abstractC0354b) {
        b bVarK = k(this);
        bVarK.f1154d = abstractC0354b;
        return bVarK.b();
    }

    public C0355c m(C0371t c0371t) {
        b bVarK = k(this);
        bVarK.f1151a = c0371t;
        return bVarK.b();
    }

    public C0355c n(Executor executor) {
        b bVarK = k(this);
        bVarK.f1152b = executor;
        return bVarK.b();
    }

    public C0355c o(int i4) {
        Z1.m.h(i4 >= 0, "invalid maxsize %s", i4);
        b bVarK = k(this);
        bVarK.f1159i = Integer.valueOf(i4);
        return bVarK.b();
    }

    public C0355c p(int i4) {
        Z1.m.h(i4 >= 0, "invalid maxsize %s", i4);
        b bVarK = k(this);
        bVarK.f1160j = Integer.valueOf(i4);
        return bVarK.b();
    }

    public C0355c q(C0031c c0031c, Object obj) {
        Z1.m.o(c0031c, "key");
        Z1.m.o(obj, "value");
        b bVarK = k(this);
        int i4 = 0;
        while (true) {
            Object[][] objArr = this.f1146f;
            if (i4 >= objArr.length) {
                i4 = -1;
                break;
            }
            if (c0031c.equals(objArr[i4][0])) {
                break;
            }
            i4++;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f1146f.length + (i4 == -1 ? 1 : 0), 2);
        bVarK.f1156f = objArr2;
        Object[][] objArr3 = this.f1146f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i4 == -1) {
            bVarK.f1156f[this.f1146f.length] = new Object[]{c0031c, obj};
        } else {
            bVarK.f1156f[i4] = new Object[]{c0031c, obj};
        }
        return bVarK.b();
    }

    public C0355c r(AbstractC0363k.a aVar) {
        ArrayList arrayList = new ArrayList(this.f1147g.size() + 1);
        arrayList.addAll(this.f1147g);
        arrayList.add(aVar);
        b bVarK = k(this);
        bVarK.f1157g = Collections.unmodifiableList(arrayList);
        return bVarK.b();
    }

    public C0355c s() {
        b bVarK = k(this);
        bVarK.f1158h = Boolean.TRUE;
        return bVarK.b();
    }

    public C0355c t() {
        b bVarK = k(this);
        bVarK.f1158h = Boolean.FALSE;
        return bVarK.b();
    }

    public String toString() {
        g.b bVarD = Z1.g.b(this).d("deadline", this.f1141a).d("authority", this.f1143c).d("callCredentials", this.f1144d);
        Executor executor = this.f1142b;
        return bVarD.d("executor", executor != null ? executor.getClass() : null).d("compressorName", this.f1145e).d("customOptions", Arrays.deepToString(this.f1146f)).e("waitForReady", j()).d("maxInboundMessageSize", this.f1149i).d("maxOutboundMessageSize", this.f1150j).d("streamTracerFactories", this.f1147g).toString();
    }

    public C0355c(b bVar) {
        this.f1141a = bVar.f1151a;
        this.f1142b = bVar.f1152b;
        this.f1143c = bVar.f1153c;
        this.f1144d = bVar.f1154d;
        this.f1145e = bVar.f1155e;
        this.f1146f = bVar.f1156f;
        this.f1147g = bVar.f1157g;
        this.f1148h = bVar.f1158h;
        this.f1149i = bVar.f1159i;
        this.f1150j = bVar.f1160j;
    }
}
