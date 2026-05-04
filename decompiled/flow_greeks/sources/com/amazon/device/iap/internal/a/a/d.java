package com.amazon.device.iap.internal.a.a;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.RequestId;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends com.amazon.device.iap.internal.a.c {
    public d(RequestId requestId, Set<String> set) {
        super(requestId);
        c cVar = new c(this, set);
        cVar.b(new b(this, set));
        a((h) cVar);
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void b() {
        a((ProductDataResponse) a().b());
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void c() {
        ProductDataResponse productDataResponseBuild = (ProductDataResponse) a().b();
        if (productDataResponseBuild == null) {
            productDataResponseBuild = new ProductDataResponseBuilder().setRequestId(d()).setRequestStatus(ProductDataResponse.RequestStatus.FAILED).build();
        }
        a(productDataResponseBuild);
    }
}
