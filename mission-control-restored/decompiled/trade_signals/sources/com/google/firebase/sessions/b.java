package com.google.firebase.sessions;

import B5.k;
import T3.h;
import Y6.L;
import Y6.M;
import a0.AbstractC1040a;
import android.content.Context;
import android.util.Log;
import b0.C1173d;
import b0.C1179j;
import b0.E;
import b0.InterfaceC1178i;
import b0.y;
import c0.C1243b;
import com.google.firebase.sessions.b;
import g4.C1791F;
import g4.C1795J;
import g4.C1809Y;
import g4.C1812a0;
import g4.C1813b;
import g4.C1823l;
import g4.InterfaceC1804T;
import g4.InterfaceC1808X;
import g4.InterfaceC1810Z;
import g4.SessionData;
import j4.C2222i;
import j4.SessionConfigs;
import java.io.File;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes.dex */
public interface b {

    public interface a {
        b a();

        a b(InterfaceC2711i interfaceC2711i);

        a c(h hVar);

        a d(InterfaceC2711i interfaceC2711i);

        a e(S3.b bVar);

        a f(Context context);

        a g(G2.f fVar);
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.b$b, reason: collision with other inner class name */
    public interface InterfaceC0256b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15932a = a.f15933a;

        /* JADX INFO: renamed from: com.google.firebase.sessions.b$b$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f15933a = new a();

            public static /* synthetic */ InterfaceC1178i g(a aVar, E e8, C1243b c1243b, List list, L l8, Function0 function0, int i8, Object obj) {
                if ((i8 & 4) != 0) {
                    list = AbstractC2595q.i();
                }
                return aVar.f(e8, c1243b, list, l8, function0);
            }

            public static final SessionConfigs j(C1173d ex) {
                AbstractC2304t.f(ex, "ex");
                Log.w("FirebaseSessions", "CorruptionException in session configs DataStore", ex);
                return C2222i.f20072a.a();
            }

            public static final File k(Context context) {
                return AbstractC1040a.a(context, "aqs/sessionConfigsDataStore.data");
            }

            public static final SessionData m(C1791F c1791f, C1173d ex) {
                AbstractC2304t.f(ex, "ex");
                Log.w("FirebaseSessions", "CorruptionException in session data DataStore", ex);
                return c1791f.a();
            }

            public static final File n(Context context) {
                return AbstractC1040a.a(context, "aqs/sessionDataStore.data");
            }

            public final C1813b e(G2.f firebaseApp) {
                AbstractC2304t.f(firebaseApp, "firebaseApp");
                return C1795J.f18035a.b(firebaseApp);
            }

            public final InterfaceC1178i f(E e8, C1243b c1243b, List list, L l8, Function0 function0) {
                return h() ? y.f12852a.a(e8, c1243b, list, l8, function0) : C1179j.f12617a.a(e8, c1243b, list, l8, function0);
            }

            public final boolean h() {
                try {
                    System.loadLibrary("datastore_shared_counter");
                    return true;
                } catch (SecurityException | UnsatisfiedLinkError unused) {
                    return false;
                }
            }

            public final InterfaceC1178i i(final Context appContext, InterfaceC2711i blockingDispatcher) {
                AbstractC2304t.f(appContext, "appContext");
                AbstractC2304t.f(blockingDispatcher, "blockingDispatcher");
                return g(this, C2222i.f20072a, new C1243b(new k() { // from class: g4.m
                    @Override // B5.k
                    public final Object invoke(Object obj) {
                        return b.InterfaceC0256b.a.j((C1173d) obj);
                    }
                }), null, M.a(blockingDispatcher), new Function0() { // from class: g4.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return b.InterfaceC0256b.a.k(appContext);
                    }
                }, 4, null);
            }

            public final InterfaceC1178i l(final Context appContext, InterfaceC2711i blockingDispatcher, final C1791F sessionDataSerializer) {
                AbstractC2304t.f(appContext, "appContext");
                AbstractC2304t.f(blockingDispatcher, "blockingDispatcher");
                AbstractC2304t.f(sessionDataSerializer, "sessionDataSerializer");
                return g(this, sessionDataSerializer, new C1243b(new k() { // from class: g4.o
                    @Override // B5.k
                    public final Object invoke(Object obj) {
                        return b.InterfaceC0256b.a.m(sessionDataSerializer, (C1173d) obj);
                    }
                }), null, M.a(blockingDispatcher), new Function0() { // from class: g4.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return b.InterfaceC0256b.a.n(appContext);
                    }
                }, 4, null);
            }

            public final InterfaceC1808X o() {
                return C1809Y.f18128a;
            }

            public final InterfaceC1810Z p() {
                return C1812a0.f18135a;
            }
        }
    }

    C1823l a();

    InterfaceC1804T b();
}
