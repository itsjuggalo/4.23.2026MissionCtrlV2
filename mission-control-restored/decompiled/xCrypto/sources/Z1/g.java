package Z1;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0083b f5974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C0083b f5975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5976d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f5977e;

        public static final class a extends C0083b {
            public a() {
                super();
            }
        }

        /* JADX INFO: renamed from: Z1.g$b$b, reason: collision with other inner class name */
        public static class C0083b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f5978a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f5979b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public C0083b f5980c;

            public C0083b() {
            }
        }

        public static boolean l(Object obj) {
            return obj instanceof CharSequence ? ((CharSequence) obj).length() == 0 : obj instanceof Collection ? ((Collection) obj).isEmpty() : obj instanceof Map ? ((Map) obj).isEmpty() : obj instanceof j ? !((j) obj).c() : obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public b a(String str, double d4) {
            return j(str, String.valueOf(d4));
        }

        public b b(String str, int i4) {
            return j(str, String.valueOf(i4));
        }

        public b c(String str, long j4) {
            return j(str, String.valueOf(j4));
        }

        public b d(String str, Object obj) {
            return h(str, obj);
        }

        public b e(String str, boolean z4) {
            return j(str, String.valueOf(z4));
        }

        public final C0083b f() {
            C0083b c0083b = new C0083b();
            this.f5975c.f5980c = c0083b;
            this.f5975c = c0083b;
            return c0083b;
        }

        public final b g(Object obj) {
            f().f5979b = obj;
            return this;
        }

        public final b h(String str, Object obj) {
            C0083b c0083bF = f();
            c0083bF.f5979b = obj;
            c0083bF.f5978a = (String) m.n(str);
            return this;
        }

        public final a i() {
            a aVar = new a();
            this.f5975c.f5980c = aVar;
            this.f5975c = aVar;
            return aVar;
        }

        public final b j(String str, Object obj) {
            a aVarI = i();
            aVarI.f5979b = obj;
            aVarI.f5978a = (String) m.n(str);
            return this;
        }

        public b k(Object obj) {
            return g(obj);
        }

        public b m() {
            this.f5976d = true;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                r7 = this;
                boolean r0 = r7.f5976d
                boolean r1 = r7.f5977e
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = 32
                r2.<init>(r3)
                java.lang.String r3 = r7.f5973a
                r2.append(r3)
                r3 = 123(0x7b, float:1.72E-43)
                r2.append(r3)
                Z1.g$b$b r3 = r7.f5974b
                Z1.g$b$b r3 = r3.f5980c
                java.lang.String r4 = ""
            L1b:
                if (r3 == 0) goto L65
                java.lang.Object r5 = r3.f5979b
                boolean r6 = r3 instanceof Z1.g.b.a
                if (r6 != 0) goto L30
                if (r5 != 0) goto L28
                if (r0 != 0) goto L62
                goto L30
            L28:
                if (r1 == 0) goto L30
                boolean r6 = l(r5)
                if (r6 != 0) goto L62
            L30:
                r2.append(r4)
                java.lang.String r4 = r3.f5978a
                if (r4 == 0) goto L3f
                r2.append(r4)
                r4 = 61
                r2.append(r4)
            L3f:
                if (r5 == 0) goto L5d
                java.lang.Class r4 = r5.getClass()
                boolean r4 = r4.isArray()
                if (r4 == 0) goto L5d
                java.lang.Object[] r4 = new java.lang.Object[]{r5}
                java.lang.String r4 = java.util.Arrays.deepToString(r4)
                int r5 = r4.length()
                r6 = 1
                int r5 = r5 - r6
                r2.append(r4, r6, r5)
                goto L60
            L5d:
                r2.append(r5)
            L60:
                java.lang.String r4 = ", "
            L62:
                Z1.g$b$b r3 = r3.f5980c
                goto L1b
            L65:
                r0 = 125(0x7d, float:1.75E-43)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: Z1.g.b.toString():java.lang.String");
        }

        public b(String str) {
            C0083b c0083b = new C0083b();
            this.f5974b = c0083b;
            this.f5975c = c0083b;
            this.f5976d = false;
            this.f5977e = false;
            this.f5973a = (String) m.n(str);
        }
    }

    public static b a(Class cls) {
        return new b(cls.getSimpleName());
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
