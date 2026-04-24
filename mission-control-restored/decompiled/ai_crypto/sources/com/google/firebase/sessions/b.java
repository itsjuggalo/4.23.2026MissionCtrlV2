package com.google.firebase.sessions;

import Q5.k;
import Z3.C0782b;
import Z3.C0792l;
import Z3.J;
import Z3.K;
import Z3.L;
import Z3.M;
import Z3.t;
import Z3.u;
import Z3.z;
import android.content.Context;
import android.util.Log;
import c0.C1114c;
import c0.InterfaceC1119h;
import d0.C1389b;
import f0.AbstractC1543b;
import java.io.File;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public interface b {

    public interface a {
        b a();

        a b(Q2.g gVar);

        a c(O3.h hVar);

        a d(H5.g gVar);

        a e(H5.g gVar);

        a f(N3.b bVar);

        a g(Context context);
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.b$b, reason: collision with other inner class name */
    public interface InterfaceC0196b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12295a = a.f12296a;

        /* JADX INFO: renamed from: com.google.firebase.sessions.b$b$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f12296a = new a();

            /* JADX INFO: renamed from: com.google.firebase.sessions.b$b$a$a, reason: collision with other inner class name */
            public static final class C0197a extends s implements k {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final C0197a f12297a = new C0197a();

                public C0197a() {
                    super(1);
                }

                @Override // Q5.k
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final g0.f invoke(C1114c ex) {
                    r.f(ex, "ex");
                    Log.w(FirebaseSessionsRegistrar.TAG, "CorruptionException in settings DataStore in " + t.f5972a.e() + com.amazon.a.a.o.c.a.b.f10001a, ex);
                    return g0.g.a();
                }
            }

            /* JADX INFO: renamed from: com.google.firebase.sessions.b$b$a$b, reason: collision with other inner class name */
            public static final class C0198b extends s implements Function0 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Context f12298a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0198b(Context context) {
                    super(0);
                    this.f12298a = context;
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final File invoke() {
                    return AbstractC1543b.a(this.f12298a, u.f5973a.b());
                }
            }

            /* JADX INFO: renamed from: com.google.firebase.sessions.b$b$a$c */
            public static final class c extends s implements k {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final c f12299a = new c();

                public c() {
                    super(1);
                }

                @Override // Q5.k
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final g0.f invoke(C1114c ex) {
                    r.f(ex, "ex");
                    Log.w(FirebaseSessionsRegistrar.TAG, "CorruptionException in sessions DataStore in " + t.f5972a.e() + com.amazon.a.a.o.c.a.b.f10001a, ex);
                    return g0.g.a();
                }
            }

            /* JADX INFO: renamed from: com.google.firebase.sessions.b$b$a$d */
            public static final class d extends s implements Function0 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Context f12300a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public d(Context context) {
                    super(0);
                    this.f12300a = context;
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final File invoke() {
                    return AbstractC1543b.a(this.f12300a, u.f5973a.a());
                }
            }

            public final C0782b a(Q2.g firebaseApp) {
                r.f(firebaseApp, "firebaseApp");
                return z.f6012a.b(firebaseApp);
            }

            public final InterfaceC1119h b(Context appContext) {
                r.f(appContext, "appContext");
                return g0.e.c(g0.e.f14249a, new C1389b(C0197a.f12297a), null, null, new C0198b(appContext), 6, null);
            }

            public final InterfaceC1119h c(Context appContext) {
                r.f(appContext, "appContext");
                return g0.e.c(g0.e.f14249a, new C1389b(c.f12299a), null, null, new d(appContext), 6, null);
            }

            public final J d() {
                return K.f5874a;
            }

            public final L e() {
                return M.f5875a;
            }
        }
    }

    j a();

    i b();

    C0792l c();

    h d();

    d4.i e();
}
