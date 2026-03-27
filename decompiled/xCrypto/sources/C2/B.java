package C2;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class B implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f158h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static n f162l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MethodChannel f164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f153c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f154d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f155e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f156f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f157g = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f159i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f160j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f161k = 0;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f166b;

        public a(i iVar, MethodChannel.Result result) {
            this.f165a = iVar;
            this.f166b = result;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (B.f156f) {
                B.this.l(this.f165a);
            }
            this.f166b.success(null);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f170c;

        public b(i iVar, String str, MethodChannel.Result result) {
            this.f168a = iVar;
            this.f169b = str;
            this.f170c = result;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (B.f156f) {
                i iVar = this.f168a;
                if (iVar != null) {
                    B.this.l(iVar);
                }
                try {
                    if (q.c(B.f157g)) {
                        Log.d("Sqflite", "delete database " + this.f169b);
                    }
                    i.o(this.f169b);
                } catch (Exception e4) {
                    Log.e("Sqflite", "error " + e4 + " while closing database " + B.f161k);
                }
            }
            this.f170c.success(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0048 A[Catch: all -> 0x003e, Exception -> 0x004c, TryCatch #1 {Exception -> 0x004c, blocks: (B:16:0x0040, B:18:0x0048, B:21:0x004e), top: B:45:0x0040, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004e A[Catch: all -> 0x003e, Exception -> 0x004c, TRY_LEAVE, TryCatch #1 {Exception -> 0x004c, blocks: (B:16:0x0040, B:18:0x0048, B:21:0x004e), top: B:45:0x0040, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void d(boolean r2, java.lang.String r3, io.flutter.plugin.common.MethodChannel.Result r4, java.lang.Boolean r5, C2.i r6, io.flutter.plugin.common.MethodCall r7, boolean r8, int r9) {
        /*
            java.lang.Object r0 = C2.B.f156f
            monitor-enter(r0)
            if (r2 != 0) goto L40
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L3e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3e
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L3e
            java.lang.String r2 = r2.getParent()     // Catch: java.lang.Throwable -> L3e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3e
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L3e
            if (r2 != 0) goto L40
            boolean r2 = r1.mkdirs()     // Catch: java.lang.Throwable -> L3e
            if (r2 != 0) goto L40
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L3e
            if (r2 != 0) goto L40
            java.lang.String r2 = "sqlite_error"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
            r5.<init>()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r6 = "open_failed "
            r5.append(r6)     // Catch: java.lang.Throwable -> L3e
            r5.append(r3)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L3e
            r5 = 0
            r4.error(r2, r3, r5)     // Catch: java.lang.Throwable -> L3e
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            return
        L3e:
            r2 = move-exception
            goto Laf
        L40:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L4c
            boolean r2 = r2.equals(r5)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L4c
            if (r2 == 0) goto L4e
            r6.M()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L4c
            goto L51
        L4c:
            r2 = move-exception
            goto La5
        L4e:
            r6.L()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L4c
        L51:
            java.lang.Object r2 = C2.B.f155e     // Catch: java.lang.Throwable -> L3e
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L3e
            if (r8 == 0) goto L62
            java.util.Map r5 = C2.B.f153c     // Catch: java.lang.Throwable -> L60
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L60
            r5.put(r3, r7)     // Catch: java.lang.Throwable -> L60
            goto L62
        L60:
            r3 = move-exception
            goto La3
        L62:
            java.util.Map r5 = C2.B.f154d     // Catch: java.lang.Throwable -> L60
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L60
            r5.put(r7, r6)     // Catch: java.lang.Throwable -> L60
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L60
            int r2 = r6.f191d     // Catch: java.lang.Throwable -> L3e
            boolean r2 = C2.q.b(r2)     // Catch: java.lang.Throwable -> L3e
            if (r2 == 0) goto L99
            java.lang.String r2 = "Sqflite"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
            r5.<init>()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r6 = r6.A()     // Catch: java.lang.Throwable -> L3e
            r5.append(r6)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r6 = "opened "
            r5.append(r6)     // Catch: java.lang.Throwable -> L3e
            r5.append(r9)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r6 = " "
            r5.append(r6)     // Catch: java.lang.Throwable -> L3e
            r5.append(r3)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L3e
            android.util.Log.d(r2, r3)     // Catch: java.lang.Throwable -> L3e
        L99:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            r2 = 0
            java.util.Map r2 = p(r9, r2, r2)
            r4.success(r2)
            return
        La3:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L60
            throw r3     // Catch: java.lang.Throwable -> L3e
        La5:
            E2.d r3 = new E2.d     // Catch: java.lang.Throwable -> L3e
            r3.<init>(r7, r4)     // Catch: java.lang.Throwable -> L3e
            r6.D(r2, r3)     // Catch: java.lang.Throwable -> L3e
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            return
        Laf:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: C2.B.d(boolean, java.lang.String, io.flutter.plugin.common.MethodChannel$Result, java.lang.Boolean, C2.i, io.flutter.plugin.common.MethodCall, boolean, int):void");
    }

    public static /* synthetic */ void g(MethodCall methodCall, i iVar, MethodChannel.Result result) {
        try {
            iVar.f196i.setLocale(E.e((String) methodCall.argument("locale")));
            result.success(null);
        } catch (Exception e4) {
            result.error("sqlite_error", "Error calling setLocale: " + e4.getMessage(), null);
        }
    }

    public static boolean o(String str) {
        return str == null || str.equals(":memory:");
    }

    public static Map p(int i4, boolean z4, boolean z5) {
        HashMap map = new HashMap();
        map.put(DiagnosticsEntry.ID_KEY, Integer.valueOf(i4));
        if (z4) {
            map.put("recovered", Boolean.TRUE);
        }
        if (z5) {
            map.put("recoveredInTransaction", Boolean.TRUE);
        }
        return map;
    }

    public final void A(final MethodCall methodCall, final MethodChannel.Result result) {
        final int i4;
        i iVar;
        final String str = (String) methodCall.argument("path");
        final Boolean bool = (Boolean) methodCall.argument("readOnly");
        final boolean zO = o(str);
        boolean z4 = (Boolean.FALSE.equals(methodCall.argument("singleInstance")) || zO) ? false : true;
        if (z4) {
            synchronized (f155e) {
                try {
                    if (q.c(f157g)) {
                        Log.d("Sqflite", "Look for " + str + " in " + f153c.keySet());
                    }
                    Integer num = (Integer) f153c.get(str);
                    if (num != null && (iVar = (i) f154d.get(num)) != null) {
                        if (iVar.f196i.isOpen()) {
                            if (q.c(f157g)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(iVar.A());
                                sb.append("re-opened single instance ");
                                sb.append(iVar.F() ? "(in transaction) " : "");
                                sb.append(num);
                                sb.append(" ");
                                sb.append(str);
                                Log.d("Sqflite", sb.toString());
                            }
                            result.success(p(num.intValue(), true, iVar.F()));
                            return;
                        }
                        if (q.c(f157g)) {
                            Log.d("Sqflite", iVar.A() + "single instance database of " + str + " not opened");
                        }
                    }
                } finally {
                }
            }
        }
        Object obj = f155e;
        synchronized (obj) {
            i4 = f161k + 1;
            f161k = i4;
        }
        final i iVar2 = new i(this.f163a, str, i4, z4, f157g);
        synchronized (obj) {
            try {
                if (f162l == null) {
                    n nVarA = n.a("Sqflite", f160j, f159i);
                    f162l = nVarA;
                    nVarA.start();
                    if (q.b(iVar2.f191d)) {
                        Log.d("Sqflite", iVar2.A() + "starting worker pool with priority " + f159i);
                    }
                }
                iVar2.f195h = f162l;
                if (q.b(iVar2.f191d)) {
                    Log.d("Sqflite", iVar2.A() + "opened " + i4 + " " + str);
                }
                final boolean z5 = z4;
                f162l.b(iVar2, new Runnable() { // from class: C2.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        B.d(zO, str, result, bool, iVar2, methodCall, z5, i4);
                    }
                });
            } finally {
            }
        }
    }

    public void B(MethodCall methodCall, MethodChannel.Result result) {
        Object objArgument = methodCall.argument("androidThreadPriority");
        if (objArgument != null) {
            f159i = ((Integer) objArgument).intValue();
        }
        Object objArgument2 = methodCall.argument("androidThreadCount");
        if (objArgument2 != null && !objArgument2.equals(Integer.valueOf(f160j))) {
            f160j = ((Integer) objArgument2).intValue();
            n nVar = f162l;
            if (nVar != null) {
                nVar.c();
                f162l = null;
            }
        }
        Integer numA = q.a(methodCall);
        if (numA != null) {
            f157g = numA.intValue();
        }
        result.success(null);
    }

    public final void C(final MethodCall methodCall, final MethodChannel.Result result) {
        final i iVarN = n(methodCall, result);
        if (iVarN == null) {
            return;
        }
        f162l.b(iVarN, new Runnable() { // from class: C2.v
            @Override // java.lang.Runnable
            public final void run() {
                iVarN.N(new E2.d(methodCall, result));
            }
        });
    }

    public final void D(final MethodCall methodCall, final MethodChannel.Result result) {
        final i iVarN = n(methodCall, result);
        if (iVarN == null) {
            return;
        }
        f162l.b(iVarN, new Runnable() { // from class: C2.t
            @Override // java.lang.Runnable
            public final void run() {
                iVarN.O(new E2.d(methodCall, result));
            }
        });
    }

    public final void E(final MethodCall methodCall, final MethodChannel.Result result) {
        final i iVarN = n(methodCall, result);
        if (iVarN == null) {
            return;
        }
        f162l.b(iVarN, new Runnable() { // from class: C2.w
            @Override // java.lang.Runnable
            public final void run() {
                B.g(methodCall, iVarN, result);
            }
        });
    }

    public final void F(final MethodCall methodCall, final MethodChannel.Result result) {
        final i iVarN = n(methodCall, result);
        if (iVarN == null) {
            return;
        }
        f162l.b(iVarN, new Runnable() { // from class: C2.z
            @Override // java.lang.Runnable
            public final void run() {
                iVarN.Q(new E2.d(methodCall, result));
            }
        });
    }

    public final void l(i iVar) {
        try {
            if (q.b(iVar.f191d)) {
                Log.d("Sqflite", iVar.A() + "closing database ");
            }
            iVar.k();
        } catch (Exception e4) {
            Log.e("Sqflite", "error " + e4 + " while closing database " + f161k);
        }
        synchronized (f155e) {
            try {
                if (f154d.isEmpty() && f162l != null) {
                    if (q.b(iVar.f191d)) {
                        Log.d("Sqflite", iVar.A() + "stopping thread");
                    }
                    f162l.c();
                    f162l = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final i m(int i4) {
        return (i) f154d.get(Integer.valueOf(i4));
    }

    public final i n(MethodCall methodCall, MethodChannel.Result result) {
        int iIntValue = ((Integer) methodCall.argument(DiagnosticsEntry.ID_KEY)).intValue();
        i iVarM = m(iIntValue);
        if (iVarM != null) {
            return iVarM;
        }
        result.error("sqlite_error", "database_closed " + iIntValue, null);
        return null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        q(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f163a = null;
        this.f164b.setMethodCallHandler(null);
        this.f164b = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.getClass();
        switch (str) {
            case "execute":
                x(methodCall, result);
                break;
            case "closeDatabase":
                s(methodCall, result);
                break;
            case "options":
                B(methodCall, result);
                break;
            case "insert":
                z(methodCall, result);
                break;
            case "update":
                F(methodCall, result);
                break;
            case "androidSetLocale":
                E(methodCall, result);
                break;
            case "deleteDatabase":
                w(methodCall, result);
                break;
            case "debugMode":
                v(methodCall, result);
                break;
            case "openDatabase":
                A(methodCall, result);
                break;
            case "batch":
                r(methodCall, result);
                break;
            case "debug":
                u(methodCall, result);
                break;
            case "query":
                C(methodCall, result);
                break;
            case "databaseExists":
                t(methodCall, result);
                break;
            case "queryCursorNext":
                D(methodCall, result);
                break;
            case "getPlatformVersion":
                result.success("Android " + Build.VERSION.RELEASE);
                break;
            case "getDatabasesPath":
                y(methodCall, result);
                break;
            default:
                result.notImplemented();
                break;
        }
    }

    public final void q(Context context, BinaryMessenger binaryMessenger) {
        this.f163a = context;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.tekartik.sqflite", StandardMethodCodec.INSTANCE, binaryMessenger.makeBackgroundTaskQueue());
        this.f164b = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public final void r(final MethodCall methodCall, final MethodChannel.Result result) {
        final i iVarN = n(methodCall, result);
        if (iVarN == null) {
            return;
        }
        f162l.b(iVarN, new Runnable() { // from class: C2.A
            @Override // java.lang.Runnable
            public final void run() {
                iVarN.h(methodCall, result);
            }
        });
    }

    public final void s(MethodCall methodCall, MethodChannel.Result result) {
        Integer num = (Integer) methodCall.argument(DiagnosticsEntry.ID_KEY);
        int iIntValue = num.intValue();
        i iVarN = n(methodCall, result);
        if (iVarN == null) {
            return;
        }
        if (q.b(iVarN.f191d)) {
            Log.d("Sqflite", iVarN.A() + "closing " + iIntValue + " " + iVarN.f189b);
        }
        String str = iVarN.f189b;
        synchronized (f155e) {
            try {
                f154d.remove(num);
                if (iVarN.f188a) {
                    f153c.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f162l.b(iVarN, new a(iVarN, result));
    }

    public final void t(MethodCall methodCall, MethodChannel.Result result) {
        result.success(Boolean.valueOf(i.x((String) methodCall.argument("path"))));
    }

    public final void u(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("cmd");
        HashMap map = new HashMap();
        if (com.amazon.a.a.o.b.au.equals(str)) {
            int i4 = f157g;
            if (i4 > 0) {
                map.put("logLevel", Integer.valueOf(i4));
            }
            Map map2 = f154d;
            if (!map2.isEmpty()) {
                HashMap map3 = new HashMap();
                for (Map.Entry entry : map2.entrySet()) {
                    i iVar = (i) entry.getValue();
                    HashMap map4 = new HashMap();
                    map4.put("path", iVar.f189b);
                    map4.put("singleInstance", Boolean.valueOf(iVar.f188a));
                    int i5 = iVar.f191d;
                    if (i5 > 0) {
                        map4.put("logLevel", Integer.valueOf(i5));
                    }
                    map3.put(((Integer) entry.getKey()).toString(), map4);
                }
                map.put("databases", map3);
            }
        }
        result.success(map);
    }

    public final void v(MethodCall methodCall, MethodChannel.Result result) {
        D2.a.f322a = Boolean.TRUE.equals(methodCall.arguments());
        D2.a.f324c = D2.a.f323b && D2.a.f322a;
        if (!D2.a.f322a) {
            f157g = 0;
        } else if (D2.a.f324c) {
            f157g = 2;
        } else if (D2.a.f322a) {
            f157g = 1;
        }
        result.success(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(io.flutter.plugin.common.MethodCall r9, io.flutter.plugin.common.MethodChannel.Result r10) {
        /*
            r8 = this;
            java.lang.String r0 = "path"
            java.lang.Object r9 = r9.argument(r0)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r0 = C2.B.f155e
            monitor-enter(r0)
            int r1 = C2.B.f157g     // Catch: java.lang.Throwable -> L38
            boolean r1 = C2.q.c(r1)     // Catch: java.lang.Throwable -> L38
            if (r1 == 0) goto L3a
            java.lang.String r1 = "Sqflite"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r2.<init>()     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = "Look for "
            r2.append(r3)     // Catch: java.lang.Throwable -> L38
            r2.append(r9)     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = " in "
            r2.append(r3)     // Catch: java.lang.Throwable -> L38
            java.util.Map r3 = C2.B.f153c     // Catch: java.lang.Throwable -> L38
            java.util.Set r3 = r3.keySet()     // Catch: java.lang.Throwable -> L38
            r2.append(r3)     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L38
            android.util.Log.d(r1, r2)     // Catch: java.lang.Throwable -> L38
            goto L3a
        L38:
            r9 = move-exception
            goto Lab
        L3a:
            java.util.Map r1 = C2.B.f153c     // Catch: java.lang.Throwable -> L38
            java.lang.Object r2 = r1.get(r9)     // Catch: java.lang.Throwable -> L38
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L38
            if (r2 == 0) goto L98
            java.util.Map r3 = C2.B.f154d     // Catch: java.lang.Throwable -> L38
            java.lang.Object r4 = r3.get(r2)     // Catch: java.lang.Throwable -> L38
            C2.i r4 = (C2.i) r4     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L98
            android.database.sqlite.SQLiteDatabase r5 = r4.f196i     // Catch: java.lang.Throwable -> L38
            boolean r5 = r5.isOpen()     // Catch: java.lang.Throwable -> L38
            if (r5 == 0) goto L98
            int r5 = C2.B.f157g     // Catch: java.lang.Throwable -> L38
            boolean r5 = C2.q.c(r5)     // Catch: java.lang.Throwable -> L38
            if (r5 == 0) goto L91
            java.lang.String r5 = "Sqflite"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r6.<init>()     // Catch: java.lang.Throwable -> L38
            java.lang.String r7 = r4.A()     // Catch: java.lang.Throwable -> L38
            r6.append(r7)     // Catch: java.lang.Throwable -> L38
            java.lang.String r7 = "found single instance "
            r6.append(r7)     // Catch: java.lang.Throwable -> L38
            boolean r7 = r4.F()     // Catch: java.lang.Throwable -> L38
            if (r7 == 0) goto L7a
            java.lang.String r7 = "(in transaction) "
            goto L7c
        L7a:
            java.lang.String r7 = ""
        L7c:
            r6.append(r7)     // Catch: java.lang.Throwable -> L38
            r6.append(r2)     // Catch: java.lang.Throwable -> L38
            java.lang.String r7 = " "
            r6.append(r7)     // Catch: java.lang.Throwable -> L38
            r6.append(r9)     // Catch: java.lang.Throwable -> L38
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L38
            android.util.Log.d(r5, r6)     // Catch: java.lang.Throwable -> L38
        L91:
            r3.remove(r2)     // Catch: java.lang.Throwable -> L38
            r1.remove(r9)     // Catch: java.lang.Throwable -> L38
            goto L99
        L98:
            r4 = 0
        L99:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L38
            C2.B$b r0 = new C2.B$b
            r0.<init>(r4, r9, r10)
            C2.n r9 = C2.B.f162l
            if (r9 == 0) goto La7
            r9.b(r4, r0)
            return
        La7:
            r0.run()
            return
        Lab:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L38
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: C2.B.w(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public final void x(final MethodCall methodCall, final MethodChannel.Result result) {
        final i iVarN = n(methodCall, result);
        if (iVarN == null) {
            return;
        }
        f162l.b(iVarN, new Runnable() { // from class: C2.y
            @Override // java.lang.Runnable
            public final void run() {
                iVarN.v(new E2.d(methodCall, result));
            }
        });
    }

    public void y(MethodCall methodCall, MethodChannel.Result result) {
        if (f158h == null) {
            f158h = this.f163a.getDatabasePath("tekartik_sqflite.db").getParent();
        }
        result.success(f158h);
    }

    public final void z(final MethodCall methodCall, final MethodChannel.Result result) {
        final i iVarN = n(methodCall, result);
        if (iVarN == null) {
            return;
        }
        f162l.b(iVarN, new Runnable() { // from class: C2.u
            @Override // java.lang.Runnable
            public final void run() {
                iVarN.E(new E2.d(methodCall, result));
            }
        });
    }
}
