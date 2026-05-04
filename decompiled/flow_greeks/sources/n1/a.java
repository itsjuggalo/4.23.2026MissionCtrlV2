package n1;

import android.content.Context;
import android.content.SharedPreferences;
import cd.h0;
import cd.k;
import cd.l;
import cd.s;
import dd.a0;
import gd.e;
import id.m;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import l1.g;
import pd.o;
import pd.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f16457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f16458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f16459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f16461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f16462f;

    /* JADX INFO: renamed from: n1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0293a extends m implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16463a;

        public C0293a(e eVar) {
            super(2, eVar);
        }

        @Override // pd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, e eVar) {
            return ((C0293a) create(obj, eVar)).invokeSuspend(h0.f3852a);
        }

        @Override // id.a
        public final e create(Object obj, e eVar) {
            return new C0293a(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            hd.c.f();
            if (this.f16463a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            s.b(obj);
            return id.b.a(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f16464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f16465b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, String str) {
            super(0);
            this.f16464a = context;
            this.f16465b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final SharedPreferences invoke() {
            SharedPreferences sharedPreferences = this.f16464a.getSharedPreferences(this.f16465b, 0);
            t.e(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
            return sharedPreferences;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f16466a = new c();

        public static final boolean a(Context context, String name) {
            t.f(context, "context");
            t.f(name, "name");
            return context.deleteSharedPreferences(name);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f16467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f16468b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16470d;

        public d(e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f16468b = obj;
            this.f16470d |= Integer.MIN_VALUE;
            return a.this.c(null, this);
        }
    }

    public a(Function0 function0, Set set, o oVar, p pVar, Context context, String str) {
        this.f16457a = oVar;
        this.f16458b = pVar;
        this.f16459c = context;
        this.f16460d = str;
        this.f16461e = l.b(function0);
        this.f16462f = set == n1.b.a() ? null : a0.M0(set);
    }

    @Override // l1.g
    public Object a(e eVar) throws IOException {
        Context context;
        String str;
        SharedPreferences.Editor editorEdit = e().edit();
        Set set = this.f16462f;
        if (set == null) {
            editorEdit.clear();
        } else {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                editorEdit.remove((String) it.next());
            }
        }
        if (!editorEdit.commit()) {
            throw new IOException("Unable to delete migrated keys from SharedPreferences.");
        }
        if (e().getAll().isEmpty() && (context = this.f16459c) != null && (str = this.f16460d) != null) {
            d(context, str);
        }
        Set set2 = this.f16462f;
        if (set2 != null) {
            set2.clear();
        }
        return h0.f3852a;
    }

    @Override // l1.g
    public Object b(Object obj, e eVar) {
        return this.f16458b.invoke(new n1.c(e(), this.f16462f), obj, eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // l1.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(java.lang.Object r5, gd.e r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof n1.a.d
            if (r0 == 0) goto L13
            r0 = r6
            n1.a$d r0 = (n1.a.d) r0
            int r1 = r0.f16470d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f16470d = r1
            goto L18
        L13:
            n1.a$d r0 = new n1.a$d
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f16468b
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f16470d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f16467a
            n1.a r5 = (n1.a) r5
            cd.s.b(r6)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            cd.s.b(r6)
            pd.o r6 = r4.f16457a
            r0.f16467a = r4
            r0.f16470d = r3
            java.lang.Object r6 = r6.invoke(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r5 = r4
        L46:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r0 = 0
            if (r6 != 0) goto L54
            java.lang.Boolean r5 = id.b.a(r0)
            return r5
        L54:
            java.util.Set r6 = r5.f16462f
            if (r6 != 0) goto L6e
            android.content.SharedPreferences r5 = r5.e()
            java.util.Map r5 = r5.getAll()
            java.lang.String r6 = "sharedPrefs.all"
            kotlin.jvm.internal.t.e(r5, r6)
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L6c
            goto L91
        L6c:
            r3 = r0
            goto L91
        L6e:
            android.content.SharedPreferences r5 = r5.e()
            if (r6 == 0) goto L7b
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L7b
            goto L6c
        L7b:
            java.util.Iterator r6 = r6.iterator()
        L7f:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L6c
            java.lang.Object r1 = r6.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r5.contains(r1)
            if (r1 == 0) goto L7f
        L91:
            java.lang.Boolean r5 = id.b.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.a.c(java.lang.Object, gd.e):java.lang.Object");
    }

    public final void d(Context context, String str) {
        c.a(context, str);
    }

    public final SharedPreferences e() {
        return (SharedPreferences) this.f16461e.getValue();
    }

    public /* synthetic */ a(Context context, String str, Set set, o oVar, p pVar, int i10, kotlin.jvm.internal.k kVar) {
        this(context, str, (i10 & 4) != 0 ? n1.b.a() : set, (i10 & 8) != 0 ? new C0293a(null) : oVar, pVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context, String sharedPreferencesName, Set keysToMigrate, o shouldRunMigration, p migrate) {
        this(new b(context, sharedPreferencesName), keysToMigrate, shouldRunMigration, migrate, context, sharedPreferencesName);
        t.f(context, "context");
        t.f(sharedPreferencesName, "sharedPreferencesName");
        t.f(keysToMigrate, "keysToMigrate");
        t.f(shouldRunMigration, "shouldRunMigration");
        t.f(migrate, "migrate");
    }
}
