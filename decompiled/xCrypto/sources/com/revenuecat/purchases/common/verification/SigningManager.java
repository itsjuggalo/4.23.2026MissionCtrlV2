package com.revenuecat.purchases.common.verification;

import W2.E;
import W2.m;
import W2.o;
import X2.AbstractC0769p;
import X2.AbstractC0770q;
import X2.x;
import android.util.Base64;
import com.amazon.a.a.o.b.f;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.Result;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import r3.AbstractC1753A;
import r3.C1756c;

/* JADX INFO: loaded from: classes.dex */
public final class SigningManager {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int NONCE_BYTES_SIZE = 12;

    @Deprecated
    public static final String POST_PARAMS_ALGORITHM = "sha256";

    @Deprecated
    public static final byte POST_PARAMS_SEPARATOR = 0;
    private final String apiKey;
    private final AppConfig appConfig;
    private final SignatureVerificationMode signatureVerificationMode;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    public static final class Parameters {
        private final String apiKey;
        private final String body;
        private final String eTag;
        private final String nonce;
        private final String postParamsHashHeader;
        private final String requestTime;
        private final byte[] salt;
        private final String urlPath;

        public Parameters(byte[] salt, String apiKey, String str, String urlPath, String str2, String requestTime, String str3, String str4) {
            r.f(salt, "salt");
            r.f(apiKey, "apiKey");
            r.f(urlPath, "urlPath");
            r.f(requestTime, "requestTime");
            this.salt = salt;
            this.apiKey = apiKey;
            this.nonce = str;
            this.urlPath = urlPath;
            this.postParamsHashHeader = str2;
            this.requestTime = requestTime;
            this.eTag = str3;
            this.body = str4;
        }

        public static /* synthetic */ Parameters copy$default(Parameters parameters, byte[] bArr, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                bArr = parameters.salt;
            }
            if ((i4 & 2) != 0) {
                str = parameters.apiKey;
            }
            if ((i4 & 4) != 0) {
                str2 = parameters.nonce;
            }
            if ((i4 & 8) != 0) {
                str3 = parameters.urlPath;
            }
            if ((i4 & 16) != 0) {
                str4 = parameters.postParamsHashHeader;
            }
            if ((i4 & 32) != 0) {
                str5 = parameters.requestTime;
            }
            if ((i4 & 64) != 0) {
                str6 = parameters.eTag;
            }
            if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0) {
                str7 = parameters.body;
            }
            String str8 = str6;
            String str9 = str7;
            String str10 = str4;
            String str11 = str5;
            return parameters.copy(bArr, str, str2, str3, str10, str11, str8, str9);
        }

        public final byte[] component1() {
            return this.salt;
        }

        public final String component2() {
            return this.apiKey;
        }

        public final String component3() {
            return this.nonce;
        }

        public final String component4() {
            return this.urlPath;
        }

        public final String component5() {
            return this.postParamsHashHeader;
        }

        public final String component6() {
            return this.requestTime;
        }

        public final String component7() {
            return this.eTag;
        }

        public final String component8() {
            return this.body;
        }

        public final Parameters copy(byte[] salt, String apiKey, String str, String urlPath, String str2, String requestTime, String str3, String str4) {
            r.f(salt, "salt");
            r.f(apiKey, "apiKey");
            r.f(urlPath, "urlPath");
            r.f(requestTime, "requestTime");
            return new Parameters(salt, apiKey, str, urlPath, str2, requestTime, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!r.b(Parameters.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            r.d(obj, "null cannot be cast to non-null type com.revenuecat.purchases.common.verification.SigningManager.Parameters");
            Parameters parameters = (Parameters) obj;
            return Arrays.equals(this.salt, parameters.salt) && r.b(this.apiKey, parameters.apiKey) && r.b(this.nonce, parameters.nonce) && r.b(this.urlPath, parameters.urlPath) && r.b(this.postParamsHashHeader, parameters.postParamsHashHeader) && r.b(this.requestTime, parameters.requestTime) && r.b(this.eTag, parameters.eTag) && r.b(this.body, parameters.body);
        }

        public final String getApiKey() {
            return this.apiKey;
        }

        public final String getBody() {
            return this.body;
        }

        public final String getETag() {
            return this.eTag;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final String getPostParamsHashHeader() {
            return this.postParamsHashHeader;
        }

        public final String getRequestTime() {
            return this.requestTime;
        }

        public final byte[] getSalt() {
            return this.salt;
        }

        public final String getUrlPath() {
            return this.urlPath;
        }

        public int hashCode() {
            int iHashCode = ((Arrays.hashCode(this.salt) * 31) + this.apiKey.hashCode()) * 31;
            String str = this.nonce;
            int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.urlPath.hashCode()) * 31;
            String str2 = this.postParamsHashHeader;
            int iHashCode3 = (((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.requestTime.hashCode()) * 31;
            String str3 = this.eTag;
            int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.body;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final byte[] toSignatureToVerify() {
            /*
                r5 = this;
                byte[] r0 = r5.salt
                java.lang.String r1 = r5.apiKey
                java.nio.charset.Charset r2 = r3.C1756c.f14563b
                byte[] r1 = r1.getBytes(r2)
                java.lang.String r3 = "this as java.lang.String).getBytes(charset)"
                kotlin.jvm.internal.r.e(r1, r3)
                byte[] r0 = X2.AbstractC0763j.k(r0, r1)
                java.lang.String r1 = r5.nonce
                r4 = 0
                if (r1 == 0) goto L1d
                byte[] r1 = android.util.Base64.decode(r1, r4)
                goto L1e
            L1d:
                r1 = 0
            L1e:
                if (r1 != 0) goto L22
                byte[] r1 = new byte[r4]
            L22:
                byte[] r0 = X2.AbstractC0763j.k(r0, r1)
                java.lang.String r1 = r5.urlPath
                byte[] r1 = r1.getBytes(r2)
                kotlin.jvm.internal.r.e(r1, r3)
                byte[] r0 = X2.AbstractC0763j.k(r0, r1)
                java.lang.String r1 = r5.postParamsHashHeader
                if (r1 == 0) goto L40
                byte[] r1 = r1.getBytes(r2)
                kotlin.jvm.internal.r.e(r1, r3)
                if (r1 != 0) goto L42
            L40:
                byte[] r1 = new byte[r4]
            L42:
                byte[] r0 = X2.AbstractC0763j.k(r0, r1)
                java.lang.String r1 = r5.requestTime
                byte[] r1 = r1.getBytes(r2)
                kotlin.jvm.internal.r.e(r1, r3)
                byte[] r0 = X2.AbstractC0763j.k(r0, r1)
                java.lang.String r1 = r5.eTag
                if (r1 == 0) goto L60
                byte[] r1 = r1.getBytes(r2)
                kotlin.jvm.internal.r.e(r1, r3)
                if (r1 != 0) goto L62
            L60:
                byte[] r1 = new byte[r4]
            L62:
                byte[] r0 = X2.AbstractC0763j.k(r0, r1)
                java.lang.String r1 = r5.body
                if (r1 == 0) goto L73
                byte[] r1 = r1.getBytes(r2)
                kotlin.jvm.internal.r.e(r1, r3)
                if (r1 != 0) goto L75
            L73:
                byte[] r1 = new byte[r4]
            L75:
                byte[] r0 = X2.AbstractC0763j.k(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.verification.SigningManager.Parameters.toSignatureToVerify():byte[]");
        }

        public String toString() {
            return "Parameters(salt=" + Arrays.toString(this.salt) + ", apiKey=" + this.apiKey + ", nonce=" + this.nonce + ", urlPath=" + this.urlPath + ", postParamsHashHeader=" + this.postParamsHashHeader + ", requestTime=" + this.requestTime + ", eTag=" + this.eTag + ", body=" + this.body + ')';
        }
    }

    public SigningManager(SignatureVerificationMode signatureVerificationMode, AppConfig appConfig, String apiKey) {
        r.f(signatureVerificationMode, "signatureVerificationMode");
        r.f(appConfig, "appConfig");
        r.f(apiKey, "apiKey");
        this.signatureVerificationMode = signatureVerificationMode;
        this.appConfig = appConfig;
        this.apiKey = apiKey;
    }

    public final String createRandomNonce() {
        byte[] bArr = new byte[12];
        new SecureRandom().nextBytes(bArr);
        byte[] bArrEncode = Base64.encode(bArr, 0);
        r.e(bArrEncode, "encode(bytes, Base64.DEFAULT)");
        return AbstractC1753A.F0(new String(bArrEncode, C1756c.f14563b)).toString();
    }

    public final String getPostParamsForSigningHeaderIfNeeded(Endpoint endpoint, List<o> list) {
        r.f(endpoint, "endpoint");
        if (list == null || list.isEmpty() || !shouldVerifyEndpoint(endpoint)) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(list, 10));
        int i4 = 0;
        for (Object obj : list) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                AbstractC0769p.p();
            }
            o oVar = (o) obj;
            if (i4 > 0) {
                messageDigest.update((byte) 0);
            }
            byte[] bytes = ((String) oVar.d()).getBytes(C1756c.f14563b);
            r.e(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            arrayList.add(E.f5463a);
            i4 = i5;
        }
        byte[] bArrDigest = messageDigest.digest();
        r.e(bArrDigest, "sha256Digest.digest()");
        String string = "";
        for (byte b4 : bArrDigest) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b4)}, 1));
            r.e(str, "format(this, *args)");
            sb.append(str);
            string = sb.toString();
        }
        return x.Q(AbstractC0769p.j(x.Q(list, f.f8804a, null, null, 0, null, SigningManager$getPostParamsForSigningHeaderIfNeeded$header$1.INSTANCE, 30, null), POST_PARAMS_ALGORITHM, string), Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, null, null, 0, null, null, 62, null);
    }

    public final SignatureVerificationMode getSignatureVerificationMode() {
        return this.signatureVerificationMode;
    }

    public final boolean shouldVerifyEndpoint(Endpoint endpoint) {
        r.f(endpoint, "endpoint");
        return endpoint.getSupportsSignatureVerification() && this.signatureVerificationMode.getShouldVerify();
    }

    public final VerificationResult verifyResponse(String urlPath, String str, String str2, String str3, String str4, String str5, String str6) {
        r.f(urlPath, "urlPath");
        if (this.appConfig.getForceSigningErrors()) {
            LogLevel logLevel = LogLevel.WARN;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.w("[Purchases] - " + logLevel.name(), "Forcing signing error for request with path: " + urlPath);
            }
            return VerificationResult.FAILED;
        }
        IntermediateSignatureHelper intermediateSignatureHelper = this.signatureVerificationMode.getIntermediateSignatureHelper();
        if (intermediateSignatureHelper == null) {
            return VerificationResult.NOT_REQUESTED;
        }
        if (str == null) {
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            String str7 = String.format(NetworkStrings.VERIFICATION_MISSING_SIGNATURE, Arrays.copyOf(new Object[]{urlPath}, 1));
            r.e(str7, "format(this, *args)");
            currentLogHandler2.e("[Purchases] - ERROR", str7, null);
            return VerificationResult.FAILED;
        }
        if (str4 == null) {
            LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
            String str8 = String.format(NetworkStrings.VERIFICATION_MISSING_REQUEST_TIME, Arrays.copyOf(new Object[]{urlPath}, 1));
            r.e(str8, "format(this, *args)");
            currentLogHandler3.e("[Purchases] - ERROR", str8, null);
            return VerificationResult.FAILED;
        }
        if (str3 == null && str5 == null) {
            LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
            String str9 = String.format(NetworkStrings.VERIFICATION_MISSING_BODY_OR_ETAG, Arrays.copyOf(new Object[]{urlPath}, 1));
            r.e(str9, "format(this, *args)");
            currentLogHandler4.e("[Purchases] - ERROR", str9, null);
            return VerificationResult.FAILED;
        }
        try {
            Signature signatureFromString$purchases_defaultsRelease = Signature.Companion.fromString$purchases_defaultsRelease(str);
            Result<SignatureVerifier, PurchasesError> resultCreateIntermediateKeyVerifierIfVerified = intermediateSignatureHelper.createIntermediateKeyVerifierIfVerified(signatureFromString$purchases_defaultsRelease);
            if (resultCreateIntermediateKeyVerifierIfVerified instanceof Result.Error) {
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                String str10 = String.format(NetworkStrings.VERIFICATION_INTERMEDIATE_KEY_FAILED, Arrays.copyOf(new Object[]{urlPath, ((PurchasesError) ((Result.Error) resultCreateIntermediateKeyVerifierIfVerified).getValue()).getUnderlyingErrorMessage()}, 2));
                r.e(str10, "format(this, *args)");
                currentLogHandler5.e("[Purchases] - ERROR", str10, null);
                return VerificationResult.FAILED;
            }
            if (!(resultCreateIntermediateKeyVerifierIfVerified instanceof Result.Success)) {
                throw new m();
            }
            if (!((SignatureVerifier) ((Result.Success) resultCreateIntermediateKeyVerifierIfVerified).getValue()).verify(signatureFromString$purchases_defaultsRelease.getPayload(), new Parameters(signatureFromString$purchases_defaultsRelease.getSalt(), this.apiKey, str2, urlPath, str6, str4, str5, str3).toSignatureToVerify())) {
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                String str11 = String.format(NetworkStrings.VERIFICATION_ERROR, Arrays.copyOf(new Object[]{urlPath}, 1));
                r.e(str11, "format(this, *args)");
                currentLogHandler6.e("[Purchases] - ERROR", str11, null);
                return VerificationResult.FAILED;
            }
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                String str12 = "[Purchases] - " + logLevel2.name();
                String str13 = String.format(NetworkStrings.VERIFICATION_SUCCESS, Arrays.copyOf(new Object[]{urlPath}, 1));
                r.e(str13, "format(this, *args)");
                currentLogHandler7.v(str12, str13);
            }
            return VerificationResult.VERIFIED;
        } catch (InvalidSignatureSizeException e4) {
            LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
            String str14 = String.format(NetworkStrings.VERIFICATION_INVALID_SIZE, Arrays.copyOf(new Object[]{urlPath, e4.getMessage()}, 2));
            r.e(str14, "format(this, *args)");
            currentLogHandler8.e("[Purchases] - ERROR", str14, null);
            return VerificationResult.FAILED;
        }
    }
}
