package com.google.firebase.sessions;

import V.f;
import V.g;
import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import android.util.Log;
import b3.InterfaceC0868f;
import b3.l;
import i3.p;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0868f(c = "com.google.firebase.sessions.SessionDatastoreImpl$firebaseSessionDataFlow$1", f = "SessionDatastore.kt", l = {78}, m = "invokeSuspend")
public final class SessionDatastoreImpl$firebaseSessionDataFlow$1 extends l implements p {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public SessionDatastoreImpl$firebaseSessionDataFlow$1(e eVar) {
        super(3, eVar);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = AbstractC0787c.e();
        int i4 = this.label;
        if (i4 == 0) {
            q.b(obj);
            w3.e eVar = (w3.e) this.L$0;
            Log.e("FirebaseSessionsRepo", "Error reading stored session data.", (Throwable) this.L$1);
            f fVarA = g.a();
            this.L$0 = null;
            this.label = 1;
            if (eVar.emit(fVarA, this) == objE) {
                return objE;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.b(obj);
        }
        return E.f5463a;
    }

    @Override // i3.p
    public final Object invoke(w3.e eVar, Throwable th, e eVar2) {
        SessionDatastoreImpl$firebaseSessionDataFlow$1 sessionDatastoreImpl$firebaseSessionDataFlow$1 = new SessionDatastoreImpl$firebaseSessionDataFlow$1(eVar2);
        sessionDatastoreImpl$firebaseSessionDataFlow$1.L$0 = eVar;
        sessionDatastoreImpl$firebaseSessionDataFlow$1.L$1 = th;
        return sessionDatastoreImpl$firebaseSessionDataFlow$1.invokeSuspend(E.f5463a);
    }
}
