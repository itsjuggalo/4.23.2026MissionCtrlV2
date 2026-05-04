package io.flutter.plugins.firebase.database;

import dd.r;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;", "", Constants.PATH, "", "value", Constants.PRIORITY, "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "getPath", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "getPriority", "toList", "", "equals", "", "other", "hashCode", "", "component1", "component2", "component3", "copy", "toString", "Companion", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DatabaseReferenceRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String path;
    private final Object priority;
    private final Object value;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¨\u0006\b"}, d2 = {"Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest$Companion;", "", "<init>", "()V", "fromList", "Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;", "pigeonVar_list", "", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final DatabaseReferenceRequest fromList(List<? extends Object> pigeonVar_list) {
            kotlin.jvm.internal.t.f(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
            return new DatabaseReferenceRequest((String) obj, pigeonVar_list.get(1), pigeonVar_list.get(2));
        }

        private Companion() {
        }
    }

    public DatabaseReferenceRequest(String path, Object obj, Object obj2) {
        kotlin.jvm.internal.t.f(path, "path");
        this.path = path;
        this.value = obj;
        this.priority = obj2;
    }

    public static /* synthetic */ DatabaseReferenceRequest copy$default(DatabaseReferenceRequest databaseReferenceRequest, String str, Object obj, Object obj2, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            str = databaseReferenceRequest.path;
        }
        if ((i10 & 2) != 0) {
            obj = databaseReferenceRequest.value;
        }
        if ((i10 & 4) != 0) {
            obj2 = databaseReferenceRequest.priority;
        }
        return databaseReferenceRequest.copy(str, obj, obj2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Object getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Object getPriority() {
        return this.priority;
    }

    public final DatabaseReferenceRequest copy(String path, Object value, Object priority) {
        kotlin.jvm.internal.t.f(path, "path");
        return new DatabaseReferenceRequest(path, value, priority);
    }

    public boolean equals(Object other) {
        if (!(other instanceof DatabaseReferenceRequest)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        return GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.deepEquals(toList(), ((DatabaseReferenceRequest) other).toList());
    }

    public final String getPath() {
        return this.path;
    }

    public final Object getPriority() {
        return this.priority;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return toList().hashCode();
    }

    public final List<Object> toList() {
        return r.n(this.path, this.value, this.priority);
    }

    public String toString() {
        return "DatabaseReferenceRequest(path=" + this.path + ", value=" + this.value + ", priority=" + this.priority + ")";
    }

    public /* synthetic */ DatabaseReferenceRequest(String str, Object obj, Object obj2, int i10, kotlin.jvm.internal.k kVar) {
        this(str, (i10 & 2) != 0 ? null : obj, (i10 & 4) != 0 ? null : obj2);
    }
}
