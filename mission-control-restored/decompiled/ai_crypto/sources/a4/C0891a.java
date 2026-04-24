package a4;

import J5.d;
import a4.InterfaceC0892b;
import android.util.Log;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.a;
import k6.c;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: a4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0891a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0891a f6297a = new C0891a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f6298b = Collections.synchronizedMap(new LinkedHashMap());

    /* JADX INFO: renamed from: a4.a$a, reason: collision with other inner class name */
    public static final class C0113a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k6.a f6299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC0892b f6300b;

        public C0113a(k6.a mutex, InterfaceC0892b interfaceC0892b) {
            r.f(mutex, "mutex");
            this.f6299a = mutex;
            this.f6300b = interfaceC0892b;
        }

        public final k6.a a() {
            return this.f6299a;
        }

        public final InterfaceC0892b b() {
            return this.f6300b;
        }

        public final void c(InterfaceC0892b interfaceC0892b) {
            this.f6300b = interfaceC0892b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0113a)) {
                return false;
            }
            C0113a c0113a = (C0113a) obj;
            return r.b(this.f6299a, c0113a.f6299a) && r.b(this.f6300b, c0113a.f6300b);
        }

        public int hashCode() {
            int iHashCode = this.f6299a.hashCode() * 31;
            InterfaceC0892b interfaceC0892b = this.f6300b;
            return iHashCode + (interfaceC0892b == null ? 0 : interfaceC0892b.hashCode());
        }

        public String toString() {
            return "Dependency(mutex=" + this.f6299a + ", subscriber=" + this.f6300b + ')';
        }

        public /* synthetic */ C0113a(k6.a aVar, InterfaceC0892b interfaceC0892b, int i7, AbstractC2148j abstractC2148j) {
            this(aVar, (i7 & 2) != 0 ? null : interfaceC0892b);
        }
    }

    /* JADX INFO: renamed from: a4.a$b */
    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f6302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f6303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f6304d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f6305e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f6306f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public /* synthetic */ Object f6307g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f6309i;

        public b(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f6307g = obj;
            this.f6309i |= Integer.MIN_VALUE;
            return C0891a.this.c(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(InterfaceC0892b.a subscriberName) {
        r.f(subscriberName, "subscriberName");
        if (subscriberName == InterfaceC0892b.a.PERFORMANCE) {
            throw new IllegalArgumentException("Incompatible versions of Firebase Perf and Firebase Sessions.\nA safe combination would be:\n  firebase-sessions:1.1.0\n  firebase-crashlytics:18.5.0\n  firebase-perf:20.5.0\nFor more information contact Firebase Support.");
        }
        Map dependencies = f6298b;
        if (dependencies.containsKey(subscriberName)) {
            Log.d("SessionsDependencies", "Dependency " + subscriberName + " already added.");
            return;
        }
        r.e(dependencies, "dependencies");
        dependencies.put(subscriberName, new C0113a(c.a(true), null, 2, 0 == true ? 1 : 0));
        Log.d("SessionsDependencies", "Dependency to " + subscriberName + " added.");
    }

    public static final void e(InterfaceC0892b subscriber) {
        r.f(subscriber, "subscriber");
        InterfaceC0892b.a aVarC = subscriber.c();
        C0113a c0113aB = f6297a.b(aVarC);
        if (c0113aB.b() != null) {
            Log.d("SessionsDependencies", "Subscriber " + aVarC + " already registered.");
            return;
        }
        c0113aB.c(subscriber);
        Log.d("SessionsDependencies", "Subscriber " + aVarC + " registered.");
        a.C0298a.b(c0113aB.a(), null, 1, null);
    }

    public final C0113a b(InterfaceC0892b.a aVar) {
        Map dependencies = f6298b;
        r.e(dependencies, "dependencies");
        Object obj = dependencies.get(aVar);
        if (obj != null) {
            r.e(obj, "dependencies.getOrElse(s…load time.\"\n      )\n    }");
            return (C0113a) obj;
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
    public final java.lang.Object c(H5.d r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof a4.C0891a.b
            if (r0 == 0) goto L13
            r0 = r11
            a4.a$b r0 = (a4.C0891a.b) r0
            int r1 = r0.f6309i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6309i = r1
            goto L18
        L13:
            a4.a$b r0 = new a4.a$b
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f6307g
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f6309i
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r2 = r0.f6306f
            java.lang.Object r5 = r0.f6305e
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r0.f6304d
            k6.a r6 = (k6.a) r6
            java.lang.Object r7 = r0.f6303c
            a4.b$a r7 = (a4.InterfaceC0892b.a) r7
            java.lang.Object r8 = r0.f6302b
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.f6301a
            java.util.Map r9 = (java.util.Map) r9
            E5.q.b(r11)
            goto La0
        L40:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L48:
            E5.q.b(r11)
            java.util.Map r11 = a4.C0891a.f6298b
            java.lang.String r2 = "dependencies"
            kotlin.jvm.internal.r.e(r11, r2)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            int r5 = r11.size()
            int r5 = F5.I.b(r5)
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
            a4.b$a r7 = (a4.InterfaceC0892b.a) r7
            java.lang.Object r11 = r11.getValue()
            a4.a$a r11 = (a4.C0891a.C0113a) r11
            k6.a r6 = r11.a()
            r0.f6301a = r5
            r0.f6302b = r8
            r0.f6303c = r7
            r0.f6304d = r6
            r0.f6305e = r5
            r0.f6306f = r2
            r0.f6309i = r3
            java.lang.Object r11 = r6.d(r4, r0)
            if (r11 != r1) goto L9f
            return r1
        L9f:
            r9 = r5
        La0:
            a4.a r11 = a4.C0891a.f6297a     // Catch: java.lang.Throwable -> Lae
            a4.b r11 = r11.d(r7)     // Catch: java.lang.Throwable -> Lae
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
        throw new UnsupportedOperationException("Method not decompiled: a4.C0891a.c(H5.d):java.lang.Object");
    }

    public final InterfaceC0892b d(InterfaceC0892b.a subscriberName) {
        r.f(subscriberName, "subscriberName");
        InterfaceC0892b interfaceC0892bB = b(subscriberName).b();
        if (interfaceC0892bB != null) {
            return interfaceC0892bB;
        }
        throw new IllegalStateException("Subscriber " + subscriberName + " has not been registered.");
    }
}
