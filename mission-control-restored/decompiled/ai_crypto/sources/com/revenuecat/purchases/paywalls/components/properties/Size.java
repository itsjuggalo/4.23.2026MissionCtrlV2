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
public final class Size {
    public static final Companion Companion = new Companion(null);
    private final SizeConstraint height;
    private final SizeConstraint width;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final b serializer() {
            return Size$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Size(int i7, SizeConstraint sizeConstraint, SizeConstraint sizeConstraint2, k0 k0Var) {
        if (3 != (i7 & 3)) {
            AbstractC2611a0.a(i7, 3, Size$$serializer.INSTANCE.getDescriptor());
        }
        this.width = sizeConstraint;
        this.height = sizeConstraint2;
    }

    public static final /* synthetic */ void write$Self(Size size, d dVar, e eVar) {
        SizeConstraintDeserializer sizeConstraintDeserializer = SizeConstraintDeserializer.INSTANCE;
        dVar.x(eVar, 0, sizeConstraintDeserializer, size.width);
        dVar.x(eVar, 1, sizeConstraintDeserializer, size.height);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return r.b(this.width, size.width) && r.b(this.height, size.height);
    }

    public final /* synthetic */ SizeConstraint getHeight() {
        return this.height;
    }

    public final /* synthetic */ SizeConstraint getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width.hashCode() * 31) + this.height.hashCode();
    }

    public String toString() {
        return "Size(width=" + this.width + ", height=" + this.height + ')';
    }

    public Size(SizeConstraint width, SizeConstraint height) {
        r.f(width, "width");
        r.f(height, "height");
        this.width = width;
        this.height = height;
    }
}
