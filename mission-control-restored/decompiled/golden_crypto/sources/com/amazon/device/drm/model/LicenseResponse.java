package com.amazon.device.drm.model;

import com.amazon.a.a.o.b;
import com.amazon.a.a.o.f;
import com.amazon.device.drm.a.c.a;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LicenseResponse {
    private static final String REQUEST_ID = "REQUEST_ID";
    private static final String REQUEST_STATUS = "REQUEST_STATUS";
    private static final String TO_STRING_FORMAT = "LicenseResponse: {requestId: \"%s\", requestStatus: \"%s\"}";
    private final RequestId requestId;
    private final RequestStatus requestStatus;

    public enum RequestStatus {
        LICENSED,
        NOT_LICENSED,
        ERROR_VERIFICATION,
        ERROR_INVALID_LICENSING_KEYS,
        EXPIRED,
        UNKNOWN_ERROR
    }

    public LicenseResponse(a aVar) {
        f.a(aVar.b(), b.B);
        f.a(aVar.c(), b.C);
        this.requestId = aVar.b();
        this.requestStatus = aVar.c();
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public String toString() {
        RequestId requestId = this.requestId;
        RequestStatus requestStatus = this.requestStatus;
        return String.format(TO_STRING_FORMAT, requestId, requestStatus != null ? requestStatus.toString() : AbstractJsonLexerKt.NULL);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(REQUEST_STATUS, this.requestStatus);
        jSONObject.put(REQUEST_ID, this.requestId);
        return jSONObject;
    }
}
