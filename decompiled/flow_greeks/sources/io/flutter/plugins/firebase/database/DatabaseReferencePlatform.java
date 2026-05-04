package io.flutter.plugins.firebase.database;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lio/flutter/plugins/firebase/database/DatabaseReferencePlatform;", "", Constants.PATH, "", "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "toList", "", "equals", "", "other", "hashCode", "", "component1", "copy", "toString", "Companion", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DatabaseReferencePlatform {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String path;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¨\u0006\b"}, d2 = {"Lio/flutter/plugins/firebase/database/DatabaseReferencePlatform$Companion;", "", "<init>", "()V", "fromList", "Lio/flutter/plugins/firebase/database/DatabaseReferencePlatform;", "pigeonVar_list", "", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final DatabaseReferencePlatform fromList(List<? extends Object> pigeonVar_list) {
            kotlin.jvm.internal.t.f(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
            return new DatabaseReferencePlatform((String) obj);
        }

        private Companion() {
        }
    }

    public DatabaseReferencePlatform(String path) {
        kotlin.jvm.internal.t.f(path, "path");
        this.path = path;
    }

    public static /* synthetic */ DatabaseReferencePlatform copy$default(DatabaseReferencePlatform databaseReferencePlatform, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = databaseReferencePlatform.path;
        }
        return databaseReferencePlatform.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public final DatabaseReferencePlatform copy(String path) {
        kotlin.jvm.internal.t.f(path, "path");
        return new DatabaseReferencePlatform(path);
    }

    public boolean equals(Object other) {
        if (!(other instanceof DatabaseReferencePlatform)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        return GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.deepEquals(toList(), ((DatabaseReferencePlatform) other).toList());
    }

    public final String getPath() {
        return this.path;
    }

    public int hashCode() {
        return toList().hashCode();
    }

    public final List<Object> toList() {
        return dd.q.e(this.path);
    }

    public String toString() {
        return "DatabaseReferencePlatform(path=" + this.path + ")";
    }
}
