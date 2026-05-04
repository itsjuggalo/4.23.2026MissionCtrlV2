package p6;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0311b f18319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C0311b f18320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f18321d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f18322e;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends C0311b {
            public a() {
                super();
            }
        }

        /* JADX INFO: renamed from: p6.h$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class C0311b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f18323a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f18324b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public C0311b f18325c;

            public C0311b() {
            }
        }

        public static boolean l(Object obj) {
            return obj instanceof CharSequence ? ((CharSequence) obj).length() == 0 : obj instanceof Collection ? ((Collection) obj).isEmpty() : obj instanceof Map ? ((Map) obj).isEmpty() : obj instanceof k ? !((k) obj).c() : obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public b a(String str, double d10) {
            return j(str, String.valueOf(d10));
        }

        public b b(String str, int i10) {
            return j(str, String.valueOf(i10));
        }

        public b c(String str, long j10) {
            return j(str, String.valueOf(j10));
        }

        public b d(String str, Object obj) {
            return h(str, obj);
        }

        public b e(String str, boolean z10) {
            return j(str, String.valueOf(z10));
        }

        public final C0311b f() {
            C0311b c0311b = new C0311b();
            this.f18320c.f18325c = c0311b;
            this.f18320c = c0311b;
            return c0311b;
        }

        public final b g(Object obj) {
            f().f18324b = obj;
            return this;
        }

        public final b h(String str, Object obj) {
            C0311b c0311bF = f();
            c0311bF.f18324b = obj;
            c0311bF.f18323a = (String) n.n(str);
            return this;
        }

        public final a i() {
            a aVar = new a();
            this.f18320c.f18325c = aVar;
            this.f18320c = aVar;
            return aVar;
        }

        public final b j(String str, Object obj) {
            a aVarI = i();
            aVarI.f18324b = obj;
            aVarI.f18323a = (String) n.n(str);
            return this;
        }

        public b k(Object obj) {
            return g(obj);
        }

        public b m() {
            this.f18321d = true;
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
                boolean r0 = r7.f18321d
                boolean r1 = r7.f18322e
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = 32
                r2.<init>(r3)
                java.lang.String r3 = r7.f18318a
                r2.append(r3)
                r3 = 123(0x7b, float:1.72E-43)
                r2.append(r3)
                p6.h$b$b r3 = r7.f18319b
                p6.h$b$b r3 = r3.f18325c
                java.lang.String r4 = ""
            L1b:
                if (r3 == 0) goto L65
                java.lang.Object r5 = r3.f18324b
                boolean r6 = r3 instanceof p6.h.b.a
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
                java.lang.String r4 = r3.f18323a
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
                p6.h$b$b r3 = r3.f18325c
                goto L1b
            L65:
                r0 = 125(0x7d, float:1.75E-43)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p6.h.b.toString():java.lang.String");
        }

        public b(String str) {
            C0311b c0311b = new C0311b();
            this.f18319b = c0311b;
            this.f18320c = c0311b;
            this.f18321d = false;
            this.f18322e = false;
            this.f18318a = (String) n.n(str);
        }
    }

    public static b a(Class cls) {
        return new b(cls.getSimpleName());
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
