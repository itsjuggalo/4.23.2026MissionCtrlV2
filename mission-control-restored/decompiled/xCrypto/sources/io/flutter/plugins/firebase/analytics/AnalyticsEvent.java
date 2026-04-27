package io.flutter.plugins.firebase.analytics;

import X2.AbstractC0769p;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class AnalyticsEvent {
    public static final Companion Companion = new Companion(null);
    private final String name;
    private final Map<String, Object> parameters;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final AnalyticsEvent fromList(List<? extends Object> pigeonVar_list) {
            kotlin.jvm.internal.r.f(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.String");
            return new AnalyticsEvent((String) obj, (Map) pigeonVar_list.get(1));
        }

        private Companion() {
        }
    }

    public AnalyticsEvent(String name, Map<String, ? extends Object> map) {
        kotlin.jvm.internal.r.f(name, "name");
        this.name = name;
        this.parameters = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnalyticsEvent copy$default(AnalyticsEvent analyticsEvent, String str, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = analyticsEvent.name;
        }
        if ((i4 & 2) != 0) {
            map = analyticsEvent.parameters;
        }
        return analyticsEvent.copy(str, map);
    }

    public final String component1() {
        return this.name;
    }

    public final Map<String, Object> component2() {
        return this.parameters;
    }

    public final AnalyticsEvent copy(String name, Map<String, ? extends Object> map) {
        kotlin.jvm.internal.r.f(name, "name");
        return new AnalyticsEvent(name, map);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AnalyticsEvent)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.deepEquals(toList(), ((AnalyticsEvent) obj).toList());
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        return toList().hashCode();
    }

    public final List<Object> toList() {
        return AbstractC0769p.j(this.name, this.parameters);
    }

    public String toString() {
        return "AnalyticsEvent(name=" + this.name + ", parameters=" + this.parameters + ")";
    }

    public /* synthetic */ AnalyticsEvent(String str, Map map, int i4, AbstractC1585j abstractC1585j) {
        this(str, (i4 & 2) != 0 ? null : map);
    }
}
