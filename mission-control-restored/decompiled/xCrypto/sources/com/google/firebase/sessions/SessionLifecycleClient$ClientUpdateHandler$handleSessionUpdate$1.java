package com.google.firebase.sessions;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import android.util.Log;
import b3.InterfaceC0868f;
import b3.l;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import i3.o;
import java.util.Collection;
import java.util.Map;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0868f(c = "com.google.firebase.sessions.SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1", f = "SessionLifecycleClient.kt", l = {74}, m = "invokeSuspend")
public final class SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1 extends l implements o {
    final /* synthetic */ String $sessionId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1(String str, e eVar) {
        super(2, eVar);
        this.$sessionId = str;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1(this.$sessionId, eVar);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = AbstractC0787c.e();
        int i4 = this.label;
        if (i4 == 0) {
            q.b(obj);
            FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.INSTANCE;
            this.label = 1;
            obj = firebaseSessionsDependencies.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.b(obj);
        }
        Collection<SessionSubscriber> collectionValues = ((Map) obj).values();
        String str = this.$sessionId;
        for (SessionSubscriber sessionSubscriber : collectionValues) {
            sessionSubscriber.onSessionChanged(new SessionSubscriber.SessionDetails(str));
            Log.d(SessionLifecycleClient.TAG, "Notified " + sessionSubscriber.getSessionSubscriberName() + " of new session " + str);
        }
        return E.f5463a;
    }

    @Override // i3.o
    public final Object invoke(L l4, e eVar) {
        return ((SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1) create(l4, eVar)).invokeSuspend(E.f5463a);
    }
}
