package com.revenuecat.purchases.utils;

import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Result<A, B> {

    public static final class Error<B> extends Result {
        private final B value;

        public Error(B b4) {
            super(null);
            this.value = b4;
        }

        public final B getValue() {
            return this.value;
        }
    }

    public static final class Success<A> extends Result {
        private final A value;

        public Success(A a4) {
            super(null);
            this.value = a4;
        }

        public final A getValue() {
            return this.value;
        }
    }

    public /* synthetic */ Result(AbstractC1585j abstractC1585j) {
        this();
    }

    private Result() {
    }
}
