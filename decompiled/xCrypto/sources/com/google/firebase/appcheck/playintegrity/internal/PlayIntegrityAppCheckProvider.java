package com.google.firebase.appcheck.playintegrity.internal;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckProvider;
import com.google.firebase.appcheck.AppCheckToken;
import com.google.firebase.appcheck.internal.AppCheckTokenResponse;
import com.google.firebase.appcheck.internal.DefaultAppCheckToken;
import com.google.firebase.appcheck.internal.NetworkClient;
import com.google.firebase.appcheck.internal.RetryManager;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class PlayIntegrityAppCheckProvider implements AppCheckProvider {
    private static final String UTF_8 = "UTF-8";
    private final Executor blockingExecutor;
    private final IntegrityManager integrityManager;
    private final Executor liteExecutor;
    private final NetworkClient networkClient;
    private final String projectNumber;
    private final RetryManager retryManager;

    public PlayIntegrityAppCheckProvider(FirebaseApp firebaseApp, Executor executor, Executor executor2) {
        this(firebaseApp.getOptions().getGcmSenderId(), IntegrityManagerFactory.create(firebaseApp.getApplicationContext()), new NetworkClient(firebaseApp), executor, executor2, new RetryManager());
    }

    public static /* synthetic */ Task d(final PlayIntegrityAppCheckProvider playIntegrityAppCheckProvider, IntegrityTokenResponse integrityTokenResponse) {
        playIntegrityAppCheckProvider.getClass();
        final ExchangePlayIntegrityTokenRequest exchangePlayIntegrityTokenRequest = new ExchangePlayIntegrityTokenRequest(integrityTokenResponse.token());
        return Tasks.call(playIntegrityAppCheckProvider.blockingExecutor, new Callable() { // from class: com.google.firebase.appcheck.playintegrity.internal.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                PlayIntegrityAppCheckProvider playIntegrityAppCheckProvider2 = this.f10221a;
                return playIntegrityAppCheckProvider2.networkClient.exchangeAttestationForAppCheckToken(exchangePlayIntegrityTokenRequest.toJsonString().getBytes(PlayIntegrityAppCheckProvider.UTF_8), 3, playIntegrityAppCheckProvider2.retryManager);
            }
        });
    }

    private Task<IntegrityTokenResponse> getPlayIntegrityAttestation() {
        final GeneratePlayIntegrityChallengeRequest generatePlayIntegrityChallengeRequest = new GeneratePlayIntegrityChallengeRequest();
        return Tasks.call(this.blockingExecutor, new Callable() { // from class: com.google.firebase.appcheck.playintegrity.internal.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                PlayIntegrityAppCheckProvider playIntegrityAppCheckProvider = this.f10223a;
                return GeneratePlayIntegrityChallengeResponse.fromJsonString(playIntegrityAppCheckProvider.networkClient.generatePlayIntegrityChallenge(generatePlayIntegrityChallengeRequest.toJsonString().getBytes(PlayIntegrityAppCheckProvider.UTF_8), playIntegrityAppCheckProvider.retryManager));
            }
        }).onSuccessTask(this.liteExecutor, new SuccessContinuation() { // from class: com.google.firebase.appcheck.playintegrity.internal.c
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                PlayIntegrityAppCheckProvider playIntegrityAppCheckProvider = this.f10225a;
                return playIntegrityAppCheckProvider.integrityManager.requestIntegrityToken(IntegrityTokenRequest.builder().setCloudProjectNumber(Long.parseLong(playIntegrityAppCheckProvider.projectNumber)).setNonce(((GeneratePlayIntegrityChallengeResponse) obj).getChallenge()).build());
            }
        });
    }

    @Override // com.google.firebase.appcheck.AppCheckProvider
    public Task<AppCheckToken> getToken() {
        return getPlayIntegrityAttestation().onSuccessTask(this.liteExecutor, new SuccessContinuation() { // from class: com.google.firebase.appcheck.playintegrity.internal.d
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return PlayIntegrityAppCheckProvider.d(this.f10226a, (IntegrityTokenResponse) obj);
            }
        }).onSuccessTask(this.liteExecutor, new SuccessContinuation() { // from class: com.google.firebase.appcheck.playintegrity.internal.e
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return Tasks.forResult(DefaultAppCheckToken.constructFromAppCheckTokenResponse((AppCheckTokenResponse) obj));
            }
        });
    }

    public PlayIntegrityAppCheckProvider(String str, IntegrityManager integrityManager, NetworkClient networkClient, Executor executor, Executor executor2, RetryManager retryManager) {
        this.projectNumber = str;
        this.integrityManager = integrityManager;
        this.networkClient = networkClient;
        this.liteExecutor = executor;
        this.blockingExecutor = executor2;
        this.retryManager = retryManager;
    }
}
