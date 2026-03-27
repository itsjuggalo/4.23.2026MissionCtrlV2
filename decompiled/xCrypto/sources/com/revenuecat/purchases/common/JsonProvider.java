package com.revenuecat.purchases.common;

import K3.n;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonProvider {
    public static final Companion Companion = new Companion(null);
    private static final K3.a defaultJson = n.b(null, JsonProvider$Companion$defaultJson$1.INSTANCE, 1, null);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final K3.a getDefaultJson() {
            return JsonProvider.defaultJson;
        }

        private Companion() {
        }
    }

    public /* synthetic */ JsonProvider(AbstractC1585j abstractC1585j) {
        this();
    }

    private JsonProvider() {
    }
}
