package com.amazon.device.simplesignin.a.a.a;

import com.amazon.d.a.j;
import com.amazon.device.simplesignin.a.a.c;
import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.GetUserAndLinksResponse;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14590b = "SSI_GetUserAndLinks";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14591c = "1.0";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14592d = "b";

    public b(a aVar, String str) {
        super(aVar, f14590b, "1.0");
        super.a(com.amazon.device.simplesignin.a.a.a.f14564a, str);
    }

    @Override // com.amazon.device.simplesignin.a.a.c
    public void a(RequestStatus requestStatus) {
        if (RequestStatus.INVALID_LINK_SIGNING_KEY_ENCRYPTION.equals(requestStatus) || RequestStatus.INVALID_LINK_SIGNING_KEY.equals(requestStatus)) {
            a(RequestStatus.FAILURE, null, null);
        } else {
            a(requestStatus, null, null);
        }
    }

    @Override // com.amazon.a.a.n.a.h
    public boolean b(j jVar) {
        List<Link> listA;
        Map mapB = jVar.b();
        if (mapB.containsKey(com.amazon.device.simplesignin.a.a.a.f14565b) && mapB.containsKey(com.amazon.device.simplesignin.a.a.a.f14566c)) {
            String str = (String) mapB.get(com.amazon.device.simplesignin.a.a.a.f14565b);
            String str2 = (String) mapB.get(com.amazon.device.simplesignin.a.a.a.f14566c);
            if (str != null && str2 != null && (listA = com.amazon.device.simplesignin.a.d.b.a(str, str2)) != null) {
                a(RequestStatus.SUCCESSFUL, str, listA);
                return true;
            }
        }
        a(RequestStatus.FAILURE);
        return false;
    }

    private void a(RequestStatus requestStatus, String str, List<Link> list) {
        d dVar = (d) j();
        GetUserAndLinksResponse getUserAndLinksResponse = new GetUserAndLinksResponse();
        getUserAndLinksResponse.setRequestId(dVar.e());
        getUserAndLinksResponse.setRequestStatus(requestStatus);
        getUserAndLinksResponse.setAmazonUserId(str);
        getUserAndLinksResponse.setLinks(list);
        super.a(getUserAndLinksResponse);
    }
}
