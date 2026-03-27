package com.google.firebase.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.firebase.storage.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1221g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f12440a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q2.g f12441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final N3.b f12442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final N3.b f12443d;

    public C1221g(Q2.g gVar, N3.b bVar, N3.b bVar2, Executor executor, Executor executor2) {
        this.f12441b = gVar;
        this.f12442c = bVar;
        this.f12443d = bVar2;
        G.d(executor, executor2);
    }

    public synchronized C1220f a(String str) {
        C1220f c1220f;
        c1220f = (C1220f) this.f12440a.get(str);
        if (c1220f == null) {
            c1220f = new C1220f(str, this.f12441b, this.f12442c, this.f12443d);
            this.f12440a.put(str, c1220f);
        }
        return c1220f;
    }
}
