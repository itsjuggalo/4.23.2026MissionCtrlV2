package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.e;
import d1.C1611A;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1611A f14849a;

    public static final class a implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final X0.b f14850a;

        public a(X0.b bVar) {
            this.f14850a = bVar;
        }

        @Override // com.bumptech.glide.load.data.e.a
        public Class a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e b(InputStream inputStream) {
            return new k(inputStream, this.f14850a);
        }
    }

    public k(InputStream inputStream, X0.b bVar) {
        C1611A c1611a = new C1611A(inputStream, bVar);
        this.f14849a = c1611a;
        c1611a.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
        this.f14849a.e();
    }

    public void c() {
        this.f14849a.c();
    }

    @Override // com.bumptech.glide.load.data.e
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream a() {
        this.f14849a.reset();
        return this.f14849a;
    }
}
