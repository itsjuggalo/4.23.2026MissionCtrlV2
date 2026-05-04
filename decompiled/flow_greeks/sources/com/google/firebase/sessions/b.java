package com.google.firebase.sessions;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.firebase.sessions.b;
import dd.r;
import ga.h;
import gd.i;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.t;
import l1.e0;
import l1.j;
import l1.y;
import ng.n0;
import ng.o0;
import pd.k;
import ua.SessionData;
import ua.f0;
import ua.j0;
import ua.l;
import ua.s0;
import ua.w0;
import ua.x0;
import ua.y0;
import ua.z0;
import xa.SessionConfigs;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface b {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        a a(i iVar);

        a b(i iVar);

        b build();

        a c(fa.b bVar);

        a d(h hVar);

        a e(a7.g gVar);

        a f(Context context);
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface InterfaceC0106b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6585a = a.f6586a;

        /* JADX INFO: renamed from: com.google.firebase.sessions.b$b$a */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f6586a = new a();

            public static /* synthetic */ l1.i g(a aVar, e0 e0Var, m1.b bVar, List list, n0 n0Var, Function0 function0, int i10, Object obj) {
                if ((i10 & 4) != 0) {
                    list = r.k();
                }
                return aVar.f(e0Var, bVar, list, n0Var, function0);
            }

            public static final SessionConfigs k(l1.d ex) {
                t.f(ex, "ex");
                Log.w("FirebaseSessions", "CorruptionException in session configs DataStore", ex);
                return xa.i.f24752a.b();
            }

            public static final File l(Context context) throws IOException {
                File fileA = k1.a.a(context, "firebaseSessions/sessionConfigsDataStore.data");
                f6586a.i(fileA);
                return fileA;
            }

            public static final SessionData n(f0 f0Var, l1.d ex) {
                t.f(ex, "ex");
                Log.w("FirebaseSessions", "CorruptionException in session data DataStore", ex);
                return f0Var.b();
            }

            public static final File o(Context context) throws IOException {
                File fileA = k1.a.a(context, "firebaseSessions/sessionDataStore.data");
                f6586a.i(fileA);
                return fileA;
            }

            public final ua.b e(a7.g firebaseApp) {
                t.f(firebaseApp, "firebaseApp");
                return j0.f22596a.b(firebaseApp);
            }

            public final l1.i f(e0 e0Var, m1.b bVar, List list, n0 n0Var, Function0 function0) {
                return h() ? y.f15301a.a(e0Var, bVar, list, n0Var, function0) : j.f15057a.a(e0Var, bVar, list, n0Var, function0);
            }

            public final boolean h() {
                try {
                    System.loadLibrary("datastore_shared_counter");
                    return true;
                } catch (SecurityException | UnsatisfiedLinkError unused) {
                    return false;
                }
            }

            public final void i(File file) throws IOException {
                File parentFile = file.getParentFile();
                if (parentFile == null) {
                    return;
                }
                if (parentFile.exists() && !parentFile.isDirectory() && t.b(parentFile.getName(), "firebaseSessions") && !parentFile.delete()) {
                    throw new IOException("Failed to delete conflicting file: " + parentFile);
                }
                if (parentFile.isDirectory()) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        Files.createDirectories(parentFile.toPath(), new FileAttribute[0]);
                        return;
                    } catch (Exception e10) {
                        throw new IOException("Failed to create directory: " + parentFile, e10);
                    }
                }
                if (parentFile.mkdirs() || parentFile.isDirectory()) {
                    return;
                }
                throw new IOException("Failed to create directory: " + parentFile);
            }

            public final l1.i j(final Context appContext, i blockingDispatcher) {
                t.f(appContext, "appContext");
                t.f(blockingDispatcher, "blockingDispatcher");
                return g(this, xa.i.f24752a, new m1.b(new k() { // from class: ua.m
                    @Override // pd.k
                    public final Object invoke(Object obj) {
                        return b.InterfaceC0106b.a.k((l1.d) obj);
                    }
                }), null, o0.a(blockingDispatcher), new Function0() { // from class: ua.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return b.InterfaceC0106b.a.l(appContext);
                    }
                }, 4, null);
            }

            public final l1.i m(final Context appContext, i blockingDispatcher, final f0 sessionDataSerializer) {
                t.f(appContext, "appContext");
                t.f(blockingDispatcher, "blockingDispatcher");
                t.f(sessionDataSerializer, "sessionDataSerializer");
                return g(this, sessionDataSerializer, new m1.b(new k() { // from class: ua.o
                    @Override // pd.k
                    public final Object invoke(Object obj) {
                        return b.InterfaceC0106b.a.n(sessionDataSerializer, (l1.d) obj);
                    }
                }), null, o0.a(blockingDispatcher), new Function0() { // from class: ua.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return b.InterfaceC0106b.a.o(appContext);
                    }
                }, 4, null);
            }

            public final w0 p() {
                return x0.f22721a;
            }

            public final y0 q() {
                return z0.f22724a;
            }
        }
    }

    l a();

    s0 b();
}
