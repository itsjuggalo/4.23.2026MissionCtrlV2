package com.google.firebase.sessions;

import android.content.Context;
import java.io.File;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$2 extends s implements Function0 {
    final /* synthetic */ Context $appContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$2(Context context) {
        super(0);
        this.$appContext = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final File invoke() {
        return U.b.a(this.$appContext, SessionDataStoreConfigs.INSTANCE.getSETTINGS_CONFIG_NAME());
    }
}
