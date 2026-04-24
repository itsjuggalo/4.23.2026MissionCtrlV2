package com.amazon.a.a.e;

import com.amazon.a.a.e.a;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<T extends a<T>> extends a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f8448b = new com.amazon.a.a.o.c("RelativeExpirable");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f8449c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Date f8450d = new Date();

    @Override // com.amazon.a.a.e.a
    public final Date a() {
        com.amazon.a.a.o.c cVar = f8448b;
        cVar.a("RelativeExpiration duration: " + h() + ", expirable: " + this);
        Date date = new Date(this.f8450d.getTime() + (h() * 1000));
        StringBuilder sb = new StringBuilder();
        sb.append("Expiration should occur at time: ");
        sb.append(date);
        cVar.a(sb.toString());
        return date;
    }

    public abstract long h();
}
