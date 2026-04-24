package com.google.firebase.abt.component;

import I2.a;
import M2.C0700c;
import M2.InterfaceC0701d;
import M2.g;
import M2.q;
import a4.h;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.abt.component.AbtRegistrar;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class AbtRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-abt";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ a lambda$getComponents$0(InterfaceC0701d interfaceC0701d) {
        return new a((Context) interfaceC0701d.get(Context.class), interfaceC0701d.c(AnalyticsConnector.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<C0700c> getComponents() {
        return Arrays.asList(C0700c.e(a.class).h(LIBRARY_NAME).b(q.l(Context.class)).b(q.j(AnalyticsConnector.class)).f(new g() { // from class: I2.b
            @Override // M2.g
            public final Object create(InterfaceC0701d interfaceC0701d) {
                return AbtRegistrar.lambda$getComponents$0(interfaceC0701d);
            }
        }).d(), h.b(LIBRARY_NAME, "21.1.1"));
    }
}
