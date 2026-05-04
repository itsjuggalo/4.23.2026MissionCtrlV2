package io.flutter.plugins.firebase.database;

import dd.r;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lio/flutter/plugins/firebase/database/TransactionRequest;", "", Constants.PATH, "", Constants.TRANSACTION_KEY, "", "applyLocally", "", "<init>", "(Ljava/lang/String;JZ)V", "getPath", "()Ljava/lang/String;", "getTransactionKey", "()J", "getApplyLocally", "()Z", "toList", "", "equals", "other", "hashCode", "", "component1", "component2", "component3", "copy", "toString", "Companion", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TransactionRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean applyLocally;
    private final String path;
    private final long transactionKey;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¨\u0006\b"}, d2 = {"Lio/flutter/plugins/firebase/database/TransactionRequest$Companion;", "", "<init>", "()V", "fromList", "Lio/flutter/plugins/firebase/database/TransactionRequest;", "pigeonVar_list", "", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final TransactionRequest fromList(List<? extends Object> pigeonVar_list) {
            kotlin.jvm.internal.t.f(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
            Object obj2 = pigeonVar_list.get(1);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue = ((Long) obj2).longValue();
            Object obj3 = pigeonVar_list.get(2);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            return new TransactionRequest((String) obj, jLongValue, ((Boolean) obj3).booleanValue());
        }

        private Companion() {
        }
    }

    public TransactionRequest(String path, long j10, boolean z10) {
        kotlin.jvm.internal.t.f(path, "path");
        this.path = path;
        this.transactionKey = j10;
        this.applyLocally = z10;
    }

    public static /* synthetic */ TransactionRequest copy$default(TransactionRequest transactionRequest, String str, long j10, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = transactionRequest.path;
        }
        if ((i10 & 2) != 0) {
            j10 = transactionRequest.transactionKey;
        }
        if ((i10 & 4) != 0) {
            z10 = transactionRequest.applyLocally;
        }
        return transactionRequest.copy(str, j10, z10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTransactionKey() {
        return this.transactionKey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getApplyLocally() {
        return this.applyLocally;
    }

    public final TransactionRequest copy(String path, long transactionKey, boolean applyLocally) {
        kotlin.jvm.internal.t.f(path, "path");
        return new TransactionRequest(path, transactionKey, applyLocally);
    }

    public boolean equals(Object other) {
        if (!(other instanceof TransactionRequest)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        return GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.deepEquals(toList(), ((TransactionRequest) other).toList());
    }

    public final boolean getApplyLocally() {
        return this.applyLocally;
    }

    public final String getPath() {
        return this.path;
    }

    public final long getTransactionKey() {
        return this.transactionKey;
    }

    public int hashCode() {
        return toList().hashCode();
    }

    public final List<Object> toList() {
        return r.n(this.path, Long.valueOf(this.transactionKey), Boolean.valueOf(this.applyLocally));
    }

    public String toString() {
        return "TransactionRequest(path=" + this.path + ", transactionKey=" + this.transactionKey + ", applyLocally=" + this.applyLocally + ")";
    }
}
