package com.google.firebase.analytics.connector.internal;

import A3.d;
import G2.f;
import M2.C0700c;
import M2.InterfaceC0701d;
import M2.q;
import a4.h;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnalyticsConnector lambda$getComponents$0(InterfaceC0701d interfaceC0701d) {
        return AnalyticsConnectorImpl.getInstance((f) interfaceC0701d.get(f.class), (Context) interfaceC0701d.get(Context.class), (d) interfaceC0701d.get(d.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<C0700c> getComponents() {
        return Arrays.asList(C0700c.e(AnalyticsConnector.class).b(q.l(f.class)).b(q.l(Context.class)).b(q.l(d.class)).f(zzb.zza).e().d(), h.b("fire-analytics", "23.0.0"));
    }
}
