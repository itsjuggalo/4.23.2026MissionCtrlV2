package x0;

import android.os.Bundle;
import dd.u0;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y extends g {
    public /* synthetic */ y(Bundle bundle, String str, Bundle bundle2, boolean z10, boolean z11, Set set, int i10, int i11, kotlin.jvm.internal.k kVar) {
        this(bundle, str, bundle2, z10, (i11 & 16) != 0 ? false : z11, (i11 & 32) != 0 ? u0.d() : set, (i11 & 64) != 0 ? 2000 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(Bundle requestData, String type, Bundle candidateQueryData, boolean z10, boolean z11, Set allowedProviders, int i10) {
        super(type, requestData, candidateQueryData, z10, z11, allowedProviders, i10);
        kotlin.jvm.internal.t.f(requestData, "requestData");
        kotlin.jvm.internal.t.f(type, "type");
        kotlin.jvm.internal.t.f(candidateQueryData, "candidateQueryData");
        kotlin.jvm.internal.t.f(allowedProviders, "allowedProviders");
        if (type.length() <= 0) {
            throw new IllegalArgumentException("type should not be empty");
        }
        if (i10 == 100) {
            throw new IllegalArgumentException("Custom types should not have passkey level priority.");
        }
    }

    public /* synthetic */ y(String str, Bundle bundle, Bundle bundle2, boolean z10, boolean z11, Set set, int i10, kotlin.jvm.internal.k kVar) {
        this(str, bundle, bundle2, z10, (i10 & 16) != 0 ? false : z11, (i10 & 32) != 0 ? u0.d() : set);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y(String type, Bundle requestData, Bundle candidateQueryData, boolean z10, boolean z11, Set allowedProviders) {
        this(requestData, type, candidateQueryData, z10, z11, allowedProviders, 0, 64, (kotlin.jvm.internal.k) null);
        kotlin.jvm.internal.t.f(type, "type");
        kotlin.jvm.internal.t.f(requestData, "requestData");
        kotlin.jvm.internal.t.f(candidateQueryData, "candidateQueryData");
        kotlin.jvm.internal.t.f(allowedProviders, "allowedProviders");
    }

    public /* synthetic */ y(String str, Bundle bundle, Bundle bundle2, boolean z10, boolean z11, Set set, int i10, int i11, kotlin.jvm.internal.k kVar) {
        this(str, bundle, bundle2, z10, (i11 & 16) != 0 ? false : z11, (i11 & 32) != 0 ? u0.d() : set, (i11 & 64) != 0 ? 2000 : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y(String type, Bundle requestData, Bundle candidateQueryData, boolean z10, boolean z11, Set allowedProviders, int i10) {
        this(requestData, type, candidateQueryData, z10, z11, allowedProviders, i10);
        kotlin.jvm.internal.t.f(type, "type");
        kotlin.jvm.internal.t.f(requestData, "requestData");
        kotlin.jvm.internal.t.f(candidateQueryData, "candidateQueryData");
        kotlin.jvm.internal.t.f(allowedProviders, "allowedProviders");
    }
}
