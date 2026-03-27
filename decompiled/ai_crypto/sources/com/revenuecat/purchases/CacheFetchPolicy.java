package com.revenuecat.purchases;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes.dex */
public enum CacheFetchPolicy {
    CACHE_ONLY,
    FETCH_CURRENT,
    NOT_STALE_CACHED_OR_CURRENT,
    CACHED_OR_FETCHED;

    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public final CacheFetchPolicy m12default() {
            return CacheFetchPolicy.CACHED_OR_FETCHED;
        }

        private Companion() {
        }
    }
}
