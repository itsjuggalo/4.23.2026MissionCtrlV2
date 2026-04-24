package com.amazon.a.a.m;

import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends com.amazon.a.a.e.a<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f9759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Date f9760c;

    public a(Object obj, Date date) {
        this.f9759b = obj;
        this.f9760c = date;
    }

    @Override // com.amazon.a.a.e.a
    public final Date a() {
        return this.f9760c;
    }

    public final Object h() {
        return this.f9759b;
    }
}
