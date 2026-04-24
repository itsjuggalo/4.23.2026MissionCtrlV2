package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class PackageComponent implements PaywallComponent {
    public static final Companion Companion = new Companion(null);
    private final boolean isSelectedByDefault;
    private final String packageId;
    private final StackComponent stack;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return PackageComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PackageComponent(int i4, String str, boolean z4, StackComponent stackComponent, k0 k0Var) {
        if (7 != (i4 & 7)) {
            AbstractC0325a0.a(i4, 7, PackageComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.packageId = str;
        this.isSelectedByDefault = z4;
        this.stack = stackComponent;
    }

    public static /* synthetic */ void getPackageId$annotations() {
    }

    public static /* synthetic */ void isSelectedByDefault$annotations() {
    }

    public static final /* synthetic */ void write$Self(PackageComponent packageComponent, d dVar, e eVar) {
        dVar.o(eVar, 0, packageComponent.packageId);
        dVar.y(eVar, 1, packageComponent.isSelectedByDefault);
        dVar.u(eVar, 2, StackComponent$$serializer.INSTANCE, packageComponent.stack);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PackageComponent)) {
            return false;
        }
        PackageComponent packageComponent = (PackageComponent) obj;
        return r.b(this.packageId, packageComponent.packageId) && this.isSelectedByDefault == packageComponent.isSelectedByDefault && r.b(this.stack, packageComponent.stack);
    }

    public final /* synthetic */ String getPackageId() {
        return this.packageId;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public int hashCode() {
        return (((this.packageId.hashCode() * 31) + Boolean.hashCode(this.isSelectedByDefault)) * 31) + this.stack.hashCode();
    }

    public final /* synthetic */ boolean isSelectedByDefault() {
        return this.isSelectedByDefault;
    }

    public String toString() {
        return "PackageComponent(packageId=" + this.packageId + ", isSelectedByDefault=" + this.isSelectedByDefault + ", stack=" + this.stack + ')';
    }

    public PackageComponent(String packageId, boolean z4, StackComponent stack) {
        r.f(packageId, "packageId");
        r.f(stack, "stack");
        this.packageId = packageId;
        this.isSelectedByDefault = z4;
        this.stack = stack;
    }
}
