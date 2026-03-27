package com.google.firebase.storage.ktx;

import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes.dex */
public abstract class TaskState<T> {

    public static final class InProgress<T> extends TaskState<T> {
        private final T snapshot;

        public InProgress(T t4) {
            super(null);
            this.snapshot = t4;
        }

        public final T getSnapshot() {
            return this.snapshot;
        }
    }

    public static final class Paused<T> extends TaskState<T> {
        private final T snapshot;

        public Paused(T t4) {
            super(null);
            this.snapshot = t4;
        }

        public final T getSnapshot() {
            return this.snapshot;
        }
    }

    public /* synthetic */ TaskState(AbstractC1585j abstractC1585j) {
        this();
    }

    private TaskState() {
    }
}
