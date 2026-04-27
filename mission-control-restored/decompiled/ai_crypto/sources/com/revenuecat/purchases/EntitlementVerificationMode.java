package com.revenuecat.purchases;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes.dex */
public enum EntitlementVerificationMode {
    DISABLED,
    INFORMATIONAL;

    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
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
