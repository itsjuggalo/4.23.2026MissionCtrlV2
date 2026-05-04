package io.flutter.plugins.firebase.database;

import dd.r;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lio/flutter/plugins/firebase/database/TransactionHandlerResult;", "", "value", "aborted", "", "exception", "<init>", "(Ljava/lang/Object;ZZ)V", "getValue", "()Ljava/lang/Object;", "getAborted", "()Z", "getException", "toList", "", "equals", "other", "hashCode", "", "component1", "component2", "component3", "copy", "toString", "", "Companion", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TransactionHandlerResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean aborted;
    private final boolean exception;
    private final Object value;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¨\u0006\b"}, d2 = {"Lio/flutter/plugins/firebase/database/TransactionHandlerResult$Companion;", "", "<init>", "()V", "fromList", "Lio/flutter/plugins/firebase/database/TransactionHandlerResult;", "pigeonVar_list", "", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final TransactionHandlerResult fromList(List<? extends Object> pigeonVar_list) {
            kotlin.jvm.internal.t.f(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            Object obj2 = pigeonVar_list.get(1);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) obj2).booleanValue();
            Object obj3 = pigeonVar_list.get(2);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            return new TransactionHandlerResult(obj, zBooleanValue, ((Boolean) obj3).booleanValue());
        }

        private Companion() {
        }
    }

    public TransactionHandlerResult(Object obj, boolean z10, boolean z11) {
        this.value = obj;
        this.aborted = z10;
        this.exception = z11;
    }

    public static /* synthetic */ TransactionHandlerResult copy$default(TransactionHandlerResult transactionHandlerResult, Object obj, boolean z10, boolean z11, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = transactionHandlerResult.value;
        }
        if ((i10 & 2) != 0) {
            z10 = transactionHandlerResult.aborted;
        }
        if ((i10 & 4) != 0) {
            z11 = transactionHandlerResult.exception;
        }
        return transactionHandlerResult.copy(obj, z10, z11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Object getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAborted() {
        return this.aborted;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getException() {
        return this.exception;
    }

    public final TransactionHandlerResult copy(Object value, boolean aborted, boolean exception) {
        return new TransactionHandlerResult(value, aborted, exception);
    }

    public boolean equals(Object other) {
        if (!(other instanceof TransactionHandlerResult)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        return GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.deepEquals(toList(), ((TransactionHandlerResult) other).toList());
    }

    public final boolean getAborted() {
        return this.aborted;
    }

    public final boolean getException() {
        return this.exception;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return toList().hashCode();
    }

    public final List<Object> toList() {
        return r.n(this.value, Boolean.valueOf(this.aborted), Boolean.valueOf(this.exception));
    }

    public String toString() {
        return "TransactionHandlerResult(value=" + this.value + ", aborted=" + this.aborted + ", exception=" + this.exception + ")";
    }

    public /* synthetic */ TransactionHandlerResult(Object obj, boolean z10, boolean z11, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : obj, z10, z11);
    }
}
