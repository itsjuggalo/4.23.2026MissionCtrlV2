package com.amazon.a.a.m;

import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends com.amazon.a.a.e.a<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f4386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Date f4387c;

    public a(Object obj, Date date) {
        this.f4386b = obj;
        this.f4387c = date;
    }

    @Override // com.amazon.a.a.e.a
    public final Date a() {
        return this.f4387c;
    }

    public final Object h() {
        return this.f4386b;
    }
}
