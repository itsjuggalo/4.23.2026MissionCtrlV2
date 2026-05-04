package va;

import android.util.Log;
import gd.e;
import id.d;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import va.c;
import wg.a;
import wg.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f23206a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f23207b = Collections.synchronizedMap(new LinkedHashMap());

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final wg.a f23208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f23209b;

        public a(wg.a mutex, c cVar) {
            t.f(mutex, "mutex");
            this.f23208a = mutex;
            this.f23209b = cVar;
        }

        public final wg.a a() {
            return this.f23208a;
        }

        public final c b() {
            return this.f23209b;
        }

        public final void c(c cVar) {
            this.f23209b = cVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return t.b(this.f23208a, aVar.f23208a) && t.b(this.f23209b, aVar.f23209b);
        }

        public int hashCode() {
            int iHashCode = this.f23208a.hashCode() * 31;
            c cVar = this.f23209b;
            return iHashCode + (cVar == null ? 0 : cVar.hashCode());
        }

        public String toString() {
            return "Dependency(mutex=" + this.f23208a + ", subscriber=" + this.f23209b + ')';
        }

        public /* synthetic */ a(wg.a aVar, c cVar, int i10, k kVar) {
            this(aVar, (i10 & 2) != 0 ? null : cVar);
        }
    }

    /* JADX INFO: renamed from: va.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0402b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f23210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f23211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f23212c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f23213d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f23214e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f23215f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public /* synthetic */ Object f23216g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f23218i;

        public C0402b(e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f23216g = obj;
            this.f23218i |= Integer.MIN_VALUE;
            return b.this.c(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(c.a subscriberName) {
        t.f(subscriberName, "subscriberName");
        Map dependencies = f23207b;
        if (dependencies.containsKey(subscriberName)) {
            Log.d("FirebaseSessions", "Dependency " + subscriberName + " already added.");
            return;
        }
        t.e(dependencies, "dependencies");
        dependencies.put(subscriberName, new a(g.a(true), null, 2, 0 == true ? 1 : 0));
        Log.d("FirebaseSessions", "Dependency to " + subscriberName + " added.");
    }

    public static final void e(c subscriber) {
        t.f(subscriber, "subscriber");
        c.a aVarB = subscriber.b();
        a aVarB2 = f23206a.b(aVarB);
        if (aVarB2.b() != null) {
            Log.d("FirebaseSessions", "Subscriber " + aVarB + " already registered.");
            return;
        }
        aVarB2.c(subscriber);
        Log.d("FirebaseSessions", "Subscriber " + aVarB + " registered.");
        a.C0420a.b(aVarB2.a(), null, 1, null);
    }

    public final a b(c.a aVar) {
        Map dependencies = f23207b;
        t.e(dependencies, "dependencies");
        Object obj = dependencies.get(aVar);
        if (obj != null) {
            t.e(obj, "getOrElse(...)");
            return (a) obj;
        }
        throw new IllegalStateException("Cannot get dependency " + aVar + ". Dependencies should be added at class load time.");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x009f -> B:27:0x00a0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(gd.e r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof va.b.C0402b
            if (r0 == 0) goto L13
            r0 = r11
            va.b$b r0 = (va.b.C0402b) r0
            int r1 = r0.f23218i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23218i = r1
            goto L18
        L13:
            va.b$b r0 = new va.b$b
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f23216g
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f23218i
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r2 = r0.f23215f
            java.lang.Object r5 = r0.f23214e
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r0.f23213d
            wg.a r6 = (wg.a) r6
            java.lang.Object r7 = r0.f23212c
            va.c$a r7 = (va.c.a) r7
            java.lang.Object r8 = r0.f23211b
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.f23210a
            java.util.Map r9 = (java.util.Map) r9
            cd.s.b(r11)
            goto La0
        L40:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L48:
            cd.s.b(r11)
            java.util.Map r11 = va.b.f23207b
            java.lang.String r2 = "dependencies"
            kotlin.jvm.internal.t.e(r11, r2)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            int r5 = r11.size()
            int r5 = dd.n0.d(r5)
            r2.<init>(r5)
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
            r8 = r11
            r5 = r2
        L69:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto Lb3
            java.lang.Object r11 = r8.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r2 = r11.getKey()
            java.lang.Object r6 = r11.getKey()
            r7 = r6
            va.c$a r7 = (va.c.a) r7
            java.lang.Object r11 = r11.getValue()
            va.b$a r11 = (va.b.a) r11
            wg.a r6 = r11.a()
            r0.f23210a = r5
            r0.f23211b = r8
            r0.f23212c = r7
            r0.f23213d = r6
            r0.f23214e = r5
            r0.f23215f = r2
            r0.f23218i = r3
            java.lang.Object r11 = r6.d(r4, r0)
            if (r11 != r1) goto L9f
            return r1
        L9f:
            r9 = r5
        La0:
            va.b r11 = va.b.f23206a     // Catch: java.lang.Throwable -> Lae
            va.c r11 = r11.d(r7)     // Catch: java.lang.Throwable -> Lae
            r6.c(r4)
            r5.put(r2, r11)
            r5 = r9
            goto L69
        Lae:
            r11 = move-exception
            r6.c(r4)
            throw r11
        Lb3:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: va.b.c(gd.e):java.lang.Object");
    }

    public final c d(c.a subscriberName) {
        t.f(subscriberName, "subscriberName");
        c cVarB = b(subscriberName).b();
        if (cVarB != null) {
            return cVarB;
        }
        throw new IllegalStateException("Subscriber " + subscriberName + " has not been registered.");
    }
}
