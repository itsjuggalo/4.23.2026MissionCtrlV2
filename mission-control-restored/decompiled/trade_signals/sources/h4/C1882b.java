package h4;

import android.util.Log;
import h4.InterfaceC1883c;
import h7.a;
import h7.g;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2707e;
import u5.AbstractC2777d;

/* JADX INFO: renamed from: h4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1882b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1882b f18671a = new C1882b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f18672b = Collections.synchronizedMap(new LinkedHashMap());

    /* JADX INFO: renamed from: h4.b$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h7.a f18673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC1883c f18674b;

        public a(h7.a mutex, InterfaceC1883c interfaceC1883c) {
            AbstractC2304t.f(mutex, "mutex");
            this.f18673a = mutex;
            this.f18674b = interfaceC1883c;
        }

        public final h7.a a() {
            return this.f18673a;
        }

        public final InterfaceC1883c b() {
            return this.f18674b;
        }

        public final void c(InterfaceC1883c interfaceC1883c) {
            this.f18674b = interfaceC1883c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC2304t.b(this.f18673a, aVar.f18673a) && AbstractC2304t.b(this.f18674b, aVar.f18674b);
        }

        public int hashCode() {
            int iHashCode = this.f18673a.hashCode() * 31;
            InterfaceC1883c interfaceC1883c = this.f18674b;
            return iHashCode + (interfaceC1883c == null ? 0 : interfaceC1883c.hashCode());
        }

        public String toString() {
            return "Dependency(mutex=" + this.f18673a + ", subscriber=" + this.f18674b + ')';
        }

        public /* synthetic */ a(h7.a aVar, InterfaceC1883c interfaceC1883c, int i8, AbstractC2296k abstractC2296k) {
            this(aVar, (i8 & 2) != 0 ? null : interfaceC1883c);
        }
    }

    /* JADX INFO: renamed from: h4.b$b, reason: collision with other inner class name */
    public static final class C0315b extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f18675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f18676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f18677c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f18678d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f18679e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f18680f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public /* synthetic */ Object f18681g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f18683i;

        public C0315b(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f18681g = obj;
            this.f18683i |= Integer.MIN_VALUE;
            return C1882b.this.c(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(InterfaceC1883c.a subscriberName) {
        StringBuilder sb;
        String str;
        AbstractC2304t.f(subscriberName, "subscriberName");
        Map dependencies = f18672b;
        if (dependencies.containsKey(subscriberName)) {
            sb = new StringBuilder();
            sb.append("Dependency ");
            sb.append(subscriberName);
            str = " already added.";
        } else {
            AbstractC2304t.e(dependencies, "dependencies");
            dependencies.put(subscriberName, new a(g.a(true), null, 2, 0 == true ? 1 : 0));
            sb = new StringBuilder();
            sb.append("Dependency to ");
            sb.append(subscriberName);
            str = " added.";
        }
        sb.append(str);
        Log.d("FirebaseSessions", sb.toString());
    }

    public static final void e(InterfaceC1883c subscriber) {
        AbstractC2304t.f(subscriber, "subscriber");
        InterfaceC1883c.a aVarB = subscriber.b();
        a aVarB2 = f18671a.b(aVarB);
        if (aVarB2.b() != null) {
            Log.d("FirebaseSessions", "Subscriber " + aVarB + " already registered.");
            return;
        }
        aVarB2.c(subscriber);
        Log.d("FirebaseSessions", "Subscriber " + aVarB + " registered.");
        a.C0316a.b(aVarB2.a(), null, 1, null);
    }

    public final a b(InterfaceC1883c.a aVar) {
        Map dependencies = f18672b;
        AbstractC2304t.e(dependencies, "dependencies");
        Object obj = dependencies.get(aVar);
        if (obj != null) {
            AbstractC2304t.e(obj, "getOrElse(...)");
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
    public final java.lang.Object c(s5.InterfaceC2707e r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof h4.C1882b.C0315b
            if (r0 == 0) goto L13
            r0 = r11
            h4.b$b r0 = (h4.C1882b.C0315b) r0
            int r1 = r0.f18683i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f18683i = r1
            goto L18
        L13:
            h4.b$b r0 = new h4.b$b
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f18681g
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f18683i
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r2 = r0.f18680f
            java.lang.Object r5 = r0.f18679e
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r0.f18678d
            h7.a r6 = (h7.a) r6
            java.lang.Object r7 = r0.f18677c
            h4.c$a r7 = (h4.InterfaceC1883c.a) r7
            java.lang.Object r8 = r0.f18676b
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.f18675a
            java.util.Map r9 = (java.util.Map) r9
            o5.AbstractC2491s.b(r11)
            goto La0
        L40:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L48:
            o5.AbstractC2491s.b(r11)
            java.util.Map r11 = h4.C1882b.f18672b
            java.lang.String r2 = "dependencies"
            kotlin.jvm.internal.AbstractC2304t.e(r11, r2)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            int r5 = r11.size()
            int r5 = p5.L.d(r5)
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
            h4.c$a r7 = (h4.InterfaceC1883c.a) r7
            java.lang.Object r11 = r11.getValue()
            h4.b$a r11 = (h4.C1882b.a) r11
            h7.a r6 = r11.a()
            r0.f18675a = r5
            r0.f18676b = r8
            r0.f18677c = r7
            r0.f18678d = r6
            r0.f18679e = r5
            r0.f18680f = r2
            r0.f18683i = r3
            java.lang.Object r11 = r6.a(r4, r0)
            if (r11 != r1) goto L9f
            return r1
        L9f:
            r9 = r5
        La0:
            h4.b r11 = h4.C1882b.f18671a     // Catch: java.lang.Throwable -> Lae
            h4.c r11 = r11.d(r7)     // Catch: java.lang.Throwable -> Lae
            r6.d(r4)
            r5.put(r2, r11)
            r5 = r9
            goto L69
        Lae:
            r11 = move-exception
            r6.d(r4)
            throw r11
        Lb3:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.C1882b.c(s5.e):java.lang.Object");
    }

    public final InterfaceC1883c d(InterfaceC1883c.a subscriberName) {
        AbstractC2304t.f(subscriberName, "subscriberName");
        InterfaceC1883c interfaceC1883cB = b(subscriberName).b();
        if (interfaceC1883cB != null) {
            return interfaceC1883cB;
        }
        throw new IllegalStateException("Subscriber " + subscriberName + " has not been registered.");
    }
}
