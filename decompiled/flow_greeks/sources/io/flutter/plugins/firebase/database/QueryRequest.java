package io.flutter.plugins.firebase.database;

import dd.r;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005J\u0013\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010JB\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lio/flutter/plugins/firebase/database/QueryRequest;", "", Constants.PATH, "", Constants.MODIFIERS, "", "", "value", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "getPath", "()Ljava/lang/String;", "getModifiers", "()Ljava/util/List;", "getValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "toList", "equals", "other", "hashCode", "", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lio/flutter/plugins/firebase/database/QueryRequest;", "toString", "Companion", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class QueryRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Map<String, Object>> modifiers;
    private final String path;
    private final Boolean value;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¨\u0006\b"}, d2 = {"Lio/flutter/plugins/firebase/database/QueryRequest$Companion;", "", "<init>", "()V", "fromList", "Lio/flutter/plugins/firebase/database/QueryRequest;", "pigeonVar_list", "", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final QueryRequest fromList(List<? extends Object> pigeonVar_list) {
            kotlin.jvm.internal.t.f(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
            Object obj2 = pigeonVar_list.get(1);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.Any?>>");
            return new QueryRequest((String) obj, (List) obj2, (Boolean) pigeonVar_list.get(2));
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QueryRequest(String path, List<? extends Map<String, ? extends Object>> modifiers, Boolean bool) {
        kotlin.jvm.internal.t.f(path, "path");
        kotlin.jvm.internal.t.f(modifiers, "modifiers");
        this.path = path;
        this.modifiers = modifiers;
        this.value = bool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueryRequest copy$default(QueryRequest queryRequest, String str, List list, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = queryRequest.path;
        }
        if ((i10 & 2) != 0) {
            list = queryRequest.modifiers;
        }
        if ((i10 & 4) != 0) {
            bool = queryRequest.value;
        }
        return queryRequest.copy(str, list, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public final List<Map<String, Object>> component2() {
        return this.modifiers;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getValue() {
        return this.value;
    }

    public final QueryRequest copy(String path, List<? extends Map<String, ? extends Object>> modifiers, Boolean value) {
        kotlin.jvm.internal.t.f(path, "path");
        kotlin.jvm.internal.t.f(modifiers, "modifiers");
        return new QueryRequest(path, modifiers, value);
    }

    public boolean equals(Object other) {
        if (!(other instanceof QueryRequest)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        return GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.deepEquals(toList(), ((QueryRequest) other).toList());
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }

    public final String getPath() {
        return this.path;
    }

    public final Boolean getValue() {
        return this.value;
    }

    public int hashCode() {
        return toList().hashCode();
    }

    public final List<Object> toList() {
        return r.n(this.path, this.modifiers, this.value);
    }

    public String toString() {
        return "QueryRequest(path=" + this.path + ", modifiers=" + this.modifiers + ", value=" + this.value + ")";
    }

    public /* synthetic */ QueryRequest(String str, List list, Boolean bool, int i10, kotlin.jvm.internal.k kVar) {
        this(str, list, (i10 & 4) != 0 ? null : bool);
    }
}
