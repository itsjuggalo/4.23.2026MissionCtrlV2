package com.revenuecat.purchases.paywalls.components;

import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import k7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0083\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ActionTypeSurrogate;", "", "(Ljava/lang/String;I)V", "restore_purchases", "navigate_back", "navigate_to", FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE, "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
enum ActionTypeSurrogate {
    restore_purchases,
    navigate_back,
    navigate_to,
    unknown;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ActionTypeSurrogate$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/ActionTypeSurrogate;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return ActionTypeSurrogateDeserializer.INSTANCE;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }
}
