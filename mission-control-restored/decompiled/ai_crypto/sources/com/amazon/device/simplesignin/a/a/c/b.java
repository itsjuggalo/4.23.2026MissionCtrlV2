package com.amazon.device.simplesignin.a.a.c;

import android.util.Log;
import com.amazon.d.a.j;
import com.amazon.device.simplesignin.a.a.c;
import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.request.SSIEventRequest;
import com.amazon.device.simplesignin.model.response.RecordMetricsEventResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10496b = "SSI_PublishMetric";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10497c = "1.0";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10498d = "b";

    public b(a aVar, SSIEventRequest sSIEventRequest) {
        super(aVar, f10496b, "1.0");
        super.a(com.amazon.device.simplesignin.a.a.a.f10472t, sSIEventRequest.getEvent().toString());
        super.a(com.amazon.device.simplesignin.a.a.a.f10473u, sSIEventRequest.getEpochTimestamp());
        if (sSIEventRequest.getFailureReason() != null) {
            super.a(com.amazon.device.simplesignin.a.a.a.f10474v, sSIEventRequest.getFailureReason().toString());
        } else {
            super.a(com.amazon.device.simplesignin.a.a.a.f10474v, "NA");
        }
    }

    @Override // com.amazon.device.simplesignin.a.a.c
    public void a(RequestStatus requestStatus) {
        b(requestStatus);
    }

    @Override // com.amazon.a.a.n.a.h
    public boolean b(j jVar) {
        Map mapB = jVar.b();
        if (mapB.containsKey(com.amazon.device.simplesignin.a.a.a.f10471s)) {
            b(RequestStatus.SUCCESSFUL);
            return Boolean.parseBoolean(mapB.get(com.amazon.device.simplesignin.a.a.a.f10471s).toString());
        }
        a(RequestStatus.FAILURE);
        return false;
    }

    private void b(RequestStatus requestStatus) {
        d dVar = (d) j();
        Log.i(f10498d, "Response for request id: " + dVar.e() + " is: " + requestStatus.toString());
        RecordMetricsEventResponse recordMetricsEventResponse = new RecordMetricsEventResponse();
        recordMetricsEventResponse.setRequestId(dVar.e());
        recordMetricsEventResponse.setRequestStatus(requestStatus);
        super.a(recordMetricsEventResponse);
    }
}
