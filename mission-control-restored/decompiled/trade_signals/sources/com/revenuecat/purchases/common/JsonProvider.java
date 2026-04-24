package com.revenuecat.purchases.common;

import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import p7.AbstractC2609b;
import p7.u;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b0\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/common/JsonProvider;", "", "()V", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class JsonProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AbstractC2609b defaultJson = u.b(null, JsonProvider$Companion$defaultJson$1.INSTANCE, 1, null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/common/JsonProvider$Companion;", "", "<init>", "()V", "Lp7/b;", "defaultJson", "Lp7/b;", "getDefaultJson", "()Lp7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public final AbstractC2609b getDefaultJson() {
            return JsonProvider.defaultJson;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    private JsonProvider() {
    }

    public /* synthetic */ JsonProvider(AbstractC2296k abstractC2296k) {
        this();
    }
}
