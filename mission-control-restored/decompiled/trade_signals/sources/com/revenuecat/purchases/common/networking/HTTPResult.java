package com.revenuecat.purchases.common.networking;

import com.revenuecat.purchases.VerificationResult;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\b\u0018\u0000 -2\u00020\u0001:\u0002-.B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J=\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\u0006\u0010+\u001a\u00020\u0005J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult;", "", "responseCode", "", "payload", "", "origin", "Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "requestDate", "Ljava/util/Date;", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "(ILjava/lang/String;Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;Ljava/util/Date;Lcom/revenuecat/purchases/VerificationResult;)V", "backendErrorCode", "getBackendErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "backendErrorMessage", "getBackendErrorMessage", "()Ljava/lang/String;", "body", "Lorg/json/JSONObject;", "getBody", "()Lorg/json/JSONObject;", "getOrigin", "()Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "getPayload", "getRequestDate", "()Ljava/util/Date;", "getResponseCode", "()I", "getVerificationResult", "()Lcom/revenuecat/purchases/VerificationResult;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "serialize", "toString", "Companion", "Origin", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HTTPResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ETAG_HEADER_NAME = "X-RevenueCat-ETag";
    public static final String REQUEST_TIME_HEADER_NAME = "X-RevenueCat-Request-Time";
    public static final String SIGNATURE_HEADER_NAME = "X-Signature";
    private final Integer backendErrorCode;
    private final String backendErrorMessage;
    private final JSONObject body;
    private final Origin origin;
    private final String payload;
    private final Date requestDate;
    private final int responseCode;
    private final VerificationResult verificationResult;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult$Companion;", "", "()V", "ETAG_HEADER_NAME", "", "REQUEST_TIME_HEADER_NAME", "SIGNATURE_HEADER_NAME", "deserialize", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "serialized", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final HTTPResult deserialize(String serialized) throws JSONException {
            Origin originValueOf;
            VerificationResult verificationResultValueOf;
            AbstractC2304t.f(serialized, "serialized");
            JSONObject jSONObject = new JSONObject(serialized);
            int i8 = jSONObject.getInt("responseCode");
            String payload = jSONObject.getString("payload");
            if (jSONObject.has("origin")) {
                String string = jSONObject.getString("origin");
                AbstractC2304t.e(string, "jsonObject.getString(SERIALIZATION_NAME_ORIGIN)");
                originValueOf = Origin.valueOf(string);
            } else {
                originValueOf = Origin.CACHE;
            }
            Origin origin = originValueOf;
            Date date = jSONObject.has("requestDate") ? new Date(jSONObject.getLong("requestDate")) : null;
            if (jSONObject.has("verificationResult")) {
                String string2 = jSONObject.getString("verificationResult");
                AbstractC2304t.e(string2, "jsonObject.getString(SER…NAME_VERIFICATION_RESULT)");
                verificationResultValueOf = VerificationResult.valueOf(string2);
            } else {
                verificationResultValueOf = VerificationResult.NOT_REQUESTED;
            }
            VerificationResult verificationResult = verificationResultValueOf;
            AbstractC2304t.e(payload, "payload");
            return new HTTPResult(i8, payload, origin, date, verificationResult);
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "", "(Ljava/lang/String;I)V", "BACKEND", "CACHE", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Origin {
        BACKEND,
        CACHE
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public HTTPResult(int r2, java.lang.String r3, com.revenuecat.purchases.common.networking.HTTPResult.Origin r4, java.util.Date r5, com.revenuecat.purchases.VerificationResult r6) {
        /*
            r1 = this;
            java.lang.String r0 = "payload"
            kotlin.jvm.internal.AbstractC2304t.f(r3, r0)
            java.lang.String r0 = "origin"
            kotlin.jvm.internal.AbstractC2304t.f(r4, r0)
            java.lang.String r0 = "verificationResult"
            kotlin.jvm.internal.AbstractC2304t.f(r6, r0)
            r1.<init>()
            r1.responseCode = r2
            r1.payload = r3
            r1.origin = r4
            r1.requestDate = r5
            r1.verificationResult = r6
            boolean r2 = V6.C.a0(r3)
            r2 = r2 ^ 1
            r4 = 0
            if (r2 == 0) goto L26
            goto L27
        L26:
            r3 = r4
        L27:
            org.json.JSONObject r2 = new org.json.JSONObject
            if (r3 == 0) goto L2f
            r2.<init>(r3)
            goto L32
        L2f:
            r2.<init>()
        L32:
            r1.body = r2
            boolean r3 = com.revenuecat.purchases.common.BackendHelperKt.isSuccessful(r1)
            if (r3 != 0) goto L4b
            java.lang.String r3 = "code"
            int r3 = r2.optInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r5 = r3.intValue()
            if (r5 <= 0) goto L4b
            goto L4c
        L4b:
            r3 = r4
        L4c:
            r1.backendErrorCode = r3
            boolean r3 = com.revenuecat.purchases.common.BackendHelperKt.isSuccessful(r1)
            if (r3 != 0) goto L68
            java.lang.String r3 = "message"
            java.lang.String r2 = r2.optString(r3)
            java.lang.String r3 = "it"
            kotlin.jvm.internal.AbstractC2304t.e(r2, r3)
            boolean r3 = V6.C.a0(r2)
            r3 = r3 ^ 1
            if (r3 == 0) goto L68
            r4 = r2
        L68:
            r1.backendErrorMessage = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.networking.HTTPResult.<init>(int, java.lang.String, com.revenuecat.purchases.common.networking.HTTPResult$Origin, java.util.Date, com.revenuecat.purchases.VerificationResult):void");
    }

    public static /* synthetic */ HTTPResult copy$default(HTTPResult hTTPResult, int i8, String str, Origin origin, Date date, VerificationResult verificationResult, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = hTTPResult.responseCode;
        }
        if ((i9 & 2) != 0) {
            str = hTTPResult.payload;
        }
        String str2 = str;
        if ((i9 & 4) != 0) {
            origin = hTTPResult.origin;
        }
        Origin origin2 = origin;
        if ((i9 & 8) != 0) {
            date = hTTPResult.requestDate;
        }
        Date date2 = date;
        if ((i9 & 16) != 0) {
            verificationResult = hTTPResult.verificationResult;
        }
        return hTTPResult.copy(i8, str2, origin2, date2, verificationResult);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getResponseCode() {
        return this.responseCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPayload() {
        return this.payload;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Origin getOrigin() {
        return this.origin;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getRequestDate() {
        return this.requestDate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final VerificationResult getVerificationResult() {
        return this.verificationResult;
    }

    public final HTTPResult copy(int responseCode, String payload, Origin origin, Date requestDate, VerificationResult verificationResult) {
        AbstractC2304t.f(payload, "payload");
        AbstractC2304t.f(origin, "origin");
        AbstractC2304t.f(verificationResult, "verificationResult");
        return new HTTPResult(responseCode, payload, origin, requestDate, verificationResult);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HTTPResult)) {
            return false;
        }
        HTTPResult hTTPResult = (HTTPResult) other;
        return this.responseCode == hTTPResult.responseCode && AbstractC2304t.b(this.payload, hTTPResult.payload) && this.origin == hTTPResult.origin && AbstractC2304t.b(this.requestDate, hTTPResult.requestDate) && this.verificationResult == hTTPResult.verificationResult;
    }

    public final Integer getBackendErrorCode() {
        return this.backendErrorCode;
    }

    public final String getBackendErrorMessage() {
        return this.backendErrorMessage;
    }

    public final JSONObject getBody() {
        return this.body;
    }

    public final Origin getOrigin() {
        return this.origin;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final Date getRequestDate() {
        return this.requestDate;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final VerificationResult getVerificationResult() {
        return this.verificationResult;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.responseCode) * 31) + this.payload.hashCode()) * 31) + this.origin.hashCode()) * 31;
        Date date = this.requestDate;
        return ((iHashCode + (date == null ? 0 : date.hashCode())) * 31) + this.verificationResult.hashCode();
    }

    public final String serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("responseCode", this.responseCode);
        jSONObject.put("payload", this.payload);
        jSONObject.put("origin", this.origin.name());
        Date date = this.requestDate;
        jSONObject.put("requestDate", date != null ? Long.valueOf(date.getTime()) : null);
        jSONObject.put("verificationResult", this.verificationResult.name());
        String string = jSONObject.toString();
        AbstractC2304t.e(string, "jsonObject.toString()");
        return string;
    }

    public String toString() {
        return "HTTPResult(responseCode=" + this.responseCode + ", payload=" + this.payload + ", origin=" + this.origin + ", requestDate=" + this.requestDate + ", verificationResult=" + this.verificationResult + ')';
    }
}
