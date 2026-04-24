package com.google.firebase.sessions;

import S.C0518d;
import V.f;
import V.g;
import android.util.Log;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$1 extends s implements k {
    public static final FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$1 INSTANCE = new FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$1();

    public FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$1() {
        super(1);
    }

    @Override // i3.k
    public final f invoke(C0518d ex) {
        r.f(ex, "ex");
        Log.w(FirebaseSessionsRegistrar.TAG, "CorruptionException in sessions DataStore in " + ProcessDetailsProvider.INSTANCE.getProcessName$com_google_firebase_firebase_sessions() + com.amazon.a.a.o.c.a.b.f8816a, ex);
        return g.a();
    }
}
