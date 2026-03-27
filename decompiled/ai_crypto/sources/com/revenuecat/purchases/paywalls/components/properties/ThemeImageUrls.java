package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import n6.b;
import p6.e;
import q6.d;
import r6.AbstractC2611a0;
import r6.k0;

/* JADX INFO: loaded from: classes2.dex */
@InternalRevenueCatAPI
public final class ThemeImageUrls {
    public static final Companion Companion = new Companion(null);
    private final ImageUrls dark;
    private final ImageUrls light;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final b serializer() {
            return ThemeImageUrls$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ThemeImageUrls(int i7, ImageUrls imageUrls, ImageUrls imageUrls2, k0 k0Var) {
        if (1 != (i7 & 1)) {
            AbstractC2611a0.a(i7, 1, ThemeImageUrls$$serializer.INSTANCE.getDescriptor());
        }
        this.light = imageUrls;
        if ((i7 & 2) == 0) {
            this.dark = null;
        } else {
            this.dark = imageUrls2;
        }
    }

    public static final /* synthetic */ void write$Self(ThemeImageUrls themeImageUrls, d dVar, e eVar) {
        ImageUrls$$serializer imageUrls$$serializer = ImageUrls$$serializer.INSTANCE;
        dVar.x(eVar, 0, imageUrls$$serializer, themeImageUrls.light);
        if (!dVar.C(eVar, 1) && themeImageUrls.dark == null) {
            return;
        }
        dVar.r(eVar, 1, imageUrls$$serializer, themeImageUrls.dark);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThemeImageUrls)) {
            return false;
        }
        ThemeImageUrls themeImageUrls = (ThemeImageUrls) obj;
        return r.b(this.light, themeImageUrls.light) && r.b(this.dark, themeImageUrls.dark);
    }

    public final /* synthetic */ ImageUrls getDark() {
        return this.dark;
    }

    public final /* synthetic */ ImageUrls getLight() {
        return this.light;
    }

    public int hashCode() {
        int iHashCode = this.light.hashCode() * 31;
        ImageUrls imageUrls = this.dark;
        return iHashCode + (imageUrls == null ? 0 : imageUrls.hashCode());
    }

    public String toString() {
        return "ThemeImageUrls(light=" + this.light + ", dark=" + this.dark + ')';
    }

    public ThemeImageUrls(ImageUrls light, ImageUrls imageUrls) {
        r.f(light, "light");
        this.light = light;
        this.dark = imageUrls;
    }

    public /* synthetic */ ThemeImageUrls(ImageUrls imageUrls, ImageUrls imageUrls2, int i7, AbstractC2148j abstractC2148j) {
        this(imageUrls, (i7 & 2) != 0 ? null : imageUrls2);
    }
}
