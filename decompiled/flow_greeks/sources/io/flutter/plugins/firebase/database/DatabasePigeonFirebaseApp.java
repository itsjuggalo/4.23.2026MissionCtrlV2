package io.flutter.plugins.firebase.database;

import dd.r;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;", "", "appName", "", Constants.DATABASE_URL, "settings", "Lio/flutter/plugins/firebase/database/DatabasePigeonSettings;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/flutter/plugins/firebase/database/DatabasePigeonSettings;)V", "getAppName", "()Ljava/lang/String;", "getDatabaseURL", "getSettings", "()Lio/flutter/plugins/firebase/database/DatabasePigeonSettings;", "toList", "", "equals", "", "other", "hashCode", "", "component1", "component2", "component3", "copy", "toString", "Companion", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DatabasePigeonFirebaseApp {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String appName;
    private final String databaseURL;
    private final DatabasePigeonSettings settings;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¨\u0006\b"}, d2 = {"Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp$Companion;", "", "<init>", "()V", "fromList", "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;", "pigeonVar_list", "", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final DatabasePigeonFirebaseApp fromList(List<? extends Object> pigeonVar_list) {
            kotlin.jvm.internal.t.f(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) pigeonVar_list.get(1);
            Object obj2 = pigeonVar_list.get(2);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonSettings");
            return new DatabasePigeonFirebaseApp((String) obj, str, (DatabasePigeonSettings) obj2);
        }

        private Companion() {
        }
    }

    public DatabasePigeonFirebaseApp(String appName, String str, DatabasePigeonSettings settings) {
        kotlin.jvm.internal.t.f(appName, "appName");
        kotlin.jvm.internal.t.f(settings, "settings");
        this.appName = appName;
        this.databaseURL = str;
        this.settings = settings;
    }

    public static /* synthetic */ DatabasePigeonFirebaseApp copy$default(DatabasePigeonFirebaseApp databasePigeonFirebaseApp, String str, String str2, DatabasePigeonSettings databasePigeonSettings, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = databasePigeonFirebaseApp.appName;
        }
        if ((i10 & 2) != 0) {
            str2 = databasePigeonFirebaseApp.databaseURL;
        }
        if ((i10 & 4) != 0) {
            databasePigeonSettings = databasePigeonFirebaseApp.settings;
        }
        return databasePigeonFirebaseApp.copy(str, str2, databasePigeonSettings);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDatabaseURL() {
        return this.databaseURL;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final DatabasePigeonSettings getSettings() {
        return this.settings;
    }

    public final DatabasePigeonFirebaseApp copy(String appName, String databaseURL, DatabasePigeonSettings settings) {
        kotlin.jvm.internal.t.f(appName, "appName");
        kotlin.jvm.internal.t.f(settings, "settings");
        return new DatabasePigeonFirebaseApp(appName, databaseURL, settings);
    }

    public boolean equals(Object other) {
        if (!(other instanceof DatabasePigeonFirebaseApp)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        return GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.deepEquals(toList(), ((DatabasePigeonFirebaseApp) other).toList());
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getDatabaseURL() {
        return this.databaseURL;
    }

    public final DatabasePigeonSettings getSettings() {
        return this.settings;
    }

    public int hashCode() {
        return toList().hashCode();
    }

    public final List<Object> toList() {
        return r.n(this.appName, this.databaseURL, this.settings);
    }

    public String toString() {
        return "DatabasePigeonFirebaseApp(appName=" + this.appName + ", databaseURL=" + this.databaseURL + ", settings=" + this.settings + ")";
    }

    public /* synthetic */ DatabasePigeonFirebaseApp(String str, String str2, DatabasePigeonSettings databasePigeonSettings, int i10, kotlin.jvm.internal.k kVar) {
        this(str, (i10 & 2) != 0 ? null : str2, databasePigeonSettings);
    }
}
