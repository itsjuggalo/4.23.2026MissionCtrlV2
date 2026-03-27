package com.google.android.gms.internal.play_billing;

import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class F0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G f15160a = new G();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Logger f15162c;

    public F0(Class cls) {
        this.f15161b = cls.getName();
    }

    public final Logger a() {
        Logger logger = this.f15162c;
        if (logger != null) {
            return logger;
        }
        synchronized (this.f15160a) {
            try {
                Logger logger2 = this.f15162c;
                if (logger2 != null) {
                    return logger2;
                }
                Logger logger3 = Logger.getLogger(this.f15161b);
                this.f15162c = logger3;
                return logger3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
