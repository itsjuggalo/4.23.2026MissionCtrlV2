package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.e;
import java.io.InputStream;
import p3.b0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f5303a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j3.b f5304a;

        public a(j3.b bVar) {
            this.f5304a = bVar;
        }

        @Override // com.bumptech.glide.load.data.e.a
        public Class a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e b(InputStream inputStream) {
            return new k(inputStream, this.f5304a);
        }
    }

    public k(InputStream inputStream, j3.b bVar) {
        b0 b0Var = new b0(inputStream, bVar);
        this.f5303a = b0Var;
        b0Var.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
        this.f5303a.e();
    }

    public void c() {
        this.f5303a.c();
    }

    @Override // com.bumptech.glide.load.data.e
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream a() {
        this.f5303a.reset();
        return this.f5303a;
    }
}
