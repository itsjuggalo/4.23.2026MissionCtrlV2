package com.revenuecat.purchases.common;

import kotlin.jvm.internal.AbstractC2148j;
import s6.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class JsonProvider {
    public static final Companion Companion = new Companion(null);
    private static final s6.a defaultJson = n.b(null, JsonProvider$Companion$defaultJson$1.INSTANCE, 1, null);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final s6.a getDefaultJson() {
            return JsonProvider.defaultJson;
        }

        private Companion() {
        }
    }

    public /* synthetic */ JsonProvider(AbstractC2148j abstractC2148j) {
        this();
    }

    private JsonProvider() {
    }
}
