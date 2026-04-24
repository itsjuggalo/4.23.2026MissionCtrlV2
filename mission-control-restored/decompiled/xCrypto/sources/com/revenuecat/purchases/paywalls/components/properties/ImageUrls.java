package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import J3.w0;
import W2.w;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class ImageUrls {
    public static final Companion Companion = new Companion(null);
    private final int height;
    private final URL original;
    private final URL webp;
    private final URL webpLowRes;
    private final int width;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return ImageUrls$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ImageUrls(int i4, URL url, URL url2, URL url3, w wVar, w wVar2, k0 k0Var, AbstractC1585j abstractC1585j) {
        this(i4, url, url2, url3, wVar, wVar2, k0Var);
    }

    public static /* synthetic */ void getOriginal$annotations() {
    }

    public static /* synthetic */ void getWebp$annotations() {
    }

    public static /* synthetic */ void getWebpLowRes$annotations() {
    }

    public static final /* synthetic */ void write$Self(ImageUrls imageUrls, d dVar, e eVar) {
        URLSerializer uRLSerializer = URLSerializer.INSTANCE;
        dVar.u(eVar, 0, uRLSerializer, imageUrls.original);
        dVar.u(eVar, 1, uRLSerializer, imageUrls.webp);
        dVar.u(eVar, 2, uRLSerializer, imageUrls.webpLowRes);
        w0 w0Var = w0.f990a;
        dVar.u(eVar, 3, w0Var, w.a(imageUrls.width));
        dVar.u(eVar, 4, w0Var, w.a(imageUrls.height));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageUrls)) {
            return false;
        }
        ImageUrls imageUrls = (ImageUrls) obj;
        return r.b(this.original, imageUrls.original) && r.b(this.webp, imageUrls.webp) && r.b(this.webpLowRes, imageUrls.webpLowRes) && this.width == imageUrls.width && this.height == imageUrls.height;
    }

    /* JADX INFO: renamed from: getHeight-pVg5ArA, reason: not valid java name */
    public final /* synthetic */ int m205getHeightpVg5ArA() {
        return this.height;
    }

    public final /* synthetic */ URL getOriginal() {
        return this.original;
    }

    public final /* synthetic */ URL getWebp() {
        return this.webp;
    }

    public final /* synthetic */ URL getWebpLowRes() {
        return this.webpLowRes;
    }

    /* JADX INFO: renamed from: getWidth-pVg5ArA, reason: not valid java name */
    public final /* synthetic */ int m206getWidthpVg5ArA() {
        return this.width;
    }

    public int hashCode() {
        return (((((((this.original.hashCode() * 31) + this.webp.hashCode()) * 31) + this.webpLowRes.hashCode()) * 31) + w.h(this.width)) * 31) + w.h(this.height);
    }

    public String toString() {
        return "ImageUrls(original=" + this.original + ", webp=" + this.webp + ", webpLowRes=" + this.webpLowRes + ", width=" + ((Object) w.i(this.width)) + ", height=" + ((Object) w.i(this.height)) + ')';
    }

    public /* synthetic */ ImageUrls(URL url, URL url2, URL url3, int i4, int i5, AbstractC1585j abstractC1585j) {
        this(url, url2, url3, i4, i5);
    }

    private ImageUrls(int i4, URL url, URL url2, URL url3, w wVar, w wVar2, k0 k0Var) {
        if (31 != (i4 & 31)) {
            AbstractC0325a0.a(i4, 31, ImageUrls$$serializer.INSTANCE.getDescriptor());
        }
        this.original = url;
        this.webp = url2;
        this.webpLowRes = url3;
        this.width = wVar.k();
        this.height = wVar2.k();
    }

    private ImageUrls(URL original, URL webp, URL webpLowRes, int i4, int i5) {
        r.f(original, "original");
        r.f(webp, "webp");
        r.f(webpLowRes, "webpLowRes");
        this.original = original;
        this.webp = webp;
        this.webpLowRes = webpLowRes;
        this.width = i4;
        this.height = i5;
    }
}
