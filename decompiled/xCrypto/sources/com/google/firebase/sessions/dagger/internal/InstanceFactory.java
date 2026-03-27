package com.google.firebase.sessions.dagger.internal;

import com.google.firebase.sessions.dagger.Lazy;

/* JADX INFO: loaded from: classes.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
    private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = new InstanceFactory<>(null);
    private final T instance;

    private InstanceFactory(T t4) {
        this.instance = t4;
    }

    public static <T> Factory<T> create(T t4) {
        return new InstanceFactory(Preconditions.checkNotNull(t4, "instance cannot be null"));
    }

    public static <T> Factory<T> createNullable(T t4) {
        return t4 == null ? nullInstanceFactory() : new InstanceFactory(t4);
    }

    private static <T> InstanceFactory<T> nullInstanceFactory() {
        return (InstanceFactory<T>) NULL_INSTANCE_FACTORY;
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, V2.a
    public T get() {
        return this.instance;
    }
}
