package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
final class UrlSurrogate {
    public static final Companion Companion = new Companion(null);
    private final ButtonComponent.UrlMethod method;
    private final String url_lid;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return UrlSurrogate$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ UrlSurrogate(int i4, String str, ButtonComponent.UrlMethod urlMethod, k0 k0Var, AbstractC1585j abstractC1585j) {
        this(i4, str, urlMethod, k0Var);
    }

    public static final /* synthetic */ void write$Self(UrlSurrogate urlSurrogate, d dVar, e eVar) {
        dVar.u(eVar, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m193boximpl(urlSurrogate.url_lid));
        dVar.u(eVar, 1, UrlMethodDeserializer.INSTANCE, urlSurrogate.method);
    }

    public final ButtonComponent.UrlMethod getMethod() {
        return this.method;
    }

    /* JADX INFO: renamed from: getUrl_lid-z7Tp-4o, reason: not valid java name */
    public final String m165getUrl_lidz7Tp4o() {
        return this.url_lid;
    }

    public /* synthetic */ UrlSurrogate(String str, ButtonComponent.UrlMethod urlMethod, AbstractC1585j abstractC1585j) {
        this(str, urlMethod);
    }

    private UrlSurrogate(int i4, String str, ButtonComponent.UrlMethod urlMethod, k0 k0Var) {
        if (3 != (i4 & 3)) {
            AbstractC0325a0.a(i4, 3, UrlSurrogate$$serializer.INSTANCE.getDescriptor());
        }
        this.url_lid = str;
        this.method = urlMethod;
    }

    private UrlSurrogate(String url_lid, ButtonComponent.UrlMethod method) {
        r.f(url_lid, "url_lid");
        r.f(method, "method");
        this.url_lid = url_lid;
        this.method = method;
    }
}
