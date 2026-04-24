package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class TabControlToggleComponent implements PaywallComponent {
    public static final Companion Companion = new Companion(null);
    private final boolean defaultValue;
    private final ColorScheme thumbColorOff;
    private final ColorScheme thumbColorOn;
    private final ColorScheme trackColorOff;
    private final ColorScheme trackColorOn;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return TabControlToggleComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TabControlToggleComponent(int i4, boolean z4, ColorScheme colorScheme, ColorScheme colorScheme2, ColorScheme colorScheme3, ColorScheme colorScheme4, k0 k0Var) {
        if (31 != (i4 & 31)) {
            AbstractC0325a0.a(i4, 31, TabControlToggleComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.defaultValue = z4;
        this.thumbColorOn = colorScheme;
        this.thumbColorOff = colorScheme2;
        this.trackColorOn = colorScheme3;
        this.trackColorOff = colorScheme4;
    }

    public static /* synthetic */ void getDefaultValue$annotations() {
    }

    public static /* synthetic */ void getThumbColorOff$annotations() {
    }

    public static /* synthetic */ void getThumbColorOn$annotations() {
    }

    public static /* synthetic */ void getTrackColorOff$annotations() {
    }

    public static /* synthetic */ void getTrackColorOn$annotations() {
    }

    public static final /* synthetic */ void write$Self(TabControlToggleComponent tabControlToggleComponent, d dVar, e eVar) {
        dVar.y(eVar, 0, tabControlToggleComponent.defaultValue);
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        dVar.u(eVar, 1, colorScheme$$serializer, tabControlToggleComponent.thumbColorOn);
        dVar.u(eVar, 2, colorScheme$$serializer, tabControlToggleComponent.thumbColorOff);
        dVar.u(eVar, 3, colorScheme$$serializer, tabControlToggleComponent.trackColorOn);
        dVar.u(eVar, 4, colorScheme$$serializer, tabControlToggleComponent.trackColorOff);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabControlToggleComponent)) {
            return false;
        }
        TabControlToggleComponent tabControlToggleComponent = (TabControlToggleComponent) obj;
        return this.defaultValue == tabControlToggleComponent.defaultValue && r.b(this.thumbColorOn, tabControlToggleComponent.thumbColorOn) && r.b(this.thumbColorOff, tabControlToggleComponent.thumbColorOff) && r.b(this.trackColorOn, tabControlToggleComponent.trackColorOn) && r.b(this.trackColorOff, tabControlToggleComponent.trackColorOff);
    }

    public final /* synthetic */ boolean getDefaultValue() {
        return this.defaultValue;
    }

    public final /* synthetic */ ColorScheme getThumbColorOff() {
        return this.thumbColorOff;
    }

    public final /* synthetic */ ColorScheme getThumbColorOn() {
        return this.thumbColorOn;
    }

    public final /* synthetic */ ColorScheme getTrackColorOff() {
        return this.trackColorOff;
    }

    public final /* synthetic */ ColorScheme getTrackColorOn() {
        return this.trackColorOn;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.defaultValue) * 31) + this.thumbColorOn.hashCode()) * 31) + this.thumbColorOff.hashCode()) * 31) + this.trackColorOn.hashCode()) * 31) + this.trackColorOff.hashCode();
    }

    public String toString() {
        return "TabControlToggleComponent(defaultValue=" + this.defaultValue + ", thumbColorOn=" + this.thumbColorOn + ", thumbColorOff=" + this.thumbColorOff + ", trackColorOn=" + this.trackColorOn + ", trackColorOff=" + this.trackColorOff + ')';
    }

    public TabControlToggleComponent(boolean z4, ColorScheme thumbColorOn, ColorScheme thumbColorOff, ColorScheme trackColorOn, ColorScheme trackColorOff) {
        r.f(thumbColorOn, "thumbColorOn");
        r.f(thumbColorOff, "thumbColorOff");
        r.f(trackColorOn, "trackColorOn");
        r.f(trackColorOff, "trackColorOff");
        this.defaultValue = z4;
        this.thumbColorOn = thumbColorOn;
        this.thumbColorOff = thumbColorOff;
        this.trackColorOn = trackColorOn;
        this.trackColorOff = trackColorOff;
    }
}
