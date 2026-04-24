package com.revenuecat.purchases;

import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes.dex */
public enum EntitlementVerificationMode {
    DISABLED,
    INFORMATIONAL;

    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final EntitlementVerificationMode getDefault() {
            return EntitlementVerificationMode.INFORMATIONAL;
        }

        private Companion() {
        }
    }

    public final boolean isEnabled() {
        return this != DISABLED;
    }
}
