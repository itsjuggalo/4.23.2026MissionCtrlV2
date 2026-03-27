package com.google.firebase.appcheck.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class NetworkClient {
    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE = "Content-Type";
    public static final int DEBUG = 2;
    private static final String DEBUG_EXCHANGE_URL_TEMPLATE = "https://firebaseappcheck.googleapis.com/v1/projects/%s/apps/%s:exchangeDebugToken?key=%s";
    public static final int PLAY_INTEGRITY = 3;
    private static final String PLAY_INTEGRITY_CHALLENGE_URL_TEMPLATE = "https://firebaseappcheck.googleapis.com/v1/projects/%s/apps/%s:generatePlayIntegrityChallenge?key=%s";
    private static final String PLAY_INTEGRITY_EXCHANGE_URL_TEMPLATE = "https://firebaseappcheck.googleapis.com/v1/projects/%s/apps/%s:exchangePlayIntegrityToken?key=%s";
    private static final String TAG = "com.google.firebase.appcheck.internal.NetworkClient";
    public static final int UNKNOWN = 0;
    private static final String UTF_8 = "UTF-8";
    static final String X_ANDROID_CERT = "X-Android-Cert";
    static final String X_ANDROID_PACKAGE = "X-Android-Package";
    static final String X_FIREBASE_CLIENT = "X-Firebase-Client";
    private final String apiKey;
    private final String appId;
    private final Context context;
    private final Provider<HeartBeatController> heartBeatControllerProvider;
    private final String projectId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AttestationTokenType {
    }

    public NetworkClient(FirebaseApp firebaseApp) {
        this(firebaseApp.getApplicationContext(), firebaseApp.getOptions(), ((DefaultFirebaseAppCheck) FirebaseAppCheck.getInstance(firebaseApp)).getHeartbeatControllerProvider());
    }

    private String getFingerprintHashForPackage() {
        try {
            Context context = this.context;
            byte[] bArrA = G1.a.a(context, context.getPackageName());
            if (bArrA != null) {
                return G1.i.c(bArrA, false);
            }
            Log.e(TAG, "Could not get fingerprint hash for package: " + this.context.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e4) {
            Log.e(TAG, "No such package: " + this.context.getPackageName(), e4);
            return null;
        }
    }

    private static String getUrlTemplate(int i4) {
        if (i4 == 2) {
            return DEBUG_EXCHANGE_URL_TEMPLATE;
        }
        if (i4 == 3) {
            return PLAY_INTEGRITY_EXCHANGE_URL_TEMPLATE;
        }
        throw new IllegalArgumentException("Unknown token type.");
    }

    private static final boolean isResponseSuccess(int i4) {
        return i4 >= 200 && i4 < 300;
    }

    private String makeNetworkRequest(URL url, byte[] bArr, RetryManager retryManager, boolean z4) {
        HttpURLConnection httpURLConnectionCreateHttpUrlConnection = createHttpUrlConnection(url);
        try {
            httpURLConnectionCreateHttpUrlConnection.setDoOutput(true);
            httpURLConnectionCreateHttpUrlConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnectionCreateHttpUrlConnection.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
            String heartBeat = getHeartBeat();
            if (heartBeat != null) {
                httpURLConnectionCreateHttpUrlConnection.setRequestProperty(X_FIREBASE_CLIENT, heartBeat);
            }
            httpURLConnectionCreateHttpUrlConnection.setRequestProperty(X_ANDROID_PACKAGE, this.context.getPackageName());
            httpURLConnectionCreateHttpUrlConnection.setRequestProperty(X_ANDROID_CERT, getFingerprintHashForPackage());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnectionCreateHttpUrlConnection.getOutputStream(), bArr.length);
            try {
                bufferedOutputStream.write(bArr, 0, bArr.length);
                bufferedOutputStream.close();
                int responseCode = httpURLConnectionCreateHttpUrlConnection.getResponseCode();
                InputStream inputStream = isResponseSuccess(responseCode) ? httpURLConnectionCreateHttpUrlConnection.getInputStream() : httpURLConnectionCreateHttpUrlConnection.getErrorStream();
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF_8));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } finally {
                    }
                }
                bufferedReader.close();
                String string = sb.toString();
                if (isResponseSuccess(responseCode)) {
                    if (z4) {
                        retryManager.resetBackoffOnSuccess();
                    }
                    httpURLConnectionCreateHttpUrlConnection.disconnect();
                    return string;
                }
                retryManager.updateBackoffOnFailure(responseCode);
                HttpErrorResponse httpErrorResponseFromJsonString = HttpErrorResponse.fromJsonString(string);
                throw new FirebaseException("Error returned from API. code: " + httpErrorResponseFromJsonString.getErrorCode() + " body: " + httpErrorResponseFromJsonString.getErrorMessage());
            } finally {
            }
        } catch (Throwable th) {
            httpURLConnectionCreateHttpUrlConnection.disconnect();
            throw th;
        }
    }

    public HttpURLConnection createHttpUrlConnection(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public AppCheckTokenResponse exchangeAttestationForAppCheckToken(byte[] bArr, int i4, RetryManager retryManager) throws FirebaseException {
        if (retryManager.canRetry()) {
            return AppCheckTokenResponse.fromJsonString(makeNetworkRequest(new URL(String.format(getUrlTemplate(i4), this.projectId, this.appId, this.apiKey)), bArr, retryManager, true));
        }
        throw new FirebaseException("Too many attempts.");
    }

    public String generatePlayIntegrityChallenge(byte[] bArr, RetryManager retryManager) throws FirebaseException {
        if (retryManager.canRetry()) {
            return makeNetworkRequest(new URL(String.format(PLAY_INTEGRITY_CHALLENGE_URL_TEMPLATE, this.projectId, this.appId, this.apiKey)), bArr, retryManager, false);
        }
        throw new FirebaseException("Too many attempts.");
    }

    public String getHeartBeat() {
        HeartBeatController heartBeatController = this.heartBeatControllerProvider.get();
        if (heartBeatController != null) {
            try {
                return (String) Tasks.await(heartBeatController.getHeartBeatsHeader());
            } catch (Exception unused) {
                Log.w(TAG, "Unable to get heartbeats!");
            }
        }
        return null;
    }

    public NetworkClient(Context context, FirebaseOptions firebaseOptions, Provider<HeartBeatController> provider) {
        AbstractC0940s.k(context);
        AbstractC0940s.k(firebaseOptions);
        AbstractC0940s.k(provider);
        this.context = context;
        this.apiKey = firebaseOptions.getApiKey();
        this.appId = firebaseOptions.getApplicationId();
        String projectId = firebaseOptions.getProjectId();
        this.projectId = projectId;
        if (projectId != null) {
            this.heartBeatControllerProvider = provider;
            return;
        }
        throw new IllegalArgumentException("FirebaseOptions#getProjectId cannot be null.");
    }
}
