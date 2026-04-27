package v2;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: renamed from: v2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2842h {

    /* JADX INFO: renamed from: v2.h$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0416b f23759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C0416b f23760c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f23761d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f23762e;

        /* JADX INFO: renamed from: v2.h$b$a */
        public static final class a extends C0416b {
            public a() {
                super();
            }
        }

        /* JADX INFO: renamed from: v2.h$b$b, reason: collision with other inner class name */
        public static class C0416b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f23763a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f23764b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public C0416b f23765c;

            public C0416b() {
            }
        }

        public b(String str) {
            C0416b c0416b = new C0416b();
            this.f23759b = c0416b;
            this.f23760c = c0416b;
            this.f23761d = false;
            this.f23762e = false;
            this.f23758a = (String) AbstractC2848n.n(str);
        }

        public static boolean l(Object obj) {
            return obj instanceof CharSequence ? ((CharSequence) obj).length() == 0 : obj instanceof Collection ? ((Collection) obj).isEmpty() : obj instanceof Map ? ((Map) obj).isEmpty() : obj instanceof AbstractC2845k ? !((AbstractC2845k) obj).c() : obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public b a(String str, double d8) {
            return j(str, String.valueOf(d8));
        }

        public b b(String str, int i8) {
            return j(str, String.valueOf(i8));
        }

        public b c(String str, long j8) {
            return j(str, String.valueOf(j8));
        }

        public b d(String str, Object obj) {
            return h(str, obj);
        }

        public b e(String str, boolean z7) {
            return j(str, String.valueOf(z7));
        }

        public final C0416b f() {
            C0416b c0416b = new C0416b();
            this.f23760c.f23765c = c0416b;
            this.f23760c = c0416b;
            return c0416b;
        }

        public final b g(Object obj) {
            f().f23764b = obj;
            return this;
        }

        public final b h(String str, Object obj) {
            C0416b c0416bF = f();
            c0416bF.f23764b = obj;
            c0416bF.f23763a = (String) AbstractC2848n.n(str);
            return this;
        }

        public final a i() {
            a aVar = new a();
            this.f23760c.f23765c = aVar;
            this.f23760c = aVar;
            return aVar;
        }

        public final b j(String str, Object obj) {
            a aVarI = i();
            aVarI.f23764b = obj;
            aVarI.f23763a = (String) AbstractC2848n.n(str);
            return this;
        }

        public b k(Object obj) {
            return g(obj);
        }

        public b m() {
            this.f23761d = true;
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
                boolean r0 = r7.f23761d
                boolean r1 = r7.f23762e
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = 32
                r2.<init>(r3)
                java.lang.String r3 = r7.f23758a
                r2.append(r3)
                r3 = 123(0x7b, float:1.72E-43)
                r2.append(r3)
                v2.h$b$b r3 = r7.f23759b
                v2.h$b$b r3 = r3.f23765c
                java.lang.String r4 = ""
            L1b:
                if (r3 == 0) goto L65
                java.lang.Object r5 = r3.f23764b
                boolean r6 = r3 instanceof v2.AbstractC2842h.b.a
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
                java.lang.String r4 = r3.f23763a
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
                v2.h$b$b r3 = r3.f23765c
                goto L1b
            L65:
                r0 = 125(0x7d, float:1.75E-43)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: v2.AbstractC2842h.b.toString():java.lang.String");
        }
    }

    public static b a(Class cls) {
        return new b(cls.getSimpleName());
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
