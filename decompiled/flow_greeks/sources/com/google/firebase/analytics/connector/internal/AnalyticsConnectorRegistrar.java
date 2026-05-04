package com.google.firebase.analytics.connector.internal;

import a7.g;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import o7.c;
import o7.d;
import o7.q;
import oa.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnalyticsConnector lambda$getComponents$0(d dVar) {
        return AnalyticsConnectorImpl.getInstance((g) dVar.get(g.class), (Context) dVar.get(Context.class), (c9.d) dVar.get(c9.d.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<c> getComponents() {
        return Arrays.asList(c.c(AnalyticsConnector.class).b(q.k(g.class)).b(q.k(Context.class)).b(q.k(c9.d.class)).f(zzb.zza).e().d(), h.b("fire-analytics", "23.0.0"));
    }
}
