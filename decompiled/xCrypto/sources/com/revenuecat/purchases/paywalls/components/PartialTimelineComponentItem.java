package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.C0335h;
import J3.k0;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class PartialTimelineComponentItem implements PartialComponent {
    public static final Companion Companion = new Companion(null);
    private final TimelineComponent.Connector connector;
    private final Boolean visible;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return PartialTimelineComponentItem$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PartialTimelineComponentItem() {
        this((Boolean) null, (TimelineComponent.Connector) (0 == true ? 1 : 0), 3, (AbstractC1585j) (0 == true ? 1 : 0));
    }

    public static final /* synthetic */ void write$Self(PartialTimelineComponentItem partialTimelineComponentItem, d dVar, e eVar) {
        if (dVar.j(eVar, 0) || partialTimelineComponentItem.visible != null) {
            dVar.E(eVar, 0, C0335h.f929a, partialTimelineComponentItem.visible);
        }
        if (!dVar.j(eVar, 1) && partialTimelineComponentItem.connector == null) {
            return;
        }
        dVar.E(eVar, 1, TimelineComponent$Connector$$serializer.INSTANCE, partialTimelineComponentItem.connector);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialTimelineComponentItem)) {
            return false;
        }
        PartialTimelineComponentItem partialTimelineComponentItem = (PartialTimelineComponentItem) obj;
        return r.b(this.visible, partialTimelineComponentItem.visible) && r.b(this.connector, partialTimelineComponentItem.connector);
    }

    public final /* synthetic */ TimelineComponent.Connector getConnector() {
        return this.connector;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        TimelineComponent.Connector connector = this.connector;
        return iHashCode + (connector != null ? connector.hashCode() : 0);
    }

    public String toString() {
        return "PartialTimelineComponentItem(visible=" + this.visible + ", connector=" + this.connector + ')';
    }

    public /* synthetic */ PartialTimelineComponentItem(int i4, Boolean bool, TimelineComponent.Connector connector, k0 k0Var) {
        if ((i4 & 1) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i4 & 2) == 0) {
            this.connector = null;
        } else {
            this.connector = connector;
        }
    }

    public PartialTimelineComponentItem(Boolean bool, TimelineComponent.Connector connector) {
        this.visible = bool;
        this.connector = connector;
    }

    public /* synthetic */ PartialTimelineComponentItem(Boolean bool, TimelineComponent.Connector connector, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? null : bool, (i4 & 2) != 0 ? null : connector);
    }
}
