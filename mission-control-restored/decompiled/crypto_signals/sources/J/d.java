package J;

import R4.l;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.ResultReceiver;
import androidx.credentials.playservices.HiddenActivity;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import o1.g;
import o1.m;

/* JADX INFO: loaded from: classes.dex */
public final class d extends k implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HiddenActivity f656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f657c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(HiddenActivity hiddenActivity, int i, int i6) {
        super(1);
        this.f655a = i6;
        this.f656b = hiddenActivity;
        this.f657c = i;
    }

    @Override // R4.l
    public final Object invoke(Object obj) {
        switch (this.f655a) {
            case 0:
                HiddenActivity hiddenActivity = this.f656b;
                g gVar = (g) obj;
                try {
                    hiddenActivity.f4466b = true;
                    hiddenActivity.startIntentSenderForResult(gVar.f8650a.getIntentSender(), this.f657c, null, 0, 0, 0, null);
                } catch (IntentSender.SendIntentException e) {
                    ResultReceiver resultReceiver = hiddenActivity.f4465a;
                    j.b(resultReceiver);
                    hiddenActivity.a(resultReceiver, "GET_UNKNOWN", "During begin sign in, one tap ui intent sender failure: " + e.getMessage());
                }
                break;
            case 1:
                HiddenActivity hiddenActivity2 = this.f656b;
                m mVar = (m) obj;
                try {
                    hiddenActivity2.f4466b = true;
                    hiddenActivity2.startIntentSenderForResult(mVar.f8661a.getIntentSender(), this.f657c, null, 0, 0, 0, null);
                } catch (IntentSender.SendIntentException e2) {
                    ResultReceiver resultReceiver2 = hiddenActivity2.f4465a;
                    j.b(resultReceiver2);
                    hiddenActivity2.a(resultReceiver2, "CREATE_UNKNOWN", "During save password, found UI intent sender failure: " + e2.getMessage());
                }
                break;
            case 2:
                HiddenActivity hiddenActivity3 = this.f656b;
                PendingIntent result = (PendingIntent) obj;
                j.e(result, "result");
                try {
                    hiddenActivity3.f4466b = true;
                    hiddenActivity3.startIntentSenderForResult(result.getIntentSender(), this.f657c, null, 0, 0, 0, null);
                } catch (IntentSender.SendIntentException e6) {
                    ResultReceiver resultReceiver3 = hiddenActivity3.f4465a;
                    j.b(resultReceiver3);
                    hiddenActivity3.a(resultReceiver3, "CREATE_UNKNOWN", "During public key credential, found IntentSender failure on public key creation: " + e6.getMessage());
                }
                break;
            default:
                HiddenActivity hiddenActivity4 = this.f656b;
                PendingIntent pendingIntent = (PendingIntent) obj;
                try {
                    hiddenActivity4.f4466b = true;
                    hiddenActivity4.startIntentSenderForResult(pendingIntent.getIntentSender(), this.f657c, null, 0, 0, 0, null);
                } catch (IntentSender.SendIntentException e7) {
                    ResultReceiver resultReceiver4 = hiddenActivity4.f4465a;
                    j.b(resultReceiver4);
                    hiddenActivity4.a(resultReceiver4, "GET_UNKNOWN", "During get sign-in intent, one tap ui intent sender failure: " + e7.getMessage());
                }
                break;
        }
        return G4.l.f540a;
    }
}
