package com.amazon.device.simplesignin.a.a.b;

import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.LinkUserAccountResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends com.amazon.device.simplesignin.a.a.c {
    public c(d dVar, String str, String str2) {
        super(dVar, str, str2);
    }

    @Override // com.amazon.device.simplesignin.a.a.c
    public void a(RequestStatus requestStatus) {
        a(requestStatus, null, null);
    }

    public void a(RequestStatus requestStatus, String str, LinkUserAccountResponse.SuccessCode successCode) {
        d dVar = (d) j();
        LinkUserAccountResponse linkUserAccountResponse = new LinkUserAccountResponse();
        linkUserAccountResponse.setRequestId(dVar.e());
        linkUserAccountResponse.setRequestStatus(requestStatus);
        linkUserAccountResponse.setLinkId(str);
        linkUserAccountResponse.setSuccessCode(successCode);
        super.a(linkUserAccountResponse);
    }

    public boolean a(Map map) {
        if (!map.containsKey(com.amazon.device.simplesignin.a.a.a.f10465m)) {
            a(RequestStatus.FAILURE);
            return false;
        }
        String str = (String) map.get(com.amazon.device.simplesignin.a.a.a.f10465m);
        if (str == null) {
            a(RequestStatus.FAILURE);
            return false;
        }
        String strA = (!map.containsKey(com.amazon.device.simplesignin.a.a.a.f10463k) || map.get(com.amazon.device.simplesignin.a.a.a.f10463k) == null) ? null : (String) map.get(com.amazon.device.simplesignin.a.a.a.f10463k);
        if (map.containsKey(com.amazon.device.simplesignin.a.a.a.f10464l) && map.get(com.amazon.device.simplesignin.a.a.a.f10464l) != null) {
            strA = com.amazon.device.simplesignin.a.d.b.a((String) map.get(com.amazon.device.simplesignin.a.a.a.f10464l));
        }
        a(RequestStatus.SUCCESSFUL, strA, LinkUserAccountResponse.SuccessCode.valueOf(str));
        return true;
    }
}
