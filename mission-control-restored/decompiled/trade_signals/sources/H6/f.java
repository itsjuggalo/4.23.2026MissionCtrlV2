package H6;

import V6.C;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public class f implements H6.n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f3978d = C.L0(f.class.getCanonicalName(), ".", "");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final H6.n f3979e = new a("NO_LOCKS", InterfaceC0049f.f3988a, H6.e.f3977b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H6.k f3980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0049f f3981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3982c;

    public static class a extends f {
        public a(String str, InterfaceC0049f interfaceC0049f, H6.k kVar) {
            super(str, interfaceC0049f, kVar, null);
        }

        public static /* synthetic */ void j(int i8) {
            String str = i8 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i8 != 1 ? 3 : 2];
            if (i8 != 1) {
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i8 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i8 != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            String str2 = String.format(str, objArr);
            if (i8 == 1) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // H6.f
        public o p(String str, Object obj) {
            if (str == null) {
                j(0);
            }
            o oVarA = o.a();
            if (oVarA == null) {
                j(1);
            }
            return oVarA;
        }
    }

    public class b extends j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f3983d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar, Function0 function0, Object obj) {
            super(fVar, function0);
            this.f3983d = obj;
        }

        private static /* synthetic */ void a(int i8) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
        }

        @Override // H6.f.h
        public o c(boolean z7) {
            o oVarD = o.d(this.f3983d);
            if (oVarD == null) {
                a(0);
            }
            return oVarD;
        }
    }

    public class c extends k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ B5.k f3985e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ B5.k f3986f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f fVar, Function0 function0, B5.k kVar, B5.k kVar2) {
            super(fVar, function0);
            this.f3985e = kVar;
            this.f3986f = kVar2;
        }

        private static /* synthetic */ void a(int i8) {
            String str = i8 != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i8 != 2 ? 2 : 3];
            if (i8 != 2) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            } else {
                objArr[0] = "value";
            }
            if (i8 != 2) {
                objArr[1] = "recursionDetected";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            }
            if (i8 == 2) {
                objArr[2] = "doPostCompute";
            }
            String str2 = String.format(str, objArr);
            if (i8 == 2) {
                throw new IllegalArgumentException(str2);
            }
        }

        @Override // H6.f.h
        public o c(boolean z7) {
            B5.k kVar = this.f3985e;
            if (kVar == null) {
                o oVarC = super.c(z7);
                if (oVarC == null) {
                    a(0);
                }
                return oVarC;
            }
            o oVarD = o.d(kVar.invoke(Boolean.valueOf(z7)));
            if (oVarD == null) {
                a(1);
            }
            return oVarD;
        }

        @Override // H6.f.i
        public void g(Object obj) {
            if (obj == null) {
                a(2);
            }
            this.f3986f.invoke(obj);
        }
    }

    public static class d extends e implements H6.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(f fVar, ConcurrentMap concurrentMap) {
            super(fVar, concurrentMap, null);
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
        }

        private static /* synthetic */ void b(int i8) {
            String str = i8 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i8 != 3 ? 3 : 2];
            if (i8 == 1) {
                objArr[0] = "map";
            } else if (i8 == 2) {
                objArr[0] = "computation";
            } else if (i8 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i8 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i8 == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i8 != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i8 == 3) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // H6.f.e, H6.a
        public Object a(Object obj, Function0 function0) {
            if (function0 == null) {
                b(2);
            }
            Object objA = super.a(obj, function0);
            if (objA == null) {
                b(3);
            }
            return objA;
        }

        public /* synthetic */ d(f fVar, ConcurrentMap concurrentMap, a aVar) {
            this(fVar, concurrentMap);
        }
    }

    public static class e extends l implements H6.b {

        public class a implements B5.k {
            @Override // B5.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Object invoke(g gVar) {
                return gVar.f3990b.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(f fVar, ConcurrentMap concurrentMap) {
            super(fVar, concurrentMap, new a());
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
        }

        private static /* synthetic */ void b(int i8) {
            Object[] objArr = new Object[3];
            if (i8 == 1) {
                objArr[0] = "map";
            } else if (i8 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i8 != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public Object a(Object obj, Function0 function0) {
            if (function0 == null) {
                b(2);
            }
            return invoke(new g(obj, function0));
        }

        public /* synthetic */ e(f fVar, ConcurrentMap concurrentMap, a aVar) {
            this(fVar, concurrentMap);
        }
    }

    /* JADX INFO: renamed from: H6.f$f, reason: collision with other inner class name */
    public interface InterfaceC0049f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InterfaceC0049f f3988a = new a();

        /* JADX INFO: renamed from: H6.f$f$a */
        public static class a implements InterfaceC0049f {
            public static /* synthetic */ void b(int i8) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // H6.f.InterfaceC0049f
            public RuntimeException a(Throwable th) {
                if (th == null) {
                    b(0);
                }
                throw S6.d.b(th);
            }
        }

        RuntimeException a(Throwable th);
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f3989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0 f3990b;

        public g(Object obj, Function0 function0) {
            this.f3989a = obj;
            this.f3990b = function0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.f3989a.equals(((g) obj).f3989a);
        }

        public int hashCode() {
            return this.f3989a.hashCode();
        }
    }

    public static abstract class i extends h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile H6.l f3994d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(f fVar, Function0 function0) {
            super(fVar, function0);
            if (fVar == null) {
                a(0);
            }
            if (function0 == null) {
                a(1);
            }
            this.f3994d = null;
        }

        private static /* synthetic */ void a(int i8) {
            Object[] objArr = new Object[3];
            if (i8 != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // H6.f.h
        public final void b(Object obj) {
            this.f3994d = new H6.l(obj);
            try {
                g(obj);
            } finally {
                this.f3994d = null;
            }
        }

        public abstract void g(Object obj);

        @Override // H6.f.h, kotlin.jvm.functions.Function0
        public Object invoke() {
            H6.l lVar = this.f3994d;
            return (lVar == null || !lVar.b()) ? super.invoke() : lVar.a();
        }
    }

    public static class j extends h implements H6.i {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(f fVar, Function0 function0) {
            super(fVar, function0);
            if (fVar == null) {
                a(0);
            }
            if (function0 == null) {
                a(1);
            }
        }

        private static /* synthetic */ void a(int i8) {
            String str = i8 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i8 != 2 ? 3 : 2];
            if (i8 == 1) {
                objArr[0] = "computable";
            } else if (i8 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i8 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i8 != 2) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i8 == 2) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // H6.f.h, kotlin.jvm.functions.Function0
        public Object invoke() {
            Object objInvoke = super.invoke();
            if (objInvoke == null) {
                a(2);
            }
            return objInvoke;
        }
    }

    public static abstract class k extends i implements H6.i {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(f fVar, Function0 function0) {
            super(fVar, function0);
            if (fVar == null) {
                a(0);
            }
            if (function0 == null) {
                a(1);
            }
        }

        private static /* synthetic */ void a(int i8) {
            String str = i8 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i8 != 2 ? 3 : 2];
            if (i8 == 1) {
                objArr[0] = "computable";
            } else if (i8 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i8 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i8 != 2) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i8 == 2) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // H6.f.i, H6.f.h, kotlin.jvm.functions.Function0
        public Object invoke() {
            Object objInvoke = super.invoke();
            if (objInvoke == null) {
                a(2);
            }
            return objInvoke;
        }
    }

    public static class l implements H6.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f3995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentMap f3996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final B5.k f3997c;

        public l(f fVar, ConcurrentMap concurrentMap, B5.k kVar) {
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
            if (kVar == null) {
                b(2);
            }
            this.f3995a = fVar;
            this.f3996b = concurrentMap;
            this.f3997c = kVar;
        }

        private static /* synthetic */ void b(int i8) {
            String str = (i8 == 3 || i8 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i8 == 3 || i8 == 4) ? 2 : 3];
            if (i8 == 1) {
                objArr[0] = "map";
            } else if (i8 == 2) {
                objArr[0] = "compute";
            } else if (i8 == 3 || i8 == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i8 == 3) {
                objArr[1] = "recursionDetected";
            } else if (i8 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i8 != 3 && i8 != 4) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i8 != 3 && i8 != 4) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public final AssertionError c(Object obj, Object obj2) {
            return (AssertionError) f.q(new AssertionError("Inconsistent key detected. " + n.COMPUTING + " is expected, was: " + obj2 + ", most probably race condition detected on input " + obj + " under " + this.f3995a));
        }

        @Override // H6.h
        public boolean f(Object obj) {
            Object obj2 = this.f3996b.get(obj);
            return (obj2 == null || obj2 == n.COMPUTING) ? false : true;
        }

        public final AssertionError g(Object obj, Object obj2) {
            AssertionError assertionError = (AssertionError) f.q(new AssertionError("Race condition detected on input " + obj + ". Old value is " + obj2 + " under " + this.f3995a));
            if (assertionError == null) {
                b(4);
            }
            return assertionError;
        }

        public o i(Object obj, boolean z7) {
            o oVarP = this.f3995a.p("", obj);
            if (oVarP == null) {
                b(3);
            }
            return oVarP;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: all -> 0x003b, PHI: r0
          0x003e: PHI (r0v8 java.lang.Object) = (r0v7 java.lang.Object), (r0v21 java.lang.Object) binds: [B:10:0x0020, B:12:0x002d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #3 {all -> 0x003b, blocks: (B:9:0x0018, B:11:0x0022, B:13:0x002f, B:18:0x003e, B:20:0x0042, B:24:0x0050, B:34:0x007b, B:37:0x0087, B:39:0x008b, B:40:0x008f, B:41:0x0090, B:42:0x0092, B:47:0x009b, B:49:0x00a9, B:50:0x00ad, B:51:0x00ae, B:52:0x00b8, B:54:0x00be, B:55:0x00c8, B:57:0x00ca, B:58:0x00ce, B:44:0x0094, B:45:0x0098, B:36:0x0081, B:53:0x00b9, B:27:0x0056, B:31:0x0075, B:32:0x0079), top: B:67:0x0018, inners: #0, #1, #2 }] */
        @Override // B5.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object invoke(java.lang.Object r6) {
            /*
                Method dump skipped, instruction units count: 215
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: H6.f.l.invoke(java.lang.Object):java.lang.Object");
        }

        public final AssertionError j(Object obj, Throwable th) {
            return (AssertionError) f.q(new AssertionError("Unable to remove " + obj + " under " + this.f3995a, th));
        }
    }

    public static class m extends l implements H6.g {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(f fVar, ConcurrentMap concurrentMap, B5.k kVar) {
            super(fVar, concurrentMap, kVar);
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
            if (kVar == null) {
                b(2);
            }
        }

        private static /* synthetic */ void b(int i8) {
            String str = i8 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i8 != 3 ? 3 : 2];
            if (i8 == 1) {
                objArr[0] = "map";
            } else if (i8 == 2) {
                objArr[0] = "compute";
            } else if (i8 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i8 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i8 != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i8 == 3) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // H6.f.l, B5.k
        public Object invoke(Object obj) {
            Object objInvoke = super.invoke(obj);
            if (objInvoke == null) {
                b(3);
            }
            return objInvoke;
        }
    }

    public enum n {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f4002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f4003b;

        public o(Object obj, boolean z7) {
            this.f4002a = obj;
            this.f4003b = z7;
        }

        public static o a() {
            return new o(null, true);
        }

        public static o d(Object obj) {
            return new o(obj, false);
        }

        public Object b() {
            return this.f4002a;
        }

        public boolean c() {
            return this.f4003b;
        }

        public String toString() {
            return c() ? "FALL_THROUGH" : String.valueOf(this.f4002a);
        }
    }

    public f(String str) {
        this(str, (Runnable) null, (B5.k) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void j(int r13) {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H6.f.j(int):void");
    }

    public static ConcurrentMap m() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    public static Throwable q(Throwable th) {
        if (th == null) {
            j(36);
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                i8 = -1;
                break;
            }
            if (!stackTrace[i8].getClassName().startsWith(f3978d)) {
                break;
            }
            i8++;
        }
        List listSubList = Arrays.asList(stackTrace).subList(i8, length);
        th.setStackTrace((StackTraceElement[]) listSubList.toArray(new StackTraceElement[listSubList.size()]));
        return th;
    }

    @Override // H6.n
    public H6.b a() {
        return new e(this, m(), null);
    }

    @Override // H6.n
    public H6.a b() {
        return new d(this, m(), null);
    }

    @Override // H6.n
    public H6.i c(Function0 function0, Object obj) {
        if (function0 == null) {
            j(26);
        }
        if (obj == null) {
            j(27);
        }
        return new b(this, function0, obj);
    }

    @Override // H6.n
    public H6.h d(B5.k kVar) {
        if (kVar == null) {
            j(19);
        }
        H6.h hVarO = o(kVar, m());
        if (hVarO == null) {
            j(20);
        }
        return hVarO;
    }

    @Override // H6.n
    public H6.i e(Function0 function0) {
        if (function0 == null) {
            j(23);
        }
        return new j(this, function0);
    }

    @Override // H6.n
    public Object f(Function0 function0) {
        if (function0 == null) {
            j(34);
        }
        this.f3980a.lock();
        try {
            return function0.invoke();
        } finally {
        }
    }

    @Override // H6.n
    public H6.g g(B5.k kVar) {
        if (kVar == null) {
            j(9);
        }
        H6.g gVarN = n(kVar, m());
        if (gVarN == null) {
            j(10);
        }
        return gVarN;
    }

    @Override // H6.n
    public H6.j h(Function0 function0) {
        if (function0 == null) {
            j(30);
        }
        return new h(this, function0);
    }

    @Override // H6.n
    public H6.i i(Function0 function0, B5.k kVar, B5.k kVar2) {
        if (function0 == null) {
            j(28);
        }
        if (kVar2 == null) {
            j(29);
        }
        return new c(this, function0, kVar, kVar2);
    }

    public H6.g n(B5.k kVar, ConcurrentMap concurrentMap) {
        if (kVar == null) {
            j(14);
        }
        if (concurrentMap == null) {
            j(15);
        }
        return new m(this, concurrentMap, kVar);
    }

    public H6.h o(B5.k kVar, ConcurrentMap concurrentMap) {
        if (kVar == null) {
            j(21);
        }
        if (concurrentMap == null) {
            j(22);
        }
        return new l(this, concurrentMap, kVar);
    }

    public o p(String str, Object obj) {
        String str2;
        if (str == null) {
            j(35);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Recursion detected ");
        sb.append(str);
        if (obj == null) {
            str2 = "";
        } else {
            str2 = "on input: " + obj;
        }
        sb.append(str2);
        sb.append(" under ");
        sb.append(this);
        throw ((AssertionError) q(new AssertionError(sb.toString())));
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.f3982c + ")";
    }

    public f(String str, InterfaceC0049f interfaceC0049f, H6.k kVar) {
        if (str == null) {
            j(4);
        }
        if (interfaceC0049f == null) {
            j(5);
        }
        if (kVar == null) {
            j(6);
        }
        this.f3980a = kVar;
        this.f3981b = interfaceC0049f;
        this.f3982c = str;
    }

    public /* synthetic */ f(String str, InterfaceC0049f interfaceC0049f, H6.k kVar, a aVar) {
        this(str, interfaceC0049f, kVar);
    }

    public f(String str, Runnable runnable, B5.k kVar) {
        this(str, InterfaceC0049f.f3988a, H6.k.f4004a.a(runnable, kVar));
    }

    public static class h implements H6.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f3991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0 f3992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile Object f3993c;

        public h(f fVar, Function0 function0) {
            if (fVar == null) {
                a(0);
            }
            if (function0 == null) {
                a(1);
            }
            this.f3993c = n.NOT_COMPUTED;
            this.f3991a = fVar;
            this.f3992b = function0;
        }

        private static /* synthetic */ void a(int i8) {
            String str = (i8 == 2 || i8 == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i8 == 2 || i8 == 3) ? 2 : 3];
            if (i8 == 1) {
                objArr[0] = "computable";
            } else if (i8 == 2 || i8 == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i8 == 2) {
                objArr[1] = "recursionDetected";
            } else if (i8 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i8 != 2 && i8 != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i8 != 2 && i8 != 3) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public o c(boolean z7) {
            o oVarP = this.f3991a.p("in a lazy value", null);
            if (oVarP == null) {
                a(2);
            }
            return oVarP;
        }

        public boolean e() {
            return (this.f3993c == n.NOT_COMPUTED || this.f3993c == n.COMPUTING) ? false : true;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003e A[Catch: all -> 0x0024, TryCatch #1 {all -> 0x0024, blocks: (B:7:0x0012, B:9:0x0018, B:14:0x0026, B:16:0x002a, B:18:0x0039, B:19:0x003e, B:21:0x0042, B:23:0x004d, B:24:0x0052, B:28:0x0061, B:30:0x0067, B:32:0x006d, B:33:0x0073, B:34:0x007d, B:35:0x007e, B:36:0x0084, B:25:0x0054), top: B:41:0x0012, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0052 A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #1 {all -> 0x0024, blocks: (B:7:0x0012, B:9:0x0018, B:14:0x0026, B:16:0x002a, B:18:0x0039, B:19:0x003e, B:21:0x0042, B:23:0x004d, B:24:0x0052, B:28:0x0061, B:30:0x0067, B:32:0x006d, B:33:0x0073, B:34:0x007d, B:35:0x007e, B:36:0x0084, B:25:0x0054), top: B:41:0x0012, inners: #0 }] */
        @Override // kotlin.jvm.functions.Function0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object invoke() {
            /*
                r4 = this;
                java.lang.Object r0 = r4.f3993c
                boolean r1 = r0 instanceof H6.f.n
                if (r1 != 0) goto Lb
                java.lang.Object r0 = S6.m.f(r0)
                return r0
            Lb:
                H6.f r0 = r4.f3991a
                H6.k r0 = r0.f3980a
                r0.lock()
                java.lang.Object r0 = r4.f3993c     // Catch: java.lang.Throwable -> L24
                boolean r1 = r0 instanceof H6.f.n     // Catch: java.lang.Throwable -> L24
                if (r1 != 0) goto L26
                java.lang.Object r0 = S6.m.f(r0)     // Catch: java.lang.Throwable -> L24
            L1c:
                H6.f r1 = r4.f3991a
                H6.k r1 = r1.f3980a
                r1.unlock()
                return r0
            L24:
                r0 = move-exception
                goto L85
            L26:
                H6.f$n r1 = H6.f.n.COMPUTING     // Catch: java.lang.Throwable -> L24
                if (r0 != r1) goto L3e
                H6.f$n r2 = H6.f.n.RECURSION_WAS_DETECTED     // Catch: java.lang.Throwable -> L24
                r4.f3993c = r2     // Catch: java.lang.Throwable -> L24
                r2 = 1
                H6.f$o r2 = r4.c(r2)     // Catch: java.lang.Throwable -> L24
                boolean r3 = r2.c()     // Catch: java.lang.Throwable -> L24
                if (r3 != 0) goto L3e
                java.lang.Object r0 = r2.b()     // Catch: java.lang.Throwable -> L24
                goto L1c
            L3e:
                H6.f$n r2 = H6.f.n.RECURSION_WAS_DETECTED     // Catch: java.lang.Throwable -> L24
                if (r0 != r2) goto L52
                r0 = 0
                H6.f$o r0 = r4.c(r0)     // Catch: java.lang.Throwable -> L24
                boolean r2 = r0.c()     // Catch: java.lang.Throwable -> L24
                if (r2 != 0) goto L52
                java.lang.Object r0 = r0.b()     // Catch: java.lang.Throwable -> L24
                goto L1c
            L52:
                r4.f3993c = r1     // Catch: java.lang.Throwable -> L24
                kotlin.jvm.functions.Function0 r0 = r4.f3992b     // Catch: java.lang.Throwable -> L60
                java.lang.Object r0 = r0.invoke()     // Catch: java.lang.Throwable -> L60
                r4.b(r0)     // Catch: java.lang.Throwable -> L60
                r4.f3993c = r0     // Catch: java.lang.Throwable -> L60
                goto L1c
            L60:
                r0 = move-exception
                boolean r1 = S6.d.a(r0)     // Catch: java.lang.Throwable -> L24
                if (r1 != 0) goto L7e
                java.lang.Object r1 = r4.f3993c     // Catch: java.lang.Throwable -> L24
                H6.f$n r2 = H6.f.n.COMPUTING     // Catch: java.lang.Throwable -> L24
                if (r1 != r2) goto L73
                java.lang.Object r1 = S6.m.c(r0)     // Catch: java.lang.Throwable -> L24
                r4.f3993c = r1     // Catch: java.lang.Throwable -> L24
            L73:
                H6.f r1 = r4.f3991a     // Catch: java.lang.Throwable -> L24
                H6.f$f r1 = H6.f.k(r1)     // Catch: java.lang.Throwable -> L24
                java.lang.RuntimeException r0 = r1.a(r0)     // Catch: java.lang.Throwable -> L24
                throw r0     // Catch: java.lang.Throwable -> L24
            L7e:
                H6.f$n r1 = H6.f.n.NOT_COMPUTED     // Catch: java.lang.Throwable -> L24
                r4.f3993c = r1     // Catch: java.lang.Throwable -> L24
                java.lang.RuntimeException r0 = (java.lang.RuntimeException) r0     // Catch: java.lang.Throwable -> L24
                throw r0     // Catch: java.lang.Throwable -> L24
            L85:
                H6.f r1 = r4.f3991a
                H6.k r1 = r1.f3980a
                r1.unlock()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: H6.f.h.invoke():java.lang.Object");
        }

        public void b(Object obj) {
        }
    }
}
