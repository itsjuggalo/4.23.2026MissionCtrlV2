package com.google.firebase.sessions;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.sessions.FirebaseSessionsRegistrar;
import com.google.firebase.sessions.b;
import dd.r;
import ga.h;
import gd.i;
import i4.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import l1.y;
import ng.k0;
import o7.e0;
import o7.q;
import ua.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0001\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\b\u001a0\u0012,\u0012*\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "<init>", "()V", "", "Lo7/c;", "", "kotlin.jvm.PlatformType", "getComponents", "()Ljava/util/List;", "Companion", "a", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String LIBRARY_NAME = "fire-sessions";
    private static final e0 appContext;
    private static final e0 backgroundDispatcher;
    private static final e0 blockingDispatcher;
    private static final e0 firebaseApp;
    private static final e0 firebaseInstallationsApi;
    private static final e0 firebaseSessionsComponent;
    private static final e0 transportFactory;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public a() {
        }
    }

    static {
        e0 e0VarB = e0.b(Context.class);
        t.e(e0VarB, "unqualified(...)");
        appContext = e0VarB;
        e0 e0VarB2 = e0.b(a7.g.class);
        t.e(e0VarB2, "unqualified(...)");
        firebaseApp = e0VarB2;
        e0 e0VarB3 = e0.b(h.class);
        t.e(e0VarB3, "unqualified(...)");
        firebaseInstallationsApi = e0VarB3;
        e0 e0VarA = e0.a(d7.a.class, k0.class);
        t.e(e0VarA, "qualified(...)");
        backgroundDispatcher = e0VarA;
        e0 e0VarA2 = e0.a(d7.b.class, k0.class);
        t.e(e0VarA2, "qualified(...)");
        blockingDispatcher = e0VarA2;
        e0 e0VarB4 = e0.b(j.class);
        t.e(e0VarB4, "unqualified(...)");
        transportFactory = e0VarB4;
        e0 e0VarB5 = e0.b(b.class);
        t.e(e0VarB5, "unqualified(...)");
        firebaseSessionsComponent = e0VarB5;
        try {
            y.f15301a.getClass();
        } catch (NoClassDefFoundError unused) {
            Log.w("FirebaseSessions", "Your app is experiencing a known issue in the Android Gradle plugin, see https://issuetracker.google.com/328687152\n\nIt affects Java-only apps using AGP version 8.3.2 and under. To avoid the issue, either:\n\n1. Upgrade Android Gradle plugin to 8.4.0+\n   Follow the guide at https://developer.android.com/build/agp-upgrade-assistant\n\n2. Or, add the Kotlin plugin to your app\n   Follow the guide at https://developer.android.com/kotlin/add-kotlin\n\n3. Or, do the technical workaround described in https://issuetracker.google.com/issues/328687152#comment3");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l getComponents$lambda$0(o7.d dVar) {
        return ((b) dVar.f(firebaseSessionsComponent)).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b getComponents$lambda$1(o7.d dVar) {
        b.a aVarA = com.google.firebase.sessions.a.a();
        Object objF = dVar.f(appContext);
        t.e(objF, "get(...)");
        b.a aVarF = aVarA.f((Context) objF);
        Object objF2 = dVar.f(backgroundDispatcher);
        t.e(objF2, "get(...)");
        b.a aVarA2 = aVarF.a((i) objF2);
        Object objF3 = dVar.f(blockingDispatcher);
        t.e(objF3, "get(...)");
        b.a aVarB = aVarA2.b((i) objF3);
        Object objF4 = dVar.f(firebaseApp);
        t.e(objF4, "get(...)");
        b.a aVarE = aVarB.e((a7.g) objF4);
        Object objF5 = dVar.f(firebaseInstallationsApi);
        t.e(objF5, "get(...)");
        b.a aVarD = aVarE.d((h) objF5);
        fa.b bVarD = dVar.d(transportFactory);
        t.e(bVarD, "getProvider(...)");
        return aVarD.c(bVarD).build();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<o7.c> getComponents() {
        return r.n(o7.c.c(l.class).h(LIBRARY_NAME).b(q.l(firebaseSessionsComponent)).f(new o7.g() { // from class: ua.q
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return FirebaseSessionsRegistrar.getComponents$lambda$0(dVar);
            }
        }).e().d(), o7.c.c(b.class).h("fire-sessions-component").b(q.l(appContext)).b(q.l(backgroundDispatcher)).b(q.l(blockingDispatcher)).b(q.l(firebaseApp)).b(q.l(firebaseInstallationsApi)).b(q.n(transportFactory)).f(new o7.g() { // from class: ua.r
            @Override // o7.g
            public final Object create(o7.d dVar) {
                return FirebaseSessionsRegistrar.getComponents$lambda$1(dVar);
            }
        }).d(), oa.h.b(LIBRARY_NAME, "3.0.3"));
    }
}
