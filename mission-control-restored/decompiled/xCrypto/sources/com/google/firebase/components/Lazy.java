package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance;
    private volatile Provider<T> provider;

    public Lazy(T t4) {
        this.instance = UNINITIALIZED;
        this.instance = t4;
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        T t4;
        T t5 = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t5 != obj) {
            return t5;
        }
        synchronized (this) {
            try {
                t4 = (T) this.instance;
                if (t4 == obj) {
                    t4 = this.provider.get();
                    this.instance = t4;
                    this.provider = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t4;
    }

    public boolean isInitialized() {
        return this.instance != UNINITIALIZED;
    }

    public Lazy(Provider<T> provider) {
        this.instance = UNINITIALIZED;
        this.provider = provider;
    }
}
