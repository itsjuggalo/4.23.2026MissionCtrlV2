package io.flutter.plugins.firebase.database;

import dd.r;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010JJ\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\"J\t\u0010#\u001a\u00020\bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010¨\u0006%"}, d2 = {"Lio/flutter/plugins/firebase/database/DatabasePigeonSettings;", "", Constants.DATABASE_PERSISTENCE_ENABLED, "", Constants.DATABASE_CACHE_SIZE_BYTES, "", Constants.DATABASE_LOGGING_ENABLED, Constants.DATABASE_EMULATOR_HOST, "", Constants.DATABASE_EMULATOR_PORT, "<init>", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;)V", "getPersistenceEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCacheSizeBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLoggingEnabled", "getEmulatorHost", "()Ljava/lang/String;", "getEmulatorPort", "toList", "", "equals", "other", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;)Lio/flutter/plugins/firebase/database/DatabasePigeonSettings;", "toString", "Companion", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DatabasePigeonSettings {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long cacheSizeBytes;
    private final String emulatorHost;
    private final Long emulatorPort;
    private final Boolean loggingEnabled;
    private final Boolean persistenceEnabled;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¨\u0006\b"}, d2 = {"Lio/flutter/plugins/firebase/database/DatabasePigeonSettings$Companion;", "", "<init>", "()V", "fromList", "Lio/flutter/plugins/firebase/database/DatabasePigeonSettings;", "pigeonVar_list", "", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final DatabasePigeonSettings fromList(List<? extends Object> pigeonVar_list) {
            kotlin.jvm.internal.t.f(pigeonVar_list, "pigeonVar_list");
            return new DatabasePigeonSettings((Boolean) pigeonVar_list.get(0), (Long) pigeonVar_list.get(1), (Boolean) pigeonVar_list.get(2), (String) pigeonVar_list.get(3), (Long) pigeonVar_list.get(4));
        }

        private Companion() {
        }
    }

    public DatabasePigeonSettings() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ DatabasePigeonSettings copy$default(DatabasePigeonSettings databasePigeonSettings, Boolean bool, Long l10, Boolean bool2, String str, Long l11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = databasePigeonSettings.persistenceEnabled;
        }
        if ((i10 & 2) != 0) {
            l10 = databasePigeonSettings.cacheSizeBytes;
        }
        if ((i10 & 4) != 0) {
            bool2 = databasePigeonSettings.loggingEnabled;
        }
        if ((i10 & 8) != 0) {
            str = databasePigeonSettings.emulatorHost;
        }
        if ((i10 & 16) != 0) {
            l11 = databasePigeonSettings.emulatorPort;
        }
        Long l12 = l11;
        Boolean bool3 = bool2;
        return databasePigeonSettings.copy(bool, l10, bool3, str, l12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getPersistenceEnabled() {
        return this.persistenceEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getCacheSizeBytes() {
        return this.cacheSizeBytes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getLoggingEnabled() {
        return this.loggingEnabled;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEmulatorHost() {
        return this.emulatorHost;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getEmulatorPort() {
        return this.emulatorPort;
    }

    public final DatabasePigeonSettings copy(Boolean persistenceEnabled, Long cacheSizeBytes, Boolean loggingEnabled, String emulatorHost, Long emulatorPort) {
        return new DatabasePigeonSettings(persistenceEnabled, cacheSizeBytes, loggingEnabled, emulatorHost, emulatorPort);
    }

    public boolean equals(Object other) {
        if (!(other instanceof DatabasePigeonSettings)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        return GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.deepEquals(toList(), ((DatabasePigeonSettings) other).toList());
    }

    public final Long getCacheSizeBytes() {
        return this.cacheSizeBytes;
    }

    public final String getEmulatorHost() {
        return this.emulatorHost;
    }

    public final Long getEmulatorPort() {
        return this.emulatorPort;
    }

    public final Boolean getLoggingEnabled() {
        return this.loggingEnabled;
    }

    public final Boolean getPersistenceEnabled() {
        return this.persistenceEnabled;
    }

    public int hashCode() {
        return toList().hashCode();
    }

    public final List<Object> toList() {
        return r.n(this.persistenceEnabled, this.cacheSizeBytes, this.loggingEnabled, this.emulatorHost, this.emulatorPort);
    }

    public String toString() {
        return "DatabasePigeonSettings(persistenceEnabled=" + this.persistenceEnabled + ", cacheSizeBytes=" + this.cacheSizeBytes + ", loggingEnabled=" + this.loggingEnabled + ", emulatorHost=" + this.emulatorHost + ", emulatorPort=" + this.emulatorPort + ")";
    }

    public DatabasePigeonSettings(Boolean bool, Long l10, Boolean bool2, String str, Long l11) {
        this.persistenceEnabled = bool;
        this.cacheSizeBytes = l10;
        this.loggingEnabled = bool2;
        this.emulatorHost = str;
        this.emulatorPort = l11;
    }

    public /* synthetic */ DatabasePigeonSettings(Boolean bool, Long l10, Boolean bool2, String str, Long l11, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : bool, (i10 & 2) != 0 ? null : l10, (i10 & 4) != 0 ? null : bool2, (i10 & 8) != 0 ? null : str, (i10 & 16) != 0 ? null : l11);
    }
}
