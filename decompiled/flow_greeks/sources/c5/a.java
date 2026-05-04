package c5;

import android.content.Intent;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.ClearTokenRequest;
import com.google.android.gms.auth.api.identity.RevokeAccessRequest;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    Task authorize(AuthorizationRequest authorizationRequest);

    Task clearToken(ClearTokenRequest clearTokenRequest);

    b getAuthorizationResultFromIntent(Intent intent);

    Task revokeAccess(RevokeAccessRequest revokeAccessRequest);
}
