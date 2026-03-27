package io.flutter.plugins.firebase.firebaseremoteconfig;

import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteConfigPigeonSettings {
    public static final Companion Companion = new Companion(null);
    private final long fetchTimeoutSeconds;
    private final long minimumFetchIntervalSeconds;

    public static final class Companion {
        private Companion() {
        }

        public final RemoteConfigPigeonSettings fromList(List<? extends Object> pigeonVar_list) {
            AbstractC2304t.f(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue = ((Long) obj).longValue();
            Object obj2 = pigeonVar_list.get(1);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.Long");
            return new RemoteConfigPigeonSettings(jLongValue, ((Long) obj2).longValue());
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public RemoteConfigPigeonSettings(long j8, long j9) {
        this.fetchTimeoutSeconds = j8;
        this.minimumFetchIntervalSeconds = j9;
    }

    public static /* synthetic */ RemoteConfigPigeonSettings copy$default(RemoteConfigPigeonSettings remoteConfigPigeonSettings, long j8, long j9, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            j8 = remoteConfigPigeonSettings.fetchTimeoutSeconds;
        }
        if ((i8 & 2) != 0) {
            j9 = remoteConfigPigeonSettings.minimumFetchIntervalSeconds;
        }
        return remoteConfigPigeonSettings.copy(j8, j9);
    }

    public final long component1() {
        return this.fetchTimeoutSeconds;
    }

    public final long component2() {
        return this.minimumFetchIntervalSeconds;
    }

    public final RemoteConfigPigeonSettings copy(long j8, long j9) {
        return new RemoteConfigPigeonSettings(j8, j9);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RemoteConfigPigeonSettings)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.deepEquals(toList(), ((RemoteConfigPigeonSettings) obj).toList());
    }

    public final long getFetchTimeoutSeconds() {
        return this.fetchTimeoutSeconds;
    }

    public final long getMinimumFetchIntervalSeconds() {
        return this.minimumFetchIntervalSeconds;
    }

    public int hashCode() {
        return toList().hashCode();
    }

    public final List<Object> toList() {
        return AbstractC2595q.l(Long.valueOf(this.fetchTimeoutSeconds), Long.valueOf(this.minimumFetchIntervalSeconds));
    }

    public String toString() {
        return "RemoteConfigPigeonSettings(fetchTimeoutSeconds=" + this.fetchTimeoutSeconds + ", minimumFetchIntervalSeconds=" + this.minimumFetchIntervalSeconds + ")";
    }
}
