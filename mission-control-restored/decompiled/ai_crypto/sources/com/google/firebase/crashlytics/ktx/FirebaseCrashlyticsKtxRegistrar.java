package com.google.firebase.crashlytics.ktx;

import F5.AbstractC0556n;
import b3.C0986c;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseCrashlyticsKtxRegistrar implements ComponentRegistrar {
    public static final a Companion = new a(null);

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<C0986c> getComponents() {
        return AbstractC0556n.g();
    }
}
