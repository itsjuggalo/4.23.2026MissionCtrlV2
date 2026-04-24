package com.revenuecat.purchases.common.networking;

import com.revenuecat.purchases.common.networking.HTTPResult;
import java.util.Date;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class HTTPResultWithETag {
    public static final Companion Companion = new Companion(null);
    private static final String SERIALIZATION_NAME_ETAG = "eTag";
    private static final String SERIALIZATION_NAME_HTTPRESULT = "httpResult";
    private static final String SERIALIZATION_NAME_LAST_REFRESH_TIME = "lastRefreshTime";
    private final ETagData eTagData;
    private final HTTPResult httpResult;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final HTTPResultWithETag deserialize(String serialized) throws JSONException {
            r.f(serialized, "serialized");
            JSONObject jSONObject = new JSONObject(serialized);
            String eTag = jSONObject.getString(HTTPResultWithETag.SERIALIZATION_NAME_ETAG);
            Long lValueOf = Long.valueOf(jSONObject.optLong(HTTPResultWithETag.SERIALIZATION_NAME_LAST_REFRESH_TIME, -1L));
            if (lValueOf.longValue() == -1) {
                lValueOf = null;
            }
            Date date = lValueOf != null ? new Date(lValueOf.longValue()) : null;
            String serializedHTTPResult = jSONObject.getString(HTTPResultWithETag.SERIALIZATION_NAME_HTTPRESULT);
            r.e(eTag, "eTag");
            ETagData eTagData = new ETagData(eTag, date);
            HTTPResult.Companion companion = HTTPResult.Companion;
            r.e(serializedHTTPResult, "serializedHTTPResult");
            return new HTTPResultWithETag(eTagData, companion.deserialize(serializedHTTPResult));
        }

        private Companion() {
        }
    }

    public HTTPResultWithETag(ETagData eTagData, HTTPResult httpResult) {
        r.f(eTagData, "eTagData");
        r.f(httpResult, "httpResult");
        this.eTagData = eTagData;
        this.httpResult = httpResult;
    }

    public static /* synthetic */ HTTPResultWithETag copy$default(HTTPResultWithETag hTTPResultWithETag, ETagData eTagData, HTTPResult hTTPResult, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            eTagData = hTTPResultWithETag.eTagData;
        }
        if ((i4 & 2) != 0) {
            hTTPResult = hTTPResultWithETag.httpResult;
        }
        return hTTPResultWithETag.copy(eTagData, hTTPResult);
    }

    public final ETagData component1() {
        return this.eTagData;
    }

    public final HTTPResult component2() {
        return this.httpResult;
    }

    public final HTTPResultWithETag copy(ETagData eTagData, HTTPResult httpResult) {
        r.f(eTagData, "eTagData");
        r.f(httpResult, "httpResult");
        return new HTTPResultWithETag(eTagData, httpResult);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HTTPResultWithETag)) {
            return false;
        }
        HTTPResultWithETag hTTPResultWithETag = (HTTPResultWithETag) obj;
        return r.b(this.eTagData, hTTPResultWithETag.eTagData) && r.b(this.httpResult, hTTPResultWithETag.httpResult);
    }

    public final ETagData getETagData() {
        return this.eTagData;
    }

    public final HTTPResult getHttpResult() {
        return this.httpResult;
    }

    public int hashCode() {
        return (this.eTagData.hashCode() * 31) + this.httpResult.hashCode();
    }

    public final String serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SERIALIZATION_NAME_ETAG, this.eTagData.getETag());
        Date lastRefreshTime = this.eTagData.getLastRefreshTime();
        if (lastRefreshTime != null) {
            jSONObject.put(SERIALIZATION_NAME_LAST_REFRESH_TIME, lastRefreshTime.getTime());
        }
        jSONObject.put(SERIALIZATION_NAME_HTTPRESULT, this.httpResult.serialize());
        String string = jSONObject.toString();
        r.e(string, "JSONObject().apply {\n   …e())\n        }.toString()");
        return string;
    }

    public String toString() {
        return "HTTPResultWithETag(eTagData=" + this.eTagData + ", httpResult=" + this.httpResult + ')';
    }
}
