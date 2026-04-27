package com.revenuecat.purchases.utils;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Result<A, B> {

    public static final class Error<B> extends Result {
        private final B value;

        public Error(B b7) {
            super(null);
            this.value = b7;
        }

        public final B getValue() {
            return this.value;
        }
    }

    public static final class Success<A> extends Result {
        private final A value;

        public Success(A a7) {
            super(null);
            this.value = a7;
        }

        public final A getValue() {
            return this.value;
        }
    }

    public /* synthetic */ Result(AbstractC2148j abstractC2148j) {
        this();
    }

    private Result() {
    }
}
