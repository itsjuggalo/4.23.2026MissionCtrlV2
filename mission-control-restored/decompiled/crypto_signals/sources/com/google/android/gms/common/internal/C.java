package com.google.android.gms.common.internal;

import android.os.Bundle;
import u1.C1200b;

/* JADX INFO: loaded from: classes.dex */
public abstract class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f5190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0428f f5192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5193d;
    public final Bundle e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AbstractC0428f f5194f;

    public C(AbstractC0428f abstractC0428f, int i, Bundle bundle) {
        this.f5194f = abstractC0428f;
        Boolean bool = Boolean.TRUE;
        this.f5192c = abstractC0428f;
        this.f5190a = bool;
        this.f5191b = false;
        this.f5193d = i;
        this.e = bundle;
    }

    public abstract void a(C1200b c1200b);

    public abstract boolean b();

    public final void c() {
        synchronized (this) {
            this.f5190a = null;
        }
        synchronized (this.f5192c.zzt) {
            this.f5192c.zzt.remove(this);
        }
    }
}
